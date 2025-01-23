package jdbcapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteMultipleRowsDemo {

	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		
		String driver="oracle.jdbc.OracleDriver";
		String jdbcUrl="jdbc:oracle:thin:@localhost:1521:XE";
		String user="ravi";
		String pwd="ravi";
		Class.forName(driver);
		Connection con=DriverManager.getConnection(jdbcUrl,user,pwd);
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter cut off salary:");
		double cutOff=sc.nextDouble();
		String sqlQuery=String.format("delete from employees where esal>=%f", cutOff);
		int updateCount=st.executeUpdate(sqlQuery);
		System.out.println("The number of rows deleted:"+updateCount);
		con.close();
	}
}
