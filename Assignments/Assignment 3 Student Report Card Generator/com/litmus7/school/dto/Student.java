package com.litmus7.school.dto;

import java.util.Scanner;

public class Student {
	private String name;
	private int rollNo;
	private int[] marks = new int[5];

	enum Grade {
		A("Excellent"), B("Good"), C("Average"), D("Below Average"), F("Failed");

		private final String description;

		Grade(String description) {
			this.description = description;
		}

		public String getDescription() {
			return description;
		}
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

	private Grade getGrade(int marks[]) {
		float avg = calculateAverage();
		if (avg >= 90)
			return Grade.A;
		else if (avg >= 75)
			return Grade.B;
		else if (avg >= 60)
			return Grade.C;
		else if (avg >= 50)
			return Grade.D;
		else
			return Grade.F;

	}

	public void printReportCard(int n) {
		System.out.println("---Report Card of student " + (n + 1) + "---");
		System.out.println("Name: " + name + "\nRoll Number: " + rollNo + "\nTotal Marks: " + calculateTotal(marks)
				+ "\nAverage Marks: " + calculateAverage() + "\nGrade: " + getGrade(marks) + " ("
				+ getGrade(marks).getDescription() + ")");
	}

}
