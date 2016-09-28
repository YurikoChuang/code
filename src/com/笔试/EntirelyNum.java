package com.笔试;
/**
 * 求1000以内的完全数
 * 所有除本身外的因子之和等于该数
 * @author Seki
 *
 */
public class EntirelyNum {
	public static void findNum()
	{
		for (int i = 6; i < 1000; i++) {
			int sum = 0;
			for (int j = 1; j < i; j++) {			
				if (i%j == 0){
					sum +=j;
				}
			}
			if (sum == i) {
				System.out.println(i);
			}
		}
	}
	
	public static void main(String[] args) {
		findNum();
	}
}
