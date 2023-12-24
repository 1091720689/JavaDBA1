package com.atguigu.test04servletconfigcontext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * title:ServletConfig接口和ServletContext接口
 * author: Ray
 * date: 2022/8/20
 * description :
 */
public class ServletDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ServletConifg对象
        ServletConfig servletConfig = this.getServletConfig();
        //从ServletConfig中获取相关配置信息
        String encoding = servletConfig.getInitParameter("encoding");
        System.out.println("encoding = " + encoding);
        String xxx = servletConfig.getInitParameter("xxx");
        System.out.println("xxx = " + xxx);

        String servletName = servletConfig.getServletName();
        System.out.println("servletName = " + servletName);
        //获取ServletContext
        ServletContext servletContext = servletConfig.getServletContext();
        ServletContext servletContext1 = this.getServletContext();
        System.out.println(servletContext == servletContext1);
        //ServletContext对象：是整个应用上下文对象，整个应用程序只有一个ServletContext对象，
        //内部包含一个Map集合，可以存储键值对信息，整个应用中所有的Servlet可以共享它
        servletContext.setAttribute("uname", "张三");//存储一个数据
        Object uname = servletContext.getAttribute("uname");//根据属性名获取属性值
        System.out.println("ServletDemo1:uname = " + uname);

        //获取全局参数
        String xxx1 = servletContext.getInitParameter("xxx");
        System.out.println("xxx1 = " + xxx1);
        //获取contextPath
        String contextPath = servletContext.getContextPath();
        System.out.println("contextPath = " + contextPath);
        //获取资源的物理路径
        String realPath = servletContext.getRealPath("/hello.html");
        System.out.println("realPath = " + realPath);


    }
}
