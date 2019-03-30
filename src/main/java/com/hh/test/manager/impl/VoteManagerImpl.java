package com.hh.test.manager.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hh.test.dao.VoteDao;
import com.hh.test.db.CustomerContextHolder;
import com.hh.test.manager.VoteManager;
import com.hh.test.pojo.vote.Candidate;
import com.hh.test.pojo.vote.PartmentCnt;
import com.hh.test.pojo.vote.Star;
import com.hh.test.pojo.vote.VotePojo;
import com.hh.test.pojo.vote.VoteReuslt;
import com.hh.test.pojo.vote.Votor;
import com.hh.test.util.UUIDRadom;

@Service
public class VoteManagerImpl implements VoteManager {

	Logger log = LoggerFactory.getLogger(getClass());

	@Resource
	private VoteDao voteDao;

	@Override
	public List<Candidate> getCandidateById(String starType) {
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		return voteDao.getCandidateById(starType);
	}

	@Override
	@Transactional
	public void setVote(VotePojo votePojo) throws RuntimeException {

		Star[] stars = votePojo.getStars();
		for (Star star : stars) {
			String[] candidates = star.getCandidate();
			for (String candidate : candidates) {
				VoteReuslt voteReuslt = new VoteReuslt();
				voteReuslt.setId(new UUIDRadom().getUUID());
				voteReuslt.setPartment(votePojo.getPartment());
				voteReuslt.setUserName(votePojo.getUserName());
				voteReuslt.setStarType(star.getStarType());
				voteReuslt.setCandidate(candidate);
				voteReuslt.setCreateTime(new Date());
				CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
				voteDao.setVote(voteReuslt);
			}
		}

	}

	@Override
	public List<PartmentCnt> getVotePartment() {
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		return voteDao.getVotePartment();
	}

	@Override
	public List<PartmentCnt> candidateTop10() {
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		return voteDao.candidateTop10();
	}

	@Override
	public List<Votor> getVotorByName(String userName) {
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		return voteDao.getVotorByName(userName);
	}

	@Override
	public List<VoteReuslt> getVotedByName(String userName) {
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		return voteDao.getVotedByName(userName);
	}


}
