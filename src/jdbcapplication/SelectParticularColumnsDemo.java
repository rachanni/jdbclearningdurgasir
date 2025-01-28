package jdbcapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectParticularColumnsDemo {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc=new Scanner(System.in);
		String driver="oracle.jdbc.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="ravi";
		String pwd="ravi";
		Connection con=DriverManager.getConnection(jdbc_url,user,pwd);
		Statement st=con.createStatement();
		String sql_query="select ename,eaddr from employees";
		boolean flag=false;
		ResultSet rs=st.executeQuery(sql_query);
		System.out.println("ENAME\tEADDR");
		System.out.println("--------------------------------");
		while(rs.next()) {
			flag=true;
			System.out.println(rs.getString(1)+"\t"+rs.getString(2));
		}
		if(flag==false) {
			System.out.println("No matched record found");
		}
		con.close();
	}
}
