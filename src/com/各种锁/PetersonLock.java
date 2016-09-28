package com.各种锁;

import java.util.concurrent.locks.Lock;

public class PetersonLock implements Runnable {

    private static boolean[] in = { false, false };     // 主观地表示某一个进程是否希望使用资源
    private static  int turn = 0;               // 客观地表示哪一个进程有权使用进程

    public static void main(String[] args) {

        
        new Thread(new PetersonLock(0), "我是线程 0 ").start();
        new Thread(new PetersonLock(1), "我是线程 1 ").start();
    }

    private final int id;

    //构造方法
    public PetersonLock(int i) {
        id = i;
    }

    private int other() {
        return id == 0 ? 1 : 0;
    }

    @Override
    public void run() {
    	
    	lock();
    	
        int cnt = 10;
        while(cnt-- > 0){
            System.out.println("-------------------[" + id + "] Working");
        }
        
        unlock();
    }
    
    public void lock()
    {
        in[id] = true;      // 表示本进程想使用资源
     
        while (in[other()] && turn == other()) {    // 如果对方进程想使用资源，
        	//且对方进程有使用资源的权限时，本进程等待
            System.out.println("[" + id + "] - wait...");
        }
    }
    public void unlock()
    {
        turn = other();     // 谦让，把使用进程的权限让给对方进程
        in[id] = false;     // 本进程用完资源后，必须表示不再想用资源
    }
    
 
}
