package type4driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Type4DriverDemo {

	public static void main(String[] args) throws Exception {
		
//		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","ravi","ravi");
		Statement st=con.createStatement();
		st.setFetchSize(50); // Set this to an appropriate value

		ResultSet rs=st.executeQuery("select * from movies");
		int rowCount=0;
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"..."+rs.getString(2)+"..."+rs.getString(3)+"..."+rs.getString(4));
			rowCount++;
		}
		System.out.println("Number of row in table: "+rowCount);
		con.close();
	}
}
