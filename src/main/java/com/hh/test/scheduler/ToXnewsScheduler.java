package com.hh.test.scheduler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.xml.bind.JAXB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hh.test.manager.ToXnewsManager;
import com.hh.test.pojo.MonitorConf;
import com.hh.test.pojo.ProgramNode;
import com.hh.test.util.FileUtils;

@Service("toXnewsScheduler")
public class ToXnewsScheduler {

	Logger log = LoggerFactory.getLogger(getClass());
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Resource
	private ToXnewsManager  toXnewsManager;

	public void readXml() {
		String errorFile="Z:\\workflowMonitor\\error\\";
		File dir = new File("Z:\\workflowMonitor\\avidout\\");
		File[] files = dir.listFiles();
		if (files.length>0){
			
			for (int i = 0; i < files.length; i++) {
				if (files[i].getName().endsWith(".xml")) {
					String xmlPath = files[i].getAbsolutePath();
					MonitorConf monitorConf = new MonitorConf();
					try {
						monitorConf = JAXB.unmarshal(new FileInputStream(xmlPath), MonitorConf.class);
						log.info("解析mxl后的monitorConf==" + monitorConf);
						toXnewsManager.insertMonitorConf(monitorConf);
					} catch (FileNotFoundException e) {
						try {
							FileUtils.copyFileUsingFileStreams(files[i], new File(errorFile+files[i].getName()));
							log.info(" 解析xml异常,将异常文件移动到{}",errorFile+files[i].getName());
						} catch (IOException e1) {
						}
					}
					// TODO 解析后入库并删除当前xml
					files[i].delete();
				}
			}
		}
		
	}
	
	/**
	 * 看看统计与分析
	 */
	public void checkKankan() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		String beginTime = sdf.format(date);
		String endTime = sdf.format(cal.getTime());
		
		toXnewsManager.checkClue(beginTime, endTime,6,0);
		toXnewsManager.checkClue(beginTime, endTime,7,0);
		toXnewsManager.checkClue(beginTime, endTime,8,0);
		toXnewsManager.checkKankan(beginTime, endTime,9,0); //是否推送

	}

	public static void main(String[] args) {
		/**
		 * jaxb 方式解析xml
		 */

		File dir = new File("Z:\\workflowMonitor\\avidout\\");
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].getName().endsWith(".xml")) {
				String xmlPath = files[i].getAbsolutePath();
				System.out.println(xmlPath);
				MonitorConf monitorConf = new MonitorConf();
				try {
					monitorConf = JAXB.unmarshal(new FileInputStream(xmlPath), MonitorConf.class);
				} catch (FileNotFoundException e) {
					// TODO 异常处理
					System.out.println(" 解析xml异常");
				}
				// TODO 解析后入库并删除当前xml
				System.out.println("monitorConf==" + monitorConf);
				ProgramNode programNode=monitorConf.getProgramNodes().get(0);
				String starttime=programNode.getCreateTime();
				System.out.println(new Date(Long.parseLong(starttime)) );
			}
		}

	}

}
