package projectThings;


//importing class for GUI
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class RoomTable implements ActionListener {
	
	//initializing
	JFrame frame, loginDialog;
	JLabel welcome, dbs, opt, luton, address, roomid,roomStat, lblUpdate;
	JTextField roomF, statF;
	JScrollPane scroll;
	JTable room;
	JButton close, get,update ;
	
	//for table
	DefaultTableModel model = new DefaultTableModel(); // Bridge
	
	//constructor of class
	public RoomTable() {
		
		//for window
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(1000, 600));//size of window
		frame.setTitle("Room Information");//title
		frame.setResizable(false);//cannot be resized
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		//initializing
		welcome = new JLabel();
		dbs = new JLabel();
		opt = new JLabel();
		luton = new JLabel();
		address = new JLabel();
		roomid = new JLabel();
		roomStat = new JLabel();
		lblUpdate = new JLabel();
		
		//textfield
		roomF = new JTextField();
		statF = new JTextField();
		
		//buttons
		close = new JButton();
		get = new JButton();
		update = new JButton();
		
		//maintaining font uniformity
		luton.setFont(new Font("Aerial", Font.BOLD, 30));
		luton.setText("LUTON HOTEL ");
		luton.setBounds(320, 10, 600, 30);

		address.setFont(new Font("Aerial", Font.PLAIN, 14));
		address.setText("Luton , United Kingdom");
		address.setBounds(340, 40, 200, 20);

		welcome.setFont(new Font("Courier", Font.BOLD, 28));
		welcome.setText("ROOM DESCRIPTION");
		welcome.setBounds(290, 60, 500, 25);

		dbs.setFont(new Font("Courier", Font.PLAIN, 14));
		dbs.setText("(Database Connection Successful)");
		dbs.setBounds(295, 60, 300, 70);

		opt.setFont(new Font("Courier", Font.BOLD, 20));
		opt.setText("ROOM INFORMATION :");
		opt.setBounds(20, 110, 300, 40);
		
		lblUpdate.setFont(new Font("Courier", Font.BOLD, 30));
		lblUpdate.setText("UPDATE SECTION");
		lblUpdate.setBounds(650, 100, 300, 40);
		
		roomid.setFont(new Font("Courier", Font.BOLD, 20));
		roomid.setText("Room ID ");
		roomid.setBounds(650, 150, 300, 40);
		
		roomF.setFont(new Font("Courier", Font.BOLD, 20));
		roomF.setColumns(20);
		roomF.setBounds(650, 200, 250, 25);
		roomF.setEditable(false);
		
		roomStat.setFont(new Font("Courier", Font.BOLD, 20));
		roomStat.setText("Room Status");
		roomStat.setBounds(650, 220, 300, 40);
		
		statF.setFont(new Font("Courier", Font.BOLD, 20));
		statF.setColumns(20);
		statF.setBounds(650, 270, 250, 25);
		
		get.setFont(new Font("Courier", Font.BOLD, 18));
		get.setText("GET VALUE");
		get.setBounds(650, 310, 150, 40);
		get.addActionListener(this);
		
		update.setFont(new Font("Courier", Font.BOLD, 18));
		update.setText("UPDATE");
		update.setBounds(820, 310, 150, 40);
		update.addActionListener(this);
		
		close.setFont(new Font("Courier", Font.BOLD, 18));
		close.setText("CLOSE");
		close.setBounds(730, 360, 150, 40);
		close.addActionListener(this);
		
		//for table
		room = new JTable(model);
		/*TableColumn tcol ;
		tcol = room.getColumnModel().getColumn(0);
        room.getColumnModel().removeColumn(tcol);
        tcol = room.getColumnModel().getColumn(1);
        room.getColumnModel().removeColumn(tcol);
        tcol = room.getColumnModel().getColumn(2);
        room.getColumnModel().removeColumn(tcol);
        tcol = room.getColumnModel().getColumn(3);
        room.getColumnModel().removeColumn(tcol);
        */
		model.addColumn("Room ID");
		model.addColumn("Room Type");
		model.addColumn("Room Status");
		model.addColumn("Room Price");
		
		display_data();
		
		JScrollPane scroll = new JScrollPane(room);
		scroll.setBounds(20, 150, 600, 400);

		// view = new JButton("View Rooms");
		
		
		//adding components in GUI
		// frame.add(view);
		frame.add(welcome);
		frame.add(address);
		frame.add(dbs);
		frame.add(luton);
		frame.add(opt);
		frame.add(lblUpdate);
		frame.add(roomid);
		frame.add(roomF);
		frame.add(roomStat);
		frame.add(statF);
		frame.add(close);
		frame.add(get);
		frame.add(update);
		frame.add(scroll);	
		
		frame.setVisible(true);
	}
	//public static void main(String[]args) {
		
		//RoomTable rt = new RoomTable();
	//displays data
	public void display_data() {		
		// room = new JTable(data , ColumnName);
		// DefaultTableModel model = new DefaultTableModel();
		
		int rows = room.getRowCount();
		for(int i=rows-1; i>=0; i--) {
			model.removeRow(i);
		}
		//execute query
		CRUD1 crud = new CRUD1();
		@SuppressWarnings("rawtypes")
		List allRoomDetails = crud.selectRoom();		
		for (int i = 0; i < allRoomDetails.size(); i++) {
			RoomDetails room = (RoomDetails) allRoomDetails.get(i);
			model.addRow(new Object[] { room.getRoomNo(), room.getType(), room.getStatus(), room.getCost() });
			// print(allRoomDetailsget(i));//to print on console
		}
	}
	
	//button performing action
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == close) {
			//frame.setVisible(false);
			new WelcomeStaff();
			frame.dispose();
		}
		else if (e.getSource() == get) {
			int i = room.getSelectedRow();
			roomF.setText(room.getValueAt(i, 0).toString());
			statF.setText(room.getValueAt(i, 2).toString());
			

		}
		else if (e.getSource() == update) {
			
			CRUD1 crud = new CRUD1();
			int roomId = Integer.parseInt(roomF.getText());
			String status = statF.getText();
			crud.updateRoomStatus(roomId, status);
			JOptionPane.showMessageDialog(frame, "Updated Record Successfully !");
			display_data();
		}
	}
}