package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/thymeleaf")
public class ThymeleafServlet extends ViewBaseServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问到了ThymeleafServlet...");
        //应该调用业务层，业务层调用dao层，dao将结果返给service,service将结果返给Servlet
        String username="admin888";//模拟的返回结果
        //Servlet应该将数据展示在网页上
        //1. 将数据放在请求域
        request.setAttribute("aaa",username);
        request.setAttribute("bbb","root");
        //2. 调用Thymeleaf中的渲染方法(thymeleaf要对admin页面进行渲染)
            //Thymealf的processTemplate方法原理是转发(相当于转发到admin.html)
        this.processTemplate("admin",request,response);
    }
}
