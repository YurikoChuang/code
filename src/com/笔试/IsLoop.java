package com.笔试;

import com.笔试.DoubleLink.DNode;

/**
 * 判断一个链表是否有环
 * @author Seki
 *
 */
public class IsLoop {
	
	static DoubleLink<Integer> linkTable = new DoubleLink<>();
	/**
	 * 生成一个有环的链表
	 */
	public static void makeLinkTable()
	{
		
		for (int i = 0; i < 10; i++) {
			linkTable.appendLast(i);
			if(i == 9)
			{
				DNode lastNode = linkTable.getNode(i);
				lastNode.nextNode = linkTable.getNode(0);
			}
		}
	}
	
	/**
	 * 判断是否有环,  一个快指针,一个慢指针
	 * @return
	 */
	public static boolean isLoop()
	{
		DNode slow = linkTable.getNode(0);
		DNode fast = linkTable.getNode(0);
		while(fast!=null && fast.nextNode!=null)
		{
			slow = slow.nextNode;
			fast = fast.nextNode.nextNode;
			 if ( slow == fast ) 
				 return true;  
		}
		return false;
	}
	
	public static void main(String[] args) {
		makeLinkTable();
		System.out.println(isLoop());
	}
	
}
