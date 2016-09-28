package com.笔试;

import java.util.Scanner;

/**
 * 删除字符串的空格
 * @author Seki
 *
 */
public class 删除字符串的空格 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String str = null;
		str = scanner.nextLine();
		
		str = str.replace(" ", "");
		System.out.println(str);
	}
}
