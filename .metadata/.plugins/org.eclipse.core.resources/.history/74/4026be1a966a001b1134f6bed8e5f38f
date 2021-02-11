package com.example.demo.util;

import java.lang.reflect.Field;

import com.example.demo.entity.Userentity;

public class FieldUtil<T> {

	public static String getFields(Object usr) throws Exception{
		Class clazz = usr.getClass();
		
		Userentity obj = (Userentity) usr;
		String[] str2 = new String[] {"name","address"};
		for(int j=0; j<str2.length; j++) {
			Field field = FieldUtil.getField(usr).getDeclaredField(str2[j]);
			field.setAccessible(true); 
			
             switch(field.getName()) {
             case "name":return obj.getName();
             case "address":return obj.getAddress();
             default:return "Not Found";
             }
		 }
			
		return "";
	}
	
	public static Class<?> getField(Object u) {
		Userentity obj = (Userentity) u;
		return obj.getClass();
	}
	
	//public static void main(String []arr)throws Exception {
	//	Userentity u = new Userentity();
	//	u.setAddress("abc");
	//	u.setName("xyz");
	//	System.out.println(FieldUtil.getFields(u));
	//}
}
