package com.hh.test.dao;

import java.util.List;

import com.hh.test.pojo.pd1000.Pdduration;
import com.hh.test.pojo.pd1000.Pdduration2;

public interface Pd1000Dao {

	
	List<Pdduration> getDuration();
	List<Pdduration> getPlaying();
	List<Pdduration2> getDurationDistic();
	void insertPdduration2(Pdduration2 pdduration2);
	void insertPdduration3(Pdduration2 pdduration2);
	void insertPdduration4(Pdduration2 pdduration2);
	void insertPlaying3(Pdduration2 pdduration2);
	List<Pdduration2> getPlayingDistic();
	void insertPlaying4(Pdduration2 pdduration2);
}
