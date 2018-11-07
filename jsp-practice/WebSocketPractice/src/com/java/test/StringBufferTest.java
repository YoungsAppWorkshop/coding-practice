package com.java.test;

public class StringBufferTest {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append("joung:online:");
		sb.append("kim:offline:");
		System.out.println(sb);
		System.out.println(sb.length());
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
	}

}
