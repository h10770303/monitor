package com.hh.test.manager;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hh.test.pojo.diagnostics.Message;
import com.hh.test.pojo.diagnostics.MessageShow;
import com.hh.test.pojo.diagnostics.MessageTime;
import com.hh.test.pojo.diagnostics.Record;
import com.hh.test.util.SearchType;

@Service
public interface DiagnosticsManager {

	
	int insertMessage(String xmlPath,String xmlPath2) throws ParseException,FileNotFoundException;

	int getMessageCnt(SearchType searchType);

	List<Message> getMessageBySearchType(SearchType searchType);

	List<MessageShow> analysisFile(String time,String time2,String id);

	List<MessageTime> messageGroupTime(String step)throws ParseException;

}
