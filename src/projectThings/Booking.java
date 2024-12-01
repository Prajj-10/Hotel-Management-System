package projectThings;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


@SuppressWarnings("unused")
public class Booking  implements ActionListener, ItemListener{
	JFrame frame;
    Dimension dimension;
    JLabel bookId, checkIn, checkOut,roomType, title , mainTitle, warn , warn2, lblRoomNo;
    //t means text followed by bId which means booking id
    JTextField  tcheckIn, tcheckOut;
    JButton submit, close;
    @SuppressWarnings("rawtypes")
    JComboBox RoomType, RoomNo;
	@SuppressWarnings({ "rawtypes" })
	JComboBox roomCombo, cmbRoomNos;
	
	CRUD1 crud = new CRUD1();
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Booking() {
		
	frame=new JFrame();
	    	
	    	frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(new Dimension(650,350));
			frame.setTitle("Booking Page");
			frame.setResizable(false);
			frame.setLayout(null);
			frame.setLocationRelativeTo(null);
	    
			lblRoomNo = new JLabel();
	    
			String [] data = {"Single-A/C" , "Double-A/C" , "Single" , "Double"};			
			//RoomType = new JComboBox(data);
			
			roomCombo = new JComboBox(data); //room type
			roomCombo.setBounds(250, 60, 100, 20);
			//roomCombo.addActionListener(this);
			roomCombo.addItemListener(this);
			
			cmbRoomNos = new JComboBox();
			cmbRoomNos.setBounds(250, 90, 100, 20);
			cmbRoomNos.addActionListener(this);
			
			
			mainTitle = new JLabel();
			mainTitle.setText("LUTON HOTEL BOOKING SYSTEM");
			mainTitle.setFont(new Font("Courier" , Font.BOLD , 30));
			mainTitle.setBounds(50, 0, 500, 40);
			
			title = new JLabel();
			title.setText("WELCOME TO THE BOOKING PAGE");
			title.setFont(new Font("Courier" , Font.BOLD , 20));
			title.setBounds(120, 30, 400, 20);
			
			
	    	checkIn = new JLabel("Estimated Check In  :");
	    	checkIn.setFont(new Font("Courier" , Font.BOLD , 18));
	    	checkIn.setBounds(20, 120, 300, 20);
	    	
	    	
	    	checkOut = new JLabel("Estimated Check Out :");
	    	checkOut.setFont(new Font("Courier" , Font.BOLD , 18));
	    	checkOut.setBounds(20, 150, 300, 20);
	
	    	
	    	roomType = new JLabel("Preferred Room Type");
	    	roomType.setFont(new Font("Courier" , Font.BOLD , 18));
	    	roomType.setBounds(20, 60, 300, 20);
	    	
	    	lblRoomNo.setText("Available Rooms ");
	    	lblRoomNo.setFont(new Font("Courier" , Font.BOLD , 18));
	    	lblRoomNo.setBounds(20, 90, 300, 20);
	   
	    	
	    	submit = new JButton("SUBMIT");
	    	submit.setFont(new Font("Courier" , Font.BOLD , 18));
	    	submit.setBounds(525, 220, 100, 25);
	    	submit.addActionListener(this);
	    	
	    	close = new JButton("CLOSE");
	    	close.setFont(new Font("Courier" , Font.BOLD , 18));
	    	close.setBounds(525, 250, 100, 25);
	    	close.addActionListener(this);
	    	
	    	
	    	warn = new JLabel();
	    	warn.setText("NOTE : You must enter date in correct order for the booking to be processed.");
	    	warn.setFont(new Font("Courier" , Font.BOLD , 12));
	    	warn.setBounds(20, 190, 700, 20);
	    	
	    	warn2 = new JLabel("FORMAT - (YYYY/MM/DD)");
	    	warn2.setFont(new Font("Courier" , Font.PLAIN , 12));
	    	warn2.setBounds(200, 210, 300, 20);
	    	
	    	tcheckIn = new JTextField();
	    	tcheckOut = new JTextField();
	    	
	    	
	    	
	    	tcheckIn.setColumns(10);
	    	tcheckIn.setBounds(250, 122, 200, 25);
	    	
	    	tcheckOut.setColumns(10);
	    	tcheckOut.setBounds(250, 152, 200, 25);
	    	
	    	
	    	frame.add(mainTitle);
	    	frame.add(title);
	    	frame.add(roomCombo);
	    	frame.add(lblRoomNo);
	    	frame.add(cmbRoomNos);
	    	frame.add(checkIn);
	    	frame.add(tcheckIn);
	    	frame.add(checkOut);
	    	frame.add(tcheckOut);
	    	frame.add(roomType);
	    	frame.add(warn);
	    	frame.add(warn2);
	    	frame.add(submit);
	    	frame.add(close);
	    	
	    	
	    	
	    	
	    	
	    	frame.setVisible(true);
	    	
	    	
	    	
	    	
	}
	
	
	
	
	
	public static void main(String[]args) {
		@SuppressWarnings("unused")
		Booking book = new Booking();
		
		
		
		
	}





	@Override
	 public void actionPerformed(ActionEvent e) {
        if ((tcheckIn.getText().isEmpty() || tcheckOut.getText().isEmpty()) && e.getSource() == submit ) {
            JOptionPane.showMessageDialog(frame, "Please enter all the fields correctly !" , "Error" ,1);
        }
        else if(e.getSource() == close) {
            frame.dispose();
        }
        else if(e.getSource()==submit) {        	    		        	
            String chkIn;
            String chkOut;
            String room_type;            
            int roomNo;
            int reg_id;
            int login_id;
            String user_type;
            
           
            
            chkIn = tcheckIn.getText();
            chkOut = tcheckOut.getText();
            room_type = (String) roomCombo.getSelectedItem();
            roomNo = Integer.parseInt(cmbRoomNos.getSelectedItem().toString());
            login_id = MyGlobal.current_login.getLoginId();
            user_type = MyGlobal.current_login.getUserType();
            
            reg_id = crud.getRegID(login_id, user_type);      
            crud.insertBooking(chkIn, chkOut, room_type, roomNo, reg_id,user_type);
            
            
            //MyDB mydb = new MyDB();
            
            //BookingDetails book =mydb.doBooking();
            
            
            //int booking_id = crud.getBookingID();
            
            //MyBooking.current_booking= book;
            
            //System.out.println(room_type);

            JOptionPane.showMessageDialog(frame, "Your Booking has been recorded. Please wait while it is being confirmed." , "Message Box" ,1);
            frame.dispose();
        }

    }





	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==roomCombo) {
			System.out.println(roomCombo.getSelectedItem().toString());
			CRUD1 crud1 = new CRUD1();
			List roomNos = crud1.getAvailableRooms(roomCombo.getSelectedItem().toString());
			cmbRoomNos.removeAllItems();
			for(int i=0; i<roomNos.size(); i++) {
				cmbRoomNos.addItem(roomNos.get(i).toString());
			}
		}
		
	}
	
}
