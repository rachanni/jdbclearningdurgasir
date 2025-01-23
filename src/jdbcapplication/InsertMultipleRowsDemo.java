package jdbcapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertMultipleRowsDemo {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		String driver="oracle.jdbc.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="ravi";
		String pwd="ravi";
		Class.forName(driver);
		Connection con=DriverManager.getConnection(jdbc_url,user,pwd);
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Employee number:");
			int eno=sc.nextInt();
			System.out.println("Employee name:");
			String ename=sc.next();
			System.out.println("Employee salary:");
			double esal=sc.nextDouble();
			System.out.println("Employee Address:");
			String eaddr=sc.next();
			String sqlQuery=String.format("insert into employees values(%d,'%s',%f,'%s')", eno,ename,esal,eaddr);
			st.executeUpdate(sqlQuery);
			System.out.println("Record inserted successfully");
			System.out.println("Do U want to insert one more record[Yes/No]:");
			String option=sc.next();
			if(option.equalsIgnoreCase("No")) {
				break;
			}
		}
		con.close();
	}
}
