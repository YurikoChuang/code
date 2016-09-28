package com.笔试;


/**
 *	奇数位上都是奇数或者偶数位上都是偶数
 *	输入：数组arr，长度大于2
 *	将arr调整成奇数位上都是奇数或者偶数位上都是偶数
 */
public class ArraySort {
	
	public static void oddInOddEvenInEven(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i%2 == 0) {		//偶数下标
				if(arr[i] % 2 != 0 )		//如果偶数下标是基数值，和后一个值交换
				{							
					swap(arr, i, i+1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[]  arr = {1,7,3,4,5,6};
		oddInOddEvenInEven(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		
		
	}
	
	/**
	 * 按照下标交换数组的两个元素
	 * @param array
	 * @param i
	 * @param j
	 */
    public static void swap(int[] array,int i,int j){
        int temp =0;
        temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
