package com.atguigu.test03servletconf;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * title:  Servlet注解配置
 * author: Ray
 * date: 2022/8/20
 * description :
 */
//@WebServlet(name = "HelloServlet1",value = "/demo1")
//@WebServlet(value = "/demo1");只写映射路径即可
@WebServlet("/demo1")//只写映射路径方式的简化写法
public class HelloServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("helloservlet1.............");
    }
}
