package bean;

public class BeanTest2 {
	private String id;
	private String passwd;
	private int num;

	// ALT + SHIFT + S >> R		자동으로 set/getMethod 생성 가능


	public void setId(String id) {
		this.id = id;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public String getPasswd() {
		return passwd;
	}

	public int getNum() {
		return num;
	}
} // Class BeanTest2
