package com.笔试;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 找出字符串中出现最多次的字符并输出
 * @author Seki
 *
 */
public class FindMostAppear {
	public static void find(){
        String str = "aaabbb";
        Integer max = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>(str.length());
        for(char chr : str.toCharArray()) {
            Integer i = map.get(chr);   
            int value = (i == null) ? 0 : i;  // 获取，没有则0，有则叠加
            map.put(chr, ++value);
            max = value > max ? value : max;  // 更新max
        }
        System.out.println(max);
        for (Entry<Character, Integer> entry : map.entrySet()) {
        	if(max.equals(entry.getValue()))
			{ 
        		System.out.println(entry.getKey());
			}
        	
		}
	}
	
	public static void main(String[] args) {
		find();
	}
}
