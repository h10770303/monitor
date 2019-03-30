package com.hh.test.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class FileReadUtils {
	
	public static String txt2String(File file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
//                System.out.println(result);
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
//        System.out.println("result=="+result);
        return result.toString();
    }
	

	/**
	 * jaxb 读取xml时使用
	 * @param file
	 * @return
	 */
	public static String xml2String(File file){
		StringBuilder result = new StringBuilder();
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
			String s = null;
			while((s = br.readLine())!=null){//使用readLine方法，一次读一行
				result.append(s+" ");
			}
			br.close();    
		}catch(Exception e){
			e.printStackTrace();
		}
//		System.out.println("result=="+result);
		return result.toString();
	}
	
	public static String readANSIFile(File file){
        StringBuilder result = new StringBuilder();
        try{
        	 InputStreamReader read = new InputStreamReader(new FileInputStream(file),  
        	            "GBK"); //构造一个BufferedReader类来读取文件
        	 BufferedReader br = new BufferedReader(read); 
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
//                System.out.println(result);
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
//        System.out.println("result=="+result);
        return result.toString();
    }
	

}
