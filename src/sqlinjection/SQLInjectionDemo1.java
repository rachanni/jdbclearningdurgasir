package sqlinjection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQLInjectionDemo1 {

	public static void main(String[] args) throws SQLException {
		
		String driver="oracle.jdbc.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="ravi";
		String pwd="ravi";
		Connection con=DriverManager.getConnection(jdbc_url,user,pwd);
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter username:");
		String uname=sc.next();
		System.out.println("Enter pwd:");
		String upwd=sc.next();
		String sql_query="select count(*) from users where uname='"+uname+"' and upwd='"+upwd+"'";
		
//		suppose user entered correct uname and upwd in this case below quey will return 1
//		otherwise 0
		ResultSet rs=st.executeQuery(sql_query);
		
//		while(rs.next()) {
//			System.out.println("ResultSet has at least one value: "+rs.getString(1));
//		}
		
		int c=0;
		if(rs.next()) {
//			if user entered correct uname and upwd then then c assigned 1
			c=rs.getInt(1);
//			System.out.println("Printing c value:"+c);
		}
		if(c==0) {
			System.out.println("Invalid credentials"+c);
		}else {
			System.out.println("Valid credentials");
		}
		con.close();

	}
}
