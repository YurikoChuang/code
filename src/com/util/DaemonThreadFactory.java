package com.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class DaemonThreadFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable r) {
		Thread thread = newThread(r);
		thread.setDaemon(true);
		return thread;
	}
	
}
