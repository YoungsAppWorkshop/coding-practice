package javaLesson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaEx2 {
	
	static List<Student> studentsList = new ArrayList<>();
	
	static {
		studentsList.add(new Student(3, "Kim", 70, 70, 70));
		studentsList.add(new Student(1, "Lee", 80, 80, 80));
		studentsList.add(new Student(4, "In", 100, 100, 100));
		studentsList.add(new Student(2, "Yang", 90, 90, 90));
		System.out.println("정렬전 : " + studentsList);
	} // close static block

	public static void main(String[] args) {
		
		// 1. 익명 클래스 이용 시
//		Collections.sort(studentsList, new Comparator<Student>() {
//			@Override
//			public int compare(Student o1, Student o2) {
//				return o1.getNum()-o2.getNum();
//			} // close method
//		}); // close anonymous class
		
		// 2. 람다 표현식
		Collections.sort(studentsList, (Student o1, Student o2) -> o1.getNum()-o2.getNum());
		
		System.out.println("정렬 후 : " + studentsList);
		
	} // close main

} // close class
