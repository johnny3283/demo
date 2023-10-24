package com.member.controller;

import com.member.model.MemService;
import com.member.model.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/mem/MemberServlet")
public class adminMemberServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("insert".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();

			req.setAttribute("errorMsgs", errorMsgs);

			//*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/

			String memberacc = req.getParameter("memberAccount");
			String memberpas = req.getParameter("memberPassword");
			String membername = req.getParameter("memberName");
			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			String memberpho = req.getParameter("memberPhone");
			String membernick = req.getParameter("memberNickname");
			String memberadd = req.getParameter("memberAddress");
			String memberemail = req.getParameter("memberEmail");
			if (memberacc == null || memberacc.trim().length() == 0) {
				errorMsgs.add("會員帳號請勿空白1");
			}
			if (memberpas == null || memberpas.trim().length() == 0) {
				errorMsgs.add("會員密碼請勿空白");
			}
			if (membername == null || membername.trim().length() == 0) {
				errorMsgs.add("會員姓名: 請勿空白");
			} else if (!membername.trim().matches(enameReg)) {
				errorMsgs.add("會員姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}
			if (memberpho == null || memberpho.trim().length() == 0) {
				errorMsgs.add("會員電話請勿空白");
			}
			if (membernick == null || membernick.trim().length() == 0) {
				errorMsgs.add("會員暱稱請勿空白");
			}
			if (memberadd == null || memberadd.trim().length() == 0) {
				errorMsgs.add("會員地址請勿空白");
			}
			if (memberemail == null || memberemail.trim().length() == 0) {
				errorMsgs.add("會員email請勿空白");
			}

			MemberVO memVO = new MemberVO();
			memVO.setMemberName(membername);
			memVO.setMemberAccount(memberacc);
			memVO.setMemberPassword(memberpas);
			memVO.setMemberPhone(memberpho);
			memVO.setMemberNickname(membernick);
			memVO.setMemberAddress(memberadd);
			memVO.setMemberEmail(memberemail);

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("memberVO", memVO);
				RequestDispatcher failureView = req.getRequestDispatcher("/member/addmember.jsp");
				failureView.forward(req, res);
				return;
			}

			MemService memSvc = new MemService();
			memVO = memSvc.addMember(membername, memberacc, memberpas, memberpho, membernick, memberadd,
					memberemail);
			
			
			req.setAttribute("MemberVO", memVO);
			String url = "/member/listAllMember.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);

		}

		if ("update".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();

			req.setAttribute("errorMsgs", errorMsgs);

			//*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer memberno = Integer.valueOf(req.getParameter("memberNo").trim());
			String membername = req.getParameter("memberName");
			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			String memberpho = req.getParameter("memberPhone");
			String membernick = req.getParameter("memberNickname");
			String memberadd = req.getParameter("memberAddress");
			String memberemail = req.getParameter("memberEmail");
			Integer memberstate = Integer.valueOf(req.getParameter("memberState").trim());

			if (membername == null || membername.trim().length() == 0) {
				errorMsgs.add("會員姓名: 請勿空白");
			} else if (!membername.trim().matches(enameReg)) {
				errorMsgs.add("會員姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}
			if (memberpho == null || memberpho.trim().length() == 0) {
				errorMsgs.add("會員電話請勿空白");
			}
			if (membernick == null || membernick.trim().length() == 0) {
				errorMsgs.add("會員暱稱請勿空白");
			}
			if (memberadd == null || memberadd.trim().length() == 0) {
				errorMsgs.add("會員地址請勿空白");
			}
			if (memberemail == null || memberemail.trim().length() == 0) {
				errorMsgs.add("會員email請勿空白");
			}
			if (memberstate == null)  {
				errorMsgs.add("會員狀態請勿空白");
			}else if(memberstate >=2) {
				errorMsgs.add("會狀態只能是0或1");
			}

			MemberVO memVO = new MemberVO();
			memVO.setMemberName(membername);
			memVO.setMemberPhone(memberpho);
			memVO.setMemberNickname(membernick);
			memVO.setMemberAddress(memberadd);
			memVO.setMemberEmail(memberemail);
			memVO.setMemberNo(memberno);
			memVO.setMemberState(memberstate);

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("MemberVO", memVO);
				RequestDispatcher failureView = req.getRequestDispatcher("/member/update_mem_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			//*************************** 2.開始修改資料 *****************************************/
			MemService memSvc = new MemService();
			memVO = memSvc.mngMember( memberno, membername, memberpho, membernick, memberadd,
					memberemail,memberstate);

			//*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("MemberVO", memVO);
			String url = "/member/listAllMember.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		// 查詢會員
		if ("getOne_For_Display".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();

			req.setAttribute("errorMsgs", errorMsgs);

			//*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("memberNo");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入會員編號");
			}

			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/member/listAllMember.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer memberNo = null;
			try {
				memberNo = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("員工編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/member/listAllMember.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			//*************************** 2.開始查詢資料 *****************************************/
			MemService memSvc = new MemService();
			MemberVO memVO = memSvc.getOneMember(memberNo);
			if (memVO == null) {
				errorMsgs.add("查無資料");

			}

			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/member/listAllMember.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			//*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("MemberVO", memVO);
			String url = "/member/listOneMember.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();

			req.setAttribute("errorMsgs", errorMsgs);

			//*************************** 1.接收請求參數 ****************************************/
			Integer memberNo = Integer.valueOf(req.getParameter("memberNo"));

			//*************************** 2.開始查詢資料 ****************************************/
			MemService memSvc = new MemService();
			MemberVO memVO = memSvc.getOneMember(memberNo);
			if (memVO == null) {
				errorMsgs.add("查無資料");

			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/member/listAllMember.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}
			//*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("MemberVO", memVO);
			String url = "/member/update_mem_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			//*************************** 1.接收請求參數 ***************************************/
			Integer memberNo = Integer.valueOf(req.getParameter("memberNo"));

			//*************************** 2.開始刪除資料 ***************************************/
			MemService memSvc = new MemService();
			memSvc.deleteMember(memberNo);

			//*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/member/listAllMember.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}
}
