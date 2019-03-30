package com.hh.test.scheduler;

import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hh.test.manager.VoteManager;

@Service("candidateScheduler")
public class CandidateScheduler {

	Logger log = LoggerFactory.getLogger(getClass());
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Resource
	private VoteManager voteManager;;

	public void getCandicate() {
//		log.info("定时任务中心投票系统："+new Date());
//		voteManager.getVotorByName("01002169");
	}
	
	

}
