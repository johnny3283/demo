package com.member.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class MemberDAO implements MemberDAO_interface {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/jihaoshi");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO member (member_account,member_password,member_name,member_phone,member_nickname,member_address,member_email) VALUES (?, ?, ?, ?, ?,?,?)";
	private static final String GET_ALL_STMT = "SELECT member_no,member_account,member_password,member_name,member_phone,member_nickname,member_address,member_email,member_state FROM member order by member_no";
	private static final String GET_ONE_STMT = "SELECT member_no,member_account,member_password,member_name,member_phone,member_nickname,member_address,member_email,member_state FROM member where member_no = ?";
	private static final String DELETE = "DELETE FROM member where member_no = ?";
	private static final String UPDATE = "UPDATE member set member_name=?,member_phone=?,member_nickname=?,member_address=?,member_email=?,member_state=? where member_no = ?";
	private static final String MNGMEMBER = "UPDATE member set member_name=?,member_phone=?,member_nickname=?,member_address=?,member_email=? where member_no = ?";
	private static final String Login = "SELECT * FROM MEMBER where member_account = ? and member_password = ?";
	private static final String GET_EMAIL_STMT = "SELECT member_no,member_account,member_email FROM MEMBER where member_email = ?";
	private static final String GET_OnlineCourseComments_ByMemberNo_STMT = "SELECT comment_no,member_no,course_no,comment_content,comment_score,comment_status FROM Online_course_comment where member_no = ? order by comment_no";
	private static final String GET_OnlineCourseCommentReports_ByMemberNo_STMT = "SELECT * FROM Online_course_comment_report where member_no = ? order by report_no";
	private static final String GET_ACCOUNT_STMT = "SELECT * FROM MEMBER where member_account = ?";
	private static final String GET_PhyCourseComments_ByMemberNo_STMT =
			"SELECT * FROM Physical_course_comment where member_no = ? order by comment_no";
	private static final String GET_PhyCourseCommentReports_ByMemberNo_STMT =
			"SELECT * FROM Online_course_comment_report where member_no = ? order by report_no";


	@Override
	public void insert(MemberVO memberVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, memberVO.getMemberAccount());
			pstmt.setString(2, memberVO.getMemberPassword());
			pstmt.setString(3, memberVO.getMemberName());
			pstmt.setString(4, memberVO.getMemberPhone());
			pstmt.setString(5, memberVO.getMemberNickname());
			pstmt.setString(6, memberVO.getMemberAddress());
			pstmt.setString(7, memberVO.getMemberEmail());

			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}
	@Override
	public void update(MemberVO memberVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, memberVO.getMemberName());
			pstmt.setString(2, memberVO.getMemberPhone());
			pstmt.setString(3, memberVO.getMemberNickname());
			pstmt.setString(4, memberVO.getMemberAddress());
			pstmt.setString(5, memberVO.getMemberEmail());
			pstmt.setInt(6,memberVO.getMemberState());
			pstmt.setInt(7, memberVO.getMemberNo());
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}
	@Override
	public void mngMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(MNGMEMBER);
			
			pstmt.setString(1, memberVO.getMemberName());
			pstmt.setString(2, memberVO.getMemberPhone());
			pstmt.setString(3, memberVO.getMemberNickname());
			pstmt.setString(4, memberVO.getMemberAddress());
			pstmt.setString(5, memberVO.getMemberEmail());
			pstmt.setInt(6, memberVO.getMemberNo());
			pstmt.executeUpdate();
			
			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}
	@Override
	public MemberVO findByPrimaryKey(Integer memberNo) {
		MemberVO MemberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, memberNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				MemberVO = new MemberVO();
				MemberVO.setMemberNo(rs.getInt("member_no"));
				MemberVO.setMemberAccount(rs.getString("member_account"));
				MemberVO.setMemberPassword(rs.getString("member_password"));
				MemberVO.setMemberName(rs.getString("member_name"));
				MemberVO.setMemberPhone(rs.getString("member_phone"));
				MemberVO.setMemberNickname(rs.getString("member_nickname"));
				MemberVO.setMemberAddress(rs.getString("member_address"));
				MemberVO.setMemberEmail(rs.getString("member_email"));
				MemberVO.setMemberState(rs.getInt("member_state"));
			}

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return MemberVO;
	}
	@Override
	public MemberVO selectForLogin(String memberAccount, String memberPassword) {
		MemberVO MemberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(Login);

			pstmt.setString(1, memberAccount);
			pstmt.setString(2, memberPassword);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				MemberVO = new MemberVO();
				MemberVO.setMemberAccount(rs.getString("member_account"));
//				MemberVO.setMemberPassword(rs.getString("member_password"));
				MemberVO.setMemberName(rs.getString("member_name"));
				MemberVO.setMemberNo(rs.getInt("member_no"));
			}

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return MemberVO;
	}
	@Override
	public void delete(Integer memberNo) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, memberNo);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}
	@Override
	public List<MemberVO> getAll() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO MemberVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				MemberVO = new MemberVO();
				MemberVO.setMemberNo(rs.getInt("member_no"));
				MemberVO.setMemberAccount(rs.getString("member_account"));
				MemberVO.setMemberPassword(rs.getString("member_password"));
				MemberVO.setMemberName(rs.getString("member_name"));
				MemberVO.setMemberPhone(rs.getString("member_phone"));
				MemberVO.setMemberNickname(rs.getString("member_nickname"));
				MemberVO.setMemberAddress(rs.getString("member_address"));
				MemberVO.setMemberEmail(rs.getString("member_email"));
				MemberVO.setMemberState(rs.getInt("member_state"));
				list.add(MemberVO);
			}

		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}
	@Override
	public MemberVO findByAccount(String memberAccount) {

		MemberVO memberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ACCOUNT_STMT);

			pstmt.setString(1, memberAccount);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMemberNo(rs.getInt("member_no"));
				memberVO.setMemberAccount(rs.getString("member_account"));
			}
			// Handle any SQL errors
		} catch (Exception se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return memberVO;
	}
	@Override
	public MemberVO findByEmail(String memberEmail) {
		
		MemberVO memberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_EMAIL_STMT);
			
			pstmt.setString(1, memberEmail);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMemberNo(rs.getInt("member_no"));
				memberVO.setMemberEmail(rs.getString("member_email"));
			}
			// Handle any SQL errors
		} catch (Exception se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return memberVO;
	}
}
