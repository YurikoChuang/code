package com.比较器;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

public class People {
	public String name;
	public Integer age;
	
	public People(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Integer getAge(){
		return this.age;
	}
	
	
	public static void main(String[] args) {
		People people = new People("aa", 4);
		People people2 = new People("bb", 4);
		List<People> list = new ArrayList<>();
		list.add(people);
		list.add(people2);
		MyComperator peopleComperator = new MyComperator();
		Collections.sort(list, peopleComperator);
		Iterator<People> iterator = list.iterator();
		while (iterator.hasNext()) {
			People people3 = (People) iterator.next();
			System.out.println(people3.name);
		}
		
	}
}
