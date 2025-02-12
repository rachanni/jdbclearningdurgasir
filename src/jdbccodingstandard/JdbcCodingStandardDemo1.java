package jdbccodingstandard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCodingStandardDemo1 {

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","ravi","ravi");
			st=con.createStatement();
			rs=st.executeQuery("select * from employees");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"..."+rs.getString(2)+"..."+rs.getDouble(3)+"..."+rs.getString(4));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)
					rs.close();
				if(st!=null)
					st.close();
				if(con!=null)
					con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
