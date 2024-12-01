package projectThings;

public class CustomerLogin {
	//declring
	String UserType;
	String cEmail;
	String password;
	
	//default constructor
	public CustomerLogin() {
		
		this.UserType = "";
		this.cEmail = "";
		this.password = "";
	}
	
	//parameterized constructor
	public CustomerLogin(String userType,String cEmail, String pw) {
		
		this.UserType = userType;
		this.cEmail = cEmail;
		this.password = pw;
		
	}
	
	//copy constructor
	public CustomerLogin(CustomerLogin cLogin) {
		
		this.UserType = cLogin.UserType;
		this.cEmail = cLogin.cEmail;
		this.password = cLogin.password;
		
		
	}

	//getter setter
	public String getUserType() {
		return UserType;
	}


	public void setRegId(String userType) {
		this.UserType = userType;
	}
	
	public String getcEmail() {
		return cEmail;
	}


	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}


	public String getPw() {
		return password;
	}


	public void setPw(String pw) {
		this.password = pw;
	}


	@Override
	public String toString() {
		return "CustomerLogin [UserType=" + UserType + ", cEmail=" + cEmail + ", password=" + password + "]";
	}

	
	
	
}
