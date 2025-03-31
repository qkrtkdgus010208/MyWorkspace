package jwbook;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO2 {
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

	public int signup(Student2 s) {
		open();
		int result = 0;
		String sql = "INSERT INTO student(username, password, photo) values (?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getUsername());
			pstmt.setString(2, s.getPassword());
			pstmt.setBlob(3, s.getPhoto());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public Student2 login(String username, String password) throws SQLException {
		open();
		String sql = "SELECT * FROM student WHERE username = ? AND password = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					Student2 s = new Student2();
					s.setUsername(rs.getString("username"));
					s.setPhoto(rs.getBlob("photo"));
					return s;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}

	public Student2 getInfo(String username) throws SQLException {
		open();
		Student2 s = new Student2();
		String sql = "SELECT * FROM student WHERE username = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					s.setUsername(rs.getString("username"));
					s.setPhoto(rs.getBlob("photo"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return s;
	}

	public byte[] getImageByUsername(String username) {
		open();
		byte[] imageBytes = null;
		ResultSet rs = null;
		String sql = "SELECT photo FROM student WHERE username = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Blob imageBlob = rs.getBlob("photo");
				imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
				imageBlob.free();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return imageBytes;
	}
}
