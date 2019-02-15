package com.sjw.permission.pto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author sjw
 * @date 2019/2/14
 */
@Data
@Validated
public class GroupPto {
    private Integer id;

    @NotBlank(message = "组名称不可以为空")
    @Length(max = 15, min = 2, message = "组名称长度需要在2-15个字之间")
    private String name;

    private Integer parentId = 0;

    @NotNull(message = "展示顺序不可以为空")
    private Integer seq;

    @Length(max = 150, message = "备注的长度需要在150个字以内")
    private String remark;
}
