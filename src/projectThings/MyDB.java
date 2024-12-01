package projectThings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MyDB {   

	// Declaring Mysql Connection to database 
	
	String SERVER = "remotemysql.com"; //localhost
	String USER = "Kpjlw3Oe8S"; //root
	String PASSWORD = "aN5gTTPRCa"; //''
	int PORT = 3306; //3306
	String DB_NAME = "Kpjlw3Oe8S"; //db_pop
	String DRIVER = "com.mysql.cj.jdbc.Driver";
	String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME+"";
	
	public Login doLogin(String eMail, String password){  // Stores Login Details 
	
		String sql = "SELECT * FROM Login WHERE Email='"+eMail+"' and Password='"+password+"'";
		
		Login lgnDetails = new Login(); 
		
		try {
			//Connect			
			Class.forName(DRIVER); //Driver Loading					
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //Connect with database			

			//Select
			PreparedStatement pstat = conn.prepareStatement(sql); //To execute SQL Statement
			ResultSet rs = pstat.executeQuery(sql);
			
			if(rs.next()) {
				
				lgnDetails = new Login();
				
				lgnDetails.setLoginId(rs.getInt("Login_ID"));   // Gets Login_Id 
				lgnDetails.setUserType(rs.getString("User_Type")); // Gets User_Type
				lgnDetails.seteMail(rs.getString("Email"));      // Gets Email
				lgnDetails.setPass(rs.getString("Password"));    // Gets Password
			}
			
			rs.close();
			pstat.close();
			conn.close();
		}
		
		catch(Exception ex) {
			System.out.println("Error: "+ex.getMessage());
		}
		return lgnDetails; // returns the values 
		
	}
	public int getRegID(int loginID) {
		//"SELECT reg_id FROM `Customer` WHERE Login_ID="+loginID;
		//connect
		//execute statement
		//get regid		
		return 0;
	}
	public BookingDetails doBooking(int Reg_ID,String userType){   // BookingsDetails depending on UserType
		
		String sql = "";
		if (userType.equals("Customer")) {
			sql = "SELECT * FROM Booking_Information WHERE Reg_ID = "+Reg_ID;
		}
		else {
			sql = "SELECT * FROM Booking_Information WHERE Corporate_Registration_ID = "+Reg_ID;
		}
		BookingDetails bookingDetails = new BookingDetails();
		
		try {
			//Connect			
			Class.forName(DRIVER); //Driver Loading					
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //Connect with database			

			//Select
			PreparedStatement pstat = conn.prepareStatement(sql); //To execute SQL Statement
			ResultSet rs = pstat.executeQuery(sql);
			
			if(rs.next()) {
				
				bookingDetails = new BookingDetails();
				
				bookingDetails.setBookingID(rs.getInt("Booking_ID"));
				bookingDetails.setCheckIn(rs.getString("Check_In"));
				bookingDetails.setCheckOut(rs.getString("Check_Out"));
				bookingDetails.setBookingStatus(rs.getString("Booking_Status"));
				bookingDetails.setCurrentBill(rs.getInt("Current_Bill"));
				bookingDetails.setPreferredRoomType(rs.getString("Preferred_Room_Type"));
				bookingDetails.setRoomNo(rs.getInt("Room_No"));
				bookingDetails.setRegID(rs.getInt("Reg_ID"));
				bookingDetails.setCorID(rs.getInt("Corporate_Registration_ID"));
				bookingDetails.setStaffID(rs.getInt("Staff_ID"));
				
				
				
			}
			
			rs.close();
			pstat.close();
			conn.close();
		}
		
		catch(Exception ex) {
			System.out.println("Error: "+ex.getMessage());
		}
		return bookingDetails;   // Returns the Details of the Wanted Booking 
		
	}
	
	
	
}
