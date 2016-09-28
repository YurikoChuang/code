package com.剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 在一个长度为n的数组里所有数字都在0到n-1范围内,
 * 其中某些数字是重复的
 * 找出任意一个重复的数字
 * @author Seki
 *
 */
public class Duplicate {
	public static void Duplicate(Integer[] array)
	{
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				System.out.println(array[i]);
			}
			else {
				map.put(array[i], false);
			}
		}
	}
	
	
	public static void main(String[] args) {
		Integer[] array = {0,1,2,3,4,5,5};
		Duplicate(array);
	}
}
