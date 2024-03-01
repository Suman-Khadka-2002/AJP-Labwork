package lab1package;

class Rectangle {
	private int length, breadth;
	public void setData (int x, int y) {
		length = x;
		breadth = y;
	}
	public int findArea() {
		return length*breadth;
	}
	public int findPerimeter() {
		return 2*(length + breadth);
	}
}

public class Question2_AreaPerimeterRect {

	public static void main(String[] args) {
		Rectangle rect = new Rectangle();
		rect.setData(4, 5);
		int area = rect.findArea();
		System.out.println("Area of Rectangle: "+ area);
		
		int perimeter = rect.findPerimeter();
		System.out.println("Perimeter of Rectangle: "+ perimeter);
	}

}
