package com.sjw.permission.common.Interceptor;

import com.sjw.permission.common.RequestHolder;
import com.sjw.permission.modules.sys.model.SysUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 87112
 * @date 2019/2/27
 */
public class LoginHanderInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        SysUser sysUser = (SysUser)request.getSession().getAttribute("user");
        if (sysUser == null) {
            String path = "/signin.jsp";
            response.sendRedirect(path);
            return true;
        }
        RequestHolder.add(sysUser);
        RequestHolder.add(request);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
