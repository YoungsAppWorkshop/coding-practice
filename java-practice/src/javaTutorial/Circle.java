package javaTutorial;

public class Circle {
	final static float PI = 3.14F; // 파이
	float radius = 0.0F; // 반지름
	float area = 0.0F;// 넓이
	float circumference = 0.0F; // 원주(원둘레)

	void setRadius(float newValue) {
		radius = newValue;
	}

	void calculateArea() {
		area = radius * radius * PI;
	}

	void calculateCircumference() {
		circumference = radius * PI * 2;
	}

	void printStates() {
		System.out.println("radius : " + radius + "  area : " + area + "  circumference : " + circumference);
	}
}
