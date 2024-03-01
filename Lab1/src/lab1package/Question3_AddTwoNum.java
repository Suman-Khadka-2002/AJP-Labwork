package lab1package;

import java.util.Scanner;

public class Question3_AddTwoNum {
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Enter 1st number: ");
			int num1 = input.nextInt();
			
			System.out.print("Enter 2nd number: ");
			int num2 = input.nextInt();
			
			int sum = add(num1, num2);
			System.out.println("Sum of " + num1 + " and "+ num2 + " = "+ sum);
		}
	}
	
	public static int add(int a, int b) {
		return a+b;
	}

}
