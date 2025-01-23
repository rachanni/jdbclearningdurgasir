package jdbcapplication;

import java.util.Scanner;

public class DynamicInputDemo {

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
		System.out.println("Hello Your Provided Information is:");
		System.out.println(eno+"\t"+ename+"\t"+esal+"\t"+eaddr);
	}
}
