package com.笔试;

import java.util.HashSet;

import com.code.MainTest;
import com.各种锁.Sum;

public class minSum {
	
	static int[] arr = {5,3,7,9,2,6};
	static HashSet<Integer> temp = new HashSet<>();
	static int  min;
	static int max;
	static int count;
	static int sum = 0;
	static int index = 0;
	
	
	public static int getFirstUnFormedNum(int arr[]){
		getAllResults(arr, index, sum, temp);
		
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			min = Math.min(min, arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			max += arr[i];
		}
		for(int j=min+1;j != max;j++){
			if(!temp.contains(j)){
				return j;
			}
		}
		
		return 0;
	}
	
	public static void getAllResults(int[] arr,int index, int preSum,
			HashSet<Integer> set){
			if (arr.length == index) {
				set.add(preSum);
				return;
			}
			getAllResults(arr, index+1, preSum, set);
			getAllResults(arr, index+1, preSum+arr[index], set);
	}
	
	public static void main(String[] args) {
	
		System.out.println(getFirstUnFormedNum(arr));
	}
	
    public static void swap(int[] array,int i,int j){
        int temp =0;
        temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
