package com.剑指offer;

import java.util.LinkedList;
import java.util.Queue;

import java.util.Stack;


public class MyQueue{
	public static Queue<Integer> myQueue = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		myQueue.offer(1);
		myQueue.offer(2);
		System.out.println(myQueue.poll());
		System.out.println(myQueue.poll());
	}
	
}
