package com.排序算法;

import junit.framework.Test;

/**
 * 堆排序 
 * 二叉堆是一个完全二叉树
 * @author Seki
 *
 */
public class 堆排序{
	/**
	 *  arrays[i]>=arrays[2*i+1] && arrays[i]>=arrays[2*i+2]; 
	 *  最小堆类似，只要改为冒最小值即可。
	 *	刚找到最大值后把最大值放在数组的最后面arrays[n],
	 *	然后进入递归把arrays[0...n-1]，只是把排好序的最大值不放入到这个过程中，
	 *  就这样把值一个个的冒出来。
	 * @param array
	 */
	public void heapSort(Integer[] array)
	{
		buildHeap(array);			//建堆	
		int length = array.length;	//数组长度
		int i = 0;
		for (i = length-1; i >= 1; i--) {
			swap(array, 0, i);		//把根顶的元素(最大)放到数组的末尾
			//heapify(array, 0, i);
			smallHeapify(array, 0, i);
		}
	}
	
	/**
	 * 创建堆  第一趟堆化
	 * 第一次将数组排成堆的形式, 会找到数组的最大值(大根堆)
	 * @param array
	 */
	public void buildHeap(Integer[] array) {
		int length = array.length;
		//堆是一个完全二叉树， 一个完全二叉树的非叶子节点
		//有length/2 - 1  个
		//堆化每一个非叶子节点
		for (int i = length/2 - 1; i >= 0; i--) {		
			//heapify(array,i,length);					
			smallHeapify(array, i, length);
			for (int j = 0; j < array.length; j++) {
				System.out.println(array[j]);
			}
			System.out.println("循环一次");
		}
		System.out.println("结束");
	}
	
	/**
	 * 堆化(大根堆)
	 * 每堆化一次,调整一个非叶子节点
	 * 找根左右孩子的最大值，和根交换
	 * @param array
	 * @param index		根节点
	 * @param max		下标最大值, 即length
	 */
	public void heapify(Integer[] array, int index, int max) {
		int left = 2*index + 1;		//左孩子下标
		int right = 2*index + 2;	//右孩子下标
		int largest = 0;			//寻找3个节点中最大值节点的下标
		if(left<max && array[left]>array[index])
		{
			largest = left;
		}
		else 
			largest = index;
	    if(right<max && array[right]>array[largest])
	    	largest = right;
	    if(largest!=index){				//如果largest不是当前index, 交换并堆化largest为根的子数
            swap(array,largest,index);
            heapify(array,largest,max);            
        }   
	}
	
	/**
	 * 堆化 (小根堆)
	 * @param arrayIntegers
	 * @param index			根节点
	 * @param max			下标最大值, 即length
	 */
	public void smallHeapify(Integer[] array , int index , int max){
		int left = 2*index + 1;		//左孩子下标
		int right = 2*index + 2;	//右孩子下标
		int smallest = 0;			//寻找3个节点中最小值节点的下标
		if(left < max && array[left] < array[index])
		{
			smallest = left;
		}
		else 
			smallest = index;
		if(right < max && array[right] < array[smallest]){
			smallest = right;
		}
		if(smallest != index){
			swap(array, smallest, index);
			smallHeapify(array, smallest, max);
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

    public static void main(String[] args) {
		Integer[] array = {5,3,6,7,2,4};
		堆排序 heapSort = new 堆排序();
		heapSort.heapSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
