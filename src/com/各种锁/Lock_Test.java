package com.各种锁;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lock_Test implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lock_Test printLetters = new Lock_Test();
		Thread thread1 = new Thread(printLetters);
		Thread thread2 = new Thread(printLetters);
		thread1.setName("线程一");
		thread2.setName("线程二");

		thread1.start();
		thread2.start();

	}

	private char c = 'a';
	
	private final Lock lock = new ReentrantLock();
	/**
	 * @return
	 */
	public synchronized boolean print() {
		//synchronized (this){
		lock.lock();
			if (c <= 'z') {
				System.out.println(Thread.currentThread().getName() + ": " + c);
				try {
					Thread.currentThread().sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				c++;
				//lock.unlock();
				return true;
			}
			return false;
			
		}
	//}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		boolean flag = print();
		while (flag) {
			flag = print();
		}
	}

}
