package jdbcapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAllRowsSortingDemo {

	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		
		String driver="oracle.jdbc.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="ravi";
		String pwd="ravi";
		Connection con=DriverManager.getConnection(jdbc_url,user,pwd);
		Statement st=con.createStatement();
		boolean flag=false;
		String sql_query="select * from employees order by esal DESC";
		ResultSet rs=st.executeQuery(sql_query);
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("---------------------------");
		while(rs.next()) {
			flag=true;
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
		}
		if(flag==false) {
			System.out.println("NO matched record found");
		}
	}
}
