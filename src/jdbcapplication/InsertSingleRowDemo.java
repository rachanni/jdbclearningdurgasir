package jdbcapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertSingleRowDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String driver="oracle.jdbc.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="ravi";
		String pwd="ravi";
		String sql_query="insert into employees values(300,'Radhika',3000,'Chennai')";
		Class.forName(driver);
		Connection con=DriverManager.getConnection(jdbc_url,user,pwd);
		Statement st=con.createStatement();
		int updateCount=st.executeUpdate(sql_query);
		System.out.println("The number of rows inserted: "+updateCount);
		con.close();
	}
}
