package com.java.test;

import java.util.HashMap;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		
		HashMap<String, String> map = new HashMap<>();
		map.put("name", "hong gil dong");
		map.put("age", "20");
		map.put("address", "seoul");
		
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(key + " : " + map.get(key));
		} // close for-each
		
		System.out.println("after modifying data");
		map.put("age", "30");
		for (String key : keys) {
			System.out.println(key + " : " + map.get(key));
		} // close for-each
		
		System.out.println("after removing data");
		map.remove("age");
		for (String key : keys) {
			System.out.println(key);
		} // close for-each
		
	} // close main

} // close class
