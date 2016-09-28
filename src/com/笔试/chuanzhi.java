package com.笔试;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

public class chuanzhi {
	

	public static void main(String[] args) {
		int a = 1;
		int b = a;
		a = 2;
		System.out.println(a);
		System.out.println(b);
		
		Integer c = new Integer(1);
		Integer d = c;
		c = new Integer(2);
		System.out.println(c);
		System.out.println(d);
		
		Test test = new Test();
		test.cc();
	}
}
