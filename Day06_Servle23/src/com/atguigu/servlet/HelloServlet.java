package com.atguigu.servlet;

import com.atguigu.bean.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问到了HelloServlet的方法...");
        //1. 如何接收请求参数
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        String password = request.getParameter("password");
        System.out.println("password = " + password);

        String gender = request.getParameter("gender");
        System.out.println("gender = " + gender);

        String address = request.getParameter("address");
        System.out.println("address = " + address);


        String[] hobbies = request.getParameterValues("hobby");
        System.out.println("Arrays.toString(hobbies) = " + Arrays.toString(hobbies));

        User user=new User(username,password,Integer.parseInt(gender),address,hobbies);
        System.out.println(user);

        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            System.out.println("entry.getKey() = " + entry.getKey());
            System.out.println("entry.getKey() = " + Arrays.toString(entry.getValue()));
        }

        //将Map集合中的数据自动封装到javaBean对象中
            //条件：map集合的key值(就是表单的name属性值)必须和User对象的属性名保持一致
        //BeanUtils   需要导入jar包
        User user1=new User();
        try {
            BeanUtils.populate(user1,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("user1 = " + user1);


        response.getWriter().write("success");
    }
}
