package projectThings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CRUD1 {
	Connection conn;
	Statement stat;
	public void connectDB() { // Connection of DB 
		//1. Download and configure MySQL driver		
		//2. Collect MySQL Server Info		
		String SERVER = "remotemysql.com"; //localhost
		String USER = "Kpjlw3Oe8S"; //root
		String PASSWORD = "aN5gTTPRCa"; //''
		int PORT = 3306; //3306
		String DB_NAME = "Kpjlw3Oe8S"; //db_pop
		try {
			//3. Connect with Database Server
			//3.a Loading Driver
			String DRIVER = "com.mysql.cj.jdbc.Driver";		
			Class.forName(DRIVER); //Driver Loading			
			//3.b Connect with Database Server
			String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME+"";
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);						
			//System.out.println("Connect database server successfully!");
			//Create table
			//Alter table
			//Drop table
			conn.close();
			//System.out.println("Connection Closed!");
		}
		catch(Exception ex) {
			System.out.println("Error : "+ex.getMessage());
		}
	}
	
	public void insertRecordLogin(String userType, String email, String pass){  // To insert in Login
		
		String SERVER = "remotemysql.com"; //localhost
		String USER = "Kpjlw3Oe8S"; //root
		String PASSWORD = "aN5gTTPRCa"; //''
		int PORT = 3306; //3306
		String DB_NAME = "Kpjlw3Oe8S"; //db_pop
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME+"";
		String sqlLogin="insert into Login (User_Type,Email,Password) values('"+userType+"', '"+email+"', '"+pass+"');";
		//String sqlCustomer="insert into Customer_Data values("+cRegno+", '"+cName+"', '"+cAddress+"', "+cPh+", '"+cEmail+"');";
		try {
			//Connect			
			Class.forName(DRIVER); //Driver Loading					
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //Connect with database			

			//Insert
			Statement stat = conn.createStatement();
			stat.executeUpdate(sqlLogin);//Insert Record
			//stat.executeUpdate(sqlCustomer);//Insert Record
			//Close
			stat.close();
			conn.close();
			System.out.println("Insert Record Successfully!");
		}
		catch(Exception ex) {
			System.out.println("Error: "+ex.getMessage());
		}		
	}
	
	public void insertCustomer(int loginId, String fullName, String address,long telNo, String email) { // to insert in Customer
		 
		String SERVER = "remotemysql.com"; //localhost
		String USER = "Kpjlw3Oe8S"; //root
		String PASSWORD = "aN5gTTPRCa"; //''
		int PORT = 3306; //3306
		String DB_NAME = "Kpjlw3Oe8S"; //db_pop
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME+"";
		//String sqlLogin="insert into Login values('"+userType+"', '"+email+"', '"+pass+"');";
		String sqlCustomer= "insert into Customer(Login_ID, Name, Address, Tele_No, Email) values("+loginId+", '"+fullName+"', '"+address+"', "+telNo+", '"+email+"');";                 		
		try {
			
			Class.forName(DRIVER); //Driver Loading					
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //Connect with database	
			
			Statement stat = conn.createStatement();
			//stat.executeUpdate(sqlLogin);//Insert Record
			stat.executeUpdate(sqlCustomer);
			//stat.executeUpdate(sqlCustomer);//Insert Record
			//Close
			stat.close();
			conn.close();
			System.out.println("Insert Record Successfully!");
		}
		
		catch(Exception ex) {
			System.out.println("Error: "+ex.getMessage());
		}
		
		
	}
	
	public void insertCorporate(int LoginId, String corName, String contaddress, String billAddress, long corphNo,String corEmail ) { // to insert in corporate
		
		String SERVER = "remotemysql.com"; //localhost
		String USER = "Kpjlw3Oe8S"; //root
		String PASSWORD = "aN5gTTPRCa"; //''
		int PORT = 3306; //3306
		String DB_NAME = "Kpjlw3Oe8S"; //db_pop
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME+"";
		String sqlCorporate = "insert into Corporate(Login_ID, Corporate_Name, Corporate_Contact_Address, Corporate_Billing_Address, Corporate_Telephone_Number, Email) values("+LoginId+", '"+corName+"', '"+contaddress+"', '"+billAddress+"',"+corphNo+",'"+corEmail+"');";
		
		
		try {
			
			Class.forName(DRIVER); //Driver Loading					
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //Connect with database
			Statement stat = conn.createStatement();
			stat.executeUpdate(sqlCorporate);
			//stat.executeUpdate(sqlCustomer);//Insert Record
			//Close
			stat.close();
			conn.close();
			System.out.println("Insert Record Successfully!");
			
		}
		
		catch(Exception ex) {
			System.out.println("Error: "+ex.getMessage());
		}
		
		
	}
	
	public void insertStaff(int loginId,String stName, String stAddress, String date, String designation, String stEmail) { // for Staff registration
		
		String SERVER = "remotemysql.com"; //localhost
		String USER = "Kpjlw3Oe8S"; //root
		String PASSWORD = "aN5gTTPRCa"; //''
		int PORT = 3306; //3306
		String DB_NAME = "Kpjlw3Oe8S"; //db_pop
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME+"";
		String sqlStaff = "insert into Staff(Login_ID,Staff_Name, Staff_Address, Staff_Working_Since, Designation, Email) values("+loginId+",'"+stName+"','"+stAddress+"','"+date+"','"+designation+"','"+stEmail+"');";
		
		try{
			
			Class.forName(DRIVER); //Driver Loading					
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //Connect with database
			Statement stat = conn.createStatement();
			stat.executeUpdate(sqlStaff);
			
			stat.close();
			conn.close();
			System.out.println("Insert Record Successfully!");
		}
		
		catch(Exception ex) {
			System.out.println("Error: "+ex.getMessage());
		}
		
		
		
	}
	
	public void insertBooking(String chkIn, String chkOut, String roomType, int RoomNo, int reg_id, String user_type) {  // Inserting Data in Booking

        String SERVER = "remotemysql.com"; //localhost
        String USER = "Kpjlw3Oe8S"; //root
        String PASSWORD = "aN5gTTPRCa"; //''
        int PORT = 3306; //3306
        String DB_NAME = "Kpjlw3Oe8S"; //db_pop
        String DRIVER = "com.mysql.cj.jdbc.Driver";
        String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME+"";
        String sql="";
        
        if(user_type.equals("Customer")){
        	sql= "insert into Booking_Information(Check_In,Check_Out,Preferred_Room_Type,Room_No,Reg_ID) values('"+chkIn+"', '"+chkOut+"','"+roomType+"',"+RoomNo+","+reg_id+");";
        }
        else {
        	sql= "insert into Booking_Information(Check_In,Check_Out,Preferred_Room_Type,Room_No,Corporate_Registration_ID) values('"+chkIn+"', '"+chkOut+"','"+roomType+"',"+RoomNo+","+reg_id+");";
        }
        
System.out.println(sql);

          try{

                Class.forName(DRIVER); //Driver Loading
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //Connect with database
                Statement stat = conn.createStatement();
                stat.executeUpdate(sql);

                stat.close();
                conn.close();
                System.out.println("Insert Record Successfully!");
            }

            catch(Exception ex) {
                System.out.println("Error: "+ex.getMessage());
            }

    }
	
	public void updateRoomStatus(int roomNo, String status) { // Updating Rooms Status 
		
			String SERVER = "remotemysql.com"; //localhost
			String USER = "Kpjlw3Oe8S"; //root
			String PASSWORD = "aN5gTTPRCa"; //''
			int PORT = 3306; //3306
			String DB_NAME = "Kpjlw3Oe8S"; //db_pop
			String DRIVER = "com.mysql.cj.jdbc.Driver";
			String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME+"";
			String sql = "update Rooms set Room_Status = '"+status+"' where Room_No = '"+roomNo+"';";
		
			try {
				//Connect			
				Class.forName(DRIVER); //Driver Loading					
				Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //Connect with database			

				//Update
				Statement stat = conn.createStatement();
				stat.executeUpdate(sql);//Update Record
			
				//Close
				stat.close();
				conn.close();
				System.out.println("Update Record Successfully!");

			}
			catch(Exception ex) {
				System.out.println("Error: "+ex.getMessage());
			}
		
		}
	
	public int getLoginID() {		// Returns the latest Login ID
		String SERVER = "remotemysql.com"; //localhost
		String USER = "Kpjlw3Oe8S"; //root
		String PASSWORD = "aN5gTTPRCa"; //''
		int PORT = 3306; //3306
		String DB_NAME = "Kpjlw3Oe8S"; //db_pop
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME+"";
		
		int loginID = 0;
		
		String sqlCFromLogin = "select MAX(Login_ID) from Login";
		
		try {
			//Connect			
			Class.forName(DRIVER); //Driver Loading					
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //Connect with database			

			//Select
			Statement stat = conn.createStatement(); //To execute SQL Statement
			ResultSet rs = stat.executeQuery(sqlCFromLogin);
			
			if(rs.next()) {
				//System.out.println(rs.getInt(1));
				loginID = rs.getInt(1);
			}
			//Close
			rs.close();
			stat.close();
			conn.close();
			//System.out.println("Select Record Successfully!");
		}
		
		catch(Exception ex) {
			System.out.println("Error: "+ex.getMessage());
		}
		
		return loginID;		
	}
	
	public int getRegID(int login_id, String userType) {  // Returns reg_Id for either customer or corporate based on login_id
		
		String SERVER = "remotemysql.com"; //localhost
		String USER = "Kpjlw3Oe8S"; //root
		String PASSWORD = "aN5gTTPRCa"; //''
		int PORT = 3306; //3306
		String DB_NAME = "Kpjlw3Oe8S"; //db_pop
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME+"";
		
		String sql ="";		
		if(userType.equals("Customer")) {
			sql = "SELECT Reg_ID from Customer where Login_ID = "+login_id;
		}
		else if(userType.equals("Corporate")) {
			sql = "SELECT Corporate_Registration_ID from Corporate where Login_ID = "+login_id;
		}
		else {
			sql = "SELECT Staff_ID from Staff where Login_ID = "+login_id;
		}
		
	System.out.println(sql);
		//RoomDetails roominfo = new RoomDetails();
		 
		int RegID = 0;
		
		try {
		
			//Connect			
			Class.forName(DRIVER); //Driver Loading					
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //Connect with database
		
			//Select
			Statement stat = conn.createStatement(); //To execute SQL Statement
			ResultSet rs = stat.executeQuery(sql);
		
			while(rs.next()) {				
				RegID = rs.getInt(1);				
			}
	
			//Close
			rs.close();
			stat.close();
			conn.close();
		}
	
		catch(Exception ex) {
			System.out.println("Error: "+ex.getMessage());
		}					
		return RegID ;
	}
	
	public List getAvailableRooms(String roomType) {   // List for Rooms to display in table
		
			String SERVER = "remotemysql.com"; //localhost
			String USER = "Kpjlw3Oe8S"; //root
			String PASSWORD = "aN5gTTPRCa"; //''
			int PORT = 3306; //3306
			String DB_NAME = "Kpjlw3Oe8S"; //db_pop
			String DRIVER = "com.mysql.cj.jdbc.Driver";
			String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME+"";
			String sql = "select Room_no from Rooms where Room_Status = 'Available' and Room_Type = '"+roomType+"';";
		
			//RoomDetails roominfo = new RoomDetails();
			 
			List roomNos= new ArrayList<>();
			
			try {
			
				//Connect			
				Class.forName(DRIVER); //Driver Loading					
				Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //Connect with database
			
				//Select
				Statement stat = conn.createStatement(); //To execute SQL Statement
				ResultSet rs = stat.executeQuery(sql);
			
				while(rs.next()) {				
					roomNos.add(rs.getString(1));				
				}
			
				//Close
				rs.close();
				stat.close();
				conn.close();
			}
		
			catch(Exception ex) {
				System.out.println("Error: "+ex.getMessage());
			}					
			return roomNos;
	}
		
	
	public List selectCustomerFromLogin() {   // getting Login Details from Customer 
		
		String SERVER = "remotemysql.com"; //localhost
		String USER = "Kpjlw3Oe8S"; //root
		String PASSWORD = "aN5gTTPRCa"; //''
		int PORT = 3306; //3306
		String DB_NAME = "Kpjlw3Oe8S"; //db_pop
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME+"";
		
		List cFromLogin = new ArrayList<CustomerLogin>();// customers from login
		
		String sqlCFromLogin = "select*from Login where User_Type ='Customer';";
		
		try {
			//Connect			
			Class.forName(DRIVER); //Driver Loading					
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //Connect with database			

			//Select
			Statement stat = conn.createStatement(); //To execute SQL Statement
			ResultSet rs = stat.executeQuery(sqlCFromLogin);
			
			while(rs.next()) {
				/*System.out.println(rs.getInt(1));//first field
				System.out.println(rs.getString(2));//second field
				System.out.println(rs.getString(3));//third field
				System.out.println(rs.getInt(4));//fourth field*/
				
				CustomerLogin cLogin = new CustomerLogin(rs.getString(1), rs.getString(2), rs.getString(3));
				
				cFromLogin.add(cLogin);
				
				
				
			}
			//Close
			rs.close();
			stat.close();
			conn.close();
			//System.out.println("Select Record Successfully!");

		}
		
		catch(Exception ex) {
			System.out.println("Error: "+ex.getMessage());
		}
		
		return cFromLogin;
		
	}
			
	
	
	public List selectRoom() {   // Rooms Display 
		
		String SERVER = "remotemysql.com"; //localhost
		String USER = "Kpjlw3Oe8S"; //root
		String PASSWORD = "aN5gTTPRCa"; //''
		int PORT = 3306; //3306
		String DB_NAME = "Kpjlw3Oe8S"; //db_pop
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME+"";
		
		
		List allRoomDetails = new ArrayList<RoomDetails>();
		
		String sqlselectRoom = "select*from Rooms;";
		
		
		
		try {
			//Connect			
			Class.forName(DRIVER); //Driver Loading					
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //Connect with database			

			//Select
			Statement stat = conn.createStatement(); //To execute SQL Statement
			ResultSet rs = stat.executeQuery(sqlselectRoom);
			
			while(rs.next()) {
				/*System.out.println(rs.getInt(1));//first field
				System.out.println(rs.getString(2));//second field
				System.out.println(rs.getString(3));//third field
				System.out.println(rs.getInt(4));//fourth field*/
				
				RoomDetails roomDetails = new RoomDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				
				allRoomDetails.add(roomDetails);
				
				
				
			}
			//Close
			rs.close();
			stat.close();
			conn.close();
			//System.out.println("Select Record Successfully!");

		}
		
		catch(Exception ex) {
			System.out.println("Error: "+ex.getMessage());
		}
		
		return allRoomDetails;
		
	}
	
	
	public void selectCustomerLogin() {   // Selecting login details from Customer
		
		String SERVER = "remotemysql.com"; //localhost
		String USER = "Kpjlw3Oe8S"; //root
		String PASSWORD = "aN5gTTPRCa"; //''
		int PORT = 3306; //3306
		String DB_NAME = "Kpjlw3Oe8S"; //db_pop
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME+"";
		String sqlselectCustomerLogin = "select*from Login where User_Type = 'Customer';";
		
		try {
			//Connect			
			Class.forName(DRIVER); //Driver Loading					
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //Connect with database			

			//Select
			Statement stat = conn.createStatement(); //To execute SQL Statement
			ResultSet rs = stat.executeQuery(sqlselectCustomerLogin);			
			
			while(rs.next()) {
				System.out.println(rs.getString(1));//first field
				System.out.println(rs.getString(2));//second field
				System.out.println(rs.getString(3));//third field
			}
			//Close
			rs.close();
			stat.close();
			conn.close();
			System.out.println("Select Record Successfully!");

		}
		catch(Exception ex) {
			System.out.println("Error: "+ex.getMessage());
		}
		
		
		
	}
		public List AllBookings() {   // All the Bookings Selected 
		
		String SERVER = "remotemysql.com"; //localhost
		String USER = "Kpjlw3Oe8S"; //root
		String PASSWORD = "aN5gTTPRCa"; //''
		int PORT = 3306; //3306
		String DB_NAME = "Kpjlw3Oe8S"; //db_pop
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME+"";
		
		
		List allBookingDetails = new ArrayList<BookingDetails>();
		
		String sqlBook = "select*from Booking_Information;";
		
		
		
		try {
			//Connect			
			Class.forName(DRIVER); //Driver Loading					
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //Connect with database			

			//Select
			Statement stat = conn.createStatement(); //To execute SQL Statement
			ResultSet rs = stat.executeQuery(sqlBook);
			
			while(rs.next()) {
				/*System.out.println(rs.getInt(1));//first field
				System.out.println(rs.getString(2));//second field
				System.out.println(rs.getString(3));//third field
				System.out.println(rs.getInt(4));//fourth field*/
				
				BookingDetails bookingDetails = new BookingDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4) , rs.getInt(5), rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10));
				
				allBookingDetails.add(bookingDetails);
				
				
				
			}
			//Close
			rs.close();
			stat.close();
			conn.close();
			//System.out.println("Select Record Successfully!");

		}
		
		catch(Exception ex) {
			System.out.println("Error: "+ex.getMessage());
		}
		
		return allBookingDetails;
		
	}
	
	public List ServiceDetails() {   // To show all the data in Service Table
			
		String SERVER = "remotemysql.com"; //localhost
		String USER = "Kpjlw3Oe8S"; //root
		String PASSWORD = "aN5gTTPRCa"; //''
		int PORT = 3306; //3306
		String DB_NAME = "Kpjlw3Oe8S"; //db_pop
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME+"";
			
			
		List allServiceDetails = new ArrayList<ServiceDetails>();
			
		String sqlService = "select*from Service;";
			
			
			
		try {
			//Connect			
			Class.forName(DRIVER); //Driver Loading					
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //Connect with database			

			//Select
			Statement stat = conn.createStatement(); //To execute SQL Statement
			ResultSet rs = stat.executeQuery(sqlService);
				
			while(rs.next()) {
				/*System.out.println(rs.getInt(1));//first field
				System.out.println(rs.getString(2));//second field
				System.out.println(rs.getString(3));//third field
				System.out.println(rs.getInt(4));//fourth field*/
					
				ServiceDetails serviceDetails = new ServiceDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
					
				allServiceDetails.add(serviceDetails);
					
					
					
			}
			//Close
			rs.close();
			stat.close();
			conn.close();
			//System.out.println("Select Record Successfully!");

		}
			
		catch(Exception ex) {
				System.out.println("Error: "+ex.getMessage());
		}
			
		return allServiceDetails;
			
	}	
	
	public void UpdateBooking(int BookingID , String chkIn, String chkOut , int roomNo , String bookingStat ,int RoomCost) {   // Updating Booking 
		 
		String SERVER = "remotemysql.com"; //localhost
		String USER = "Kpjlw3Oe8S"; //root
		String PASSWORD = "aN5gTTPRCa"; //''
		int PORT = 3306; //3306
		String DB_NAME = "Kpjlw3Oe8S"; //db_pop
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME+"";
		//String sqlLogin="insert into Login values('"+userType+"', '"+email+"', '"+pass+"');";
		String sql= "update Booking_Information set Check_In='"+chkIn+"', Check_Out='"+chkOut+"',Room_No = "+roomNo+" , Booking_Status='"+bookingStat+"', Current_Bill="+RoomCost+" where Booking_ID="+BookingID;                 
		
		try {
			
			Class.forName(DRIVER); //Driver Loading					
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //Connect with database	
			
			Statement stat = conn.createStatement();
			//stat.executeUpdate(sqlLogin);//Insert Record
			stat.executeUpdate(sql);
			//stat.executeUpdate(sqlCustomer);//Insert Record
			//Close
			stat.close();
			conn.close();
			System.out.println("Update Record Successfully!");
		}
		
		catch(Exception ex) {
			System.out.println("Error: "+ex.getMessage());
		}
		
		
	}
		
	
	
	public void DeleteBooking(int ID, String UserType) {    // For cancelling Booking 
		
		String SERVER = "remotemysql.com"; //localhost
		String USER = "Kpjlw3Oe8S"; //root
		String PASSWORD = "aN5gTTPRCa"; //''
		int PORT = 3306; //3306
		String DB_NAME = "Kpjlw3Oe8S"; //db_pop
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME+"";
		String sql = "";
		if (UserType.equals("Customer")) {
			sql= "DELETE FROM Booking_Information WHERE Reg_ID = " + ID;  
		}
		else {
			sql= "DELETE FROM Booking_Information WHERE Corporate_Registration_ID = " + ID;
		}
		           
		
		try {
			
			Class.forName(DRIVER); //Driver Loading					
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //Connect with database	
			
			Statement stat = conn.createStatement();
			//stat.executeUpdate(sqlLogin);//Insert Record
			stat.executeUpdate(sql);
			//stat.executeUpdate(sqlCustomer);//Insert Record
			//Close
			stat.close();
			conn.close();
			System.out.println("Deleted Record Successfully!");
		}
		
		catch(Exception ex) {
			System.out.println("Error: "+ex.getMessage());
		}
		
		
	}
	
	public int  getRegfromBooking(int bookingid,String userType) {  // Returns Reg_Id of either customer or corporate for Booking_Id 
		
		String SERVER = "remotemysql.com"; //localhost
		String USER = "Kpjlw3Oe8S"; //root
		String PASSWORD = "aN5gTTPRCa"; //''
		int PORT = 3306; //3306
		String DB_NAME = "Kpjlw3Oe8S"; //db_pop
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME+"";
		
		String sql = "";
		
		if (userType.equals("Customer")) {
				sql = "SELECT Reg_ID from Booking_Information WHERE Booking_ID = " + bookingid;
		}
		else {
				sql = "SELECT Corporate_Registration_ID from Booking_Information WHERE Booking_ID = " + bookingid;
		}
		int ID = 0;
		try {
			
			Class.forName(DRIVER); //Driver Loading					
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //Connect with database	
			
			Statement stat = conn.createStatement();
			//stat.executeUpdate(sqlLogin);//Insert Record
			ResultSet rs = stat.executeQuery(sql);
			//stat.executeUpdate(sqlCustomer);//Insert Record
			if(rs.next()) {
				ID=rs.getInt(1);
			}
			//Close
			stat.close();
			conn.close();
			System.out.println("Selected Record Successfully!");
		}
		
		catch(Exception ex) {
			System.out.println("Error: "+ex.getMessage());
		}
		
		
		return ID;
		
	}
	public List AllBillings() {   // Shows all from Billing Table
		
			String SERVER = "remotemysql.com"; //localhost
			String USER = "Kpjlw3Oe8S"; //root
			String PASSWORD = "aN5gTTPRCa"; //''
			int PORT = 3306; //3306
			String DB_NAME = "Kpjlw3Oe8S"; //db_pop
			String DRIVER = "com.mysql.cj.jdbc.Driver";
			String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME+"";
		
		
			List allBillingDetails = new ArrayList<BillingDetails>();
		
			String sqlBill = "select*from Billing_Table;";
		
			try {
				//Connect			
				Class.forName(DRIVER); //Driver Loading					
				Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //Connect with database			

				//Select
				Statement stat = conn.createStatement(); //To execute SQL Statement
				ResultSet rs = stat.executeQuery(sqlBill);
			
				while(rs.next()) {
					/*System.out.println(rs.getInt(1));//first field
					System.out.println(rs.getString(2));//second field
					System.out.println(rs.getString(3));//third field
					System.out.println(rs.getInt(4));//fourth field*/
				
					BillingDetails billingDetails = new BillingDetails(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4) , rs.getString(5), rs.getString(6));
				
					allBillingDetails.add(billingDetails);
				
				}
				//Close
				rs.close();
				stat.close();
				conn.close();
				//System.out.println("Select Record Successfully!");

			}
		
			catch(Exception ex) {
				System.out.println("Error: "+ex.getMessage());
			}
		
			return allBillingDetails;
	
	}
	
	public void UpdateBilling(int BillingID, String date,String status) {  // Updates the Billing when User orders something 
		 
		String SERVER = "remotemysql.com"; //localhost
		String USER = "Kpjlw3Oe8S"; //root
		String PASSWORD = "aN5gTTPRCa"; //''
		int PORT = 3306; //3306
		String DB_NAME = "Kpjlw3Oe8S"; //db_pop
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME+"";
		//String sqlLogin="insert into Login values('"+userType+"', '"+email+"', '"+pass+"');";
		String sql= "UPDATE Billing_Table SET Billing_Date = '"+date+"', Billing_Status = '"+status+"' WHERE Billing_ID = "+BillingID+";" ;                 
		
		try {
			
			Class.forName(DRIVER); //Driver Loading					
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //Connect with database	
			
			Statement stat = conn.createStatement();
			//stat.executeUpdate(sqlLogin);//Insert Record
			stat.executeUpdate(sql);
			//stat.executeUpdate(sqlCustomer);//Insert Record
			//Close
			stat.close();
			conn.close();
			System.out.println("Updated Record Successfully!");
		}
		
		catch(Exception ex) {
			System.out.println("Error: "+ex.getMessage());
		}
		
		
	}
	
	
	public int getBookingID() {		   // Returns latest Booking ID from the Table
		String SERVER = "remotemysql.com"; //localhost
		String USER = "Kpjlw3Oe8S"; //root
		String PASSWORD = "aN5gTTPRCa"; //''
		int PORT = 3306; //3306
		String DB_NAME = "Kpjlw3Oe8S"; //db_pop
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME+"";
		
		int bookingID = 0;
		
		String sqlCFromLogin = "select MAX(Booking_ID) from Booking_Information";
		
		try {
			//Connect			
			Class.forName(DRIVER); //Driver Loading					
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //Connect with database			

			//Select
			Statement stat = conn.createStatement(); //To execute SQL Statement
			ResultSet rs = stat.executeQuery(sqlCFromLogin);
			
			if(rs.next()) {
				//System.out.println(rs.getInt(1));
				bookingID = rs.getInt(1);
			}
			//Close
			rs.close();
			stat.close();
			conn.close();
			//System.out.println("Select Record Successfully!");
		}
		
		catch(Exception ex) {
			System.out.println("Error: "+ex.getMessage());
		}
		
		return bookingID;		
	}
	
	public void UpdateStaffID(int staff_Id, int bookingid) {  // Returns staffID in Booking to show who Confirmed Booking 
		String SERVER = "remotemysql.com"; //localhost
		String USER = "Kpjlw3Oe8S"; //root
		String PASSWORD = "aN5gTTPRCa"; //''
		int PORT = 3306; //3306
		String DB_NAME = "Kpjlw3Oe8S"; //db_pop
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME+"";
		//String sqlLogin="insert into Login values('"+userType+"', '"+email+"', '"+pass+"');";
		String sql= "UPDATE Booking_Information SET Staff_ID = "+staff_Id+" WHERE Booking_ID = "+bookingid+" ;";                 
		
		try {
			
			Class.forName(DRIVER); //Driver Loading					
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //Connect with database	
			
			Statement stat = conn.createStatement();
			//stat.executeUpdate(sqlLogin);//Insert Record
			stat.executeUpdate(sql);
			//stat.executeUpdate(sqlCustomer);//Insert Record
			//Close
			stat.close();
			conn.close();
			System.out.println("Updated Record Successfully!");
		}
		
		catch(Exception ex) {
			System.out.println("Error: "+ex.getMessage());
		}
		
		
	}
	public int IDtoCost(int RoomNo) {   // Returns Cost of Room for RoomID 
		String SERVER = "remotemysql.com"; //localhost
		String USER = "Kpjlw3Oe8S"; //root
		String PASSWORD = "aN5gTTPRCa"; //''
		int PORT = 3306; //3306
		String DB_NAME = "Kpjlw3Oe8S"; //db_pop
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME+"";
		
		int Roomcost = 0;
		
		String sqlCFromLogin = "SELECT Room_Cost FROM Rooms WHERE Room_No = "+RoomNo;
		
		try {
			//Connect			
			Class.forName(DRIVER); //Driver Loading					
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //Connect with database			

			//Select
			Statement stat = conn.createStatement(); //To execute SQL Statement
			ResultSet rs = stat.executeQuery(sqlCFromLogin);
			
			if(rs.next()) {
				//System.out.println(rs.getInt(1));
				Roomcost = rs.getInt(1);
			}
			//Close
			rs.close();
			stat.close();
			conn.close();
			//System.out.println("Select Record Successfully!");
		}
		
		catch(Exception ex) {
			System.out.println("Error: "+ex.getMessage());
		}
		
		return Roomcost;	
	}
	
	public int BillingIDFromBooking(int BookingID) {   // Returns Billing ID using Booking_ID
		String SERVER = "remotemysql.com"; //localhost
		String USER = "Kpjlw3Oe8S"; //root
		String PASSWORD = "aN5gTTPRCa"; //''
		int PORT = 3306; //3306
		String DB_NAME = "Kpjlw3Oe8S"; //db_pop
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME+"";
		
		int billingID = 0;
		
		String sql = "SELECT Billing_ID from Billing_Table WHERE Booking_ID = "+BookingID+";";
		
		try {
			//Connect			
			Class.forName(DRIVER); //Driver Loading					
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //Connect with database			

			//Select
			Statement stat = conn.createStatement(); //To execute SQL Statement
			ResultSet rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				//System.out.println(rs.getInt(1));
				billingID = rs.getInt(1);
			}
			//Close
			rs.close();
			stat.close();
			conn.close();
			//System.out.println("Select Record Successfully!");
		}
		
		catch(Exception ex) {
			System.out.println("Error: "+ex.getMessage());
		}
		
		
		
		return billingID;
		
	}
	
	
	
	public void UpdateTotalBilling(int currentBill, int serviceID, int billingID) {  // Updates Total Billing 
		String SERVER = "remotemysql.com"; //localhost
		String USER = "Kpjlw3Oe8S"; //root
		String PASSWORD = "aN5gTTPRCa"; //''
		int PORT = 3306; //3306
		String DB_NAME = "Kpjlw3Oe8S"; //db_pop
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME+"";
		//String sqlLogin="insert into Login values('"+userType+"', '"+email+"', '"+pass+"');";
		String sql= "UPDATE Billing_Table SET Total_Billing = Total_Billing + "+currentBill +", Service_ID = "+serviceID+" WHERE Billing_ID = "+billingID+";";                 
		
		try {
			
			Class.forName(DRIVER); //Driver Loading					
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //Connect with database	
			
			Statement stat = conn.createStatement();
			//stat.executeUpdate(sqlLogin);//Insert Record
			stat.executeUpdate(sql);
			//stat.executeUpdate(sqlCustomer);//Insert Record
			//Close
			stat.close();
			conn.close();
			System.out.println("Updated Record Successfully!");
		}
		
		catch(Exception ex) {
			System.out.println("Error: "+ex.getMessage());
		}
	}
	
	public void insertBilling(int Booking_ID, int ServiceID,int ServiceCost){  // Inserting values in Billing Table
		
			String SERVER = "remotemysql.com"; //localhost
			String USER = "Kpjlw3Oe8S"; //root
			String PASSWORD = "aN5gTTPRCa"; //''
			int PORT = 3306; //3306
			String DB_NAME = "Kpjlw3Oe8S"; //db_pop
			String DRIVER = "com.mysql.cj.jdbc.Driver";
			String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME+"";
			String sqlBilling = "INSERT INTO Billing_Table (Booking_ID,Service_ID,Total_Billing) values ("+Booking_ID+","+ServiceID+","+ServiceCost+");";
			//String sqlCustomer="insert into Customer_Data values("+cRegno+", '"+cName+"', '"+cAddress+"', "+cPh+", '"+cEmail+"');";
			try {
				//Connect			
				Class.forName(DRIVER); //Driver Loading					
				Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //Connect with database			

				//Insert
				Statement stat = conn.createStatement();
				stat.executeUpdate(sqlBilling);//Insert Record
				//stat.executeUpdate(sqlCustomer);//Insert Record
				//Close
				stat.close();
				conn.close();
				System.out.println("Insert Record Successfully!");
			}
			catch(Exception ex) {
				System.out.println("Error: "+ex.getMessage());
			}		
	}
	
	public void UpdateCurrentBill(int totalbill,int Booking_ID) {   // Updates Current Bill in Booking Information
		String SERVER = "remotemysql.com"; //localhost
		String USER = "Kpjlw3Oe8S"; //root
		String PASSWORD = "aN5gTTPRCa"; //''
		int PORT = 3306; //3306
		String DB_NAME = "Kpjlw3Oe8S"; //db_pop
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DB_NAME+"";
		//String sqlLogin="insert into Login values('"+userType+"', '"+email+"', '"+pass+"');";
		String sql= "UPDATE Booking_Information SET Current_Bill = Current_Bill + "+totalbill+" WHERE Booking_ID = "+Booking_ID+";";                 
		
		try {
			
			Class.forName(DRIVER); //Driver Loading					
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); //Connect with database	
			
			Statement stat = conn.createStatement();
			//stat.executeUpdate(sqlLogin);//Insert Record
			stat.executeUpdate(sql);
			//stat.executeUpdate(sqlCustomer);//Insert Record
			//Close
			stat.close();
			conn.close();
			System.out.println("Updated Record Successfully!");
		}
		
		catch(Exception ex) {
			System.out.println("Error: "+ex.getMessage());
		}
		
		
	}
	
	// Main method
	
	public static void main(String[]args) {
		
		
	}
	
	
}
	
	


