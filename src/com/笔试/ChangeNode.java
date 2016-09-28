package com.笔试;

import com.笔试.DoubleLink.DNode;
import com.笔试.单链表.ONode;

/**
 * 一个链表的1,2节点交换, 3,4节点交换...
 * @author Seki
 *
 */
public class ChangeNode {
	static 单链表<Integer> table = new 单链表<>();
	
	public static void makeLinkTable()
	{
		for (int i = 0; i < 9; i++) {
			table.appendLast(i);
		}
		System.out.println(table.size());
		for (int i = 0; i < 9; i++) {
			System.out.println(table.get(i));
		}
		System.out.println("建表");
	}
	
	public static void change()
	{
		int length = table.size();
		for (int i = 0; i < length; i+=2) {
			if (i+1 < length ) {
				swap(table.getNode(i),table.getNode(i+1), i);		
			}
		}
		
	}
	
	public static void swap(ONode inode, ONode nnode , int i)
	{
		ONode pNode = null;
		if (i == 0) {
			pNode = table.mHead;
		}
		else {
			pNode = table.getNode(i-1);
		}
		
		inode.nextNode = nnode.nextNode;
		pNode.nextNode = nnode;
		nnode.nextNode = inode;
		
	}
	public static void main(String[] args) {
		makeLinkTable();
		change();
		
		for (int i = 0; i < table.size(); i++) {
			System.out.println(table.get(i));
		}
	}
}
