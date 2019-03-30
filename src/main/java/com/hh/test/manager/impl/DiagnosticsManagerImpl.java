package com.hh.test.manager.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.xml.bind.JAXB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hh.test.dao.DiagnosticsDao;
import com.hh.test.db.CustomerContextHolder;
import com.hh.test.manager.DiagnosticsManager;
import com.hh.test.pojo.diagnostics.Log;
import com.hh.test.pojo.diagnostics.Message;
import com.hh.test.pojo.diagnostics.MessageDiff;
import com.hh.test.pojo.diagnostics.MessageShow;
import com.hh.test.pojo.diagnostics.MessageTime;
import com.hh.test.pojo.diagnostics.Record;
import com.hh.test.util.SearchType;

@Service
public class DiagnosticsManagerImpl implements DiagnosticsManager {

	Logger log = LoggerFactory.getLogger(getClass());

	@Resource
	private DiagnosticsDao diagnosticsDao;

	@Override
	public int insertMessage(String xmlPath,String xmlPath2) throws ParseException, FileNotFoundException {
		insertMessageLog(xmlPath);
		insertMessageLog(xmlPath2);
		return 0;
	}

	/**
	 * 将指定路径下的文本进行解析并入库
	 * @param xmlPath
	 * @throws FileNotFoundException
	 * @throws ParseException
	 */
	private void insertMessageLog(String xmlPath) throws FileNotFoundException, ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS 'GMT'",Locale.US);
		Log log = new Log();
		log = JAXB.unmarshal(new FileInputStream(xmlPath), Log.class);
		List<Record> records = log.getRecords();
		for (Record record : records) {
			if (record.getMessage().contains("Limits")) {
				String message = record.getMessage();
				String[] messageSplit = message.split(",");
				Message msg = new Message();
				msg.setId(messageSplit[0].substring(messageSplit[0].indexOf(":")+2));
				msg.setLimits(messageSplit[1].substring(messageSplit[1].indexOf(":")+2));
				msg.setMarks(messageSplit[2].substring(messageSplit[2].indexOf(":")+2));
				msg.setDuration(messageSplit[3].substring(messageSplit[3].indexOf(":")+2));
				msg.setHostName(record.getHostname());
				msg.setTime(sdf.parse(record.getSyncdate()));
			
				dealMessage(msg);
			}
		}		
	}

	/**
	 *  message 入库处理
	 * @param message
	 */
	private void dealMessage(Message message){
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		Message msg=diagnosticsDao.findMessage(message);
		if(msg==null){
			diagnosticsDao.insertMessage(message);
		}else{
			long oldtime=msg.getTime().getTime();
			long newtime=message.getTime().getTime();
			if(oldtime>newtime){
				diagnosticsDao.updateMessageTime(message);
				
			}
			
		}
	}

	@Override
	public int getMessageCnt(SearchType searchType) {
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		return diagnosticsDao.getMessageCnt(searchType);
	}

	@Override
	public List<Message> getMessageBySearchType(SearchType searchType) {
		
		return null;
	}

	@Override
	public List<MessageShow>  analysisFile(String diff1,String diff2,String id) {
		List<MessageShow> messageShows=new ArrayList<>();
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		List< Message> list=diagnosticsDao.messageGroupId();
		for (Message message : list) {
			if(!("").equals(id)&&(!message.getId().equals(id))){
				continue;
			}
			List<Message> messages=diagnosticsDao.getMessageById(message.getId());
			int size=messages.size();
			if(size<=2){
				MessageShow messageShow=new MessageShow();
				messageShow.setId(messages.get(0).getId());
				messageShow.setLimits(messages.get(0).getLimits());
				messageShow.setMarks(messages.get(0).getMarks());
				messageShow.setDuration(messages.get(0).getDuration());
				if(!("").equals(diff1)&&!("").equals(diff2)){
					if(("null").equals(diff1)||(("null").equals(diff2))){
						if(size==2) continue;
						messageShows.add(messageShow);
					}else{
						if(size==2){
							long time1=messages.get(0).getTime().getTime();
							long time2=messages.get(1).getTime().getTime();
							long tt=time2-time1;
							long i=Long.parseLong(diff1)*1000;
							long j=Long.parseLong(diff2)*1000;
							if(tt>=i && tt<=j){
								messageShow.setDiffTime(tt/1000.0+"秒");
								System.out.println(tt/1000.0+"秒");
								List<MessageDiff> messageDiffs=new ArrayList<>();
								for (Message message2 : messages) {
									MessageDiff messageDiff=new MessageDiff();
									messageDiff.setHostName(message2.getHostName());
									messageDiff.setTime(message2.getTime());
									messageDiffs.add(messageDiff);
								}
								messageShow.setDiffs(messageDiffs);
								messageShows.add(messageShow);
							}
						}
					}
				}else{
					if(size==2){
						long time1=messages.get(0).getTime().getTime();
						long time2=messages.get(1).getTime().getTime();
						messageShow.setDiffTime((time2-time1)/1000.0+"秒");
					}
					List<MessageDiff> messageDiffs=new ArrayList<>();
					for (Message message2 : messages) {
						MessageDiff messageDiff=new MessageDiff();
						messageDiff.setHostName(message2.getHostName());
						messageDiff.setTime(message2.getTime());
						messageDiffs.add(messageDiff);
					}
					messageShow.setDiffs(messageDiffs);
					
					messageShows.add(messageShow);
				}
			}
		}
		
		return messageShows;
		
	}

	@Override
	public List<MessageTime> messageGroupTime(String step) throws ParseException {
		List<MessageTime> messageTimes=new ArrayList<>();
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
//		List<Message> messages=diagnosticsDao.getMessageAll();
		Date frist=sdf.parse("00:00:00");
		Date end=sdf.parse("23:59:59");
//		System.out.println("end=="+sdf.format(end));
		Calendar cal=Calendar.getInstance();
		String beginTime=sdf.format(frist),endTime="";
		do{
			MessageTime messageTime=new MessageTime();
			cal.setTime(frist);
			beginTime=sdf.format(cal.getTime());
//			System.out.println("beginTime=="+beginTime);
			messageTime.setTime(beginTime);
			cal.add(Calendar.MINUTE, ("").equals(step)?15:Integer.parseInt(step));
			endTime=sdf.format(cal.getTime());
//			System.out.println("endTime=="+endTime);
			CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
			messageTime.setCnt(diagnosticsDao.getMessageGroupTime2(beginTime, endTime).get(0).getCnt());
			frist=cal.getTime();
			messageTimes.add(messageTime);
		}while(frist.getTime()<end.getTime());
//		System.out.println("messagesTimes=="+messageTimes.size());
		return messageTimes;
//		return diagnosticsDao.getMessageGroupTime();
	}
	
	
	public static void main(String[] args) {
		
		long tt=150;
		long i=100;
		
		long j=200;
		if(i<=tt&&j>=tt){
			System.out.println(1211221);
		}
		
//		SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd HH:mm");
//		Calendar cal=Calendar.getInstance();
//		String beginTime="",endTime="";
//		Date date =new Date();
//		for(int i=1;i<=100;i++) {
////			MessageTime messageTime=new MessageTime();
//			System.out.println("cal=="+cal.getTime());
//			cal.setTime(date);
//			beginTime=sdf.format(cal.getTime());
//			System.out.println("beginTime=="+beginTime);
//			cal.add(Calendar.MINUTE, 15);
//			endTime=sdf.format(cal.getTime());
//			System.out.println("endTime=="+endTime);
////			messageTime.setTime(beginTime);
////			messageTime.setCnt(diagnosticsDao.getMessageGroupTime2(beginTime, endTime).get(0).getCnt());
//			date=cal.getTime();
////			frist=cal.getTime();
////			messageTimes.add(messageTime);
//		}
	}


}
