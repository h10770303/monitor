package com.hh.test.manager;

import java.util.List;

import com.hh.test.pojo.vote.Candidate;
import com.hh.test.pojo.vote.PartmentCnt;
import com.hh.test.pojo.vote.VotePojo;
import com.hh.test.pojo.vote.VoteReuslt;
import com.hh.test.pojo.vote.Votor;

public interface VoteManager {

	
	List<Candidate> getCandidateById(String startType);

	/**
	 * 投票记录
	 * @param votePojo
	 */
	void setVote(VotePojo votePojo);

	/**
	 * 推投票按照部门进行统计
	 * @return
	 */
	List<PartmentCnt> getVotePartment();

	/**
	 * 投票人数top10
	 * @return
	 */
	List<PartmentCnt> candidateTop10();

	/**
	 * 更加姓名查看投票人
	 * @param userName
	 * @return
	 */
	List<Votor> getVotorByName(String userName);

	List<VoteReuslt> getVotedByName(String userName);

}
