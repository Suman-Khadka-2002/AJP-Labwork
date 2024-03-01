package lab1package;

import java.util.Scanner;

public class Question4_SimpleInterest {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the principal amount: ");
        double principal = input.nextDouble();

        System.out.print("Enter the rate of interest: ");
        double rate = input.nextDouble();

        System.out.print("Enter the time period (in years): ");
        double time = input.nextDouble();

        double simpleInterest = (principal * rate * time) / 100;

        System.out.println("The simple interest is: " + simpleInterest);

        input.close();
    }
	public static double simpleInterest(double a, double b, double c) {
		return ((a*b*c)/100);
		
	}
}
