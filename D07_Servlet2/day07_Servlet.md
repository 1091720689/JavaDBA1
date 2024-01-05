# 1.回顾

```tex
1. request
	获取请求参数
	BeanUtils工具
	获得url地址参数
	获得请求头信息
	转发
		转发到另一个Servlet
		转发到网页(打开网页)
	可以在请求域内共享数据
```

# 2.HttpServletResponse

- 主要功能就是处理响应

## 2.1 使用输出流输出响应数据

```java
//1. response可以获得输出流，输出响应数据
    //输出流将数据输出给谁了？(谁请求我我就输出给谁！)
        //现阶段只有浏览器请求我，那我就输出给浏览器
        //还会遇到移动端请求我，将数据输出给移动端(app)
        //还会遇到一个语言请求我，将数据输出给这个语言(js可以发请求到java的)
PrintWriter writer = response.getWriter();
writer.write("<h1>success</h1>");
writer.write("<h1>success</h1>");
writer.write("<h1>success</h1>");
writer.write("<h1>success</h1>");
```

## 2.2 设置响应头

- 响应中存在中文乱码的情况

```java
//2. 解决响应乱码问题(通过设置响应头)   需要在获取输出流之前执行
//        response.setHeader("Content-Type","text/html;charset=utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        PrintWriter writer = response.getWriter();
        writer.write("<h1>成功</h1>");
        writer.write("<h1>尚硅谷</h1>");
        writer.write("<h1>深圳</h1>");
        writer.write("<h1>success</h1>");
```

## 2.3 重定向

- 和转发的功能类似
  - 转发到另一个Servlet
  - 转发到一个页面

- 重定向也是办到转发的上述功能
  - 重定向到另一个Servelt
  - 重定向到一个页面

```java
//重定向到另一个Servlet    路径不能添加/
//response.sendRedirect("second");
//重定向到一个页面
response.sendRedirect("admin.html");
```

# 3.转发和重定向的区别

## 3.1转发

原理：服务器内部进行转发到目的地

## 3.2 重定向

原理：会告知客户端在发送一次请求到目的地

## 3.3 区别

|                    | 转发                   | 重定向               |
| ------------------ | ---------------------- | -------------------- |
| 浏览器的感知       | 浏览器是感知不到的     | 浏览器是可以感知到的 |
| 浏览器网址的变化   | 不变                   | 变化                 |
| 请求次数           | 一次                   | 多次                 |
| 能否共享请求域数据 | 可以的                 | 不可以的             |
| WEB-INF的资源      | 可以访问的             | 不可以访问的         |
| 目标资源           | 只能是服务器内部的资源 | 服务器内部外部都可以 |

- WEB-INF下的资源，受保护的区域(服务器可以访问但是客户端不能访问)

# 4.中文乱码问题

## 4.1 请求乱码

- get请求

  - 如果使用的是tomcat8以上的版本，get请求是不乱码的
  - 如果是tomcat7及以下版本，get请求也是乱码
    - 修改tomcat的配置文件(server.xml)

- post请求

  - 中文肯定是乱码的

    - ```java
      //在所有的获取请求参数之前设置字符集
      request.setCharacterEncoding("utf-8");
      ```

## 4.2 响应乱码

- 通过输出流输出中文，会乱码
  - 通过设置响应头的方式进行解决的

# 5.WEB项目的路径

- 该知识点比较难，需要一段时间通过代码去慢慢感悟

## 5.1 用到路径的位置

- web.xml或注解中配置的访问路径

  - ```java
    @WebServlet("/hello")
    ```

- 网页的请求路径

  - ```html
    <a href="hello">HelloServlet</a>
    ```

- 转发

  - ```java
    request.getRequestDispatcher("second").forward(request,response);
    ```

- 重定向

  - ```java
    response.sendRedirect("second");
    ```

## 5.2 路径设置

- 相对路径

  - ./    当前级别(可以省略)

  - ../    上一级

    - 之前案例：D:\workspace\atguigu\sz0704\day07_Servlet\web\index.html

      - ./  代表的是D:\workspace\atguigu\sz0704\day07_Servlet\web\
      - ../  代表的是D:\workspace\atguigu\sz0704\day07_Servlet\

    - 此时的案例：http://localhost:8888/day07_Servlet_war_exploded/index.html

      - ./    代表的是:http://localhost:8888/day07_Servlet_war_exploded/

      - ../   代表的是： http://localhost:8888/

      - ```html
        <a href="./hello">HelloServlet</a>
        	相当于请求： http://localhost:8888/day07_Servlet_war_exploded/hello
        <a href="../hello">HelloServlet</a>
        	相当于请求：http://localhost:8888/hello
        
        此时的./和../是相对于我们url
        ```

  - url是什么？

    - 统一资源定位符(就是网址全部内容)：从当前整个网络环境定定位一个资源
      - http://localhost:8888/day07_Servlet_war_exploded/index.html

  - uri是什么？

    - 统一资源标识符(url中的上下文路径开始往后的内容)：从当前项目下寻找一个资源
      - /day07_Servlet_war_exploded/index.html

- 绝对路径

  - 如果路径前添加一个/说明使用的是绝对路径

    - ```java
      <a href="hello">HelloServlet</a>
      <a href="./hello">HelloServlet</a>
      <a href="../hello">HelloServlet</a>
      	hello   其实使用的是相对路径   ./hello
      	./hello  相对路径
      	../hello   相对路径
      
      <a href="/hello">HelloServlet</a>
      	/hello   使用的就是绝对路径
      ```

    - web.xml或注解中配置的访问路径

      - 要求：路径前必须添加/  (必须使用绝对路径，如果没有添加/服务器启动失败)

      - 含义：代表的是上下文路径下

        - http://localhost:8888/day07_Servlet_war_exploded/

        - ```java
          @WebServlet("/hello")
          	//代表的是通过http://localhost:8888/day07_Servlet_war_exploded/hello就可以找到我这个Servlet
          ```

        - ```html
          <a href="./hello">HelloServlet01</a>
          	http://localhost:8888/day07_Servlet_war_exploded/hello
          	必须和Servlet设置的路径完全一致，才可以访问到Servlet
          ```

    - 网页的请求路径

      - 要求：相对路径和绝对路径都可以

        - ```html
          <a href="./hello">HelloServlet01</a>
          通过相对路径去寻找Servlet
          ```

      - 含义：代表的是端口号下

        - http://localhost:8888/

        - ```html
          <a href="/hello">绝对路径HelloServlet01</a>
           从http://localhost:8888/hello   找不到HelloServlet
          ```

        - ```html
          <a href="/day07_Servlet_war_exploded/hello">绝对路径HelloServlet02</a>
           从http://localhost:8888/day07_Servlet_war_exploded/hello
          ```

    - 转发

      - 要求：相对路径和绝对路径都可以

      - ```java
        //相对路径
            //http://localhost:8888/day07_Servlet_war_exploded/first
            //  ./  代表的是http://localhost:8888/day07_Servlet_war_exploded/
            //   ./second    相当于  http://localhost:8888/day07_Servlet_war_exploded/second
        //request.getRequestDispatcher("./second").forward(request,response);
        //绝对路径
            //含义：上下文路径下(web.xml含义一样)
            //   /   代表的是http://localhost:8888/day07_Servlet_war_exploded/
            //   /second   相当于http://localhost:8888/day07_Servlet_war_exploded/second
        request.getRequestDispatcher("/second").forward(request,response);
        ```

    - 重定向

      - 要求：相对路径和绝对路径都可以

      - ```java
        //相对路径
            // url  :  http://localhost:8888/day07_Servlet_war_exploded/first
            //   ./  代表的是  ：  http://localhost:8888/day07_Servlet_war_exploded
            //   ./second   相当于是   http://localhost:8888/day07_Servlet_war_exploded/second
        //response.sendRedirect("./second");
        //绝对路径
            //含义：  代表的是端口号下  (网页中的/含义是一样的)
            //  /   代表的是  ：  http://localhost:8888/
            //  /second   相当于  http://localhost:8888/second
            //  /day07_Servlet_war_exploded/second  相当于
                //   http://localhost:8888/day07_Servlet_war_exploded/second
        response.sendRedirect("/day07_Servlet_war_exploded/second");
        ```

## 5.3 总结

- /的含义
  - web.xml或注解、转发含义是   当前上下文路径
    - /由服务器解析
  - 网页、重定向含义是    端口下
    - /由浏览器解析

- 要求：
  - web.xml或注解必须使用绝对路径
  - 网页、转发、重定向使用绝对相对都可以
- 建议：
  - 能使用绝对路径就使用绝对路径
    - 因为相对路径一旦url发生变化，相对路径就会出问题

# 6.登录注册(不连接数据库)

## 6.1 上下文路径的动态获取

- java中

  - ```java
    String contextPath = request.getContextPath();
    ```

- 网页中

  - 网页中会引入css/js/图片/音频/视频...
  - 都建议使用绝对路径，就有好多重复内容，可以进行提取
    - 在head标签内添加base标签
      - 功能：为当前网页所有路径添加前缀

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <!--统一的前缀：目前还不能动态获取(Thymeleaf就可以动态获取了)-->
    <base href="/day07_test/">
    <meta charset="UTF-8">
    <title>登录页面</title>
    <link rel="stylesheet" href="style.css">
    <script src="dom.js"></script>
</head>
<body>
    <h1>登录页面</h1>
    <form action="login" method="post">
        username:<input type="text" name="username"><br>
        password:<input type="password" name="password"><br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
```













