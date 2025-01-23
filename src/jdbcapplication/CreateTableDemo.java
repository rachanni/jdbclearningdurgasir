package jdbcapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableDemo {

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		
		String driver="oracle.jdbc.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="ravi";
		String pwd="ravi";
		String sql_query="create table employees(eno number, ename varchar2(10), esal number(10,2), eaddr varchar2(10))";
		Class.forName(driver);
		Connection con=DriverManager.getConnection(jdbc_url,user,pwd);
		Statement st=con.createStatement();
		st.executeUpdate(sql_query);
		System.out.println("Table created successfully");
		con.close();
		
		
	}
}
