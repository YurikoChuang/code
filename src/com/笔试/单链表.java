package com.笔试;

import java.text.BreakIterator;

import junit.framework.Test;

import com.笔试.DoubleLink.DNode;
/**
 * 单链表
 * @author Seki
 *
 * @param <T>
 */
public class 单链表<T> {
	//初始化链表	 
	public 单链表() {
		 mHead = new ONode(null,null);
		 mHead.nextNode = mHead;
		 mCount = 0;
	}

	 public ONode  mHead; // 头节点
	 private int mCount; // 链表的实体（即节点的数量）
	 private int modCount; // 链表被操作的次数（备用）
	 
	 public class ONode{
		public ONode nextNode;
		public T value;
		public ONode(ONode nextNode, T value) {
			this.nextNode = nextNode;
			this.value = value;
		}
		public ONode(){
			
		}
	 }

    // 返回节点数目
    public int size() {
    	return mCount;
    }
    // 返回链表是否为空
 	public boolean isEmpty() {
 		return mCount==0;
 	}
 	
 	// 获取第index位置的节点
 	public ONode getNode(int index){
 		if(index < 0 || index > mCount){
 			throw new IndexOutOfBoundsException();
 		}
 
 	
 
 		ONode node = mHead.nextNode;
 		for (int i = 0; i < index; i++) {
 				node = node.nextNode;
 		}
 		return node;

 	}
 	
	// 获取第index位置的节点的值
	public T get(int index) {
		return getNode(index).value;
    }
	
	// 获取第1个节点的值
	public T getFirst() {
		return getNode(0).value;
	}
	// 获取最后一个节点的值
	public T getLast() {
		return getNode(mCount-1).value;
	}
    
	// 将节点插入到第index位置之前
	public void insert(int index, T value) {
		if(index == 0){
			ONode node = new ONode(mHead.nextNode, value);
			mHead.nextNode = node;
			mCount++;
			return;
		}
		
		ONode pnode = getNode(index-1);
		ONode inode = getNode(index);
		ONode tnode = new ONode(inode, value);
		pnode.nextNode = tnode;
		mCount++;
		return;
		
	}
	
    // 将节点插入第一个节点处。
     public void insertFirst(T t) {
         insert(0, t);
     }

	
	
	
	
    // 将节点追加到链表的末尾
    public void appendLast(T value) {
    	ONode node = new ONode(mHead,value);
    	if (mCount == 0) {
			mHead.nextNode = node;
			mCount++;
			return;
		} 	
        ONode lnode = getNode(mCount-1);
        lnode.nextNode = node;
        mCount++;
    }
    
    // 删除index位置的节点
    public void del(int index) {
        ONode inode = getNode(index);
        ONode pnode = getNode(index-1);
        pnode.nextNode = inode.nextNode;
        inode = null;
        mCount--;
    }
    
    // 删除第一个节点
	public void deleteFirst() {
		del(0);
    }
 
    // 删除最后一个节点
    public void deleteLast() {
    	del(mCount-1);
    }
    
    public void turn(){
    	ONode pnextNode = new ONode();
    	ONode pNode = new ONode();
    	ONode pprevNode = new ONode();
    	pNode = this.getNode(1);
    	pnextNode = pNode.nextNode;
    	
    	pprevNode = this.getNode(0);
    	pNode.nextNode = pprevNode;
    	pprevNode = pNode;
    	pNode = pnextNode;
    	pnextNode = pnextNode.nextNode;
    	pNode.nextNode = pprevNode;
    	
    	System.out.println(pNode.value);
    	System.out.println(pNode.nextNode.value);
    	System.out.println(pNode.nextNode.nextNode.value);
 
    }
    
    public static void main(String[] args) {
		单链表<Integer> link = new 单链表<>();
		link.appendLast(0);
		link.appendLast(1);
		link.appendLast(2);
		link.turn();
		
		//System.out.println(link.size());
	}
    


}
