package com.hh.test.manager;

import java.util.List;

import com.hh.test.dao.entity.Xt_applyColum;
import com.hh.test.dao.entity.Xt_leader;

public interface LeaderManager {

	int getLeaderListToal(int page, int rows, String userName, String channel);

	List<Xt_leader> getLeaderList(int page, int rows, String userName, String channel);

	int getColumListToal(int page, int rows, String columName);

	List<Xt_applyColum> getColumList(int page, int rows, String columName);

	void addLeader(Xt_leader leader);


}
