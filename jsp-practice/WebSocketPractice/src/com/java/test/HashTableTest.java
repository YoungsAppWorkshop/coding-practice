package com.java.test;

import java.util.Hashtable;
import java.util.Set;

public class HashTableTest {

	public static void main(String[] args) {
		Hashtable<String, String> map = new Hashtable<>();
		map.put("name", "hong gil dong");
		map.put("age", "20");
		map.put("address", "seoul");
		
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(key + " : " + map.get(key));
			
		}
		
		System.out.println("phone 입력 전 ");
		if(map.get("age") == null) {
			map.put("phone", "010-1234-5678");
		}
		
		keys = map.keySet();
		for (String key : keys) {
			System.out.println(key + " : " + map.get(key));
			
		}
	}

}
