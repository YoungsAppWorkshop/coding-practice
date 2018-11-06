package javaLesson;

class DObject {
	public DObject next;

	public DObject() {
		next = null;
	}

	public void draw() {
		System.out.println("DObject draw");
	}
}

class Line extends DObject {
	public void draw() {
		System.out.println("Line draw");
	}
}

class Rectangle extends DObject {
	public void draw() {
		System.out.println("Rectangle draw");
	}
}

class Circle extends DObject {
	public void draw() {
		System.out.println("Circle draw");
	}
}

public class LinkedListPractice {

	public static void main(String[] args) {
		DObject start, obj, n;

		start = new Line();
		n = start;

		obj = new Rectangle();
		n.next = obj;
		n = obj;

		obj = new Circle();
		n.next = obj;

		n = start;
		while (n != null) {
			n.draw();
			n = n.next;
		}

	}

}
