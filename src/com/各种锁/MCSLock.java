package com.各种锁;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class MCSLock {
	
    public static class MCSNode {
        MCSNode next;
        boolean isLocked = true; // 默认是在等待锁
    }  
    
    private volatile MCSNode queue = null ;// 指向最后一个申请锁的MCSNode
    
    private static final AtomicReferenceFieldUpdater<MCSLock, MCSNode> UPDATER 
    = AtomicReferenceFieldUpdater
                  . newUpdater(MCSLock.class, MCSNode. class, "queue" );


    


    
    public void lock(MCSNode currentThreadMcsNode) {
        MCSNode predecessor = UPDATER.getAndSet(this, currentThreadMcsNode);// step 1
        if (predecessor != null) {
            predecessor.next = currentThreadMcsNode;// step 2
            System.out.println(predecessor.next);
            while (currentThreadMcsNode.isLocked ) {// step 3
            	System.out.println(Thread.currentThread().getName() + " 等待解锁");
            }
        }
    }

    public void unlock(MCSNode currentThreadMcsNode) {
        if ( UPDATER.get( this ) == currentThreadMcsNode) {// 锁拥有者进行释放锁才有意义
            if (currentThreadMcsNode.next == null) {// 检查是否有人排在自己后面
                if (!UPDATER.compareAndSet(this, currentThreadMcsNode, null)) {// step 4
                    // compareAndSet返回true表示确实没有人排在自己后面
                	System.out.println("没人在我后面");
                    return;
                } else {
                    // 突然有人排在自己后面了，可能还不知道是谁，下面是等待后续者
                    // 这里之所以要忙等是因为：step 1执行完后，step 2可能还没执行完
                    while (currentThreadMcsNode.next == null) { // step 5
                    }
                }
            }

            currentThreadMcsNode.next.isLocked = false;
            //currentThreadMcsNode.next = null;// for GC
        }
    }
}
