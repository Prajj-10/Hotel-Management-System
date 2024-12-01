package projectThings;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

//Reference Libraries added to connect DBMS

// import java.sql.Connection;
// import java.sql.DriverManager;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings({ "unused", "serial" })
public class WelcomePage  extends JFrame implements ActionListener  {
	
	// Decleration and Initialization of JFrame, JLabel, JTextField,JPasswordField, JCheckBox and JComboBox 
	
	JFrame frame ,loginDialog;
	JLabel welcome , dbs , opt , luton , address , Email , Password , user;
	JTextField Efield ;
	JButton btnLogin , close , register;
	JPasswordField Pfield ; 
	JCheckBox pwCheck;
	@SuppressWarnings("rawtypes")
	JList UserType ;
	@SuppressWarnings("rawtypes")
	JComboBox cmb1 ;
	
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  WelcomePage(){
		
		// Frame Basics
		
		 	frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(new Dimension(550,300));
			frame.setTitle("Welcome Page");
			frame.setResizable(false);
			frame.setLayout(null);
			frame.setLocationRelativeTo(null);
		
			//Initialization of JLabels
			
			welcome = new JLabel();
			dbs = new JLabel();
			opt = new JLabel();
			luton = new JLabel();
			address = new JLabel();
			user = new JLabel();
			
			Email = new JLabel();
			Password = new JLabel();
			
			// Initialization of JTextField
			
			Efield = new JTextField();
			
			// Initialization of JPasswordField
			
			Pfield = new JPasswordField();
			
			// Initialization of JButtons
			
			btnLogin = new JButton();
			register = new JButton();
			close = new JButton();
			
			pwCheck = new JCheckBox();
			
			// Array Datas for JComboBox
			
			String [] data = {"Customer" , "Corporate" , "Staff"};			
			UserType = new JList(data);
			
			// JComboBox 
			
			cmb1 = new JComboBox(data);
			cmb1.setBounds(20, 105, 100, 20);
			
			// Setting Texts and Setting Bounds for JLabels
			
			welcome.setFont(new Font ("Courier" , Font.BOLD , 20));
			welcome.setText("Welcome to the Registration Page");
			welcome.setBounds(70, 35, 500, 25);
		
			dbs.setFont(new Font("Courier" , Font.PLAIN , 12));
			dbs.setText("(Database Connection Successful)");
			dbs.setBounds(145, 30 , 300 ,70);
			
			opt.setFont(new Font("Courier" , Font.BOLD , 16));
			opt.setText("Choose one of the Options :");
			opt.setBounds(20, 70, 300, 40);
		    
		    user.setFont(new Font("Courier" , Font.BOLD , 16));
		    user.setText("New User?");
		    user.setBounds(420, 70, 200, 40);
		    
		    luton.setFont(new Font("Aerial" , Font.BOLD , 25));
		    luton.setText("LUTON HOTEL ");
		    luton.setBounds(170, 0, 600, 20);
			
		    address.setFont(new Font("Aerial" , Font.PLAIN , 12));
		    address.setText("Luton , United Kingdom");
		    address.setBounds(190, 20, 200, 20);
			
			Email.setFont(new Font("Courier" , Font.BOLD , 16));
			Email.setText("Email Address  ");
			Email.setBounds(20, 125, 300, 20);
			
			Password.setFont(new Font("Courier" , Font.BOLD , 16));
			Password.setText("Password ");
			Password.setBounds(20, 145, 300, 20);
			
			
			// JTextField and JPasswordField setting Coloums and Bounds
			
			Efield.setColumns(10);
			Efield.setBounds(170, 125, 200, 20);
			
			Pfield.setColumns(10);
			Pfield.setBounds(170, 145, 200, 20);
			
			
			// JButton setting Coloums and Bounds
			
			btnLogin.setText("LOGIN");
			btnLogin.setBounds(170, 200, 70, 20);
			btnLogin.addActionListener(this);
			
			close.setText("CLOSE");
			close.setBounds(270, 200, 80, 20);
			close.addActionListener(this);
			
			register.setText("REGISTER");
		 	register.setBounds(420, 125, 100, 20);
		 	register.addActionListener(this);
		 	
		 	
		 	// JCheckBox
		 	
		 	pwCheck.setText("Unhide Password");
		 	pwCheck.setBounds(20, 170, 150, 20);
		 	pwCheck.addActionListener(this);
		 	
		 	
		 	// Adding it to frame 
			
			frame.add(welcome);
			frame.add(dbs);
			frame.add(opt);
			frame.add(luton);
			frame.add(address);
			frame.add(user);
			frame.add(cmb1);
			frame.add(Email);
			frame.add(Password);
			frame.add(Efield);
			frame.add(Pfield);
			frame.add(btnLogin);
			frame.add(close);
			frame.add(register);
			frame.add(pwCheck);
			
		
		// Making it Visible in frame
		
			frame.setVisible(true);	
	}

	
	// Action for JButtons
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) { 
		
		Login login = new Login();   // login object 
		//String value = cmb1.setSelectedItem(login.getUserType());
		EmailValidator emailvalidator = new EmailValidator(); // validates email format
		
		if (e.getSource() == btnLogin) {
			   boolean result1 = emailvalidator.validate(Efield.getText().trim()); 
			   boolean result2 = ! Efield.getText().isEmpty();   // Checks the empty condition 
			   if(result1 && result2) {
				   MyDB mydb = new MyDB();   // MyDB object 
				   String Email=Efield.getText();
				   String pass=Pfield.getText();
				   Login lgnDetails =mydb.doLogin(Email, pass);  // Returns the Login Details 
				   if(lgnDetails.getUserType().length()>0) {
					   MyGlobal.current_login = lgnDetails;		 // Stores the Data so that it can be used in any class
					   if(lgnDetails.getUserType().equals("Customer") || lgnDetails.getUserType().equals("Corporate")){						   			
						   new WelcomeUser();  // JFrame for Customer and Corporate
						   frame.dispose();
					   }
					   else {
						   MyGlobal.current_login = lgnDetails;  
							new WelcomeStaff();   // JFrame for Staff 
							frame.dispose();
					   }
				   }
				   else {
					   //wrong user name password
					   JOptionPane.showMessageDialog(frame,"Wrong Email Address/Password"); // If Email and Passwords are wrong 
				   }
			   }
			   else {
				   //validation false
				   //System.out.println("Empty Fields");
				   JOptionPane.showMessageDialog(loginDialog, "Your Login or Password is empty! Please enter your login and password." , "Error" ,1); // If fields are empty
			   }
		}
		
		// For JCheckBox to show and hide Passwords 
		
		if (pwCheck.isSelected()) {
			Pfield.setEchoChar((char)0);
		}
		else {
			Pfield.setEchoChar('*');
		}
		if (e.getSource() == close) {
			frame.dispose();
		}
		
		if (e.getSource() == register) {
			frame.dispose();  // disposes this frame 
			new Registration(); // displays the registration frame to register
		}
	}
		
	
	// Main Method
	
	public static void main(String[]args)  {
		WelcomePage welcome = new WelcomePage();
		
		
		}
		

	
}
