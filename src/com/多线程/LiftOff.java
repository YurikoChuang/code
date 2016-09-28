package com.多线程;

import java.util.concurrent.TimeUnit;

public class LiftOff implements Runnable{

	protected int countDown = 10;
	private static  int  taskCount = 0;
	private final int id = taskCount++;
	private Thread t;
	public LiftOff() {
		// TODO Auto-generated constructor stub
	}
	public LiftOff(int countDown)
	{
		this.countDown = countDown;
	}
	public String status()
	{
		return "#" + id +"(" +(countDown>0?countDown:"liftoff!!") + "), ";
	}
	
	public void run(){
		try {
			while(countDown-- > 0)
			{
	
				System.out.println(status());
				Thread.yield();
				//Thread.sleep(100);
				//TimeUnit.MILLISECONDS.sleep(100);
			} 
		}catch (Exception e) {
				e.printStackTrace();
			}
	}

}

