package com.剑指offer;


import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;


/**
 * 第一个只出现一次的字符
 * @author Seki
 *
 */
public class FirstNotRepeatingChar {
	public static void findChar(String myString){
		//有序的哈希表  entrySet遍历有序
		Map<Character, Integer> cMap = new LinkedHashMap<Character, Integer>();
		
		
		for (int i = 0; i < myString.length(); i++) {
			char temp = myString.charAt(i);
			if (!cMap.containsKey(temp)) {
				cMap.put(temp, 1);
			}
			else {
				Integer time = cMap.get(temp);
				time++;
				cMap.put(temp, time);
			}
		}
		//ArrayList<Integer> arrayList = (ArrayList<Integer>)cMap.values();
		//遍历hashmap
		Iterator<Entry<Character, Integer>> iterator = cMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Character,Integer> entry = (Map.Entry<Character, Integer>) iterator.next();

			if (entry.getValue() == 1) {
				System.out.println(entry.getKey());
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		String myString = "google";
		findChar(myString);
	}
}
