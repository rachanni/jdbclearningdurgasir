package storedprocedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class StoredProcedureDemo1 {

	public static void main(String[] args) throws SQLException {
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","ravi","ravi");
		CallableStatement cst=con.prepareCall("{call addProc(?,?,?)}");
		cst.setInt(1, 1);
		cst.setInt(2, 200);
		cst.registerOutParameter(3, Types.INTEGER);
		cst.execute();
		int result=cst.getInt(3);
		System.out.println("result is: "+result);
		con.close();
	}
}
