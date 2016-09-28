package com.生产者消费者;

public class EvenGenerator implements Runnable{
	public static int currentEvenValue= 0;
	public static int i = 0;
	
	private synchronized void next(){
		this.currentEvenValue += 2;
		System.out.println(Thread.currentThread().getName() + " 当前资源" + currentEvenValue);
		Thread.yield();
		
	}
	


	@Override
	public void run() {
		//System.out.println(Thread.currentThread().getName());
		
		while(i<10){
			this.next();
			
			i++;
		}
	}
}
