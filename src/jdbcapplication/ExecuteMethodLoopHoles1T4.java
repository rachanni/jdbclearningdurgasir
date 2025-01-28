package jdbcapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteMethodLoopHoles1T4 {

	public static void main(String[] args) throws SQLException {
		
		String driver="oracle.jdbc.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="ravi";
		String pwd="ravi";
		Connection con=DriverManager.getConnection(jdbc_url,user,pwd);
		Statement st=con.createStatement();
		int updateCount=st.executeUpdate("create table emp2(eno number)");
		System.out.println(updateCount);
		con.close();
	}
}
