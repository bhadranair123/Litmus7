package com.litmus7.school;

import com.litmus7.school.dto.Student;
import java.util.Scanner;

public class StudentApp {
	public static void main(String[] a) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many students do you want to enter");
		int number = scanner.nextInt();
		Student students[] = new Student[number];
		for (int i = 0; i < number; i++) {
			students[i] = new Student();
			students[i].inputDetails();
		}
		for (int j = 0; j < number; j++)
			students[j].printReportCard(j);
		scanner.close();
	}

}
