package com.编程之美;

/**
 * 求两个整数的最大公约数
 * 辗转相除法
 * @author Seki
 *
 */
public class 求最大公约数 {
	public static int gcd(int x, int y)
	{
		if(x<y)
		{
			int temp = 0;
	        temp = x;
	        x = y;
	        y = temp;
		}
		return (y == 0)?x:gcd(y, x%y);
		
	}
	
	public static void main(String[] args) {
		System.out.println(gcd(10,15));
	}
}
