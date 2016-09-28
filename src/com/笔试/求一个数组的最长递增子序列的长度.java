package com.笔试;

import java.util.HashMap;
import java.util.Map;

/**
 * 求一个数组的最长递增子序列的长度
 * 动态规划
 * @author Seki
 *
 */
public class 求一个数组的最长递增子序列的长度 {
	public static void longestAscend(int[] array)
	{
		int length = array.length;
		int[] List = new int[length];	//List[i] 以array[i]为末元素的最长递增子序列的长度
		List[0] = 1;	//以第a0为末元素的最长递增子序列长度为1
		
		for (int i = 1; i < array.length; i++) {
			List[i] = 1;	//List[i]的最小值为1
			
			for (int j = 0 ;j < i;j++) {	
				//状态转移方程
				//List[i] = max{1,List[j]+1},其中 j<i,array[j]<array[i]
				if (array[j] < array[i] && List[j] > List[i]-1) {
					List[i] = List[j] + 1;//更新List[i]的值。
			
				}
				else {
					continue;
				}
			}
		}
		
		System.out.println(List[length -1]);

		
		int max = List[List.length - 1];
		

		
		for (int i = 0; i < List.length; i++) {
			if (List[List.length-1] == 1) {
				System.out.println(array[array.length-1]);
			}
			if (i<List.length - 1 && List[i] != List[i+1] ) {
				System.out.println(array[i]);
			}
			else if (i == List.length - 1) {
				if (List[i] != List[i-1]) {
					System.out.println(array[i]);
				}
			} 

			
		}
	}
	
	public static void main(String[] args) {
		int[] array = {5,3,4,8,6,7};	//3,4,6,7
		longestAscend(array);
	}
}
