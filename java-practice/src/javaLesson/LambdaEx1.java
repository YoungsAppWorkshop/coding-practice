package javaLesson;

interface Xyz {
	public void a();
} // close interface

public class LambdaEx1 {

	public static void main(String[] args) {
		
		// 1. 익명 클래스 이용 시
		Xyz anony = new Xyz(){
			@Override
			public void a() {
				System.out.println("익명 클래스");
			}
		}; // close anonymous class
		anony.a();
		
		// 2. 람다 표현식
		Xyz lambda =() -> System.out.println("람다표현식");
		lambda.a();
		
	} // close main method

} // close class
