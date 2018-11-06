package javaTutorial;

public class CircleDemo {

	public static void main(String[] args) {

		Circle circle1 = new Circle();
		System.out.println("Circle1 : ");
		circle1.setRadius(5.0F);
		circle1.calculateArea();
		circle1.calculateCircumference();
		circle1.printStates();

	}

}
