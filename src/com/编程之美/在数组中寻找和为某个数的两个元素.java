package com.编程之美;

import org.omg.CORBA.portable.ValueBase;

import com.排序算法.Sort;

/**
 * 在数组中寻找和为某个数的两个元素
 * @author Seki
 *
 */
public class 在数组中寻找和为某个数的两个元素 {
	public static String findSum(Integer[] array, int sum)
	{
		quickSort(array, 0, array.length-1);	//排序
		
		for (int i = 0; i < array.length; i++) {
			int temp = array[i];
			int value = sum - temp;
			for (int j = array.length - 1; j >= 0; j--) {
				{
					if(array[j] == value)
					{
						String resultString = "找到" + temp + " " +  value;
						return resultString;
					}
					else if(array[j] > value){
						continue;
					}
					else {
						break;
					}
				}
			}
		}
		return "未找到";
	}
	
	/**
	 * 快排
	 * @param numbers
	 * @param start
	 * @param end
	 * @return
	 */
	public static Integer[] quickSort(Integer[] numbers, int start, int end) 
	{
		if (start < end)
	    {   
	        int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）   
	        int temp; // 记录临时中间值   
	        int i = start, j = end;   
	        do {   
	            while ((numbers[i] < base) && (i < end))   
	                i++;   
	            while ((numbers[j] > base) && (j > start))   
	                j--;   
	            if (i <= j) 
	            {   
	                temp = numbers[i];   
	                numbers[i] = numbers[j];   
	                numbers[j] = temp;   
	                i++;   
	                j--;   
	            }   
	        }   
	        while (i <= j); 		//i、j碰头一次， 完成一趟快排
	        if (start < j)   
	            quickSort(numbers, start, j);   
	        if (end > i)   
	            quickSort(numbers, i, end);   
    	}
		return numbers;
	}

	public static void main(String[] args) {
		Integer[] array = {5,6,1,6,7,9,8};
		System.out.println(findSum(array, 10));
	}
}
