package projectThings;


public class BillingDetails {
		int Billing_ID;
		int Booking_ID;
		int Service_ID;
		int Current_Bill;
		String Billing_Date;
		String Billing_Status;
		
		//default constructor
		public BillingDetails() {
			this.Billing_ID = 0;
			this.Booking_ID = 0;
			this.Service_ID = 0;
			this.Current_Bill = 0;
			this.Billing_Date = "";
			this.Billing_Status = "";
		}
		
		//parameterized constructor
		public BillingDetails(int billingID, int bookingID ,int serviceID, int currentBill,String billingDate , String billingStatus) {
			
			this.Billing_ID = billingID;
			this.Booking_ID = bookingID;
			this.Service_ID = serviceID;
			this.Current_Bill = currentBill;
			this.Billing_Date = billingDate; 
			this.Billing_Status = billingStatus;
			
		}
		
		//copy constructor
		public BillingDetails(BillingDetails billDetails) {
			this.Billing_ID = billDetails.Billing_ID;
			this.Booking_ID = billDetails.Booking_ID;
			this.Service_ID = billDetails.Service_ID;
			this.Current_Bill = billDetails.Current_Bill;
			this.Billing_Date = billDetails.Billing_Date;
			this.Billing_Status = billDetails.Billing_Status;
			
		}
		
		//Getters and Setters
		public int getBilling_ID() {
			return Billing_ID;
		}

		public void setBilling_ID(int billing_ID) {
			Billing_ID = billing_ID;
		}

		public int getBooking_ID() {
			return Booking_ID;
		}

		public void setBooking_ID(int booking_ID) {
			Booking_ID = booking_ID;
		}

		public int getService_ID() {
			return Service_ID;
		}

		public void setService_ID(int service_ID) {
			Service_ID = service_ID;
		}

		public int getCurrent_Bill() {
			return Current_Bill;
		}

		public void setCurrent_Bill(int current_Bill) {
			Current_Bill = current_Bill;
		}

		public String getBilling_Date() {
			return Billing_Date;
		}

		public void setBilling_Date(String billing_Date) {
			Billing_Date = billing_Date;
		}

		public String getBilling_Status() {
			return Billing_Status;
		}

		public void setBilling_Status(String billing_Status) {
			Billing_Status = billing_Status;
		}
		
		@Override
		public String toString() {
			return "BillingDetails [Billing_ID=" + Billing_ID + ", Booking_ID=" + Booking_ID + ", Service_ID="
					+ Service_ID + ", Current_Bill=" + Current_Bill + ", Billing_Date=" + Billing_Date
					+ ", Billing_Status=" + Billing_Status + "]";
		}
		
		
		
	
	
	
}
