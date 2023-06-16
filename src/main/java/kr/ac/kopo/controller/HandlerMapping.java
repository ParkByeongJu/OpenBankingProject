package kr.ac.kopo.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class HandlerMapping {

	private Map<String, Controller> mappings;

	public HandlerMapping() {
		mappings = new HashMap<>();
		Properties prop = new Properties();
		
		try {
			InputStream is = new FileInputStream("C:\\Users\\User\\eclipse-workspaceJSP\\BjBanking\\bean.properties");
			prop.load(is);
			
			Set<Object> keys = prop.keySet();
			for(Object key : keys) {
				String className = prop.getProperty(key.toString());
//				System.out.println(key + " : " + className);
				
				Class<?> clz = Class.forName(className);
				Constructor<?> consturctor =  clz.getConstructor();
				consturctor.newInstance();
				
				mappings.put(key.toString(), (Controller)consturctor.newInstance());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Controller getController(String uri) {
		
		return mappings.get(uri);
		
	}
	
	
	/*
	public static void main(String[] args) throws Exception {
//		java.util.Random r = new java.util.Random();
//		System.out.println(r.nextInt());
		
		Class<?> clz = Class.forName("java.util.Random");
		Constructor<?> constructor = clz.getConstructor();
		Object obj = constructor.newInstance();
		System.out.println("난수 : " + ((java.util.Random)obj).nextInt());
	}
	 */	
	
}




