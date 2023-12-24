package com.atguigu.test01servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * title:Servlet入门案例
 * author: Ray
 * date: 2022/8/20
 * description :
 */
public class MyServlet implements Servlet {
    //构造器:默认情况下当第一次请求servlet时执行
    public MyServlet() {
        System.out.println("Servlet 实例化....");
    }
    //初始化方法：默认情况下第一次请求servlet时执行，在实例化后执行
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Servlet 初始化...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    //servlet服务方法：执行每次请求时调用
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet 提供服务service method..........");
        String method = ((HttpServletRequest) servletRequest).getMethod();
        System.out.println("method = " + method);

        servletResponse.getWriter().println("hello i m servlet.......");
    }

    @Override
    public String getServletInfo() {
        return null;
    }
    //销毁方法：当应用程序被卸载或关闭tomcat服务器时执行，通常用于收尾工作。
    @Override
    public void destroy() {
        System.out.println("Servlet销毁....");
    }
}
