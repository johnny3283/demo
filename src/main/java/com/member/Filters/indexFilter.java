package com.member.Filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class indexFilter implements Filter {

    private FilterConfig config;

    public void init(FilterConfig config) {
        this.config = config;
    }

    public void destroy() {
        config = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        // 【取得 session】
        HttpSession session = req.getSession();
        // 【從 session 判斷此user是否登入過】
        Object account = session.getAttribute("member");
        if (account == null) {
            session.setAttribute("Guest", "訪客");
            chain.doFilter(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }
}