package com.hh.test.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hh.test.dao.ApplyColumDao;
import com.hh.test.dao.LeaderDao;
import com.hh.test.dao.entity.Xt_Apply;
import com.hh.test.dao.entity.Xt_applyColum;
import com.hh.test.dao.entity.Xt_leader;
import com.hh.test.manager.LeaderManager;

@Service
public class LeaderManagerImpl implements LeaderManager {

	Logger log = LoggerFactory.getLogger(getClass());

	@Resource
	private LeaderDao leaderDao;
	
	@Resource
	private ApplyColumDao applyColumDao;

	@Override
	public int getLeaderListToal(int page, int rows, String userName, String channel) {
		page=-1;
		List<Xt_leader> leaders = leaderDao.getLeaderList(page, rows, userName, channel);
		return leaders.size();
	}

	@Override
	public List<Xt_leader> getLeaderList(int page, int rows, String userName, String channel) {
		page = (page - 1)*rows;
		List<Xt_leader> leaders = leaderDao.getLeaderList(page, rows, userName, channel);
		return leaders;
	}

	@Override
	public int getColumListToal(int page, int rows, String columName) {
		page =- 1;
		List<Xt_applyColum> colums = applyColumDao.getColumList(page, rows,columName);
		return colums.size();
	}

	@Override
	public List<Xt_applyColum> getColumList(int page, int rows, String columName) {
		page = (page - 1)*rows;
		List<Xt_applyColum> colums = applyColumDao.getColumList(page, rows,columName);
		return colums;
	}

	@Override
	public void addLeader(Xt_leader leader) {
		if(("技术").equals(leader.getChannel())){
			leader.setStatus(1);
		}
		leaderDao.addLeader(leader);
	}

	
}
