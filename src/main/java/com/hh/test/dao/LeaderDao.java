package com.hh.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hh.test.dao.entity.Xt_leader;

public interface LeaderDao {


	List<Xt_leader> getChannel();
	List<Xt_leader> getLeaderByChannel(@Param("channel")String channel);
	void addLeader(Xt_leader leader);
	List<Xt_leader> getLeaderList(@Param("page")int page, @Param("rows")int rows, @Param("userName")String userName,@Param("channels") String channel);
	void delLeader(@Param("id")String id);

}
