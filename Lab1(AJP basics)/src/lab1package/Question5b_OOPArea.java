//package lab1package;
//
//abstract class Shape {
//    public abstract double calculateArea();
//}
//
// class Circle extends Shape {
//    private double radius;
//
//    public Circle(double radius) {
//        this.radius = radius;
//    }
//
//    public double calculateArea() {
//        return Math.PI * radius * radius;
//    }
//}
//
//class Square extends Shape {
//    private double side;
//
//    public Square(double side) {
//        this.side = side;
//    }
//
//    public double calculateArea() {
//        return side * side;
//    }
//}
//
//class Rect extends Shape {
//    private double length;
//    private double width;
//
//    public Rect(double length, double width) {
//        this.length = length;
//        this.width = width;
//    }
//
//    public double calculateArea() {
//        return length * width;
//    }
//}
//
//class Sphere extends Shape {
//    private double radius;
//
//    public Sphere(double radius) {
//        this.radius = radius;
//    }
//
//    public double calculateArea() {
//        return 4 * Math.PI * radius * radius;
//    }
//}
//
//public class Question5b_OOPArea {
//
//	public static void main(String[] args) {
//		Circle circle = new Circle(5);
//        System.out.printf("The area of the circle is: %.3f\n", circle.calculateArea());
//
//        Square square = new Square(5);
//        System.out.printf("The area of the square is: %.3f\n", square.calculateArea());
//
//        Rect rectangle = new Rect(5, 10);
//        System.out.printf("The area of the rectangle is: %.3f\n", rectangle.calculateArea());
//
//        Sphere sphere = new Sphere(5);
//        System.out.printf("The area of the sphere is: %.3f\n", sphere.calculateArea());
//	}
//
//}
