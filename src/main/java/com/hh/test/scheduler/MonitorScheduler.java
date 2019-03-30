package com.hh.test.scheduler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.xml.bind.JAXB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hh.test.manager.MonitorManager;
import com.hh.test.manager.SchedulerManager;
import com.hh.test.pojo.GztParam;
import com.hh.test.pojo.rundown.CheckInterplay;
import com.hh.test.util.DateUtil;
import com.hh.test.util.WeiXinUtil;

@Service("monitorScheduler")
public class MonitorScheduler {

	Logger log = LoggerFactory.getLogger(getClass());
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	GztParam gztParam = null;

	@Resource
	private MonitorManager monitorManager;

	@Resource
	private SchedulerManager schedulerManager;

	// 0 0/30 * * * ?
	// @Scheduled(cron="0 0/10 * * * ?")
	public void getAssetBytime() {
		log.info("进入getAssetBytime");
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		String[] types = { "clue", "topic", "title" };
		String site = "";
		String beginTime = sdf.format(date);
		String endTime = sdf.format(cal.getTime());
		System.out.println("getAssetBytime beginTime=" + beginTime);
		System.out.println("getAssetBytime endTime=" + endTime);
		for (int i = 0; i < types.length; i++) {
			monitorManager.insertClueBytime(types[i], site, beginTime, endTime);
			if (("clue").equals(types[i])) {
				site = "报片";
				monitorManager.insertClueBytime(types[i], site, beginTime, endTime);
			}
		}
	}

	/**
	 * 定时获取最新报道
	 */
	// @Scheduled(cron="0 0/10 * * * ?")
	public void getLastTile() {
		log.info("进入getLastTile");
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		String[] types = { "数字", "电视", "送看看" };
		String site = "";
		String beginTime = sdf.format(date);
		String endTime = sdf.format(cal.getTime());
		System.out.println("getLastTile beginTime=" + beginTime);
		System.out.println("getLastTile endTime=" + endTime);
		for (int i = 0; i < types.length; i++) {
			if (("送看看").equals(types[i])) {
				site = "报片";
				schedulerManager.insertKankan(types[i], site, beginTime, endTime);
			} else {
				schedulerManager.insertTile(types[i], site, beginTime, endTime);

			}
		}
	}

	/**
	 * 每天定时查看二级汇聚数据是否正常 如果异常则报警
	 */
	// @Scheduled(cron="0 0/1 * * * ?")
	public void checkCptn() {
		log.info(" 检查查二级汇聚");
		Date date = new Date();
		schedulerManager.checkCptn(date);

	}

	public void checkRundown() {
		log.info(" 检查新闻坊考评统计");
		Date date = new Date();
		schedulerManager.checkRundown(date);

	}

	/**
	 * 检查S9A10删除情况
	 */
	public void checkS9A10Del() {
		log.info(" 检查S9 A10 删除情况");
		String path = "Z:\\8990\\hmw\\batmonitor\\";
		try {
			schedulerManager.checkS9A10Del(path);
		} catch (ParseException e) {
			String touser = "HuMingWei,8990";
			String message = "S9 A10 开机删除服务异常;";
			WeiXinUtil.sendBatMessage(touser, message + e.getMessage());
		}
	}

	/**
	 * 检查甘蔗头是否正常、是否假死  每30分检测一次  
	 */
	public void checkGzt() {
		log.debug(" 检查甘蔗头运行情况");
		Date date = new Date();
		String s_date = DateUtil.dateToString(date);
		String path = "Z:\\8990\\hmw\\ganzhetou\\" + s_date + ".txt";
		int hour = date.getHours();
		if (hour==6) {
			gztParam = new GztParam("0", path, "向stp下发任务成功,error,未找到结束的标记", 0, 0);
		}
		if ((hour==7) ||(hour ==12) || (hour==18)|| (hour ==21)) {
			try {
				gztParam=schedulerManager.checkGzt(gztParam);
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	
	public void checkPy() {
		log.info(" 检查配音");
		String path = "Z:\\workflowMonitor\\interplaycheck\\py01.xml";
		try {
			CheckInterplay check = JAXB.unmarshal(new FileInputStream(path), CheckInterplay.class);
			schedulerManager.checkInterplay(check);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void checkSpam() {
		log.info(" 检查早晨审片");
		String path = "Z:\\workflowMonitor\\interplaycheck\\spam.xml";
		try {
			CheckInterplay check = JAXB.unmarshal(new FileInputStream(path), CheckInterplay.class);
			schedulerManager.checkInterplay(check);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void checkSppm() {
		log.info(" 检查下午审片");
		try {
			String path = "Z:\\workflowMonitor\\interplaycheck\\sppm.xml";
			CheckInterplay check = JAXB.unmarshal(new FileInputStream(path), CheckInterplay.class);
			schedulerManager.checkInterplay(check);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void checkSz() {
		log.info(" 检查上载");
		String path = "Z:\\workflowMonitor\\interplaycheck\\sz01.xml";
		try {
			CheckInterplay check = JAXB.unmarshal(new FileInputStream(path), CheckInterplay.class);
			schedulerManager.checkInterplay(check);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void  testRun(){
		schedulerManager.getTestRun();
	}
	
	
	public static void main(String[] args) {
		String path = "Z:\\workflowMonitor\\interplaycheck\\sppm.xml";
		
		try {
			CheckInterplay check = JAXB.unmarshal(new FileInputStream(path), CheckInterplay.class);
			System.out.println(check);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
