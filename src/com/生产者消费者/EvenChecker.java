package com.生产者消费者;


public class EvenChecker implements Runnable{
	public static int IntGenerate = 0;
	
	private synchronized void use(){
		
		if(EvenGenerator.currentEvenValue == 0){
			System.out.println("没了");
			Thread.currentThread().yield();
			return;
		}
		
		System.out.println(Thread.currentThread().getName() + "消费2");
		EvenGenerator.currentEvenValue -=2;
		System.out.println("剩余  " + EvenGenerator.currentEvenValue);
		
	}
	public void run() {
		for (int i = 0; i < 100; i++) {
			this.use();
			Thread.yield();
		
		}

	}


}

