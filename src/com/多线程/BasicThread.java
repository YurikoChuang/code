package com.多线程;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicThread implements Runnable{
	private static int sum;
	private ArrayList<Integer> list;
	
	public BasicThread(ArrayList<Integer> list) {
		System.out.println("构造方法");
		this.setList(list);
	}
	@Override
	public void run() {
		System.out.println(list.size());
		for (int i = 0; i < 10; i++)
		{
			sum = sum + list.get(i);
		}
		System.out.println("sum in this  thread is " + sum);
		System.out.println("run 方法执行完了");
		
	}
	
	
	

	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}

	public ArrayList<Integer> getList() {
		return list;
	}
	public void setList(ArrayList<Integer> list) {
		this.list = list;
	}
	
	public static void main(String[] args) {
		System.out.println("start");
		ArrayList<Integer> list  = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		System.out.println(list.size());
		BasicThread basicThread = new BasicThread(list);
		Thread thread = new Thread(basicThread);
		thread.start();
		
	}
}
