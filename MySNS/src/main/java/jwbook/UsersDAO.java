package jwbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsersDAO {
	Connection conn = null;
	PreparedStatement pstmt;

	final String JDBC_DRIVER = "org.h2.Driver";
	final String JDBC_URL = "jdbc:h2:tcp://localhost/~/jwbookdb";

	public void open() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, "jwbook", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int signup(Users u) {
		open();
		int result = 0;
		String sql = "INSERT INTO users(id, password, name, ts, img) values (?, ?, ?, CURRENT_TIMESTAMP(0), ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getId());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getName());
			pstmt.setString(4, u.getImg());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public Users login(String id, String pw){
		open();
		String sql = "SELECT * FROM users WHERE id = ? AND password = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					Users u = new Users();
					u.setId(rs.getString("id"));
					u.setName(rs.getString("name"));
					u.setImg(rs.getString("img")); // 사용자 이미지 경로 설정
					return u;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}
	
	public int withdraw(String id) {
	    open();
	    int result = 0;
	    String sql = "DELETE FROM users WHERE id = ?";
	    try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, id);
	        result = pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close();
	    }
	    return result;
	}
}