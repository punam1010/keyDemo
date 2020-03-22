package com.ebay.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class util {
	public static String getLocatorType(String key) {
		String value=getProperty(key);
		return value.split("##")[0];
	}
	public static String getLocatorValue(String key) {
		String value=getProperty(key);
		return value.split("##")[1];
	}
	
	public static String getProperty(String key){
		String value=null;
		
		try {
			FileInputStream fis=new FileInputStream("D:/MavenScript/MavenFirstScript/src/main/resources/OR.properties");
			Properties prob=new Properties();
				prob.load(fis);
				value=(String) prob.get(key);
				} catch (FileNotFoundException e) {
					System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("unable to load properties file");
			e.printStackTrace();
			}
		return value;
	}
	public static void main(String[] args) {
		String s=getLocatorType("Home.sub_Menu");
		System.out.println(s);
	}
}
