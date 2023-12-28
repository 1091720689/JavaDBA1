package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问到了SecondServlet...");

        Object msg = request.getAttribute("msg");
        System.out.println("msg = " + msg);

        Object port = request.getAttribute("port");
        System.out.println("port = " + port);

        /*服务器端是可以写一个页面回去的，这代码太垃圾了*/
        PrintWriter writer = response.getWriter();
        writer.write("<html>");
        writer.write("<head>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("<h1>success</h1>");
        writer.write("</body>");
        writer.write("</html>");

        /*通过转发，转发到此页面*/
        request.getRequestDispatcher("/success.html").forward(request,response);



    }
}
