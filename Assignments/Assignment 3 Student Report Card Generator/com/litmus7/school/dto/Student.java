package com.litmus7.school.dto;
import java.util.Scanner;

public class Student {
	String name;
	int rollno;
	int[] marks=new int[5];
	
	public void InputDetails(){
		Scanner input= new Scanner(System.in);
		System.out.println("Enter student Name: ");
		name=input.nextLine();
		System.out.println("Enter Roll number: ");
		rollno=input.nextInt();
		input.nextLine();
		System.out.println("Enter marks in 5 subjects: ");
		for(int i=0;i<5;i++) {
			System.out.println("Subject"+(i+1)+": ");
			marks[i]=input.nextInt();
			input.nextLine();
		}
		
	}
	
	
	public int CalculateTotal(int marks[]){
		int sum=0;
		for (int i=0;i<5;i++) {
			sum+=marks[i];
		}
		return sum;
	}
	
	
	public float CalculateAverage(){
		float average=(float)(CalculateTotal(marks))/5;
		return average;
	}
	
	
	public char GetGrade(int marks[]) {
		float avg=CalculateAverage();
		if (avg >= 90 )
			return 'A';
		else if (avg>=75)
			return 'B';
		else if (avg>=60)
			return 'C';
		else if (avg>=50)
			return 'D';
		else
			return 'F';	
	}
	
	public void PrintReportCard(int n) {
		System.out.println("---Report Card of student "+(n+1)+"---");
		System.out.println("Name: "+name+"\nRoll Number: "+rollno+"\nTotal Marks: "+CalculateTotal(marks)+"\nAverage Marks: "+CalculateAverage()+"\nGrade: "+GetGrade(marks));
		
	}
	
}

