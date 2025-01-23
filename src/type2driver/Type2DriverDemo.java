package type2driver;

import java.sql.*;

public class Type2DriverDemo {

	public static void main(String[] args) throws Exception {
		
//		Class.forName("oracle.jdbc.OracleDriver");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:oci:@XE","ravi","ravi");
		
//		if(con!=null) {
//			System.out.println("connection established successfully");
//		}else {
//			System.out.println("connection not established");
//		}	
//		
//		String classpath = System.getProperty("java.class.path");
//        System.out.println("Classpath: " + classpath);
		Statement st=con.createStatement();
		st.execute("ALTER SESSION SET RESULT_CACHE_MODE = FORCE");

		int count=0;
		try {
		ResultSet rs=st.executeQuery("select * from movies");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"..."+rs.getString(2)+"..."+rs.getString(3)+"..."+rs.getString(4));
			count++;
		}
		
		}
		finally {
			if(con!=null) {
				con.close();
			}
		}
		
		
		System.out.println(count);
		
		
//		con.close();
	}
}
