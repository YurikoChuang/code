package com.多线程;

import java.util.ArrayList;

import com.util.MathUtil;
import com.util.*;
public class FindPrimeThread implements Runnable{
	private int threadNum;
	public static  ArrayList<Integer> resultList = new ArrayList<>();	//保存素数的数组
	private static int length = 25;
	
	public FindPrimeThread (int threadNum)
	{
		this.setThreadNum(threadNum);
		System.out.println("我是线程" + threadNum);
	}

	@Override
	public void run() {
		System.out.println("run 方法");
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		int shift = 25*threadNum;
		System.out.println("偏移量 " + shift);
		//boolean flag = false;
		ArrayUtil.makeArray(arrayList, length , shift);
		for (int i = 0; i < arrayList.size(); i++) {
			int n = arrayList.get(i);	//取出数组的一个数
			if(MathUtil.isPrime(n))		//判断该数是不是素数
			{
				//flag = true;
				//System.out.println("找到素数 " + n);
				resultList.add(n);		//如果是素数输出,保存到结果的数组
			} 
		}
		System.out.println("线程" + threadNum + "结束");
	}


	public int getThreadNum() {
		return threadNum;
	}

	public void setThreadNum(int threadNum) {
		this.threadNum = threadNum;
	}


	
}
