package com.笔试;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

public  class Test {
	int i = 1;
	public void cc(){
		Test aTest = new Test();
		Test bTest = aTest;
		aTest.i = 2;
		System.out.println(aTest.i);
		System.out.println(bTest.i);
		bTest.i = 1;
		System.out.println(aTest.i);
		System.out.println(bTest.i);
	}
	public class Father{
		public void dd(){
			System.out.println("father");
		}
	}
	public class Son extends Father{
		
	
	}
	public static void main(String[] args) {
		Test test = new Test();
		test.cc();
		
		Father father = test.new Father();
		Son son = test.new Son();
		son.dd();
		
	}
}
