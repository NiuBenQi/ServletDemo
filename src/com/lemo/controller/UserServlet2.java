package com.lemo.controller;

import com.lemo.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: javaWebDemo
 * @description
 * @author: NiuBenQi
 * @create: 2020-01-11 10:46
 **/
@WebServlet("/UserServlet2")
public class UserServlet2 extends HttpServlet {
    // UserServlet2 类为单例模式，所以只能有一个对象，使用无参构造把new arraylist对象和添加数据写到无参构造里
    List<User> list = null;

    public UserServlet2() {
        list = new ArrayList<>();
        //2.获取请求参数并封装为对象
        list.add(new User(1, "zs", "666"));
        list.add(new User(2, "ls", "888"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String action = request.getParameter("action");
        if ("login".equals(action)) {
            login(request, response);
        } else if ("findAll".equals(action)) {
            findAll(request, response);
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("test/html;charset=UTF-8");
        // 将list放入request值域中
        request.setAttribute("list", list);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受请求并相应
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //3.数据验证非空 正则表达式
        boolean b = false;
        for (User i : list) {
            if (i.getUserName().equals(username) && i.getUserPwd().equals(password)) {
                b = true;
                break;
            }
        }
        //4.登录业务处理 ,得到登录结果
        if (b) {
            System.out.println("登录成功");
            // 登陆成功，记住密码 cookie
            Cookie c = new Cookie("username", username);
            // 存放1天，以秒为单位
            c.setMaxAge(1 * 24 * 60 * 60);
            response.addCookie(c);
            // 服务器内部转发,同一请求，地址栏不变
            // session 会话，（登陆成功后将用户信息放入session值域）
            request.getSession().setAttribute("user", new User(username, password));
            PrintWriter pw = response.getWriter();
            String jsonStr = "{\"strtus\":0,\"message\":\"ok\"}";
            pw.print(jsonStr);
            // 从一个控制层跳到另一个控制层方法   servlet---servlet
            request.getRequestDispatcher("UserServlet2?action=findAll").forward(request, response);
        } else {
            //重定向 两次请求，地址栏发生变化
            response.sendRedirect("login.jsp");
        }
    }
}
