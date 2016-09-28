package com.剑指offer;



/**
 * 求一个二进制数中1的个数
 * @author Seki
 *
 */
public class NumberOf1 {
	public static int numberOf1(int n)
	{
		int count = 0;
		while(n != 0){
			++count;
			n = (n-1) & n;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(numberOf1(10));
	}
}
