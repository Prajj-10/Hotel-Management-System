package projectThings;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class WelcomeUser extends JFrame implements ActionListener{
	
	//Decleration
	
	JFrame frame;
	JLabel welcome , lbl , bookRoom , billStat , service , Email , Password , user,bookingCancel; 
	JButton book , bill , serviceCall , close,cancelBooking;
	
	// Public Class
	
	public WelcomeUser() {
		
		// Basic Frame
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(400,300));
		frame.setTitle("Welcome User");
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		//Declaration JLabels, Initialization, Setting Bounds and Fonts
		
		welcome = new JLabel("Welcome User !");
		welcome.setFont(new Font("Courier" , Font.BOLD , 25));
		welcome.setBounds(0,0,300,25);
		
	
		lbl = new JLabel("What would you like to do ? ");
		lbl.setFont(new Font("Courier" , Font.BOLD , 18));
		lbl.setBounds(0, 30, 500, 20);
		
		bookRoom = new JLabel("Book a Room ? ");
		bookRoom.setFont(new Font("Courier" , Font.BOLD , 16));
		bookRoom.setBounds(0, 60, 200, 25);
		
		book = new JButton("BOOK");
		book.setFont(new Font("Courier" , Font.BOLD , 14));
		book.setBounds(200, 62, 150, 20);
		book.addActionListener(this);
		
	
		billStat = new JLabel("Check Bill Status ? ");
		billStat.setFont(new Font("Courier" , Font.BOLD , 16));
		billStat.setBounds(0, 90, 200, 25);
		
		bill = new JButton(" CURRENT BILL");
		bill.setFont(new Font("Courier" , Font.BOLD , 14));
		bill.setBounds(200, 92, 150, 20);
		bill.addActionListener(this);
		
		service = new JLabel("Order a service ? ");
		service.setFont(new Font("Courier" , Font.BOLD , 16));
		service.setBounds(0, 120, 200, 25);
		
		serviceCall = new JButton("ORDER SERVICE");
		serviceCall.setFont(new Font("Courier" , Font.BOLD , 14));
		serviceCall.setBounds(200, 122, 150, 20);
		serviceCall.addActionListener(this);
		
		bookingCancel = new JLabel("Cancel Booking ?");
		bookingCancel.setFont(new Font("Courier" , Font.BOLD , 16));
		bookingCancel.setBounds(0, 150, 200, 25);
		
		// Decleration of JButtons, Setting Texts, Fonts and adding Action Listener
		
		cancelBooking = new JButton("CANCEL");
		cancelBooking.setFont(new Font("Courier" , Font.BOLD , 14));
		cancelBooking.setBounds(200, 152, 150, 20);
		cancelBooking.addActionListener(this);
		
		close = new JButton("LOGOUT");
		close.setFont(new Font("Courier" , Font.BOLD , 14));
		close.setBounds(200, 182, 150, 20);
		close.addActionListener(this);
		
		
		// adding the JButtons and JLabels in Frame 
		
		frame.add(welcome);
		frame.add(lbl);
		frame.add(bookRoom);
		frame.add(book);
		frame.add(billStat);
		frame.add(bill);
		frame.add(service);
		frame.add(serviceCall);
		frame.add(bookingCancel);
		frame.add(cancelBooking);
		frame.add(close);
		
		
		frame.setVisible(true);
	}
	
	// Main Method
	
	public static void main(String[]args) { 
		
		@SuppressWarnings("unused")
		WelcomeUser wel = new WelcomeUser();
		
		
		
	}
			
		// Action Performed in JButtons
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == book) {
			new Booking();   // Extends JFrame to open Booking.java	
		}
		if (e.getSource() == close) {
			frame.dispose();        // Closes the frame
			new WelcomePage();       
		}
		if (e.getSource() == serviceCall) {
			new ServiceTable();
			frame.dispose();                 
		}	
		if (e.getSource() == cancelBooking) {
		
			//System.out.println("Cancelled");
			//BookingDetails book = new BookingDetails();
			
			int loginid = MyGlobal.current_login.getLoginId();       // Stores Current LoginID
			String usertype = MyGlobal.current_login.getUserType(); //  Stores UserType
			
			CRUD1 crud = new CRUD1();   // Object of CRUD class
			MyDB mydb = new MyDB();     // Object of MyDB class
			int reg_ID = crud.getRegID(loginid, usertype);   // calling a function that returns Reg_Id
			
			int regFromBook;  
			
			BookingDetails bookingDetails = mydb.doBooking(reg_ID,usertype); // Creating object and passing value of RegID to get corresponding booking Details 
			if (usertype.equals("Customer")) {   // If else for if Customer or Corporate is selected 
					regFromBook = bookingDetails.getRegID();	// returns Reg_ID		
			}
			else {
					regFromBook = bookingDetails.getCorID();    // returns Corporate_Registration_ID
			}
			
			if(reg_ID == regFromBook) {   // If the values match then the Booking gets Cancelled 
				crud.DeleteBooking(reg_ID, usertype);
				JOptionPane.showMessageDialog(frame, "Booking Cancelled Successfully!");  // Message Box
            }
			else {
				JOptionPane.showMessageDialog(frame, "You have no Bookings !!");
			}
			
		}
		if (e.getSource() == bill) {        // To show the current Bill 
			
			CRUD1 crud = new CRUD1();
			MyDB mydb = new MyDB();
			
			String usertype = MyGlobal.current_login.getUserType();  // gets UserType from current User
			int loginid = MyGlobal.current_login.getLoginId();
			int reg_ID = crud.getRegID(loginid, usertype);      // Returns corresponding reg_Id
			
			
			int currentBill;
			
			BookingDetails bookingDetails = mydb.doBooking(reg_ID,usertype);  // gets Current Bill from correspoding Reg_ID and UserType
			
			currentBill = bookingDetails.getCurrentBill();     // Stores the value of Current Bill
			
			JOptionPane.showMessageDialog(frame, "Your Current Bill is Rs." + currentBill);  // Message Box for user
			
		}
			
			
	}
	
}
