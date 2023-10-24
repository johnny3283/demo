package com.manager.model;

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

public class ManagerDAO implements ManagerDAO_interface {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/jihaoshi");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	// manager_no, manager_name, manager_ip, manager_account,
	// manager_password,manager_status

	private static final String INSERT_STMT = "INSERT INTO backend_manager (manager_name,manager_ip,manager_account,manager_password) VALUES (?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT * from backend_manager ";
	private static final String GET_ONE_STMT = "SELECT manager_no, manager_name, manager_ip, manager_account, manager_password, manager_status FROM backend_manager where manager_no = ?";
	private static final String DELETE = "DELETE FROM backend_manager where manager_no = ?";
	private static final String UPDATE = "UPDATE backend_manager set manager_name=?,manager_account=?,manager_password=?,manager_ip=?, manager_status=? where manager_no = ?";
	private static final String Login = "SELECT * FROM backend_manager where manager_account = ? and manager_password = ?";
	private static final String GET_AUTHORITY = "SELECT b.manager_no,e.authority_no\r\n"
			+ "	FROM authority_detail a \r\n"
			+ "	join authority e join backend_manager b \r\n"
			+ "	on a.authority_no = e.authority_no \r\n"
			+ "	and b.manager_no = a.manager_no\r\n"
			+ "	where b.manager_no = ?  ";

	@Override
	public void insert(ManagerVO ManagerVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, ManagerVO.getManagerAccount());
			pstmt.setString(2, ManagerVO.getManagerPassword());
			pstmt.setString(3, ManagerVO.getManagerName());
			pstmt.setString(4, ManagerVO.getManagerIp());

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
	public void update(ManagerVO ManagerVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, ManagerVO.getManagerName());
			pstmt.setString(2, ManagerVO.getManagerAccount());
			pstmt.setString(3, ManagerVO.getManagerPassword());
			pstmt.setString(4, ManagerVO.getManagerIp());
			pstmt.setInt(5, ManagerVO.getManagerStatus());
			pstmt.setInt(6, ManagerVO.getManagerNo());
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
	public ManagerVO findByPrimaryKey(Integer managerNo) {
		ManagerVO ManamgerVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, managerNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				ManamgerVO = new ManagerVO();
				ManamgerVO.setManagerName(rs.getString("manager_name"));
				ManamgerVO.setManagerIp(rs.getString("manager_ip"));
				ManamgerVO.setManagerAccount(rs.getString("manager_account"));
				ManamgerVO.setManagerPassword(rs.getString("manager_password"));
				ManamgerVO.setManagerStatus(rs.getInt("manager_status"));;
				ManamgerVO.setManagerNo(rs.getInt("manager_no"));

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
		return ManamgerVO;
	}

	@Override
	public ManagerVO selectForLogin(String mamberAccount, String mamberPassword) {
		ManagerVO ManagerVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(Login);

			pstmt.setString(1, mamberAccount);
			pstmt.setString(2, mamberPassword);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				ManagerVO = new ManagerVO();
				ManagerVO.setManagerAccount(rs.getString("manager_account"));
//				MemberVO.setManagerPassword(rs.getString("manager_password"));
				ManagerVO.setManagerName(rs.getString("manager_name"));
				ManagerVO.setManagerNo(rs.getInt("manager_no"));
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
		return ManagerVO;
	}

	@Override
	public List<Integer> GetAuthority(Integer managerNo) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_AUTHORITY);

			pstmt.setInt(1, managerNo);

			rs = pstmt.executeQuery();
			List<Integer> authorityNo=new ArrayList();
			while (rs.next()) {

				authorityNo.add(rs.getInt("authority_no"));
			}
			return authorityNo;


		} catch (Exception se) {
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
		return null;
	}
	@Override
	public List<ManagerVO> getAll() {
		List<ManagerVO> list = new ArrayList<ManagerVO>();
		ManagerVO manVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			// manager_no, manager_name, authority_name, manager_account, manager_status

			while (rs.next()) {

				manVO = new ManagerVO();
				manVO.setManagerNo(rs.getInt("manager_no"));
				manVO.setManagerName(rs.getString("manager_name"));
				manVO.setManagerAccount(rs.getString("manager_account"));
				manVO.setManagerStatus(rs.getInt("manager_status"));

				list.add(manVO);
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

}
