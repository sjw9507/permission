package com.sjw.permission.modules.sys.service;

import com.google.common.base.Preconditions;
import com.sjw.permission.common.RequestHolder;
import com.sjw.permission.modules.sys.dao.SysDeptMapper;
import com.sjw.permission.modules.sys.dao.SysUserMapper;
import com.sjw.permission.modules.sys.exception.ParamException;
import com.sjw.permission.modules.sys.model.SysDept;
import com.sjw.permission.modules.sys.param.DeptParam;
import com.sjw.permission.modules.sys.util.BeanValidator;
import com.sjw.permission.modules.sys.util.IpUtil;
import com.sjw.permission.modules.sys.util.LevelUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author sjw
 */
@Service
public class SysDeptService {

    @Resource
    private SysDeptMapper sysDeptMapper;
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SysLogService sysLogService;

    public void save(DeptParam param) {
        BeanValidator.check(param);
        if (checkExist(param.getParentId(), param.getName(), param.getId())) {
            throw new ParamException("同一层级下存在相同名称的部门");
        }
        SysDept dept = SysDept.builder().name(param.getName()).parentId(param.getParentId())
                .seq(param.getSeq()).remark(param.getRemark())
                .level(LevelUtil.calculateLevel(getLevel(param.getParentId()), param.getParentId()))
                .operator(RequestHolder.getCurrentUser().getUsername())
                .operateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()))
                .operateTime(new Date())
                .build();

        sysDeptMapper.insertSelective(dept);
        sysLogService.saveDeptLog(null, dept);
    }

    public void update(DeptParam param) {
        BeanValidator.check(param);
        if (checkExist(param.getParentId(), param.getName(), param.getId())) {
            throw new ParamException("同一层级下存在相同名称的部门");
        }
        SysDept before = sysDeptMapper.selectByPrimaryKey(param.getId());
        Preconditions.checkNotNull(before, "待更新的部门不存在");

        SysDept after = SysDept.builder().id(param.getId()).name(param.getName()).parentId(param.getParentId())
                .seq(param.getSeq()).remark(param.getRemark())
                .level(LevelUtil.calculateLevel(getLevel(param.getParentId()), param.getParentId()))
                .operator(RequestHolder.getCurrentUser().getUsername())
                .operateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()))
                .operateTime(new Date())
                .build();

        updateWithChild(before, after);
        sysLogService.saveDeptLog(before, after);
    }

    @Transactional(rollbackFor = Exception.class)
    private void updateWithChild(SysDept before, SysDept after) {
        String newLevelPrefix = after.getLevel();
        String oldLevelPrefix = before.getLevel();
        if (!after.getLevel().equals(before.getLevel())) {
            List<SysDept> deptList = sysDeptMapper.getChildDeptListByLevel(before.getLevel());
            if (CollectionUtils.isNotEmpty(deptList)) {
                for (SysDept dept : deptList) {
                    String level = dept.getLevel();
                    if (level.indexOf(oldLevelPrefix) == 0) {
                        level = newLevelPrefix + level.substring(oldLevelPrefix.length());
                        dept.setLevel(level);
                    }
                }
                sysDeptMapper.batchUpdateLevel(deptList);
            }
        }
        sysDeptMapper.updateByPrimaryKey(after);
    }

    private boolean checkExist(Integer parentId, String deptName, Integer deptId) {
        return sysDeptMapper.countByNameAndParentId(parentId, deptName, deptId) > 0;
    }

    private String getLevel(Integer deptId) {
        SysDept dept = sysDeptMapper.selectByPrimaryKey(deptId);
        if (dept == null) {
            return null;
        }
        return dept.getLevel();
    }

    public void delete(int deptId) {
        SysDept dept = sysDeptMapper.selectByPrimaryKey(deptId);
        Preconditions.checkNotNull(dept, "待删除的部门不存在，无法删除");
        if (sysDeptMapper.countByParentId(dept.getId()) > 0) {
            throw new ParamException("当前部门下面有子部门，无法删除");
        }
        if (sysUserMapper.countByDeptId(dept.getId()) > 0) {
            throw new ParamException("当前部门下面有用户，无法删除");
        }
        sysDeptMapper.deleteByPrimaryKey(deptId);
    }
}
