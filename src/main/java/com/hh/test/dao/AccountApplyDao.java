package com.hh.test.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hh.test.dao.entity.Xt_Apply;

public interface AccountApplyDao {

	void toApply(Xt_Apply xt_Apply);

	List<Xt_Apply> getAppList(@Param("page") int page, @Param("rows") int rows, @Param("applyName") String applyName,
			@Param("name_pinyin") String name_pinyin, @Param("status") int status);

	List<Xt_Apply> getApplyById(@Param("id")String id);

	int updateApplyById(@Param("id")String id,@Param("status")int status,@Param("user")String user,@Param("date")Date date);

	int updateApply(@Param("id")String id, @Param("status")int status, @Param("accountType")String accountType, @Param("inews")String inews, @Param("videos")String videos,
			@Param("xnews")String xnews, @Param("date")Date date);


}
