package com.各种锁;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
public class CLHLock {

	    public static class CLHNode {
	        private boolean isLocked = true; // 默认是在等待锁
	    }

	    @SuppressWarnings("unused" )
	    private volatile CLHNode tail = null;
	    private static final AtomicReferenceFieldUpdater<CLHLock, CLHNode> UPDATER 
	    	= AtomicReferenceFieldUpdater
	                  . newUpdater(CLHLock.class, CLHNode .class , "tail" );
		
		
	    /**
	     * 上锁
	     * @param currentThreadCLHNode
	     */
	    public void lock(CLHNode currentThreadCLHNode) {

			CLHNode preNode = UPDATER.getAndSet(this, currentThreadCLHNode);
	        if(preNode != null) {//已有线程占用了锁，进入自旋
	            while(preNode.isLocked) {
	    			System.out.println(Thread.currentThread().getName() + "等待解锁");
	            }
	        }
	    }

	    /**
	     * 解锁
	     * @param currentThreadCLHNode
	     */
	    public void unlock(CLHNode currentThreadCLHNode) {
	        // 如果队列里只有当前线程，则释放对当前线程的引用（for GC）。
	        if (!UPDATER .compareAndSet(this, currentThreadCLHNode, null)) {
	            // 还有后续线程
	            currentThreadCLHNode. isLocked = false ;// 改变状态，让后续线程结束自旋
	        }
	    }
	    



}
