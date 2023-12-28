package com.atguigu.test02servletcreate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * title:  创建类继承HttpServlet（掌握）
 * author: Ray
 * date: 2022/8/20
 * description :
 */
public class MyServlet3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet3.........");
        resp.getWriter().println("hello3 i m servlet3............");
    }
}
