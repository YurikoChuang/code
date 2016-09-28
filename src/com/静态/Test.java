package com.静态;

public class Test {
	public static int a;
	
	public static void main(String[] args) {
		//Make Make = new Make();
		a = Make.makeint;
		System.out.println("a= " + a );
		System.out.println("makeint = " + Make.makeint);
		Make.makeint--;
		System.out.println("a= " + a );
		System.out.println("makeint = " + Make.makeint);
		a--;
		System.out.println("a= " + a );
		System.out.println("makeint = " + Make.makeint);
	}
}
