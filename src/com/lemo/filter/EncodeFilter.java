package com.lemo.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @program: ServletDemo
 * @description 编码过滤器
 * @author: NiuBenQi
 * @create: 2020-01-20 17:55
 **/
@WebFilter(urlPatterns = "/*")
public class EncodeFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("过滤器工作中");
        //解决post中文乱码
        HttpServletRequest req = (HttpServletRequest) request;
        req.setCharacterEncoding("UTF-8");
        //放行
        chain.doFilter(req, resp);

    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
