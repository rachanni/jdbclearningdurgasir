package type5driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Type5DriverDemo {

	public static void main(String[] args) throws Exception {
		
//		Class.forName("com.ddtek.jdbc.oracle.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:datadirect:oracle://localhost:1521;ServiceName=XE","ravi","ravi");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from movies");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"..."+rs.getString(2)+"..."+rs.getString(3)+"..."+rs.getString(4));
		}
		con.close();
	}
}
