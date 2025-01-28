package jdbcapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectNonSelectDemo {

	public static void main(String[] args) throws SQLException {
		
		String driver="oracle.jdbc.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="ravi";
		String pwd="ravi";
		Connection con=DriverManager.getConnection(jdbc_url,user,pwd);
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the sql query:");
		String sql_query=sc.nextLine();
		boolean b=st.execute(sql_query);
		if(b==true) {
			ResultSet rs=st.getResultSet();
			while(rs.next()) {
				
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
			}
		}else {
			int rowCount=st.getUpdateCount();
			System.out.println("The number of records effected is: "+rowCount);
		}
		con.close();
	}
}
