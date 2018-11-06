package javaLesson;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedIOEx {

	public static void main(String[] args) {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedOutputStream out = new BufferedOutputStream(System.out, 5);
		try {
			int c;
			System.out.println("데이터를 입력하시오");
			while((c=in.read())!=-1) {
				out.flush();
				out.write(c);
			}
			out.flush();
		} catch (IOException e) {
			System.out.println("입출력 오류");
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
