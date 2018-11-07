package com.java.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DataStructureTest {

	public static void main(String[] args) {
		Set<String> testSet = new HashSet<>();
		testSet.add("hong gil dong");
		testSet.add("kim kap hwan");
		testSet.add("Yuri");
		
		Iterator<String> iterator = testSet.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
		
		testSet.remove("kim kap hwan");
		System.out.println("** after remove **");
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	}

}
