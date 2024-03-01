package shape;

public class ShapeDemo {
	public static void main(String[] args) {
		Circle c1 = new Circle(3);
		Square s1 = new Square(4);
		
		System.out.printf("The area of circle is : %.3f\n", c1.calculateArea() );
		System.out.printf("The area of Square is : %.3f\n", s1.calculateArea() );
	}

}
