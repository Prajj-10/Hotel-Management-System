package projectThings;

//importing class for GUI
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Registration extends JFrame implements ActionListener{
	
	//declaring 
	JFrame register , dialogBox ;
	JLabel welcome,name,address,telephone ,email , pw , cpw , bAd , note;
	JTextField n1,a1,t1,e1,f5,ba1;
	JPasswordField p1,p2 ;
	JButton registerButton,closeButton,bt3;
	JRadioButton rbCustomer , rbCorporate , rbStaff;
	JCheckBox pwCheck;
	
	//constructor of class
	public Registration() {
		
		//initializing
		register = new JFrame();
		register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		register.setSize(new Dimension(600,400));
		register.setTitle("Registration Form");
		register.setResizable(false);
		register.setLayout(null);
		register.setLocationRelativeTo(null);
		
		//initilizing
		welcome = new JLabel();
		name = new JLabel();
		address = new JLabel();
		telephone = new JLabel();
		email = new JLabel();
		pw = new JLabel();      // pw = password 
		cpw = new JLabel();     // cpw = confirm password
		bAd = new JLabel();
		note = new JLabel();
		
		//textfield
		n1 = new JTextField();     // name 	 
		a1 = new JTextField();     // address
		t1 = new JTextField();     // telephone
		e1 = new JTextField();     // email 
		ba1 = new JTextField();
		
		//passwordfield
		p1 = new JPasswordField(); // password
		p2 = new JPasswordField(); // confirm password 
	
		//button
		registerButton = new JButton();
		registerButton.addActionListener(this);
		
		closeButton = new JButton();
		closeButton.addActionListener(this);
		
		//radio button
		rbCustomer = new JRadioButton();
		rbCorporate = new JRadioButton();
		rbStaff = new JRadioButton();
		
		//select only one item from many 
		ButtonGroup bg = new ButtonGroup();
		
		pwCheck = new JCheckBox();
		
		//managing font uniformity
		welcome.setFont(new Font ("Courier" , Font.BOLD , 20));
		welcome.setText("Welcome to the Registration Page");
		welcome.setBounds(70, 0, 500, 25);
		
		name.setFont(new Font("Courier" , Font.BOLD , 18));
		name.setText("Full Name        :");
		name.setBounds(20,30,250,25);
		
		address.setFont(new Font("Courier" , Font.BOLD , 18));
		address.setText("Address          :");
		address.setBounds(20,60,250,25);
		
		bAd.setFont(new Font("Courier" , Font.BOLD , 18));
		bAd.setText("Billing Address  :");
		bAd.setBounds(20, 90, 250, 25);
		
		telephone.setFont(new Font("Courier" , Font.BOLD , 18));
		telephone.setText("Telephone No.    :");
		telephone.setBounds(20, 120, 250, 25);
		
		email.setFont(new Font("Courier" , Font.BOLD , 18));
		email.setText("Email Address    :");
		email.setBounds(20, 150, 250, 25);
		
		
		pw.setFont(new Font("Courier" , Font.BOLD , 18));
		pw.setText("Set Password     : ");
		pw.setBounds(20, 180, 250, 25);
		
		cpw.setFont(new Font("Courier" , Font.BOLD , 18));
		cpw.setText("Confirm Password :");
		cpw.setBounds(20, 210 , 250 ,25);
		
		registerButton.setText("REGISTER");
		registerButton.setBounds(450, 280, 100, 20);
		
		closeButton.setText("CLOSE");
		closeButton.setBounds(450,310,100,20);
		
		note.setFont(new Font("Courier" , Font.BOLD , 12));
		note.setText("The Billing Address is for Corporate customers only.");
		note.setBounds(50, 330, 400, 20);
		
		n1.setColumns(10);
		n1.setBounds(220, 32, 200, 25);
		
		a1.setColumns(10);
		a1.setBounds(220, 62, 200, 25);
		
		ba1.setColumns(10);
		ba1.setBounds( 220,92,200,25);
		
		t1.setColumns(10);
		t1.setBounds(220, 122, 200, 25);
		
		e1.setColumns(10);
		e1.setBounds(220, 152, 200, 25);
		
		p1.setColumns(10);
		p1.setBounds(220, 182, 200, 25);
		
		p2.setColumns(10);
		p2.setBounds(220, 212, 200, 25);
		
		
		
		rbCustomer.setText("Customer");
		rbCustomer.setFont(new Font("Courier" , Font.BOLD , 16));
		bg.add(rbCustomer);
		rbCustomer.setBounds(50, 280, 300, 20);
		
		
		rbCorporate.setText("Corporate");
		rbCorporate.setFont(new Font("Courier" , Font.BOLD , 16));
		bg.add(rbCorporate);
		rbCorporate.setBounds(50,300,300,20);
		
		/*
		rbStaff.setText("Staff");
		rbStaff.setFont(new Font("Courier" , Font.BOLD , 16));
		bg.add(rbStaff);
		rbStaff.setBounds(50, 290, 300, 25);
		*/
		
		
		pwCheck.setText("Unhide Password");
		pwCheck.setBounds(20, 230, 200, 25);
		pwCheck.addActionListener(this);
		
		//adding in window
		register.add(welcome);
		register.add(name);
		register.add(n1);
		register.add(address);
		register.add(a1);
		register.add(bAd);
		register.add(ba1);
		register.add(telephone);
		register.add(t1);
		register.add(email);
		register.add(e1);
		register.add(pw);
		register.add(p1);
		register.add(cpw);
		register.add(p2);
		register.add(registerButton);
		register.add(closeButton);
		register.add(rbCustomer);
		register.add(rbCorporate);
		register.add(pwCheck);
		register.add(note);
		
		
		//register.add(rbStaff);
		
		register.setVisible(true);
		
		
	}

	
	//button performs action
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
	if (e.getSource() == closeButton) {
			register.dispose();
			new WelcomePage();
	}
	if (pwCheck.isSelected()) {
			p1.setEchoChar((char)0);
			p2.setEchoChar((char)0);
	}
	else {
			p1.setEchoChar('*');
			p2.setEchoChar('*');
	}		
	if (e.getSource()==registerButton) {
		EmailValidator emailvalidator = new EmailValidator();
		if (e.getSource() == registerButton) {
			   if(!emailvalidator.validate(e1.getText().trim())) {
			        JOptionPane.showMessageDialog( dialogBox,"Your Email address is not valid. Please enter again" , "Error" ,1);
			   }
		}
		
		String str1 = new String(p1.getPassword());
		String str2 = new String(p2.getPassword());
		
		if (!((rbCustomer.isSelected() || rbCorporate.isSelected())) && e.getSource() == registerButton ) {
			JOptionPane.showMessageDialog( dialogBox,"Please select a particular User type." , "Error" ,1);
		}
		if(!(str1.equals(str2)) && e.getSource() == registerButton) {
			JOptionPane.showMessageDialog(dialogBox, "Your passwords don't match. Please check again." , "Error" ,1);
		}
		
		if ((n1.getText().isEmpty() || e1.getText().isEmpty() || a1.getText().isEmpty() || t1.getText().isEmpty() || p1.getText().isEmpty() || p2.getText().isEmpty() )&& e.getSource() == registerButton) {
			JOptionPane.showMessageDialog( dialogBox,"Please do not leave any entries empty ! Please check again." , "Error" ,1);
		}
		else if (rbCorporate.isSelected() && ba1.getText().isEmpty() && e.getSource() == registerButton) {
			JOptionPane.showMessageDialog(dialogBox, "Please enter your Billing Address" , "Error" ,1);
		}
		
		else if (str1.equals(str2) && e.getSource() == registerButton && (rbCustomer.isSelected() || rbCorporate.isSelected()) && (emailvalidator.validate(e1.getText().trim())) ){
			
			if(rbCustomer.isSelected()) {
				 
				 @SuppressWarnings("unused")
				ButtonGroup bg = new ButtonGroup();
				
				String selected = "Customer";
				
				String fullName, address, eMail, pass1;
				//int id=1;
				long phNo;
				
				String userType=selected;
				fullName=n1.getText();
				address=a1.getText();
				phNo= Long.parseLong(t1.getText()); 
				eMail=e1.getText();
				pass1=new String(p1.getPassword());
				//billingAddress=ba1.getText();
				//executing query
				CRUD1 crud1=new CRUD1();
				
				crud1.insertRecordLogin(userType, eMail, pass1);
				int loginid =crud1.getLoginID(); 
				//System.out.println(loginid);
				crud1.insertCustomer(loginid, fullName, address, phNo, eMail);
				//crud1.selectCustomerLogin();
					
					
			}
				
			else{
					
					@SuppressWarnings("unused")
					ButtonGroup bg = new ButtonGroup();
					
					String selected = "Corporate";
					
					String corfullName, billaddress, coraddress, coreMail, pass1;
					long corphNo;
					
					String userType=selected;
					corfullName=n1.getText();
					coraddress=a1.getText();
					billaddress=ba1.getText();
					corphNo= Long.parseLong(t1.getText()); 
					coreMail=e1.getText();
					pass1=new String(p1.getPassword());
					//billingAddress=ba1.getText();
					
					CRUD1 crud1=new CRUD1();
					
					crud1.insertRecordLogin(userType, coreMail, pass1);
					
					int loginid =crud1.getLoginID();
					
					crud1.insertCorporate(loginid,corfullName, coraddress, billaddress,  corphNo, coreMail );
					
			}
			
			JOptionPane.showMessageDialog(dialogBox, "Registration Successful." , "Message Box" ,1);
		}
		
		
	}	
		
	
		
		
		
			
		
		
	}

}
