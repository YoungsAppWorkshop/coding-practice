package com.java.test;

public class StaticTest {

	public static void main(String[] args) {
		StaticClass.print();

	}

}

class StaticClass {
	private static int a = 3;
	
	static void print() {
		System.out.println("Static test");
		System.out.println("a = " + a);
	}
	
	void nonStaticPrint() {
		System.out.println("non-Static test");
		System.out.println("a = " + a);
	}
}