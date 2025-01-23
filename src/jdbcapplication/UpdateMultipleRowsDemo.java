package jdbcapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateMultipleRowsDemo {

	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		
		String driver="oracle.jdbc.OracleDriver";
		String jdbcUrl="jdbc:oracle:thin:@localhost:1521:XE";
		String user="ravi";
		String pwd="ravi";
		Class.forName(driver);
		Connection con=DriverManager.getConnection(jdbcUrl,user,pwd);
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter increment salary:");
		double increment=sc.nextDouble();
		System.out.println("Enter salary range:");
		double salRange=sc.nextDouble();
		String sql_query=String.format( "update employees set esal=esal + %f where esal<%f",increment,salRange);
		int updateCount=st.executeUpdate(sql_query);
		System.out.println("The number of rows updated:"+updateCount);
		con.close();
	}
}
