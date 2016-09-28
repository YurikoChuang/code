package com.排序算法;

public class 快排 {
	/**
	 * 快速排序   
	 * 从数列中挑出一个元素，称为“基准”
	 * 重新排序数列，所有元素比基准值小的摆放在基准前面，
	 * 所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
	 * 在这个分割之后, 该基准是它的最后位置。这个称为分割（partition）操作。  
	 * 递归地把小于基准值元素的子数列和大于基准值元素的子数列排序。  
	 * @param numbers	待排序数组
	 * @param start		起始下标
	 * @param end		末尾下标
	 * @return
	 */
	public static Integer[] quickSort(Integer[] numbers, int start, int end) 
	{   
		if (start < end)
	    {   
	        int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）   
	        int temp; 					// 记录临时中间值   
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
}
