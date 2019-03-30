package com.hh.test.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hh.test.pojo.weixin.OpenId;
import com.hh.test.pojo.weixin.OpenIdLog;

public interface RunDownDao {

	OpenId getOpenIdById(@Param("openId") String openId);

	void insertOpenIdLog(OpenIdLog openIdLog);

	List<OpenIdLog> getOpenIdLogByDate(@Param("date")String date);
	

}
