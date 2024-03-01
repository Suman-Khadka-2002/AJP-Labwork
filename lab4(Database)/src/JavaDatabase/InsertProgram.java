package JavaDatabase;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class InsertProgram extends JFrame implements ActionListener{
	
	JLabel lbluserID, lblusername, lbladdress;
	JTextField txtuserID, txtusername, txtaddress;
	JButton btnsave, btnreset, btnexit, btnshowdata;
	
	public InsertProgram() {
		
		lbluserID = new JLabel("UserID");
		add(lbluserID).setBounds(20,20,100,20);
		
		txtuserID = new JTextField();
		add(txtuserID).setBounds(120,20,100,20);
		
		lblusername = new JLabel("UserName");
		add(lblusername).setBounds(20,60,100,20);
		
		txtusername = new JTextField();
		add(txtusername).setBounds(120,60,100,20);
		
		lbladdress = new JLabel("Address");
		add(lbladdress).setBounds(20,100,100,20);
		
		txtaddress = new JTextField();
		add(txtaddress).setBounds(120,100,100,20);
		
		btnsave = new JButton("Save");
		add(btnsave).setBounds(20,140,100,20);
		btnsave.addActionListener(this);
		
		btnreset = new JButton("Reset");
		add(btnreset).setBounds(120,140,100,20);
		btnreset.addActionListener(this);
		
		btnexit = new JButton("Exit");
		add(btnexit).setBounds(220,140,100,20);
		btnexit.addActionListener(this);
		
		btnshowdata = new JButton("Show Data");
		add(btnshowdata).setBounds(110,160,100,20);
		btnshowdata.addActionListener(this);
		
		
		setSize(400,250);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Insert Application");
		setResizable(false);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnsave) {
			if(txtuserID.getText().equals("")||txtusername.getText().equals("")||txtaddress.getText().equals("")) {
				JOptionPane.showMessageDialog(rootPane, "All FIeld must be filled");
				txtuserID.requestFocus();
			}
			else {
				try {
					DBConnection conn = new DBConnection();
				
					int userID = Integer.parseInt(txtuserID.getText());
					String username = txtusername.getText();
					String address = txtaddress.getText();
					
					String sqlquery = "insert into userdata values('"+userID+"','"+username+"','"+address+"')";
					int x = conn.pstmt.executeUpdate(sqlquery);
					JOptionPane.showMessageDialog(rootPane, "Data Inserted Successfully");
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			
			}
		}
		if(e.getSource()==btnreset) {
			txtuserID.setText("");
			txtusername.setText("");
			txtaddress.setText("");
			txtuserID.requestFocus();
			
		}
		if(e.getSource()==btnexit) {
			dispose();
		}
		if(e.getSource()==btnshowdata) {
			new alldetails();
			dispose();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new InsertProgram();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}