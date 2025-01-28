package jdbcapplication;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAllRowsToHtmlDemo {

	public static void main(String[] args) throws SQLException, IOException {
		
		String driver="oracle.jdbc.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="ravi";
		String pwd="ravi";
		Connection con=DriverManager.getConnection(jdbc_url,user,pwd);
		Statement st=con.createStatement();
		String sql_query="select * from employees";
		ResultSet rs=st.executeQuery(sql_query);
		String data="";
		data=data+"<html><body bgcolor='green' text='white'><centre><table border='2'>";
		data = data+"<tr><td>ENO</td><td>ENAME</td><td>ESAL</td><td>EADDR</td></tr>";
		while(rs.next()) {
			data=data+"<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getDouble(3)+"</td><td>"+rs.getString(4)+"</td></tr>";
		}
		data=data+"</table></cenre></body></html>";
		FileOutputStream fos=new FileOutputStream("emp.html");
		byte[]b=data.getBytes();
		fos.write(b);
		fos.flush();
		System.out.println("open emp.html to get Employees data");
		fos.close();
		con.close();
	}
}
