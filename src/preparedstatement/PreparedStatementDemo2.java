package preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementDemo2 {

	public static void main(String[] args) throws SQLException {
		
		String driver="oracle.jdbc.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="ravi";
		String pwd="ravi";
		Connection con=DriverManager.getConnection(jdbc_url,user,pwd);
		String sql_query="insert into employees values(?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(sql_query);
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Employee Number:");
			int eno=sc.nextInt();
			System.out.println("Enter Employee Name:");
			String ename=sc.next();
			System.out.println("Enter Employee Salary:");
			double esal=sc.nextDouble();
			System.out.println("Enter Employee Address:");
			String eaddr=sc.next();
			pst.setInt(1, eno);
			pst.setString(2, ename);
			pst.setDouble(3, esal);
			pst.setString(4, eaddr);
			pst.executeUpdate();
			System.out.println("Record inserted successfully");
			System.out.println("Do you want to insert one more record[Yes|No]:");
			String option=sc.next();
			if(option.equalsIgnoreCase("No")) {
				break;
			}
		}
		con.close();
	}
}
