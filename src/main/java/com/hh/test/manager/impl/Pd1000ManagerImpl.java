package com.hh.test.manager.impl;

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

import com.hh.test.dao.Pd1000Dao;
import com.hh.test.db.CustomerContextHolder;
import com.hh.test.manager.Pd100Manager;
import com.hh.test.pojo.pd1000.Pdduration;
import com.hh.test.pojo.pd1000.Pdduration2;
import com.hh.test.util.DateUtil;

@Service
public class Pd1000ManagerImpl implements Pd100Manager {

	Logger log = LoggerFactory.getLogger(getClass());

	@Resource
	private Pd1000Dao pd1000Dao;

	@Override
	public List<Pdduration> getPd1000() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		List<Pdduration> durations=pd1000Dao.getDuration();
		for (Pdduration pdduration : durations) {
			String dpdate=pdduration.getPddate();
			String dptime=pdduration.getPdtime();
			double diff=0;
			try {
				Date pdDate=sdf.parse(dpdate+" "+dptime);
				Date durationDate=sdf.parse(pdduration.getDate()+" "+pdduration.getTime());
				Calendar cal=Calendar.getInstance();
				cal.setTime(durationDate);
				cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY)+8);
				diff=(pdDate.getTime()-cal.getTime().getTime())/1000.0;
				CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
				Pdduration2 pdduration2=new Pdduration2();
				pdduration2.setPdDate(pdDate);
				pdduration2.setDurationDate(cal.getTime());
				pdduration2.setContent(pdduration.getContent());
				pdduration2.setDiff(diff);
				pdduration2.setDuration(pdduration.getDuration());
				pd1000Dao.insertPdduration2(pdduration2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return null;
	}
	
	

	
	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date pdDate = null;
		try {
			pdDate = sdf.parse("2019/1/3 15:08:55");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(pdDate.getHours());
	}




	@Override
	public List<Pdduration2> getPd1000Distic() {
		List<Pdduration2> list=pd1000Dao.getDurationDistic();
		List<String> contents=new ArrayList<>();
		for (Pdduration2 pdduration2 : list) {
			String content=pdduration2.getContent()+"|"+pdduration2.getDuration();
			if(!contents.contains(content)){
				contents.add(content);
				CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
				pd1000Dao.insertPdduration4(pdduration2);
			}
		}
		return null;
	}




	@Override
	public List<Pdduration> getPlaying() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		List<Pdduration> playings=pd1000Dao.getPlaying();
		for (Pdduration pdduration : playings) {
			try {
				Date durationDate=sdf.parse(pdduration.getDate()+" "+pdduration.getTime());
				Calendar cal=Calendar.getInstance();
				cal.setTime(durationDate);
				cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY)+8);
				CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
				Pdduration2 pdduration2=new Pdduration2();
				pdduration2.setDurationDate(cal.getTime());
				pdduration2.setContent(pdduration.getContent());
				pd1000Dao.insertPlaying3(pdduration2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}




	@Override
	public List<Pdduration2> getPlayingDistic() {
		List<Pdduration2> list=pd1000Dao.getPlayingDistic();
		List<String> contents=new ArrayList<>();
		for (Pdduration2 pdduration2 : list) {
			Date date=pdduration2.getDurationDate();
			int hour=date.getHours();
			int min=date.getMinutes();
			if(((hour>=18&&hour<20))||(hour==12)){
				String content=pdduration2.getContent();
				if(!contents.contains(content)){
					contents.add(content);
					CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
					pd1000Dao.insertPlaying4(pdduration2);
				}
			}else if(hour>=22){
				if(min>=30){
					String content=pdduration2.getContent();
					if(!contents.contains(content)){
						contents.add(content);
						CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
						pd1000Dao.insertPlaying4(pdduration2);
					}
				}
			}
			
		}
		return null;
	}

	
}
