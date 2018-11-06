package javaLesson;

import java.util.Scanner;

public class LinkedListDemo {
	DObject start;
	DObject obj;
	DObject n;

	public void insert(int num) {

		switch (num) {
		case 1:
			obj = new Line();
			break;
		case 2:
			obj = new Rectangle();
			break;
		case 3:
			obj = new Circle();
			break;
		}
		if (start == null) {
			start = obj;
		} else {
			n = start;
			while (n.next != null) {
				n = n.next;
			}
			n.next = obj;
		}
	}

	public void delete(int num) {
		DObject n = start;
		DObject p = start;
		int i = 1;

		while ((n != null) && (i < num)) {
			p = n;
			n = n.next;
			i++;
		}

		if (n == null) {
			System.out.println("삭제할 위치에 도형이 없습니다.");
		} else {
			if (num == 1) {
				start = start.next;
			} else {
				p.next = n.next;
			}
		}
	}

	public void show_all() {
		n = start;
		while (n != null) {
			n.draw();
			n = n.next;
		}
	}

	public static void main(String[] args) {
		LinkedListDemo d = new LinkedListDemo();
		Scanner s = new Scanner(System.in);
		int num1, num2;

		do {
			System.out.print("삽입(1), 삭제(2), 모두보기(3), 종료(4) >>>");
			num1 = s.nextInt();

			switch (num1) {
			case 1:
				System.out.print("도형 종류 Line(1), Rect(2), Circle(3) >>>");
				num2 = s.nextInt();
				d.insert(num2);
				break;
			case 2:
				System.out.print("삭제할 도형의 위치는 ? >>>");
				num2 = s.nextInt();
				d.delete(num2);
				break;
			case 3:
				d.show_all();
				break;

			}
		} while (num1 != 4);
		s.close();
	}

}
