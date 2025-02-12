package jdbcapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcMySQLDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","ravi");
		Statement st=con.createStatement();
		String sql_query="select * from employees";
		ResultSet rs=st.executeQuery(sql_query);
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("---------------------------");
		while(rs.next()) {
			
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
		}
	}
}
