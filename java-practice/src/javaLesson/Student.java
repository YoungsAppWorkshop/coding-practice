package javaLesson;

public class Student {
	private Integer num;
	private String name;
	private Integer kor;
	private Integer eng;
	private Integer math;

	public Student() {
	}

	public Student(Integer num, String name, Integer kor, Integer eng, Integer math) {
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getKor() {
		return kor;
	}

	public void setKor(Integer kor) {
		this.kor = kor;
	}

	public Integer getEng() {
		return eng;
	}

	public void setEng(Integer eng) {
		this.eng = eng;
	}

	public Integer getMath() {
		return math;
	}

	public void setMath(Integer math) {
		this.math = math;
	}

	@Override
	public String toString() {
		return num + " : " + name + " : " + kor + " : " + eng + " : " + math;
	}

}
