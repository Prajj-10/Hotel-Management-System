package projectThings;

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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class BookingTable implements ActionListener {
	JFrame frame ,loginDialog;
	JLabel welcome , dbs , opt , luton, address,chkIn, chkOut, prefRoom, book, status, lblUpdate;  
	JScrollPane scroll; 
	JTable room;
	JButton close, update, btnGetValues;
	JTextField rField, chkInField ,chkOutField, bField, sField; 
	
	DefaultTableModel model = new DefaultTableModel(); //Bridge
	
	
	
	public BookingTable() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(1500,600));
		frame.setTitle("Booking Information");
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		
		welcome = new JLabel();
		dbs = new JLabel();
		opt = new JLabel();
		luton = new JLabel();
		address = new JLabel();
		prefRoom = new JLabel();
		chkIn = new JLabel();
		chkOut = new JLabel();
		book = new JLabel();
		status = new JLabel();
		lblUpdate = new JLabel();
		
		update = new JButton();
		close = new JButton();
		btnGetValues =  new JButton();
				
		rField = new JTextField();
		chkInField = new JTextField();
		chkOutField = new JTextField();
		bField = new JTextField();
		sField = new JTextField();
		
		
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
		opt.setText("BOOKING :");
		opt.setBounds(20, 110, 300, 40);
		
		lblUpdate.setFont(new Font("Courier" , Font.BOLD , 30));
		lblUpdate.setText("UPDATING SECTION");
		lblUpdate.setBounds(1110, 70 , 300 ,70);
		
		book.setFont(new Font("Courier" , Font.BOLD, 16));
		book.setText("Booking ID");
		book.setBounds(1150, 130 , 300 ,70);
		
		bField.setFont(new Font("Courier" , Font.BOLD , 16));
		bField.setColumns(50);
		bField.setEditable(false);
		bField.setBounds(1150, 180, 200, 20);
		
		
		prefRoom.setFont(new Font("Courier" , Font.BOLD, 16));
		prefRoom.setText("Room No.");
		prefRoom.setBounds(1150, 180 , 300 ,70);
		
		rField.setFont(new Font("Courier" , Font.BOLD , 16));
		rField.setColumns(10);
		rField.setBounds(1150, 230, 200, 20);
		
		chkIn.setFont(new Font("Courier" , Font.BOLD , 16));
		chkIn.setText("Check-In");
		chkIn.setBounds(1150, 230 , 300 ,70);
		
		chkInField.setFont(new Font("Courier" , Font.BOLD , 16));
		chkInField.setColumns(10);
		chkInField.setBounds(1150,280,200,20);
		
		chkOut.setFont(new Font("Courier" , Font.BOLD , 16));
		chkOut.setText("Check-Out");
		chkOut.setBounds(1150, 280 , 300 ,70);
		
		chkOutField.setFont(new Font("Courier" , Font.BOLD , 16));
		chkOutField.setColumns(10);
		chkOutField.setBounds(1150, 330, 200, 20);
		
		status.setFont(new Font("Courier" , Font.BOLD , 16));
		status.setText("Booking Status");
		status.setBounds(1150, 330 , 300 ,70);
		
		sField.setFont(new Font("Courier" , Font.BOLD , 16));
		sField.setColumns(10);
		sField.setBounds(1150, 380, 200, 20);
		
		
		update.setFont(new Font("Courier" , Font.BOLD , 18));
		update.setText("UPDATE");
		update.setBounds(1270, 420 , 150 ,40);
		update.addActionListener(this);
		
		
		btnGetValues.setFont(new Font("Courier" , Font.BOLD , 18));
		btnGetValues.setText("GET VALUE");
		btnGetValues.setBounds(1100, 420 , 150 ,40);
		btnGetValues.addActionListener(this);
		
		close.setFont(new Font("Courier" , Font.BOLD , 18));
		close.setText("CLOSE");
		close.setBounds(1190, 470, 150, 40);
		close.addActionListener(this);
		
		room = new JTable(model);
		//room.addActionListener(this);
		
		model.addColumn("Booking ID");
		model.addColumn("Check-In");
		model.addColumn("Check-Out");
		model.addColumn("Booking Status");
		model.addColumn("Current Bill");
		model.addColumn("Preferred Room");
		model.addColumn("Room No");
		model.addColumn("Registration ID");
		model.addColumn("Corporate ID");
		model.addColumn("Staff ID");
		
		displayData();
		//room = new JTable(data , ColumnName);
		//DefaultTableModel model = new DefaultTableModel();
				
		JScrollPane scroll = new JScrollPane(room);
		scroll.setBounds(20, 150, 1050, 400);
		
		//view = new JButton("View Rooms");
		
	    //frame.add(view);
		frame.add(welcome);
		frame.add(address);
		frame.add(dbs);
		frame.add(luton);
		frame.add(opt);
		frame.add(lblUpdate);
		frame.add(close);
		frame.add(scroll);
		frame.add(book);
		frame.add(bField);
		frame.add(prefRoom);
		frame.add(rField);
		frame.add(chkIn);
		frame.add(chkInField);
		frame.add(chkOut);
		frame.add(chkOutField);
		frame.add(status);
		frame.add(sField);
		frame.add(update);
		frame.add(btnGetValues);
		
		frame.setVisible(true);
		
	}
	public void displayData() {
	//public static void main(String[]args) {	
	
		//BookingTable bt = new BookingTable();
		
		//delete all rows
		int rows = room.getRowCount();
		for(int i=rows-1; i>=0; i--) {
			model.removeRow(i);
		}
		
		CRUD1 crud = new CRUD1();
		@SuppressWarnings("rawtypes")
		List allBookingDetails = crud.AllBookings();
		
			int i;
			for(i=0; i<allBookingDetails.size(); i++){
	 		
	 		BookingDetails book = (BookingDetails) allBookingDetails.get(i);		
			model.addRow(new Object[] {book.getBookingID(), book.getCheckIn(), book.getCheckOut(), book.getBookingStatus(),book.getCurrentBill(),book.getPreferredRoomType(),book.getRoomNo(),book.getRegID(),book.getCorID(),book.getStaffID()});
	 		
			}
	 		
	 		//print(allRoomDetailsget(i));//to print on console
	 
	 }
		
		
			
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == close) {
			new WelcomeStaff();
			frame.dispose();;
		}
		else if (e.getSource() == btnGetValues) {
			int i = room.getSelectedRow();
			bField.setText(room.getValueAt(i, 0).toString());
			rField.setText(room.getValueAt(i, 6).toString());
			chkInField.setText(room.getValueAt(i, 1).toString());
			chkOutField.setText(room.getValueAt(i, 2).toString());
			sField.setText(room.getValueAt(i, 3).toString());
		}
		else if (e.getSource() == update) {
			//read values form text box
			int bookingid = Integer.parseInt(bField.getText());
			String checkInDate = chkInField.getText();
			String checkOutDate = chkOutField.getText();
			int room = Integer.parseInt(rField.getText());
			String status = sField.getText();
			
			CRUD1 crud = new CRUD1();
			int room_cost = crud.IDtoCost(room);
			int chkIn = Integer.parseInt(checkInDate.substring(8));
			int chkOut = Integer.parseInt(checkOutDate.substring(8));
			int days = chkOut - chkIn ;
			room_cost = room_cost * days;
			//send them to database for update
			//Connect with database
			//Execute update statement
			
			crud.UpdateBooking(bookingid, checkInDate,checkOutDate,room,status,room_cost);
			
			int login_id = MyGlobal.current_login.getLoginId();
			String user_type = MyGlobal.current_login.getUserType();
			
			int staffid = crud.getRegID(login_id, user_type);
			crud.UpdateStaffID(staffid,bookingid);
			crud.updateRoomStatus(room, status);
			
			
			
			JOptionPane.showMessageDialog(frame, "Updated Record Successfully !");
			displayData();
		}
	}

}	