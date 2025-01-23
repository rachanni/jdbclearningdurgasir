package jdbcapplication;

import java.util.Scanner;

public class SqlQueryWithDynamicInput {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee number:");
		int eno=sc.nextInt();
		System.out.println("Enter Employee Name:");
		String ename=sc.next();
		System.out.println("Enter Employee Salary:");
		double esal=sc.nextDouble();
		System.out.println("Enter Employee Address");
		String eaddr=sc.next();
		String sqlQuery="insert into employees values("+eno+",'"+ename+"',"+esal+",'"+eaddr+"')";
		System.out.println(sqlQuery);
	}
}
