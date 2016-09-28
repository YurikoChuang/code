package com.排序算法;

public class 归并 {
	
	
    /**
     * 归并排序(二路)
     * @param array
     */
    public void mergeSort(Integer[] array)
    {
    	 sortArray(array, 0, array.length - 1); 
    }
    
    /**
     * 给子数组排序
     * @param array
     * @param start		数组的头下标
     * @param end		数组的尾下标
     */
	public void sortArray(Integer[] array, int start, int end) {
		    
        if (start == end) {  	 // 单个元素不需要排序,直接返回  
            return;  
        }  
        int sortSize = end - start + 1;  
        int separate;  		//把数组按照下标separate分为两部分
        if (sortSize % 2 == 0) {  
        	separate = start + sortSize / 2 - 1;  
        } else {  
        	separate = start + sortSize / 2;  
        } 
        
        //递归  对子数组排序
        sortArray(array, start, separate);
        sortArray(array, separate + 1, end);
        
        //对已经排序的子数组进行归并
        mergeArray(array,start,separate,end);
        
   	}
	
	/**
	 * 对已经排序的子数组进行归并
	 * @param array			原数组
	 * @param start			起点
	 * @param separate		中点
	 * @param end			结束
	 */
	public void mergeArray(Integer[] array, int start, int separate, int end) {
		int totalSize = end - start + 1;  
        int size1 = separate - start + 1;  
        int size2 = end - separate;  
        //给子数组分配空间 , 归并排序需要拷贝整个数组
        int[] array1 = new int[size1];			  
        int[] array2 = new int[size2];       
        for (int i = 0; i < size1; i++) {  
            array1[i] = array[start + i];  
        }  
        for (int i = 0; i < size2; i++) {  
            array2[i] = array[separate + 1 + i];  
        }  
        
        int mergeCount = 0;  	
        int index1 = 0;  		//array1的索引
        int index2 = 0; 		//array2的索引
		
        while(mergeCount < totalSize)
        {
        	// 先检查有没有其中的一个数组已经处理完(全部拷贝到父数组)
        	// 如果处理完了, 把另一个子数组剩下的部分直接拷贝到父数组
        	if(index1 == size1)
        	{
        		for(int i = index2;i < size2; i++)
        		{
        			array[start + mergeCount] = array2[i];
        			mergeCount++;
        			index2++;
        		}
        	}
        	else if (index2 == size2) {
        		for (int i = index1; i < size1; i++) {
					array[start + mergeCount] = array1[i];
					mergeCount++;
					index1++;
				}
			}
        	
        	//归并两个子数组
        	else {
				int value1 = array1[index1];
				int value2 = array2[index2];
				
				if (value1 == value2) {
					  array[start + mergeCount] = value1;  
	                  array[start + mergeCount + 1] = value1;  
	                  mergeCount += 2;  
	                  index1++;  
	                  index2++;  
				}
        	    else if (value1 < value2) {  
        	    	array[start + mergeCount] = value1;  
        	    	mergeCount++;  
        	    	index1++;  
        	    } else if (value1 > value2) {  
        	    	array[start + mergeCount] = value2;  
        	    	mergeCount++;  
        	    	index2++;  
        	    }  
			}       	
        }
	}
}
