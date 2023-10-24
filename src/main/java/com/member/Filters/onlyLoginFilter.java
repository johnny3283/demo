package com.member.Filters;

import com.member.model.MemberVO;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class onlyLoginFilter  implements Filter {

	private FilterConfig config;

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	public void destroy() {
		config = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// 【取得 session】
		HttpSession session = req.getSession();
		// 【從 session 判斷此user是否登入過】
		MemberVO member =(MemberVO) session.getAttribute("member");
		if (member == null) {
			session.setAttribute("location", req.getRequestURI());
			res.sendRedirect(req.getContextPath() + "/member/login.jsp");
		}
		else {
			chain.doFilter(request, response);
			
		}
	}
}
