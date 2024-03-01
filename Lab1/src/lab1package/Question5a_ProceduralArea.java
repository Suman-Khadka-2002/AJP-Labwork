package lab1package;

import java.util.Scanner;

public class Question5a_ProceduralArea {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

        System.out.print("Enter the radius of the circle: ");
        double radius = input.nextDouble();
        double circleArea = Math.PI * radius * radius;
        System.out.printf("The area of the circle is: %.3f\n", circleArea);
        System.out.println();

        System.out.print("Enter the side of the square: ");
        double side = input.nextDouble();
        double squareArea = side * side;
        System.out.printf("The area of the square is: %.3f\n", squareArea);
        System.out.println();

        System.out.print("Enter the length of the rectangle: ");
        double length = input.nextDouble();
        System.out.print("Enter the width of the rectangle: ");
        double width = input.nextDouble();
        double rectangleArea = length * width;
        System.out.printf("The area of the rectangle is: %.3f\n", rectangleArea);
        System.out.println();

        System.out.print("Enter the radius of the sphere: ");
        double sphereRadius = input.nextDouble();
        double sphereArea = 4 * Math.PI * sphereRadius * sphereRadius;
        System.out.printf("The area of the sphere is: %.3f\n", sphereArea);
        
		input.close();
	}

}
