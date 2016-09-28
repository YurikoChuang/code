package com.笔试;

import java.util.ArrayList;

/**
 * 对字符串的空格分词	
 * @author Seki
 *
 */
public class DivideWord {

	public static void divide(String myString){
		if (myString == null) {
			return;
		}
		String[] strings = myString.split(" ");
		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
		
	}
	
	public static void main(String[] args) {
		String myString = "its a dog";
		divide(myString);
		
	}
}
