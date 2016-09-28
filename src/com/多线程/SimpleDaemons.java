package com.多线程;

import java.util.concurrent.TimeUnit;

import org.junit.rules.Timeout;
import org.omg.CORBA.PUBLIC_MEMBER;

public class SimpleDaemons implements Runnable{
	public void run()
	{
		try {
			while(true){
				Thread.sleep(100);
				System.out.println(Thread.currentThread() + " " + this);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
