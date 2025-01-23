package jdbcapplication;

import java.util.Scanner;

public class SqlQueryWithDynamicInputShortcut {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee Number:");
		int eno=sc.nextInt();
		System.out.println("Enter Employee Name:");
		String ename=sc.next();
		System.out.println("Enter Employee Salary:");
		double esal=sc.nextDouble();
		System.out.println("Enter Employee Address:");
		String eaddr=sc.next();
		String sqlQuery=String.format("insert into employees values(%d,'%s',%f,'%s')", eno,ename,esal,eaddr);
		System.out.println("Hello Query with Your Dynamic Input is:");
		System.out.println(sqlQuery);
	}
}
