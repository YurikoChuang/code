package com.剑指offer;

import java.util.Map;

import org.omg.CORBA.IRObject;

/**
 * 找出数组中超过一半的数字
 * 要找的数肯定是最后一次把次数设为1的对应temp
 * @author Seki
 *
 */
public class MoreThanHalfNum {
	public static void MoreThanHalfNum(int[] array){
		
		int count = 0;	//如果下一个数和temp一样加1, 否则减1
		
		int temp = 0;	//当前可能的数, 如果count==0那么temp肯定不是要找的数, temp=array[i]
		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				temp = array[i];
				count++;
			}
			else {	
				if (array[i] != temp) {
					count--;
				}
				else {
					count++;
				}	
			}
			
			if (count == 0) {
				temp = array[i];
			}
		}
		
		
		if (count > 0) {
			System.out.println(temp);
		}
		else {
			
			System.out.println("没有");
		}
		
	}
	public static void main(String[] args) {
		int[] array = {1,2,2,2,2,3};
		MoreThanHalfNum(array);
	}
}
