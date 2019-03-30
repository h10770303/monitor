package com.hh.test.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件工具类
 * @author smg
 *
 */
public class FileUtils {
	
	
	/**
	 * 文件复制 
	 * @param source
	 * @param dest
	 * @throws IOException
	 */
	public static void copyFileUsingFileStreams(File source, File dest)
	        throws IOException {    
	    InputStream input = null;    
	    OutputStream output = null;    
	    try {
	           input = new FileInputStream(source);
	           output = new FileOutputStream(dest);        
	           byte[] buf = new byte[1024];        
	           int bytesRead;        
	           while ((bytesRead = input.read(buf)) > 0) {
	               output.write(buf, 0, bytesRead);
	           }
	    } finally {
	        input.close();
	        output.close();
	    }
	}
	/**
	 * 通过名字进行复制
	 * @param source
	 * @param dest
	 * @throws IOException
	 */
	public static void copyFileUsingFileStreamsByName(String sources, String  dests)
			throws IOException {  
		File source=new File(sources);
		File dest=new File(dests);
		InputStream input = null;    
		OutputStream output = null;    
		try {
			input = new FileInputStream(source);
			output = new FileOutputStream(dest);        
			byte[] buf = new byte[1024];        
			int bytesRead;        
			while ((bytesRead = input.read(buf)) > 0) {
				output.write(buf, 0, bytesRead);
			}
		} finally {
			input.close();
			output.close();
		}
	}

}
