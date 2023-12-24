package com.atguigu.test02servletcreate;

import javax.servlet.*;
import java.io.IOException;

/**
 * title: 创建方式一：创建类实现Servlet接口
 * author: Ray
 * date: 2022/8/20
 * description :
 */
public class MyServlet1 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet1...........");
        servletResponse.getWriter().println("hello i m serlvet1.....");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
