package projectThings;

//importing classes for GUI and ActionListener
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BillingTable implements ActionListener{
	
	//Declare object of classes
	JFrame frame ,loginDialog;
	JLabel welcome , dbs , opt , luton, address, billingDate, billingID, lblUpdate,stat;  
	JScrollPane scroll; 
	JTable bill;
	JButton close, update, btnGetValues;
	JTextField  bField, sField,dField; 
	
	DefaultTableModel model = new DefaultTableModel(); //Bridge
	
	//constructor of class
	public BillingTable() {
		
		//adding for GUI
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(1500,600));//size of window
		frame.setTitle("Billing Information");//Setting Title
		frame.setResizable(false);//Window cannot be resized
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		//initializing 
		welcome = new JLabel();
		dbs = new JLabel();
		opt = new JLabel();
		luton = new JLabel();
		address = new JLabel();
		billingID = new JLabel();
		billingDate = new JLabel();
		lblUpdate = new JLabel();
		stat = new JLabel();
		
		//buttons
		update = new JButton();
		close = new JButton();
		btnGetValues =  new JButton();
		
		//textfield for user input
		bField = new JTextField();
		sField = new JTextField();
		dField = new JTextField();
		
		//to maintain the font uniformity
		luton.setFont(new Font("Aerial" , Font.BOLD , 35));
	    luton.setText("LUTON HOTEL ");
	    luton.setBounds(450, 05, 600, 30);
	    
	    address.setFont(new Font("Aerial" , Font.PLAIN , 20));
	    address.setText("Luton , United Kingdom");
	    address.setBounds(470, 35,300, 30);
		
		welcome.setFont(new Font ("Courier" , Font.BOLD , 28));
		welcome.setText("HOTEL BOOKINGS");
		welcome.setBounds(450, 60, 500, 25);
	
		dbs.setFont(new Font("Courier" , Font.PLAIN , 18));
		dbs.setText("(Database Connection Successful)");
		dbs.setBounds(390, 60 , 500 ,70);
		
		opt.setFont(new Font("Courier" , Font.BOLD , 28));
		opt.setText("BILLING :");
		opt.setBounds(20, 110, 300, 40);
		
		lblUpdate.setFont(new Font("Courier" , Font.BOLD , 30));
		lblUpdate.setText("UPDATING SECTION");
		lblUpdate.setBounds(1110, 70 , 300 ,70);
		
		
		billingID.setFont(new Font("Courier" , Font.BOLD, 16));
		billingID.setText("Billing ID ");
		billingID.setBounds(1150, 130 , 300 ,70);
		
		bField.setFont(new Font("Courier" , Font.BOLD , 16));
		bField.setColumns(50);
		bField.setEditable(false);
		bField.setBounds(1150, 180, 200, 20);
			
		billingDate.setFont(new Font("Courier" , Font.BOLD, 16));
		billingDate.setText("Billing Date");
		billingDate.setBounds(1150, 180 , 300 ,70);
		
		dField.setFont(new Font("Courier" , Font.BOLD , 16));
		dField.setColumns(10);
		dField.setBounds(1150, 230, 200, 20);
		
		stat.setFont(new Font("Courier" , Font.BOLD , 16));
		stat.setText("Billing Status");
		stat.setBounds(1150, 230 , 300 ,70);
		
		sField.setFont(new Font("Courier" , Font.BOLD , 16));
		sField.setColumns(10);
		sField.setBounds(1150,280,200,20);
		
		update.setFont(new Font("Courier" , Font.BOLD , 18));
		update.setText("UPDATE");
		update.setBounds(1270, 420 , 150 ,40);
		update.addActionListener(this);//adding action listener in button
		
		btnGetValues.setFont(new Font("Courier" , Font.BOLD , 18));
		btnGetValues.setText("GET VALUE");
		btnGetValues.setBounds(1100, 420 , 150 ,40);
		btnGetValues.addActionListener(this);
		
		close.setFont(new Font("Courier" , Font.BOLD , 18));
		close.setText("CLOSE");
		close.setBounds(1190, 470, 150, 40);
		close.addActionListener(this);
		
		//for table
		bill = new JTable(model);
		//room.addActionListener(this);
		
		model.addColumn("Billing ID");
		model.addColumn("Booking ID");
		model.addColumn("Service ID");
		model.addColumn("Total Bill");
		model.addColumn("Billing Date");
		model.addColumn("Billing Status");
		
		displayData();
	
		JScrollPane scroll = new JScrollPane(bill);
		scroll.setBounds(20, 150, 1050, 400);
		
		//adding in Window
		frame.add(welcome);
		frame.add(address);
		frame.add(dbs);
		frame.add(luton);
		frame.add(opt);
		frame.add(lblUpdate);
		frame.add(scroll);
		frame.add(billingID);
		frame.add(bField);
		frame.add(billingDate);
		frame.add(dField);
		frame.add(stat);
		frame.add(sField);
		frame.add(close);
		frame.add(update);
		frame.add(btnGetValues);
		
		frame.setVisible(true);
		
		
	}
		
		//to display data
		public void displayData() {
		@SuppressWarnings({ "unused" })
		//public static void main(String[]args) {	
		
			//BillingTable bt = new BillingTable();
			
			//delete all rows
			int rows = bill.getRowCount();
			for(int i=rows-1; i>=0; i--) {
				model.removeRow(i);
			}
			
			//to execute query
			CRUD1 crud = new CRUD1();
			
			List allBillingDetails = crud.AllBillings();
			
				int i;
				for(i=0; i<allBillingDetails.size(); i++){
		 		
		 		BillingDetails bill = (BillingDetails) allBillingDetails.get(i);		
				model.addRow(new Object[] {bill.getBilling_ID(),bill.getBooking_ID(),bill.getService_ID(),bill.getCurrent_Bill(),bill.getBilling_Date(),bill.getBilling_Status()});
		 		
				}
		 		
		 		//print(allRoomDetailsget(i));//to print on console
		 
		 }
		
		//buttons performing actions
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == close) {
			new WelcomeStaff();
			frame.dispose();;
		}
		else if (e.getSource() == btnGetValues) {
			int i = bill.getSelectedRow();
			bField.setText(bill.getValueAt(i, 0).toString());
			dField.setText(bill.getValueAt(i, 4).toString());
			sField.setText(bill.getValueAt(i, 5).toString());
			
		}
		else if (e.getSource() == update) {
			//read values form text box
			int bookingid = Integer.parseInt(bField.getText());
			String date = dField.getText();
			String status = sField.getText();
			//send them to database for update
			//Connect with database
			//Execute update statement
			CRUD1 crud = new CRUD1();
			crud.UpdateBilling(bookingid, date, status);
			
			JOptionPane.showMessageDialog(frame, "Updated Record Successfully !");
			displayData();
		}
		
	}
	
	
	
	

}
