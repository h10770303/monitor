package com.hh.test.servlet;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 定义java 缓存
 * @author smg
 *
 */
public class CacheClass {

	private static Map<String,String> cache = new ConcurrentHashMap<String, String>();  
	private static Long expTime=0L;
    
	public static Long getExpTime() {
		return expTime;
	}

	public static void setExpTime(Long expTime) {
		CacheClass.expTime = expTime;
	}

	
    public static void setCache(String key, String obj, long seconds){  
        cache.put(key,obj);  
        expTime=seconds;
    }  
      
    public static String getCache(String key){  
         return cache.get(key);  
    }  
      
    public static  void removeCache(String key){  
        cache.remove(key);  
    }  
    
	public static void main(String args[]){  
    	CacheClass.setCache("acc", "11", 23);
    	System.out.println(CacheClass.getCache("acc"));
    	CacheClass.setCache("acc", "11", 23);
    	CacheClass.setCache("acc", "12", 23);
    	CacheClass.setCache("acc", "13", 23);
    	System.out.println(CacheClass.getCache("acc"));
    }  
}
