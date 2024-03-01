package shape;

interface Calculation{
	double calculateArea();
}

public class Circle implements Calculation {
	private double radius;
	
	public Circle (double radius) {
		this.radius = radius;
	}
	public double calculateArea() {
		return Math.PI * radius * radius;
	}
}
 
class Square implements Calculation {
	private double length;
	
	public Square(double length) {
		this.length = length;
	}
	public double calculateArea() {
		return length*length;
	}
}
