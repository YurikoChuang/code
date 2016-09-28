package com.编程之美;
/**
 * 求子序列之和的最大值
 * @author Seki
 *
 */
public class 求数组子序列之和的最大值 {
	public static int maxSum(Integer[] array)
	{
		int maxSum = 0;  //最大和
		int sum = 0;		//前i个数的和

		for (int i = 0; i < array.length; i++) {
			if (sum <= 0) {
				sum = array[i];		//如果前i个数的和<0 那么maxsum序列不包含第0到i-1的数
			}else {
				sum += array[i];	
			}
			
			if (sum > maxSum) {
				maxSum = sum;
			}
		}
		return maxSum;
	}
	
	public static void main(String[] args) {
		Integer[] array = {-2,11,-4,13,-5,2,-5,-3,12,-9};
		System.out.println(maxSum(array));
	}
}
