package javaTutorial;

public class Test02 {

	public static void main(String[] args) {
		String[] students = new String[10];
		System.out.println(students[0]);
		String studentName = "Peter Smith";
		System.out.println(studentName);
		students[0] = studentName;
		System.out.println(students[0]);
		studentName = null;
		System.out.println(students[0]);
		System.out.println(studentName);
	}

}
