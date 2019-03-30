package com.hh.test.manager;

import java.util.Map;

import com.hh.test.pojo.rundown.RunMsgParam;
import com.hh.test.pojo.rundown.TestRunMsg;
import com.hh.test.pojo.weixin.OpenId;

public interface RunDownManager {

	OpenId getOpenIdById(String openId);
	
	String buildResponseMessage(Map<String, String> map);

	TestRunMsg getTestRunMsg(RunMsgParam msgParam);
}
