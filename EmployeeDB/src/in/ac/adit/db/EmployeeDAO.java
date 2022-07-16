package in.ac.adit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDAO {

	final static String URL = "jdbc:mysql://localhost:3306/employee";
	final static String DUSER = "root";
	final static String DPASS = "";
	private Connection con = null;
	private Statement ste = null;

	public EmployeeDAO() {
		try {
			con = DriverManager.getConnection(URL, DUSER, DPASS);
			ste = con.createStatement();
			System.out.println("Database Connected...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean create() {
		try {
			// ste.execute("INSERT INTO EMPLOYEE VALUES(1,'KUNJ',2022,'KP17@GMAIL.COM')");
			// ste.execute("INSERT INTO EMPLOYEE VALUES(2,'MADHAV',2023,'MD7@GMAIL.COM')");
			ste.execute("INSERT INTO EMPLOYEE VALUES(3,'AKSHAR',2000,'AK15@GMAIL.COM')");
			ste.execute("INSERT INTO EMPLOYEE VALUES(4,'DARSHAN',1900,'DP@HOTMAIL.COM')");
			ste.execute("INSERT INTO EMPLOYEE VALUES(5,'KARAN',2500,'KT5@GMAIL.COM')");

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public int update() {
		try {
//			ste.executeUpdate("UPDATE EMPLOYEE SET  name='PREM' WHERE id=5");
			//ste.executeUpdate("UPDATE EMPLOYEE SET  email='PP29@GMAIL.COM' WHERE id=5");
			ste.executeUpdate("UPDATE EMPLOYEE SET  id=4 WHERE name='PREM'");
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public int delete()
	{
		try {
			ste.executeUpdate("DELETE FROM EMPLOYEE WHERE ID=4");
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;	
	}
	
	public void get()
	{
		try {
			ResultSet rs = ste.executeQuery("SELECT * FROM EMPLOYEE WHERE ID=1");
			if(rs.next())
			{
				System.out.println("ID: "+rs.getInt(1));
				System.out.println("NAME: "+rs.getString(2));
				System.out.println("SALARY: "+rs.getInt(3));
				System.out.println("EMAIL: "+rs.getString(4));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getAll()
	{
		ResultSet rs;
		try {
			rs = ste.executeQuery("SELECT * FROM EMPLOYEE");
			while(rs.next())
			{
				System.out.println("ID: "+rs.getInt(1));
				System.out.println("NAME: "+rs.getString(2));
				System.out.println("SALARY: "+rs.getInt(3));
				System.out.println("EMAIL: "+rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
