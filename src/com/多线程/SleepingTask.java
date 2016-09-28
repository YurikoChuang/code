package com.多线程;

import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff{
	public void run()
	{
		try{
			while(countDown-- > 0)
			{
				System.out.println(status());
				Thread.sleep(1000);
				TimeUnit.MICROSECONDS.sleep(1000);
			}
			
		}catch(InterruptedException e){
			System.out.println(e);
		}
	}
}
