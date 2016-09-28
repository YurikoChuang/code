package com.排序算法;

public class 冒泡 {
	
	/**
	 * 	 所谓一遍处理，就是自底向上检查一遍这个序列，并时刻注意两个相邻的元素的顺序是否正确。
	 *	如果发现两个相邻元素的顺序不对，即“轻”的元素在下面，就交换它们的位置。
	 *	显然，处理一遍之后，“最轻”的元素就浮到了最高位置；处理二遍之后，“次轻”的元素就浮到了次高位置。
	 *	在作第二遍处理时，由于最高位置上的元素已是“最轻”元素，所以不必检查。
	 *	一般地，第i遍处理时，不必检查第i高位置以上的元素，因为经过前面i-1遍的处理，它们已正确地排好序。
	 */
	public void bubbleSort(Integer[] array)
	{
		
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if(array[i] > array[j])
				{
					swap(array, i, j);
				}
			}
		}
	}
	
	/**
	 * 按照下标交换数组的两个元素
	 * @param array
	 * @param i
	 * @param j
	 */
    public static void swap(Integer[] array,int i,int j){
        int temp =0;
        temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
