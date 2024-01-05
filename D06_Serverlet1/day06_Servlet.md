# 1.自我介绍

```tex
陈鑫 河北唐山  微信(陈鑫) 
```

# 2.资料

```tex
16_SZ_0704JavaEE    每日的学习资料(视频、随堂笔记、完整项目代码)
03_尚硅谷_JavaEE学科_Web    web阶段学习资料包
sz0704             实施项目代码
```

# 3.学习流程

```tex
8:30读单词，5分钟
回顾前一天的知识点
正课
1:45午分享
正课
```

# 4.回顾

```tex
1. Servlet的入门
	为什么需要Servlet? (服务器端的小程序)
2. Servlet HelloWorld
	创建一个类
	实现一个接口Servlet
	实现五个抽象方法(service)
	需要在web.xml中配置访问路径
3. Servlet的生命周期
4. ServletConfig和ServletContext	
5. Servlet体系结构	
```

# 5.HttpServletRequest(请求)

- request对象中有请求中的所有数据
- 和Servlet对象一样，对象创建由Servlet容器负责

## 5.1 获得请求参数

- 客户通过客户端传送过来的数据

- ```java
  String request.getParameter(String key);
  	根据name值获取value值
  String[] request.getParameterValues(String key);
  	根据name获取多个value值
  Map<String,String[]> request.getParameterMap();
  	获取所有的请求参数
  ```

- BeanUtils工具的介绍

  - ```java
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
    ```

## 5.2 获取url地址参数

- ```java
  //1. 获取URL地址参数
  String contextPath = request.getContextPath();
  System.out.println("contextPath = " + contextPath);//获得上下文路径  ★
  
  String serverName = request.getServerName();
  System.out.println("serverName = " + serverName);
  
  int serverPort = request.getServerPort();
  System.out.println("serverPort = " + serverPort);
  
  String scheme = request.getScheme();
  System.out.println("scheme = " + scheme);
  ```

## 5.3 获取请求头信息

- ```java
  //2. 获取请求头信息
  String header = request.getHeader("User-Agent");//获取客户端的产品信息
  System.out.println("header = " + header);
  
  String referer = request.getHeader("Referer");//获取请求的来源
  System.out.println("referer = " + referer);
  ```

## 5.4 请求的转发

- 一个Servlet不能处理完请求，需要多个Servlet处理

- ```java
  //3. 转发
  //转发到SecondServlet
  //1. 获得转发器对象
  RequestDispatcher requestDispatcher = request.getRequestDispatcher("/second");
  //2. 进行转发
  requestDispatcher.forward(request,response);
  ```

## 5.5 在请求域中共享数据

- 全局(应用)域

  - 整个web项目

- 请求域

  - 本次请求

- ```java
  // 转发之前，需要传递数据到SecondServlet
  // 将数据共享到请求域内
  request.setAttribute("msg","这是共享数据");
  request.setAttribute("port",serverPort);
  ```

- SecondServlet就可以获取到共享数据

- ```java
  Object msg = request.getAttribute("msg");
  System.out.println("msg = " + msg);
  
  Object port = request.getAttribute("port");
  System.out.println("port = " + port);
  ```

- 点击完first请求，SecondServlet是可以取到数据的(一次请求)
- 直接点击second,SecondServlet是取不到数据的(两次请求)

## 5.6 转发也是页面跳转的主要手段之一

```java
/*通过转发，转发到此页面*/
request.getRequestDispatcher("/success.html").forward(request,response);
```

# 6.HttpServletResponse(响应)

























