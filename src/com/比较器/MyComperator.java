package com.比较器;

import java.util.Comparator;

public class MyComperator implements Comparator<People>{

	@Override
	public int compare(People arg0, People arg1) {
		int minus = arg0.age.compareTo(arg1.age);


		if(arg0.age.equals(arg1.age)) {
		
			int a = arg0.name.compareTo(arg1.name);
			return a;
		}
		return minus;
	
			
	}



}
