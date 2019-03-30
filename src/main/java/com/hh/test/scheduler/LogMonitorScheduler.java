package com.hh.test.scheduler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hh.test.manager.MonitorManager;
import com.hh.test.manager.SchedulerManager;
@Service("logMonitorScheduler")
public class LogMonitorScheduler {
	
	Logger log=LoggerFactory.getLogger(getClass());
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	
	@Value("${lastFileSize}")
	private String lastFileSize;
	@Value("${filePath}")
	private String filePath;
	@Value("${filterName}")
	private String filterName;
	long lastFileSize1=0L;
	int i=0;//初始化标志
	
	@Resource
	private MonitorManager monitorManager;
	
	@Resource
	private SchedulerManager schedulerManager;
	

	
	public void readLog(){
		if(i==0){
			lastFileSize1=Long.parseLong(lastFileSize);
		}
		
		String result="";
		File file=new File(filePath);  
		
		try {
			RandomAccessFile accessFile=new RandomAccessFile(file, "r");
			long fileSize=accessFile.length();
			if(fileSize<lastFileSize1){
				lastFileSize1=0L;
			}
			log.info("lastFileSize1为="+lastFileSize1+"，fileSize为="+fileSize);
			accessFile.seek(lastFileSize1);
			String line=null;
			while ((line = accessFile.readLine()) != null) {
				line = new String(line.getBytes("ISO-8859-1"),"UTF-8");
				String[] filterNames=getFilterNames(filterName);
				for (String string : filterNames) {
					if(line.toLowerCase().contains(string)){ 
						result=result+line+"\n";
						
					}
					
				}
				
			}
			lastFileSize1=fileSize;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		i++;
//		log.error(result);
	}
	
	/**
	 * 处理filterName. 将过滤词进行处理
	 * @param filterName
	 * @return
	 */
	private String[] getFilterNames(String filterName){
		String[] array=filterName.split(",");
		return array;
	}
	
	public static void main(String[] args) {
		String filterName="a,b";
		System.out.println(filterName.split(",").length);
	}
	

}
