package com.atguigu.servllet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问到了HelloServlet...");
        //在所有的获取请求参数之前设置字符集
        request.setCharacterEncoding("utf-8");
        //接收请求参数
        String name = request.getParameter("name");
        System.out.println("name = " + name);

        //1. response可以获得输出流，输出响应数据
            //输出流将数据输出给谁了？(谁请求我我就输出给谁！)
                //现阶段只有浏览器请求我，那我就输出给浏览器
                //还会遇到移动端请求我，将数据输出给移动端(app)
                //还会遇到一个语言请求我，将数据输出给这个语言(js可以发请求到java的)
        //2. 解决响应乱码问题(通过设置响应头)   需要在获取输出流之前执行
//        response.setHeader("Content-Type","text/html;charset=utf-8");
        response.setContentType("text/html;charset=utf-8");

        //打印输出流
        PrintWriter writer = response.getWriter();
        writer.write("<h1>成功</h1>");
        writer.write("<h1>尚硅谷</h1>");
        writer.write("<h1>深圳</h1>");
        writer.write("<h1>success</h1>");
    }
}
