package com.litmus7.school;
import com.litmus7.school.dto.*;
import java.util.Scanner;

public class StudentApp {
	public static void main(String[] a) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("How many students do you want to enter");
		int number=scanner.nextInt();
		Student obj[] = new Student[number];
		for (int i=0;i<number;i++) {
			obj[i]=new Student();
			obj[i].InputDetails();
		}
		for (int j=0;j<number;j++)
			obj[j].PrintReportCard(j);
		scanner.close();
	}
	
}
