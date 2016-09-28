package com.排序算法;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;



public class Sort{

	public static void main(String[] args) {
		Sort sort = new Sort();
		Integer[] array_init = {9,7,4,6,3,1,2,5,8};
		堆排序 heapSort = new 堆排序();
		heapSort.heapSort(array_init);
		//array_init = sort.quickSort(array_init, 0, array_init.length-1);
		//sort.heapSort(array_init);
		//sort.mergeSort(array_init);
		for (int i = 0; i < array_init.length; i++) {
			System.out.println(array_init[i]);
		}
	}
}
