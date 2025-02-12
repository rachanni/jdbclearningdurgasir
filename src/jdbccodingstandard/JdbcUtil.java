package jdbccodingstandard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {

	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getOracleConnection() throws SQLException{
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","ravi","ravi");
		return con;
	}
	
	public static void cleanup(Connection con, Statement st, ResultSet rs) {
		
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
