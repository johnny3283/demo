package com.member.controller;

import com.member.model.MemService;
import com.member.model.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/getOneMem")
public class getOneMem extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		

			List<String> errorMsgs = new LinkedList<String>();

			req.setAttribute("errorMsgs", errorMsgs);

			//*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			HttpSession session = req.getSession();
			MemberVO memberVO =(MemberVO) session.getAttribute("member");
			
			Integer No = memberVO.getMemberNo();
			if(No == null) {
				RequestDispatcher failureView = req.getRequestDispatcher("/member/login.jsp");
				failureView.forward(req, res);
				return;
			}
			
			

			//********************************************************************/
			MemService memSvc = new MemService();
			MemberVO member = memSvc.getOneMember(No);


		req.setAttribute("MemberVO", member);
		String url = "/member/listOneMember.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url);
		successView.forward(req, res);

		}
	}


