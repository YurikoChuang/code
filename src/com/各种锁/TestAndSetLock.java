package com.各种锁;

import java.util.concurrent.atomic.AtomicBoolean;



public class TestAndSetLock implements Runnable{
    private static volatile int turn = 0; 
	private static AtomicBoolean testAndSetLock = new AtomicBoolean(false);
    private boolean currentThreadIsLocked = false;
    public static void main(String[] args) {
        new Thread(new TestAndSetLock(), "我是线程 0 ").start();
        new Thread(new TestAndSetLock(), "我是线程 1 ").start();
    }


	@Override
	public void run() {
		lock();
		currentThreadIsLocked = true;
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " work");
		}
		unlock();
	}
    
	
	public void lock(){

		while(testAndSetLock.getAndSet(true))
		{
			System.out.println(Thread.currentThread().getName() + "等待解锁");
			isLocked();
		}
		return;
		
	}
    
	public void unlock(){
		testAndSetLock.set(false);
		
	}
    
    public void isLocked()
    {
    	Thread currentThread = Thread.currentThread();
    	boolean flag = testAndSetLock.get();
    	if (currentThreadIsLocked == false) {
			System.out.println(currentThread.getName() + " 持有锁但没有锁");
		}
    		
    }
}
