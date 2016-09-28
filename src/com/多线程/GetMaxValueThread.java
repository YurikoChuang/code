package com.多线程;

import java.util.ArrayList;

import com.code.MainMethod;
import com.util.MathUtil;

/**
 * 
 * @author Seki
 *
 */
public class GetMaxValueThread implements Runnable{
	private ArrayList<Integer> array = new ArrayList<>();
	private int max;
	public GetMaxValueThread(ArrayList<Integer> array)
	{
		setArray(array);
	}
	@Override
	public void run() {
		if(array.size() == 2)
		{
			int MaxInThread = MathUtil.max(array.get(0),array.get(1));	
			MainMethod.maxValue = MathUtil.max(MaxInThread, MainMethod.sum);
			System.out.println(MainMethod.maxValue);
		}
		if(array.size() == 1)
			MainMethod.maxValue = MathUtil.max(array.get(0), MainMethod.sum);
		System.out.println(MainMethod.maxValue);
	}
	public ArrayList<Integer> getArray() {
		return array;
	}
	public void setArray(ArrayList<Integer> array) {
		this.array = array;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	
}
