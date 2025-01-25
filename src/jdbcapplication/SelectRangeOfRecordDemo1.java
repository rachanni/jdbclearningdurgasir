package jdbcapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectRangeOfRecordDemo1 {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc=new Scanner(System.in);
		String driver="oracle.jdbc.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="ravi";
		String pwd="ravi";
		Connection con=DriverManager.getConnection(jdbc_url,user,pwd);
		Statement st=con.createStatement();
		System.out.println("Enter city name:");
		String addr=sc.next();
		String sql_query=String.format("select * from employees where eaddr='%s'", addr);
		ResultSet rs=st.executeQuery(sql_query);
		boolean flag=false;
		while(rs.next()) {
			flag=true;
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
		}
		if(flag==false) {
			System.out.println("No matched record found");
		}
		con.close();
	}
}
