package com.笔试;

import java.util.Stack;

import com.剑指offer.MyQueue;

/**
 * 判断一个字符串是不是回文
 * @author Seki
 *
 */
public class 判断一个字符串是不是回文 {
	public static Stack<Character> stack = new Stack<>();
	
	public static boolean judgePalindrome(String myString) {
		char[] chars = myString.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (i == 0) {
				
			}
			else if (chars[i] == stack.lastElement()) {
				stack.pop();
				continue;
			}
			stack.push(chars[i]);
		}
		
		if (stack.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		String myString = "abccba";
		System.out.println(judgePalindrome(myString));
	}
}
