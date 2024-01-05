package com.atguigu.servllet;

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

        request.setAttribute("msg","successMsg");

        //转发到second
        //相对路径
            //http://localhost:8888/D07_Servlet2_war_exploded/first
            //  ./  代表的是http://localhost:8888/D07_Servlet2_war_exploded/
            //   ./second    相当于  http://localhost:8888/D07_Servlet2_war_exploded/second
        //request.getRequestDispatcher("./second").forward(request,response);
        //绝对路径
            //含义：上下文路径下(web.xml含义一样)
            //   /   代表的是http://localhost:8888/D07_Servlet2_war_exploded/
            //   /second   相当于http://localhost:8888/D07_Servlet2_war_exploded/second
        //request.getRequestDispatcher("/second").forward(request,response);
        //转发到WEB-INF下的root.html
        //request.getRequestDispatcher("WEB-INF/root.html").forward(request,response);

        //重定向到另一个Servlet
        //相对路径
            // url  :  http://localhost:8888/D07_Servlet2_war_exploded/first
            //   ./  代表的是  ：  http://localhost:8888/D07_Servlet2_war_exploded
            //   ./second   相当于是   http://localhost:8888/D07_Servlet2_war_exploded/second
        response.sendRedirect("./second");
        //绝对路径
            //含义：  代表的是端口号下  (网页中的/含义是一样的)
            //  /   代表的是  ：  http://localhost:8888/
            //  /second   相当于  http://localhost:8888/second
            //  /D07_Servlet2_war_exploded/second  相当于
                //   http://localhost:8888/D07_Servlet2_war_exploded/second
        //response.sendRedirect("/D07_Servlet2_war_exploded/second");
        //重定向到一个页面
        //response.sendRedirect("admin.html");
        //重定向到WEB-INF/root.html
        //response.sendRedirect("WEB-INF/root.html");


        //转发到baidu.com(办不到的)
        //request.getRequestDispatcher("http://baidu.com").forward(request,response);
        //重定向到baidu.com(可以办到)
        //response.sendRedirect("http://baidu.com");

    }
}
