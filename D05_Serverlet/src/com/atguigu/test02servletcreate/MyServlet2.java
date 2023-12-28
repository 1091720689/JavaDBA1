package com.atguigu.test02servletcreate;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * title:  创建方式二：创建类继承GenericServlet
 * author: Ray
 * date: 2022/8/20
 * description :
 */
public class MyServlet2 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servet2.......");
        servletResponse.getWriter().println("hello2 i m serlvet2.....");
    }
}
