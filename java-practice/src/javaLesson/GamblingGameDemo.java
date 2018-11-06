package javaLesson;

import java.io.IOException;
import java.io.InputStreamReader;

class GamblingGame {
	private static final int MAX = 2;
	private static final int ENTER = 13;
	private int num1, num2, num3;

	void standBy() {
		int characterIn = 0;
		InputStreamReader rd = new InputStreamReader(System.in);

		System.out.println("엔터키를 치시오");
		try {
			while (characterIn != ENTER) {
				characterIn = rd.read();
			}
			rd.close();
		} catch (IOException e) {
			System.out.println("입력오류");
		} 
	} // standBy()

	void generateNumbers() {
		num1 = (int) (Math.random() * MAX);
		num2 = (int) (Math.random() * MAX);
		num3 = (int) (Math.random() * MAX);
	} // generateNumbers()

	void showResult() {
		System.out.println("숫자1 : " + num1);
		System.out.println("숫자2 : " + num2);
		System.out.println("숫자3 : " + num3);

		if (this.isBingo()) {
			System.out.println("빙고!!");
		} else {
			System.out.println("꽝!! 다음 기회에...");
		}

	} // showResult()

	Boolean isBingo() {
		Boolean result = false;
		if ((num1 == num2) && (num2 == num3)) {
			result = true;
		}
		return result;
	} // isBingo()

} // class GamblingGame

public class GamblingGameDemo {

	public static void main(String[] args) {

		GamblingGame newGame = new GamblingGame();

		newGame.standBy();
		newGame.generateNumbers();
		newGame.showResult();

	} // main()

} // class GamblingGameDemo
