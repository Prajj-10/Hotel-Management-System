package projectThings;

//importing class for GUI
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

public class ServiceTable implements ActionListener{
	//declaring
	JFrame frame ,loginDialog;
	JLabel welcome , dbs , opt , luton, address,options,ServiceId, ServiceCost, Warning, Warning2 ; 
	JScrollPane scroll;
	JTable room;
	JButton close, order,orderMore;
	JTextField IdField,CostField;
	
	//for table
	DefaultTableModel model = new DefaultTableModel(); //Bridge
	
	
	//constructor of class
	public ServiceTable() {
		
		//for window
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(1500,550));//size
		frame.setTitle("Service Information");//title
		frame.setResizable(false);//cant be resized
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		//initializing
		welcome = new JLabel();
		dbs = new JLabel();
		opt = new JLabel();
		luton = new JLabel();
		address = new JLabel();
		options = new JLabel();
		ServiceId = new JLabel();
		ServiceCost = new JLabel();
		Warning = new JLabel();
		Warning2 = new JLabel();
		
		//textfield
		IdField = new JTextField();
		CostField = new JTextField();
		
		//button
		close = new JButton();
		order = new JButton();
		orderMore = new JButton();
		
		//maintaining font uniformity
		luton.setFont(new Font("Aerial" , Font.BOLD , 25));
	    luton.setText("LUTON HOTEL ");
	    luton.setBounds(550, 0, 600, 20);
	    
	    address.setFont(new Font("Aerial" , Font.PLAIN , 12));
	    address.setText("Luton , United Kingdom");
	    address.setBounds(570, 20, 200, 20);
		
		welcome.setFont(new Font ("Courier" , Font.BOLD , 22));
		welcome.setText("SERVICE MENU");
		welcome.setBounds(560, 35, 500, 25);
	
		dbs.setFont(new Font("Courier" , Font.PLAIN , 12));
		dbs.setText("(Database Connection Successful)");
		dbs.setBounds(525, 30 , 300 ,70);
		
		opt.setFont(new Font("Courier" , Font.BOLD , 16));
		opt.setText("SERVICES PROVIDED :");
		opt.setBounds(20, 70, 300, 40);
		
		options.setFont(new Font("Courier" , Font.BOLD , 25));
		options.setText("OPTIONS :");
		options.setBounds(1250, 105, 300, 40);
		
		close.setFont(new Font("Courier" , Font.BOLD , 20));
		close.setText("CLOSE");
		close.setBounds(1250, 350, 200, 40);
		close.addActionListener(this);
		
		order.setFont(new Font("Courier" , Font.BOLD , 20));
		order.setText("ORDER");
		order.setBounds(1250, 250, 200, 40);
		order.addActionListener(this);
		
		orderMore.setFont(new Font("Courier" , Font.BOLD , 20));
		orderMore.setText("ORDER MORE");
		orderMore.setBounds(1250, 300, 200, 40);
		orderMore.addActionListener(this);
		
		ServiceId.setFont(new Font("Courier" , Font.BOLD , 18));
		ServiceId.setText("Service ID :");
		ServiceId.setBounds(1250, 120 , 300 ,70);
		
		IdField.setColumns(10);
		IdField.setEditable(false);
		IdField.setBounds(1250, 170, 150, 20);
		
		ServiceCost.setFont(new Font("Courier" , Font.BOLD , 18));
		ServiceCost.setText("Service Cost :");
		ServiceCost.setBounds(1250, 170 , 300 ,70);
		
		CostField.setColumns(10);
		CostField.setEditable(false);
		CostField.setBounds(1250, 220, 150, 20);
		
		Warning.setFont(new Font("Courier" , Font.BOLD , 18));
		Warning.setText("Please use \"Order\" Button to order for the first time.");
		Warning.setBounds(100, 450 , 700 ,70);
		
		Warning2.setFont(new Font("Courier" , Font.BOLD , 18));
		Warning2.setText("Then use \"Order More\" Button to order further Services.");
		Warning2.setBounds(700, 450 , 700 ,70);
		
		//for table
		room = new JTable(model);
		model.addColumn("Service ID");
		model.addColumn("Service Name");
		model.addColumn("Service Type");
		model.addColumn("Price (in Nepali Rupees)");
	    
		DisplayData();
		
		//room = new JTable(data , ColumnName);
		//DefaultTableModel model = new DefaultTableModel();
		
		JScrollPane scroll = new JScrollPane(room);
		scroll.setBounds(20, 110, 1200, 343);
		
		//view = new JButton("View Rooms");
		
		
		
		
		//adding component in GUI
	    //frame.add(view);
		frame.add(welcome);
		frame.add(address);
		frame.add(dbs);
		frame.add(luton);
		frame.add(opt);
		frame.add(options);
		frame.add(ServiceId);
		frame.add(IdField);
		frame.add(ServiceCost);
		frame.add(CostField);
		frame.add(close);
		frame.add(order);
		frame.add(orderMore);
		frame.add(order);
		frame.add(orderMore);
		frame.add(Warning);
		frame.add(Warning2);
		frame.add(scroll);
		
		frame.setVisible(true);
		
	}
	
	//display data
	public void DisplayData() {
	//public static void main(String[]args) {
		
		//ServiceTable service = new ServiceTable();
		int rows = room.getRowCount();
		for(int i=rows-1; i>=0; i--) {
			model.removeRow(i);
		}
		
		//execute query
		CRUD1 crud = new CRUD1();
		@SuppressWarnings("rawtypes")
		List allServiceDetails = crud.ServiceDetails();
		
			int i;
			for(i=0; i<allServiceDetails.size(); i++){
	 		
	 		ServiceDetails ser = (ServiceDetails) allServiceDetails.get(i);		
			model.addRow(new Object[] {ser.getServiceID(),ser.getServiceName(),ser.getServiceType(),ser.getPrice()});
	 		
			}
	 		
	 		//print(allRoomDetailsget(i));//to print on console
	 
	 }
		
		
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == close) {
			
			boolean res1 = MyGlobal.current_login.getUserType().equals("Customer"); 
			boolean res2 = MyGlobal.current_login.getUserType().equals("Corporate");
			
			
			if ( res1||res2 ) {
				frame.dispose();
				new WelcomeUser();
			}
			else {
				frame.dispose();
				new WelcomeStaff();
			}
			
		}
		if (e.getSource() == order) {
			
			int i = room.getSelectedRow();
			IdField.setText(room.getValueAt(i, 0).toString());
			CostField.setText(room.getValueAt(i, 3).toString());
			
			CRUD1 crud = new CRUD1();
			MyDB mydb = new MyDB();
			
			String usertype = MyGlobal.current_login.getUserType();
			int loginid = MyGlobal.current_login.getLoginId();
			int reg_ID = crud.getRegID(loginid, usertype);
			
			int serviceid = Integer.parseInt(IdField.getText());
			int servicecost = Integer.parseInt(CostField.getText());
			
			int bookingid;
			
			BookingDetails bookingDetails = mydb.doBooking(reg_ID,usertype);
			if (usertype.equals("Customer")) {
				bookingid = bookingDetails.getBookingID();		
				
				crud.insertBilling(bookingid, serviceid, servicecost);
				crud.UpdateCurrentBill(servicecost, bookingid);
				JOptionPane.showMessageDialog(frame, "Your Order has reached us. Thankyou for the order.Please be patient while we process your order.");
			}
			else if (usertype.equals("Corporate")){
				bookingid = bookingDetails.getBookingID();
				
				crud.insertBilling(bookingid, serviceid, servicecost);
				crud.UpdateCurrentBill(servicecost, bookingid);
				JOptionPane.showMessageDialog(frame, "Your Order has reached us. Thankyou for the order.Please be patient while we process your order.");
			}
			else {
				JOptionPane.showMessageDialog(frame, "You need to book a room to order the services!!");
			}

			//DisplayData();
		}
		if (e.getSource() == orderMore) {
			
			int i = room.getSelectedRow();
			IdField.setText(room.getValueAt(i, 0).toString());
			CostField.setText(room.getValueAt(i, 3).toString());
			
			CRUD1 crud = new CRUD1();
			MyDB mydb = new MyDB();
			
			String usertype = MyGlobal.current_login.getUserType();
			int loginid = MyGlobal.current_login.getLoginId();
			int reg_ID = crud.getRegID(loginid, usertype);
			
			int serviceid = Integer.parseInt(IdField.getText());
			int servicecost = Integer.parseInt(CostField.getText());
			
			int bookingid;
			
			BookingDetails bookingDetails = mydb.doBooking(reg_ID,usertype);
			
			bookingid = bookingDetails.getBookingID();
			
			int billingid = crud.BillingIDFromBooking(bookingid);
			
			
			crud.UpdateTotalBilling(servicecost,serviceid,billingid);
			crud.UpdateCurrentBill(servicecost, bookingid);
			JOptionPane.showMessageDialog(frame, "Your Order has reached us. Thankyou for the order.Please be patient while we process your order.");
			
		}
		
	}

}	