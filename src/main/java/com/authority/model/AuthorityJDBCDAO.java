package com.authority.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AuthorityJDBCDAO implements AuthorityDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/FOOD?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";

	@Override
	public void insert(AuthorityVO authorityVO) {

		String sql = "INSERT INTO Authority(authority_name) VALUES(?)";
		try (Connection conn = DriverManager.getConnection(url, userid, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, authorityVO.getAuthorityName());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(AuthorityVO authorityVO) {
		String sql = "update Authority set authority_name = ? where authority_no = ?";
		try (Connection conn = DriverManager.getConnection(url, userid, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, authorityVO.getAuthorityName());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(AuthorityVO authorityVO) {
		String sql = "delete from Authority where authority_no = ?";
		try (Connection conn = DriverManager.getConnection(url, userid, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, authorityVO.getAuthorityNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public AuthorityVO findByPrimaryKey(Integer authorityNo) {
		String sql = "select * from Authority where authority_no = ?";
		try (Connection conn = DriverManager.getConnection(url, userid, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, authorityNo);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					AuthorityVO vo = new AuthorityVO();
					vo.setAuthorityNo(rs.getInt("authority_no"));
					vo.setAuthorityName(rs.getString("authority_name"));

					return vo;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AuthorityVO> getAll() {
		String sql = "select * from Authority";
		try (Connection conn = DriverManager.getConnection(url, userid, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			List<AuthorityVO> list = new ArrayList<>();
			while (rs.next()) {
				AuthorityVO vo = new AuthorityVO();
				vo.setAuthorityNo(rs.getInt("authority_no"));
				vo.setAuthorityName(rs.getString("authority_name"));
				list.add(vo);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
