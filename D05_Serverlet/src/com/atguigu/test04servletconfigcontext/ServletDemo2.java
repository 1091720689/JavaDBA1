package com.atguigu.test04servletconfigcontext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * title:
 * author: Ray
 * date: 2022/8/20
 * description :
 */
public class ServletDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        Object uname = servletContext.getAttribute("uname");
        System.out.println("ServletDemo2:uname = " + uname);
        //移除uname属性
        servletContext.removeAttribute("uname");
    }
}
