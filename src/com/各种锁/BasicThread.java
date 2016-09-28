package com.各种锁;

import java.util.ArrayList;
import java.util.Random;

import com.各种锁.CLHLock.CLHNode;
import com.各种锁.MCSLock.MCSNode;

public class BasicThread implements Runnable{
	private static int sum;
	private ArrayList<Integer> list;
	public static CLHLock clhLock = new CLHLock();
	public static MCSLock mcsLock = new MCSLock();
	
	public static void main(String[] args) {
        new Thread(new BasicThread(), "我是线程 0 ").start();
        new Thread(new BasicThread(), "我是线程 1 ").start();

	}
	
	@Override
	public void run() {
//		CLHNode currentThreadCLHNode = new CLHNode();
//		clhLock.lock(currentThreadCLHNode);
//		for (int i = 0; i < 10; i++) {
//			System.out.println(Thread.currentThread().getName() + " work");
//		}
//		clhLock.unlock(currentThreadCLHNode);
		
    	MCSNode currentThreadMcsNode = new MCSNode();
		mcsLock.lock(currentThreadMcsNode);
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " work");
		}
		mcsLock.unlock(currentThreadMcsNode);
	}
	

}
