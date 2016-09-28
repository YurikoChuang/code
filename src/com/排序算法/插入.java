package com.排序算法;

/**
 * 插入排序
 * @author Seki
 *
 */
public class 插入 {
	/**
	 * 插入排序的基本思想是，经过i-1遍处理后,L[1..i-1]己排好序。
	 * 第i遍处理仅将L[i]插入L[1..i-1]的适当位置，使得L[1..i]又是排好序的序列
	 */
	public void insertSort(Integer array[])
	{	 
        for (int i = 1; i < array.length; i++) {
            // 保证前i+1个数排好序
            int temp = array[i];
            int j;
            for (j = i; j > 0 && array[j - 1] < temp; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
	}
}
