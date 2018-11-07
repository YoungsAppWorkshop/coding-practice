package bean;

public class BeanTest1 {
	// 멤버변수
	// public : 모두 접근 가능(패키지 관계 없이)
	// private : 같은 클래스 내에서만 접근
	private String id;
	// 메소드(멤버함수)
	// 접근지정자 리턴할변수/void 함수이름(매개 변수) { 처리할 명령문; }
	public void setId(String sid) {
		id = sid;
	}
	public String getId() {
		return id;
	}
}
