package jdbcapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteSingleRowDemo {

	public static void main(String[] args) throws SQLException,ClassNotFoundException{
		
		String driver="oracle.jdbc.OracleDriver";
		String jdbcUrl="jdbc:oracle:thin:@localhost:1521:XE";
		String user="ravi";
		String pwd="ravi";
		Class.forName(driver);
		Connection con=DriverManager.getConnection(jdbcUrl,user,pwd);
		Statement st=con.createStatement();
		String sqlQuery="delete from employees where ename='Sunny'";
		int updateCount=st.executeUpdate(sqlQuery);
		System.out.println("The number of rows deleted:"+updateCount);
		con.close();
	}
}
