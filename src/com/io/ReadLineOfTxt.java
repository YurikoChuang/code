package com.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 按行读取txt
 * @author Kaname
 *
 */
public class ReadLineOfTxt {
	public void readtxt() throws IOException{
		File file = new File("G:/Test.txt");
		if (!file.exists()) {
			System.err.println("文件不存在");
		}
		FileInputStream fileInputStream = new FileInputStream(file);
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "GBK");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		String str = null;
		while(bufferedReader.readLine()!=null){
			str = bufferedReader.readLine();
			System.out.println(str);
		}
	}
	
	public static void main(String[] args) throws IOException {
		ReadLineOfTxt readLineOfTxt = new ReadLineOfTxt();
		readLineOfTxt.readtxt();
	}
	
	
}
