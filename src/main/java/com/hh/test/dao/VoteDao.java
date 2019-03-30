package com.hh.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hh.test.pojo.vote.Candidate;
import com.hh.test.pojo.vote.PartmentCnt;
import com.hh.test.pojo.vote.VoteReuslt;
import com.hh.test.pojo.vote.Votor;

public interface VoteDao {

	
	List<Candidate> getCandidateById(@Param("starType") String starType);

	/**
	 * 被投人员入库
	 * @param voteReuslt
	 */
	void setVote(VoteReuslt voteReuslt);

	List<PartmentCnt> getVotePartment();

	List<PartmentCnt> candidateTop10();

	List<Votor> getVotorByName(@Param("userName") String userName);

	List<VoteReuslt> getVotedByName(@Param("userName") String userName);

}
