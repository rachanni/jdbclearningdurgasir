package jdbcapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleToMySQL {

	public static void main(String[] args) throws SQLException {
		
		Connection con1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","ravi","ravi");
		Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","ravi");
		
		Statement st1=con1.createStatement();
		Statement st2=con2.createStatement();
		ResultSet rs=st1.executeQuery("select * from employees");
		int count=0;
		while(rs.next()) {
			count++;
			int eno=rs.getInt(1);
			String ename=rs.getString(2);
			double esal=rs.getDouble(3);
			String eaddr=rs.getString(4);
			
			String sql_query=String.format("insert into employees values(%d,'%s',%f,'%s')",eno,ename,esal,eaddr);
			st2.executeUpdate(sql_query);
			
		}
		System.out.println("Total Data copied from oracle to MySQL and number of records:"+count);
		con1.close();
		con2.close();
	}
}
