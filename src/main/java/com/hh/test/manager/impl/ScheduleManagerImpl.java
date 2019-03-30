package com.hh.test.manager.impl;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hh.test.dao.ListqDao;
import com.hh.test.dao.MonitorDao;
import com.hh.test.db.CustomerContextHolder;
import com.hh.test.manager.SchedulerManager;
import com.hh.test.pojo.GztParam;
import com.hh.test.pojo.rundown.CheckInterplay;
import com.hh.test.pojo.rundown.TestRunAlert;
import com.hh.test.pojo.weixin.Notify;
import com.hh.test.util.DateUtil;
import com.hh.test.util.FileReadUtils;
import com.hh.test.util.UUIDRadom;
import com.hh.test.util.WeiXinUtil;

@Service
public class ScheduleManagerImpl implements SchedulerManager {

	Logger log = LoggerFactory.getLogger(getClass());
	String touser="HuMingWei,8990,ShiMeiNan,ZouXueYi,DingXinFeng,HeWei,LiJiHao,DingJun,WuJiaJun";
//	String touser="HuMingWei";
	String zhibanzhang=",FuJiLiang,james,MaFeiFan,ShenXiaoLei,ZhangHua,ZhangQi,ZhuGeTianQin,RongMin,DingJiang";

	@Resource
	private MonitorDao monitorDao;
	@Resource
	private ListqDao listqDao;

	@Override
	public void insertKankan(String string, String site, String beginTime, String endTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertTile(String string, String site, String beginTime, String endTime) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void checkCptn(Date date) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		int hourNow=cal.get(Calendar.HOUR_OF_DAY);
		cal.add(Calendar.HOUR, -1);
		String endTime = sdf.format(date);
		String endTime2 = sdf2.format(date);
		String beginTime = sdf.format(cal.getTime());
		String beginTime2 = sdf2.format(cal.getTime());
		int count,count2,count3,count4=0,count5,count6=0;
		//cptn 从8-20
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_XNEWS);
		if(hourNow>=8){
			count3=monitorDao.getCptn("CPTN",beginTime,endTime);
			if(count3==0){
				sendMessage(touser, beginTime2, endTime2, "CPTN");
			}
		}
		if(hourNow>=14&&hourNow<=18){
			count4=monitorDao.getCptn("区县台视频",beginTime,endTime);
			if(count4==0){
				sendMessage(touser, beginTime2, endTime2, "区县台视频");
			}
		}
		count=monitorDao.getCptn("美联社",beginTime,endTime);
		count2=monitorDao.getCptn("路透社",beginTime,endTime);
		
		if(count==0){
			sendMessage(touser, beginTime2, endTime2, "美联社");
		}
		if(count2==0){
			sendMessage(touser, beginTime2, endTime2, "路透社");
		}
		if(hourNow<=10){
			
			count5=monitorDao.getCptn("newslink",beginTime,endTime);
			if(count5==0){
				sendMessage(touser, beginTime2, endTime2, "newslink");
				
			}
		}
		if(hourNow<=10){
			SimpleDateFormat sdf3=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
			String beginDate=sdf3.format(date);
			if(hourNow==4||hourNow==5){
				int count7=monitorDao.getCptn("国际广播电台",beginDate,endTime);
				if(count7==0){
					sendMessage(touser, beginTime2, endTime2, "国际广播电台");
				}
				
			}else{
				count6=monitorDao.getCptn("国际广播电台",beginTime,endTime);
				if(count6==0){
					sendMessage(touser, beginTime2, endTime2, "国际广播电台");
				}
			}
		}
	}
	
	public void sendMessage(String touser,String beginTime,String endTime,String type ){
		String message="xnews:"+type+":between=" + beginTime + "and" + endTime + "数量为0,请检查是否正常!";
		Notify notify=new Notify(2, "IFAG-02", "10.27.137.22", 2, type, new Date());
		WeiXinUtil.sendNotifyMessage(touser, message, notify);
	}
	

	@Override
	public void checkRundown(Date date) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 1);
		String endTime = sdf.format(cal.getTime());
		String endTime2 = sdf2.format(cal.getTime());
		String beginTime = sdf.format(date);
		String beginTime2 = sdf2.format(date);
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_XNEWS);
		int count=monitorDao.checkRundown("新闻坊",beginTime,endTime);
		if(count==0){
//			String touser="HuMingWei,8990";
			sendMessage(touser, beginTime2, endTime2, "新闻坊考评数据");
		}
	}

	@Override
	public void checkS9A10Del(String path) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		Date date=new Date();
		String s9cg1Path=path+"s9cg1\\cg1delog.txt";
		String s9cg2Path=path+"s9cg2\\cg2delog.txt";
		String s9cg3Path=path+"s9cg3\\a10del.txt";
		String s9cg1=FileReadUtils.readANSIFile(new File(s9cg1Path));
		String s9cg2=FileReadUtils.readANSIFile(new File(s9cg2Path));
		String s9cg3=FileReadUtils.readANSIFile(new File(s9cg3Path));
		String[] s9cg1s=s9cg1.split(" ");
		String[] s9cg2s=s9cg2.split(" ");
		String[] s9cg3s=s9cg3.split(" ");
		log.debug("s9cg1s[0]="+s9cg1s[0]+";s9cg1s[1]="+s9cg1s[1]);
		Date s9cg1Date=sdf.parse(s9cg1s[0].trim());
		Date s9cg2Date=sdf.parse(s9cg2s[0].trim());
		Date s9cg3Date=sdf.parse(s9cg3s[0].trim());
//		String touser="HuMingWei";
		if(((date.getTime()-s9cg1Date.getTime())/(1000*3600*24))>7){
			String message="S9 cg1 A10缓存删除批出命令7天未执行";
			WeiXinUtil.sendBatMessage(touser, message);
		}
		if(((date.getTime()-s9cg2Date.getTime())/(1000*3600*24))>7){
			String message="S9 cg2 A10缓存删除批出命令7天未执行";
			WeiXinUtil.sendBatMessage(touser, message);
		}
		if(((date.getTime()-s9cg3Date.getTime())/(1000*3600*24))>7){
			String message="S9 cg3 A10缓存删除批出命令7天未执行";
			WeiXinUtil.sendBatMessage(touser, message);
			
		}
		
	}
	public void sendBatMessage(String touser,String message){
		Notify notify=new Notify(2, "IFAG-02", "10.27.137.22", 2, "S9cg", new Date());
		WeiXinUtil.sendNotifyMessage(touser, message, notify);
	}
	

	@Override
	public GztParam checkGzt(GztParam gztParam) throws ParseException, IOException {
		gztParam=logDeal(gztParam);
		return gztParam;
		
	}
	
	
	private GztParam logDeal(GztParam gztParam) throws ParseException, IOException {
		
		// 初始化时从开始开始解析日志
		if (gztParam.getInitFlag() == 0) {
			gztParam.setLastFileSize(Long.parseLong(gztParam.getInitFileSize()));
		}
		File file = new File(gztParam.getFilePath());
		if(file.exists()){
			gztParam=deal2( file,gztParam);
		}else {
			//TODO  需要报警，没有生成日志，应该是假死状况
			String message="甘蔗头服务日志异常，请检查服务是否正常：【未找到相应日志文件】。";
			WeiXinUtil.sendBatMessage(touser, message);
		}

		return gztParam;
	}

	private GztParam deal2( File file,GztParam gztParam) throws ParseException {
		String result = "";
		int videoCnt=0,errorCnt=0;
		try {
			RandomAccessFile accessFile = new RandomAccessFile(file, "r");
			long fileSize = accessFile.length();
			accessFile.seek(gztParam.getLastFileSize());
			String line = null;
			while ((line = accessFile.readLine()) != null) {
				line = new String(line.getBytes("ISO-8859-1"), "UTF-8");
				result = result + line + System.lineSeparator();
				String[] filterNames = getFilterNames(gztParam.getFilterName());
				for (String string : filterNames) {
					if (line.toLowerCase().contains(string)) {
						if(!("未找到结束的标记").equals(string)){
							if(("向stp下发任务成功").equals(string)){
								videoCnt++;
							}else if(("error").equals(string)){
								errorCnt++;
							}
						}
					}
				}
			}

			gztParam.setLastFileSize(fileSize);
			gztParam.setInitFlag(gztParam.getInitFlag() + 1);
			
			 if (result.length()==0) {
				 
					String message="甘蔗头服务日志异常，请检查服务是否正常【服务可能假死状态】。";
					WeiXinUtil.sendBatMessage(touser, message);
			 }
			 if (videoCnt<=0) {
				 // TODO 5分钟后再次检测
				 String message="甘蔗头服务日志异常，请检查服务是否正常【未处理视频】。";
				 WeiXinUtil.sendBatMessage(touser, message);
			 }
			 if (errorCnt>40) {
				 
				 String message="甘蔗头服务日志异常，请检查服务是否正常【异常日志过多】。";
				 WeiXinUtil.sendBatMessage(touser, message);
			 }
			
			 log.debug("此次读取甘蔗头日志量resul="+result.length()+",lastFileSize=="+fileSize+",videoCnt=="+videoCnt+",errorCnt=="+errorCnt);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return gztParam;
	}
	
	

	/**
	 * 处理filterName. 将过滤词进行处理
	 * 
	 * @param filterName
	 * @return
	 */
	private String[] getFilterNames(String filterName) {
		String[] array = filterName.split(",");
		return array;
	}

	@Override
	public void checkInterplay(CheckInterplay check) throws ParseException {
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		check.setId(UUIDRadom.getUUID());
		if(!("").equals(check.getChecktime())){
			check.setCheckDate(DateUtil.stringToDateTime(check.getChecktime()));
			
			int day=getday(DateUtil.stringToDateTime(check.getChecktime()));
			if(day==6|| day==0){
				check=dealCheck(check);
			}
		}
		monitorDao.insertCheckInterplay(check);
		String checkResult=check.getCheckresult();
		if(!("info").equals(checkResult)){
			WeiXinUtil.sendBatMessage(touser+zhibanzhang, check.getCheckinfo().replace("\n", " "));
		}
		
	}

	/**
	 * 周末两天把S9的报警取消
	 * @param check
	 * @return
	 */
	private CheckInterplay dealCheck(CheckInterplay check) {
		String info="";
		if(check.getCheckinfo().contains("s9")){
			String[] checkInfo=check.getCheckinfo().split("!");
			if(checkInfo.length==2){   //只报S9的报错
				check.setCheckresult("info");
				check.setCheckinfo("审片发片测试正常!"+checkInfo[1]);
			}else{ //不仅仅报S9，只要把S9去掉就行。
				for (int i = 0; i < checkInfo.length; i++) {
					if(!checkInfo[i].contains("s9")){
						info+=checkInfo[i];
					}
				}
				check.setCheckinfo(info);
			}
		}
		return check;
	}
	
	
	

	/**
	 * 有时间获取当前星期几
	 * @param stringToDateTime
	 * @return
	 */
	private int getday(Date stringToDateTime) {
		Calendar cal=Calendar.getInstance();
		cal.setTime(stringToDateTime);
		return cal.get(Calendar.DAY_OF_WEEK)-1;
	}
	
	@Override
	public void getTestRun() {
		List<String> messages=new ArrayList<String>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		String beginTime=sdf.format(date);
		String endTime=sdf.format(cal.getTime());
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		List<TestRunAlert>alerts=listqDao.getTestRunAlert(beginTime, endTime);
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		List<CheckInterplay> interplays=monitorDao.getCheckInterplay(beginTime, endTime);
		/**
		 * 报警信息
		 */
		for (TestRunAlert alert : alerts) {
			messages.add(alert.getMessage());
			
		}
		if(interplays.size()>0){
			
			for (CheckInterplay interplay : interplays) {
				if(!("info").equals(interplay.getCheckresult())){
					messages.add(interplay.getCheckinfo());
				}
			}
		}
		
		if(messages.size()==0){
			String message="试机正常";
			messages.add(message);
		}
		
		
		WeiXinUtil.sendRunMsgMessage(touser+zhibanzhang, "", messages);
	}
	
	
}
