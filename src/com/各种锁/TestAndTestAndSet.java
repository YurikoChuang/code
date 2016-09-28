package com.各种锁;

import java.util.concurrent.atomic.AtomicBoolean;



public class TestAndTestAndSet implements Runnable{
	private static final AtomicBoolean testAndTestAndSet = new AtomicBoolean(false);
	private static boolean  currentState = false;		//当前线程锁的状态
	
    public static void main(String[] args) {

  
            new Thread(new TestAndTestAndSet(), "我是线程0  ").start();
            new Thread(new TestAndTestAndSet(), "我是线程1  ").start();
    }
    
    
	@Override
	public void run() {
		lock();
		for (int i = 0; i < 10; i++) {
			
			System.out.println(Thread.currentThread().getName() + "work");
			
		}
		unlock();
		
	}
	
	public void lock()
	{
		if (!testAndTestAndSet.get())		//如果没有线程锁定, 锁定当前线程
		{

		    testAndTestAndSet.set(true);
		    System.out.println(Thread.currentThread().getName() + "上锁");

			return;
		}
		while(testAndTestAndSet.get())
		{
			System.out.println(Thread.currentThread().getName() + "等待解锁");
		}

	}
	
	public void unlock()
	{
		System.out.println(Thread.currentThread().getName() + " 解锁");
		currentState = false;
		testAndTestAndSet.set(false);
	}
}
