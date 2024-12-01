package projectThings;

public class Login {
	
	private int loginId;
	private String userType;
	private String eMail;
	private String pass;
	
	//default constructor
	public Login() {
		
		this.loginId=0;
		this.userType = "";
		this.eMail = "";
		this.pass = "";
	}
	
	//parameterized constructor
	public Login(int loginID, String userType, String eMail, String pass) {
		
		this.loginId=loginID;
		this.userType = userType;
		this.eMail = eMail;
		this.pass = pass;
	}
	
	//copy constructor
	public Login(Login loginDetails) {
		
		this.loginId=loginDetails.loginId;
		this.userType = loginDetails.userType;
		this.eMail = loginDetails.eMail;
		this.pass = loginDetails.pass;
	}
	
	
	//getter and setter
	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", userType=" + userType + ", eMail=" + eMail + ", pass=" + pass
				+ ", getLoginId()=" + getLoginId() + ", getUserType()=" + getUserType() + ", geteMail()=" + geteMail()
				+ ", getPass()=" + getPass() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
	
}
