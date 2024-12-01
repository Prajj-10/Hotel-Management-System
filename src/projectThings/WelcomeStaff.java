package projectThings;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class WelcomeStaff extends JFrame implements ActionListener{
	
	// Decleration of JFrame, JLabels and JButton
	
	JFrame frame;
	JLabel welcome , lbl , bookRoom , roomStat , service , Email , Password , user, newStaff,billing;  
	JButton checkBook , checkRoom , serviceCall , close ,register,bill;
	
	public WelcomeStaff() {
		
		// Classic Frame
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(400,300));
		frame.setTitle("Welcome User");
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		// Initialization of JLabels , setting bounds and fonts
		
		welcome = new JLabel("Welcome Staff !");
		welcome.setFont(new Font("Courier" , Font.BOLD , 25));
		welcome.setBounds(0,0,300,25);
		
	
		lbl = new JLabel("What would you like to do ? ");
		lbl.setFont(new Font("Courier" , Font.BOLD , 18));
		lbl.setBounds(0, 30, 500, 20);
		
		bookRoom = new JLabel("Check Pending Bookings ? ");
		bookRoom.setFont(new Font("Courier" , Font.BOLD , 16));
		bookRoom.setBounds(0, 60, 400, 25);
		
		newStaff = new JLabel("Register new Staff ? ");
		newStaff.setFont(new Font("Courier" , Font.BOLD , 16));
		newStaff.setBounds(0, 150, 250, 25);
		
		billing = new JLabel("Check Bills ?");
		billing.setFont(new Font("Courier" , Font.BOLD , 16));
		billing.setBounds(0, 120, 200, 25);
	
		roomStat = new JLabel("Check Room Status ? ");
		roomStat.setFont(new Font("Courier" , Font.BOLD , 16));
		roomStat.setBounds(0, 90, 200, 25);
		
		
		// Initialization of JButtons 
		
		checkRoom = new JButton("CHECK ROOM");
		checkRoom.setFont(new Font("Courier" , Font.BOLD , 14));
		checkRoom.setBounds(250, 92, 120, 20);
		checkRoom.addActionListener(this);
				
		bill = new JButton("CHECK");
		bill.setFont(new Font("Courier" , Font.BOLD , 14));
		bill.setBounds(250, 122, 120, 20);
		bill.addActionListener(this);
		
		checkBook = new JButton("CHECK");
		checkBook.setFont(new Font("Courier" , Font.BOLD , 14));
		checkBook.setBounds(250, 62, 120, 20);
		checkBook.addActionListener(this);
		
		
		register = new JButton(" REGISTER");
		register.setFont(new Font("Courier" , Font.BOLD , 14));
		register.setBounds(250, 152, 120, 20);
		register.addActionListener(this);
		
		
		close = new JButton("LOGOUT");
		close.setFont(new Font("Courier" , Font.BOLD , 14));
		close.setBounds(250, 182, 120, 20);
		close.addActionListener(this);
		
		// adding the JLabels and JButtons into frame
		
		frame.add(welcome);
		frame.add(lbl);
		frame.add(bookRoom);
		frame.add(checkBook);
		frame.add(roomStat);
		frame.add(checkRoom);
		frame.add(billing);
		frame.add(bill);
		frame.add(newStaff);
		frame.add(register);
		frame.add(close);
				
		frame.setVisible(true);  // Displaying them in the frame
		
	}
	
	// Main Method
	
	public static void main(String[]args) {  
		
		@SuppressWarnings("unused")
		WelcomeStaff wel = new WelcomeStaff();
	}
	
	// Actions defined for JButtons 
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Disposes the shown frame and show the next frame so that only one frame is shown for user 
		
		if (e.getSource() == close) {
			frame.dispose();
			new WelcomePage();
		}
		if(e.getSource() == register) {
			frame.dispose();
			new StaffRegistration();
		}
		if(e.getSource() == checkBook) {
			new BookingTable();
			frame.dispose();
		}
		if (e.getSource() == checkRoom) {
			new RoomTable();
			frame.dispose();
		}
		if (e.getSource() == serviceCall) {
			new ServiceTable();
			frame.dispose();
		}
		if (e.getSource() == bill) {
			new BillingTable();
			frame.dispose();
		}
		
		
	}
	
	
	
}
