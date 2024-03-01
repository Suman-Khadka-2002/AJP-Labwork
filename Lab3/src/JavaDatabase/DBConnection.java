package JavaDatabase;

import java.sql.*;

public class DBConnection {
	
	public Connection con;
    public Statement pstmt;
	public DBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demodb","root","");
			pstmt = con.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}


























