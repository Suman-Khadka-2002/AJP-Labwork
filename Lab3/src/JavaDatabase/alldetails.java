package JavaDatabase;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class alldetails extends JFrame implements ActionListener{

    DefaultTableModel model=new DefaultTableModel();
    JTable table;
    JScrollPane jsp;
    JLabel l1;
    JButton btnback;
    
    public alldetails()
    {
        Font f1=new Font("ARIAL",Font.BOLD,14); 
        l1=new JLabel("User Details");
        add(l1).setBounds(20,20,180,25);
        l1.setFont(f1);
        l1.setForeground(Color.BLUE);
        
        btnback = new JButton("Back");
        add(btnback).setBounds(800,20,100,25);
        btnback.addActionListener(this);
        
        table=new JTable(model){
            @Override
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        
        jsp=new JScrollPane(table,v,h);
        add(jsp).setBounds(20,60,900,350);

        table.getTableHeader().setReorderingAllowed(false);
        
        model.addColumn("UserID");
        model.addColumn("UserName");
        model.addColumn("Address");
        
        
        setLayout(null);
        setVisible(true);
        setSize(1000,750);
        setTitle("Details");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        try {
            DBConnection c1=new DBConnection();
            ResultSet rs=c1.pstmt.executeQuery("Select * from userdata");
            while(rs.next())
            {
                model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3)});
            }
        } catch (Exception e) {
        }
        
        
    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnback) {
			dispose();
			new InsertProgram();
		}
		
	}
    
}