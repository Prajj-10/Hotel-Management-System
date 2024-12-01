package projectThings;

public class BookingDetails {
	
	//declaring variables
	int BookingID;
	String CheckIn,CheckOut,BookingStatus;
	int CurrentBill;
	String PreferredRoomType;
	int RoomNo,RegID,CorID,StaffID;
	
	//default constructor
	public BookingDetails() {
		this.BookingID = 0;
		this.CheckIn = "";
		this.CheckOut = "";
		this.BookingStatus = "";
		this.CurrentBill = 0;
		this.PreferredRoomType = ""; 
		this.RoomNo = 0;
		this.RegID = 0;
		this.CorID = 0;
		this.StaffID = 0;
	}

	//parameterized constrctor
	public BookingDetails(int bookingID, String checkIn, String checkOut, String bookingStatus,
			int currentBill, String preferredRoomType,int roomNo, int regID, int corID, int staffID) {
		super();
		this.BookingID = bookingID;
		this.CheckIn = checkIn;
		this.CheckOut = checkOut;
		this.BookingStatus = bookingStatus;
		this.CurrentBill = currentBill; 
		this.PreferredRoomType = preferredRoomType;
		this.RoomNo = roomNo;
		this.RegID = regID;
		this.CorID = corID;
		this.StaffID = staffID;
	}
	
	//copy constructor
	public BookingDetails(BookingDetails bDetails) {
		this.BookingID = bDetails.BookingID;
		this.CheckIn = bDetails.CheckIn;
		this.CheckOut = bDetails.CheckOut;
		this.BookingStatus = bDetails.BookingStatus;
		this.CurrentBill = bDetails.CurrentBill;
		this.PreferredRoomType = bDetails.PreferredRoomType;
		this.RoomNo = bDetails.RoomNo;
		this.RegID = bDetails.RegID;
		this.CorID = bDetails.CorID;
		this.StaffID = bDetails.StaffID;
	}

	//getter and setter
	public int getBookingID() {
		return BookingID;
	}


	public void setBookingID(int bookingID) {
		BookingID = bookingID;
	}


	public String getCheckIn() {
		return CheckIn;
	}


	public void setCheckIn(String checkIn) {
		CheckIn = checkIn;
	}


	public String getCheckOut() {
		return CheckOut;
	}


	public void setCheckOut(String checkOut) {
		CheckOut = checkOut;
	}


	public String getBookingStatus() {
		return BookingStatus;
	}


	public void setBookingStatus(String bookingStatus) {
		BookingStatus = bookingStatus;
	}

	public int getCurrentBill() {
		return CurrentBill;
	}


	public void setCurrentBill(int currentBill) {
		CurrentBill = currentBill;
	}
	
	
	public String getPreferredRoomType() {
		return PreferredRoomType;
	}


	public void setPreferredRoomType(String preferredRoomType) {
		PreferredRoomType = preferredRoomType;
	}

	public int getRoomNo() {
		return RoomNo;
	}


	public void setRoomNo(int roomNo) {
		RoomNo = roomNo;
	}
	

	public int getRegID() {
		return RegID;
	}


	public void setRegID(int regID) {
		RegID = regID;
	}


	public int getCorID() {
		return CorID;
	}


	public void setCorID(int corID) {
		CorID = corID;
	}


	public int getStaffID() {
		return StaffID;
	}


	public void setStaffID(int staffID) {
		StaffID = staffID;
	}


	@Override
	public String toString() {
		return "BookingDetails [BookingID=" + BookingID + ", CheckIn=" + CheckIn + ", CheckOut=" + CheckOut
				+ ", BookingStatus=" + BookingStatus + ", CurrentBill=" + CurrentBill + ", PreferredRoomType="
				+ PreferredRoomType + ", RoomNo=" + RoomNo + ", RegID=" + RegID + ", CorID=" + CorID + ", StaffID="
				+ StaffID + ", getBookingID()=" + getBookingID() + ", getCheckIn()=" + getCheckIn() + ", getCheckOut()="
				+ getCheckOut() + ", getBookingStatus()=" + getBookingStatus() + ", getCurrentBill()="
				+ getCurrentBill() + ", getPreferredRoomType()=" + getPreferredRoomType() + ", getRoomNo()="
				+ getRoomNo() + ", getRegID()=" + getRegID() + ", getCorID()=" + getCorID() + ", getStaffID()="
				+ getStaffID() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}


	
	
	
	

	
	
	
	
}
