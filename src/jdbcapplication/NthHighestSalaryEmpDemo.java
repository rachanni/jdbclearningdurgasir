package jdbcapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class NthHighestSalaryEmpDemo {

	public static void main(String[] args) throws SQLException {
		
		String driver="oracle.jdbc.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="ravi";
		String pwd="ravi";
		Connection con=DriverManager.getConnection(jdbc_url,user,pwd);
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number");
		int n=sc.nextInt();
		String sql_query="select * from(select eno,ename,esal,eaddr,rank() over(order by esal DESC)ranking from employees) where ranking="+n;
		ResultSet rs=st.executeQuery(sql_query);
		System.out.println("ENO\tENAME\tESALARY\tEADDR");
		System.out.println("--------------------------------");
		while(rs.next()) {
			
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
		}
		
		con.close();
	}
}
