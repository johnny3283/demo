package com.authority_detail.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AuthorityDetailJDBCDAO implements AuthorityDetailDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/FOOD?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";
	@Override
	public void insert(AuthorityDetailVO authorityDetailVO) {
		String sql = "INSERT INTO Authority_detail(manger_no , authority_no) VALUES(?,?)";
		try (Connection conn = DriverManager.getConnection(url, userid, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, authorityDetailVO.getMangerNo());
			pstmt.setInt(2, authorityDetailVO.getAuthorityNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(AuthorityDetailVO authorityDetailVO) {
		String sql = "update Authority_detail set authority_no = ? where manger_no = ?";
		try (Connection conn = DriverManager.getConnection(url, userid, passwd);
				
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, authorityDetailVO.getMangerNo());
			pstmt.setInt(2, authorityDetailVO.getAuthorityNo());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	@Override
	public void delete(AuthorityDetailVO authorityDetailVO) {
		String sql = "delete from Authority_detail where manger_no = ?";
		try (Connection conn = DriverManager.getConnection(url, userid, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, authorityDetailVO.getMangerNo());
			pstmt.setInt(1, authorityDetailVO.getAuthorityNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public List<AuthorityDetailVO> getAll() {
		String sql = "select * from Authority_detail";
		try (Connection conn = DriverManager.getConnection(url, userid, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			List<AuthorityDetailVO> list = new ArrayList<>();
			while (rs.next()) {
				AuthorityDetailVO vo = new AuthorityDetailVO();
				vo.setMangerNo(rs.getInt("manger_no"));
				vo.setAuthorityNo(rs.getInt("authority_no"));

				list.add(vo);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ManagerAuthorityVO> findByManagerNo(Integer managerNo) {
		String sql = "select ad.*, a.authority_name from Authority_detail ad join Authority a on ad.authority_no = a.authority_no where ad.manager_no = ?";
		try (
			Connection conn = DriverManager.getConnection(url, userid, passwd);
			PreparedStatement pstmt = conn.prepareStatement(sql)
		) {
			pstmt.setInt(1, managerNo);
			List<ManagerAuthorityVO> list = new ArrayList<>();
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					ManagerAuthorityVO vo = new ManagerAuthorityVO();
					vo.setManagerNo(rs.getInt("manager_no"));
					vo.setAuthorityNo(rs.getInt("authority_no"));
					vo.setAuthorityName(rs.getString("authority_name"));
					list.add(vo);
				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
