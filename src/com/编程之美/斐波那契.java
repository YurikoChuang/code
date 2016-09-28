package com.编程之美;
/**
 * 求斐波那契数列的第n项值
 * @author Seki
 *
 */
public class 斐波那契 {
	int Fibonacci(int n)
	{
		if (n<0)
			return 0;
		else if (n == 1)
			return 1;
		else
		{
			return (Fibonacci(n-1) + Fibonacci(n-2));
		}
	}
}
