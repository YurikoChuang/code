package com.剑指offer;

import java.util.Stack;

public class MyStack {
	static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}
	
}
