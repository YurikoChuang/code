package com.笔试;

import com.code.MainTest;

/**
 * 双向链表
 * @author Seki
 *
 * @param <T>
 */
public class DoubleLink<T> {

	private DNode mHead;	//表头
	private int mCount;			//节点数
	
	public class DNode{
		public DNode prevNode;
		public DNode nextNode;
		public T value;
		
		public DNode(DNode prevNode, DNode nextNode, T value) {
			this.prevNode = prevNode;
			this.nextNode = nextNode;
			this.value = value;
		}
	}
	
	
	public DoubleLink() {
		mHead = new DNode(null, null, null);
		mHead.prevNode = mHead.nextNode = mHead;
		mCount = 0;
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
	public DNode getNode(int index){
		if(index < 0 || index > mCount)
			throw new IndexOutOfBoundsException();
		
		//正向查找
		if(index < mCount/2)
		{
			DNode node = mHead.nextNode;
			for (int i = 0; i < index; i++) {
				node = node.nextNode;
			}
			return node;
		}
		
		//反向查找
		DNode rnode = mHead.prevNode;
		int rindex = mCount - index - 1;
		for (int i = 0; i < rindex; i++) {
			rnode = rnode.prevNode;
		}
		return rnode;
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
			DNode node = new DNode(mHead, mHead.nextNode, value);
			mHead.nextNode.prevNode = node;
			mHead.nextNode = node;
			mCount++;
			return;
		}
		
		DNode inode = getNode(index);
		DNode tnode = new DNode(inode.prevNode, inode, value);
		inode.prevNode.nextNode = tnode;
		inode.nextNode = tnode;
		mCount++;
		return;
		
	}
	
    // 将节点插入第一个节点处。
     public void insertFirst(T t) {
         insert(0, t);
     }
 
     // 将节点追加到链表的末尾
     public void appendLast(T value) {
         DNode node = new DNode( mHead.prevNode, mHead,value);
         mHead.prevNode.nextNode = node;
         mHead.prevNode = node;
         mCount++;

     }
     // 删除index位置的节点
     public void del(int index) {
         DNode inode = getNode(index);
         inode.prevNode.nextNode = inode.nextNode;
         inode.nextNode.prevNode = inode.prevNode;
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
          
     public static void main(String[] args) {
    	 testDoubleLink();
     }     
     
     public static void testDoubleLink(){
    	 DoubleLink<Integer> doubleLink = new DoubleLink<Integer>();
    	 doubleLink.insertFirst(1);
    	 doubleLink.insertFirst(2);
    	 for (int i = 0; i < doubleLink.mCount; i++) {
    		 System.out.println(doubleLink.get(i));
			
		}
    	 
     }
}
