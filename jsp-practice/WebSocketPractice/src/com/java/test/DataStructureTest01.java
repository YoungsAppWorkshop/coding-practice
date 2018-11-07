package com.java.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DataStructureTest01 {
	static HashMap<Integer, Set<Data>> map = new HashMap<>();

	public static void main(String[] args) {

		Data data1 = new Data(0, "yong");
		Data data2 = new Data(0, "kim");
		Data data3 = new Data(0, "hong");
		Data data4 = new Data(1, "park");
		Data data5 = new Data(1, "tim");
		
		// map에 데이터 입력 전에 key로
		System.out.println(map.get(1));

		System.out.println("before adding Data");
		printMap();
		System.out.println();
		
		System.out.println("after adding data1");
		addData(data1);
		printMap();
		System.out.println();
		
		System.out.println("after adding data2");
		addData(data2);
		printMap();
		System.out.println();
		
		System.out.println("after adding data3");
		addData(data3);
		printMap();
		System.out.println();
		
		System.out.println("after adding data4");
		addData(data4);
		printMap();
		System.out.println();
		
		System.out.println("after adding data5");
		addData(data5);
		printMap();
		System.out.println();
		
		System.out.println("after removing data3");
		removeData(data3);
		printMap();
		System.out.println();
		
		System.out.println("after removing data4");
		removeData(data4);
		printMap();
		System.out.println();
		
		System.out.println("after removing data5");
		removeData(data5);
		printMap();
		System.out.println();
		
		System.out.println(map.get(1));
	} // close main

	static void addData(Data data) {
		if (map.get(data.getP_num()) == null) {
			Set<Data> newSet = new HashSet<>();
			newSet.add(data);
			map.put(data.getP_num(), newSet);
		} else {
			Set<Data> aSet = map.get(data.getP_num());
			aSet.add(data);
		} // close if-else
		
	} // close method
	
	static void removeData(Data data) {
		Set<Data> aSet = map.get(data.getP_num());
		if (aSet != null) {			
			aSet.remove(data);

		} // close if
		
		if(aSet.isEmpty()) {
			map.remove(data.getP_num());
		} // close if
		
	} // close method
	
	static void printMap() {
		Set<Integer> keys = map.keySet();
		for (Integer key : keys) {
			Set<Data> aSet = map.get(key);
			Iterator<Data> iterator = aSet.iterator();
			System.out.println("Size of the Set (p_num : " + key + " ) = " + aSet.size());
			while (iterator.hasNext()) {
				Data data = (Data) iterator.next();
				System.out.println(data.getP_num() + " : " + data.getM_id());
			} // close while
			
		} // close for-each
	} // close method

} // close class

class Data {
	int p_num;
	String m_id;

	public Data(int p_num, String m_id) {
		super();
		this.p_num = p_num;
		this.m_id = m_id;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

}