package projectThings;

//importing class
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class StaffRegistration implements ActionListener{
	
	//declare
	JFrame frame;
	JLabel title , name,address,desg ,email , pw , cpw , start , warn;
	JTextField n1,a1,d1,e1,s1;
	JPasswordField p1,p2;
	JButton register , close;
	JCheckBox pwCheck;
	
	//constructor of class
	public StaffRegistration() {
		//for window
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(550,350));//size
		frame.setTitle("Staff Registration");//title
		frame.setResizable(false);//cannot be resized
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		//initializing
		title = new JLabel();
		name = new JLabel();
		address = new JLabel();
		desg = new JLabel();
		email = new JLabel();
		pw = new JLabel();      // pw = password 
		cpw = new JLabel();
		start = new JLabel();
		warn =  new JLabel();
		
		
		//textfield
		
		n1 = new JTextField();     // name 	 
		a1 = new JTextField();     // address
		s1 = new JTextField();	   // working since	
		d1 = new JTextField();     // designation
		e1 = new JTextField();     // email 
		p1 = new JPasswordField(); // password
		p2 = new JPasswordField(); // confirm password 
		
		//checkbox
		pwCheck = new JCheckBox();
		
		//maintaining fonf uniformity
		title.setText("WELCOME TO STAFF REGISTRATION");
		title.setFont(new Font ("Courier",Font.BOLD , 20));
		title.setBounds(80, 0, 500, 25);
	
		
		name.setFont(new Font("Courier" , Font.BOLD , 18));
		name.setText("Full Name        :");
		name.setBounds(20,30,250,25);
		
		address.setFont(new Font("Courier" , Font.BOLD , 18));
		address.setText("Address          :");
		address.setBounds(20,60,250,25);
		
		start.setFont(new Font("Courier" , Font.BOLD , 18));
		start.setText("Wokring Since    :");
		start.setBounds(20, 90, 250, 25);
		
		desg.setFont(new Font("Courier" , Font.BOLD , 18));
		desg.setText("Designation      :");
		desg.setBounds(20, 120, 250, 25);
		
		email.setFont(new Font("Courier" , Font.BOLD , 18));
		email.setText("Email Address    :");
		email.setBounds(20, 150, 250, 25);
		
		
		pw.setFont(new Font("Courier" , Font.BOLD , 18));
		pw.setText("Set Password     : ");
		pw.setBounds(20, 180, 250, 25);
		
		cpw.setFont(new Font("Courier" , Font.BOLD , 18));
		cpw.setText("Confirm Password :");
		cpw.setBounds(20, 210 , 250 ,25);
		
		warn.setText("Note: The \"Working Since\" should be in YYYY/MM/DD format. ");
		warn.setFont(new Font("Courier" , Font.BOLD , 10));
		warn.setBounds(20, 250, 400, 20);
		
		
		n1.setColumns(10);
		n1.setBounds(220, 32, 200, 25);
		
		a1.setColumns(10);
		a1.setBounds(220, 62, 200, 25);
		
		s1.setColumns(10);
		s1.setBounds(220, 92, 200, 25);
		
		d1.setColumns(10);
		d1.setBounds(220, 122, 200, 25);
		
		e1.setColumns(10);
		e1.setBounds(220, 152, 200, 25);
		
		p1.setColumns(10);
		p1.setBounds(220, 182, 200, 25);
		
		p2.setColumns(10);
		p2.setBounds(220, 212, 200, 25);
		
		//button
		register = new JButton();
		register.addActionListener(this);
		
		
		close = new JButton();
		
		
		
		register.setText("REGISTER");
		register.setBounds(420, 242, 100, 25);
		
		close.setText("CLOSE");
		close.setBounds(420, 272, 100, 25);
		close.addActionListener(this);
		
		pwCheck.setText("Unhide Password");
		pwCheck.setBounds(18, 230, 200, 25);
		pwCheck.addActionListener(this);
		
		
		//adding components in GUI
		frame.add(title);
		frame.add(name);
		frame.add(n1);
		frame.add(address);
		frame.add(a1);
		frame.add(start);
		frame.add(s1);
		frame.add(desg);
		frame.add(d1);
		frame.add(email);
		frame.add(e1);
		frame.add(pw);
		frame.add(p1);
		frame.add(cpw);
		frame.add(p2);
		frame.add(pwCheck);
		frame.add(warn);
		frame.add(close);
		frame.add(register);
		
		
		
		
		frame.setVisible(true);
		
	}
	
	public static void main(String[]args) {
		@SuppressWarnings("unused")
		StaffRegistration staff = new StaffRegistration();
		
	}
	
	//buttons performing actions
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		EmailValidator emailvalidator = new EmailValidator();
		//conditions
		if(e.getSource() == close) {
			frame.dispose();
			new WelcomeStaff();
		}
		if (pwCheck.isSelected()) {
			p1.setEchoChar((char)0);
			p2.setEchoChar((char)0);
		}
		else {
			p1.setEchoChar('*');
			p2.setEchoChar('*');
		}
		String str1 = new String(p1.getPassword());
		String str2 = new String(p2.getPassword());
		if (e.getSource() == register) {
				if(!emailvalidator.validate(e1.getText().trim())) {
			        JOptionPane.showMessageDialog( frame,"Your Email address is not valid. Please enter again" , "Error" ,1);
			   }
		}
		if(!(str1.equals(str2)) && e.getSource() == register) {
			JOptionPane.showMessageDialog(frame, "Your passwords don't match. Please check again." , "Error" ,1);
		}
		else if ((n1.getText().isEmpty() || a1.getText().isEmpty() || s1.getText().isEmpty() || d1.getText().isEmpty() || p1.getText().isEmpty() || p2.getText().isEmpty() )&& e.getSource() == register) {
			JOptionPane.showMessageDialog( frame,"Please do not leave any entries empty ! Please check again." , "Error" ,1);
		}
		else if (e.getSource() == register && str1.equals(str2) && (emailvalidator.validate(e1.getText().trim()))) {
			
			//String stId;
			String type, stName, stAddress, stDate, designation, stEmail, stPass; 
			
			type = "Staff";
			stName = n1.getText();
			stAddress = a1.getText();
			stDate = s1.getText();
			designation = d1.getText();
			stEmail = e1.getText();
			stPass = new String(p1.getPassword());
			
			//execute query
			CRUD1 staff = new CRUD1();
			staff.insertRecordLogin(type, stEmail, stPass);
			int loginid =staff.getLoginID();
			staff.insertStaff(loginid,stName, stAddress, stDate, designation, stEmail);
			
			JOptionPane.showMessageDialog(frame, "Registration Successful." , "Message Box" ,1);
		}
		
	}
}	
