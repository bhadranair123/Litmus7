package com.litmus7.school.dto;

import java.util.Scanner;

public class Student {
	private String name;
	private int rollNo;
	private int[] marks = new int[5];

	public enum Grades {
		A, B, C, D, E, F;
	}

	public void inputDetails() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter student Name: ");
		name = scanner.nextLine();
		System.out.println("Enter Roll number: ");
		rollNo = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter marks in 5 subjects: ");
		for (int i = 0; i < 5; i++) {
			System.out.println("Subject" + (i + 1) + ": ");
			marks[i] = scanner.nextInt();
			scanner.nextLine();
		}

	}

	private int calculateTotal(int marks[]) {
		int sum = 0;
		for (int i : marks) {
			sum += i;
		}
		return sum;
	}

	private float calculateAverage() {
		float average = (float) (calculateTotal(marks)) / 5;
		return average;
	}

	private Grades getGrade(int marks[]) {
		float avg = calculateAverage();
		if (avg >= 90)
			return Grades.A;
		else if (avg >= 75)
			return Grades.B;
		else if (avg >= 60)
			return Grades.C;
		else if (avg >= 50)
			return Grades.D;
		else
			return Grades.F;

	}

	public void gradeChart(Grades grade) {
		switch (grade) {
		case A:
			System.out.println("Excellent");
			break;
		case B:
			System.out.println("Good");
			break;
		case C:
			System.out.println("Average");
			break;
		case D:
			System.out.println("Pass");
			break;
		case F:
			System.out.println("Failed");
			break;
		}
	}

	public void printReportCard(int n) {
		System.out.println("---Report Card of student " + (n + 1) + "---");
		System.out.println("Name: " + name + "\nRoll Number: " + rollNo + "\nTotal Marks: " + calculateTotal(marks)
				+ "\nAverage Marks: " + calculateAverage() + "\nGrade: " + getGrade(marks));
		gradeChart(getGrade(marks));
	}

}
