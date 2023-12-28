package com.atguigu.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问到了FirstServlet...");
        //1. 获取URL地址参数
        String contextPath = request.getContextPath();
        System.out.println("contextPath = " + contextPath);//获得上下文路径

        String serverName = request.getServerName();
        System.out.println("serverName = " + serverName);

        int serverPort = request.getServerPort();
        System.out.println("serverPort = " + serverPort);

        String scheme = request.getScheme();
        System.out.println("scheme = " + scheme);

        //2. 获取请求头信息
        String header = request.getHeader("User-Agent");//获取客户端的产品信息
        System.out.println("header = " + header);

        String referer = request.getHeader("Referer");//获取请求的来源
        System.out.println("referer = " + referer);

        //3. 转发
        // 转发之前，需要传递数据到SecondServlet
        // 将数据共享到请求域内
        request.setAttribute("msg","这是共享数据");
        request.setAttribute("port",serverPort);


        //转发到SecondServlet
        //1. 获得转发器对象
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/second");
        //2. 进行转发
        requestDispatcher.forward(request,response);


    }
}
