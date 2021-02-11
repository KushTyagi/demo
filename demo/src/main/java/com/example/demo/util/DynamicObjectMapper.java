package com.example.demo.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class DynamicObjectMapper<T> {

	public static Object convertObjectToDao(Object dtoObj, Object daoObj) {
		try {
			String[] str = new String[] {"setName","setAddress"};
			String[] str1 = new String[] {"name","phoneno"};
			
			for(int i=0; i<str.length; i++) {
				 PropertyDescriptor pd = new PropertyDescriptor(str1[i], dtoObj.getClass());
				 Method getter = pd.getReadMethod();
				for(int j=0; j<str.length; j++) {
					Method method = daoObj.getClass().getDeclaredMethod(str[i], String.class); 
					Object convertedObj = method.invoke(daoObj, getter.invoke(dtoObj)); 
						return convertedObj;
				   }  	
			 } 
			}catch(Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	
	public static Object convertObjectToDto(Object daoObj, Object dtoObj) {
		try {
			String[] str = new String[] {"setName","setAddress"};
			for(int i=0; i<str.length; i++) {
				Method method = daoObj.getClass().getDeclaredMethod(str[i], String.class); 
				Object convertedObj = method.invoke(daoObj, FieldUtil.getFields(dtoObj)); 
					return convertedObj;
			   }
			}catch(Exception e) {
				e.printStackTrace();
			}
		return null;
			
		}
	
}
