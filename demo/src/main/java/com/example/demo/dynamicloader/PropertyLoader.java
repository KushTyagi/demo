package com.example.demo.dynamicloader;

import java.util.Properties;

public class PropertyLoader {
	private static Properties prop = null;
	
	public static String get(String key) {
		if(null == prop) {
			init();
		}
		
	   return (String)prop.get("");
	}
	
	public static void init() {
		
	}
}
