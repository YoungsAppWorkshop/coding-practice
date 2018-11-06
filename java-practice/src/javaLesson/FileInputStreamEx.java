package javaLesson;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamEx {

	public static void main(String[] args) {
		FileInputStream in = null;
		try {
			in = new FileInputStream("c:\\windows\\system.ini");
			int c;
			while((c=in.read())!= -1){
				System.out.print((char)c);
			}
		} catch (IOException e) {
			System.out.println("입출력 오류");
		}

	}

}
