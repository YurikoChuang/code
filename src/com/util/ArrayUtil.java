package com.util;

import java.util.ArrayList;
import java.util.Random;

public class ArrayUtil {
	/**
	 * 数组 赋值 长度10000
	 * @param arrayList
	 */
//	public static void makeArray(ArrayList<Integer> arrayList)
//	{
//		Random random = new Random();
//		for (int i = 0; i < 10000; i++) {
//			arrayList.add(random.nextInt(10));
//		}
//	}
	
	/**
	 * 创建数组
	 * @param arrayList
	 * @param length	长度
	 */
	public static void makeArray(ArrayList<Integer> arrayList , int length)
	{
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			//在这里添加生成数组的方式
			
			arrayList.add(random.nextInt(100));
			System.out.print(arrayList.get(i) + " ");		
			//arrayList.add(i);
		}
		System.out.println("\n");
	}
	
	/**
	 * 创建带偏移量的数组
	 * @param arrayList
	 * @param length
	 * @param shift  偏移量
	 */
	public static void makeArray(ArrayList<Integer> arrayList , int length , int shift)
	{
		for (int i = 1; i <= length; i++) {
			//在这里添加生成数组的方式
			arrayList.add(i+shift);
		}
	}
}
