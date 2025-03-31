package jwbook;

public class LoginBean {
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String id;
	private String password;
	
	public boolean vaildate() {
		if (password.equals("admin"))
			return true;
		else
			return false;
	}
	
}
