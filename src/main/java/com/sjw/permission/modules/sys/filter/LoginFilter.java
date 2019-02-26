//package com.sjw.permission.modules.sys.filter;
//
//import com.sjw.permission.common.RequestHolder;
//import com.sjw.permission.modules.sys.model.SysUser;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author sjw
// */
//@Slf4j
//@WebFilter(urlPatterns = {"/sys/*", "/admin/*"}, filterName = "loginFilter")
//@Component
//public class LoginFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//        HttpServletResponse resp = (HttpServletResponse) servletResponse;
//
//        SysUser sysUser = (SysUser)req.getSession().getAttribute("user");
//        if (sysUser == null) {
//            String path = "/signin.jsp";
//            resp.sendRedirect(path);
//            return;
//        }
//        RequestHolder.add(sysUser);
//        RequestHolder.add(req);
//        filterChain.doFilter(servletRequest, servletResponse);
//        return;
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
