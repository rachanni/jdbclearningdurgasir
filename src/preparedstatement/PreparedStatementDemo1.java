package preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementDemo1 {

	public static void main(String[] args) throws SQLException {
		
		String driver="oracle.jdbc.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="ravi";
		String pwd="ravi";
		Connection con=DriverManager.getConnection(jdbc_url,user,pwd);
		String sql_query="delete from employees where ename=?";
		PreparedStatement pst=con.prepareStatement(sql_query);
		pst.setString(1, "Sunny");
		int updateCount=pst.executeUpdate();
		System.out.println("The number of rows deleted:"+updateCount);
		System.out.println("Reusing PreparedStatement to delete one more record....");
		pst.setString(1, "Durga");
		int updateCout1=pst.executeUpdate();
		System.out.println("The number of rows deleted:"+updateCout1);
		con.close();
	}
}
