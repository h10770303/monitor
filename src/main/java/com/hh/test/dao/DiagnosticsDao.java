package com.hh.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hh.test.pojo.diagnostics.Message;
import com.hh.test.pojo.diagnostics.MessageTime;
import com.hh.test.util.SearchType;

public interface DiagnosticsDao {

	int insertMessage(Message message);
	Message findMessage(Message message);
	void updateMessageTime(Message message);
	int getMessageCnt(SearchType searchType);
	
	
	List<Message> messageGroupId();
	List<MessageTime> getMessageGroupTime();
	List<MessageTime> getMessageGroupTime2(@Param("beginTime") String beginTime,@Param("endTime") String endTime);
	List<Message> getMessageById(@Param("id") String id);
	List<Message> getMessageAll();
	

}
