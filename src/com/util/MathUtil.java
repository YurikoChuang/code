package com.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.code.MainMethod;

public class MathUtil {
	public static int mapNum= -1;
	

	/**
	 * 如果该数是素数返回true
	 * @param n
	 * @return
	 */
	public static boolean isPrime(int n)
	{
		if(n == 1)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++) { 
		if (n % i == 0) 
			return false; 
		} 
		
		return true; 

	}
	
	/**
	 * 二分数组
	 * @param array
	 * @return	返回一个map
	 */
	public static void divide(ArrayList<Integer> array)
	{
		int mid = array.size()/2;
		System.out.println("mid " + mid);
		if (mid == 1)
			return ;
		ArrayList<Integer> array1 = new ArrayList<>();
		ArrayList<Integer> array2 = new ArrayList<>(); 
		for (int i = 0; i < mid; i++) {
			array1.add(array.get(i));
		}
		for (int i = mid; i < array.size(); i++) {
			array2.add(array.get(i));
		}

		
		divide(array1);
		mapNum++;
		MainMethod.map.put(mapNum, array1);
		
		divide(array2);
		mapNum++;
		MainMethod.map.put(mapNum, array2);
		
	}
	
	/**
	 * 找两数最大值
	 * @param num1
	 * @param num2
	 * @return
	 */
    public static int max(int num1,int num2){
        return num1 > num2 ? num1 :num2;
 }

}
