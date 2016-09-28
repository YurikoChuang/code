package com.排序算法;

/**
 * 选择排序
 * @author Seki
 *
 */
public class 简单选择 {
	/**
	 * 选择排序的基本思想是：对待排序的记录序列进行n-1遍的处理，
	 * 第1遍处理是将L[1..n]中最小者与L[1]交换位置，第2遍处理是将L[2..n]中最小者与L[1]交换位置，......，
	 * 第i遍处理是将L[i..n]中最小者与L[i]交换位置。
	 * 这样，经过i遍处理之后，前i个记录的位置就已经按从小到大的顺序排列好了。
	 * @param array
	 */
	public void selectionSort(Integer[] array)
	{
		 int temp;
		 int minValueIndex;
		 for (int i = 0; i < array.length; i++) {
			temp = array[i];
			minValueIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (temp > array[j]) {
					temp = array[j];
					minValueIndex = j;
				}
			}
			swap(array, minValueIndex, i);
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
