package com.hh.test.manager;

import java.util.List;

import com.hh.test.dao.entity.Xt_Apply;
import com.hh.test.pojo.ApplyInfo;

public interface AccountManager {

	void toApply(ApplyInfo applyInfo, String flag);

	int getApplyListToal(int page,int rows,String applyName,String name_pinyin,int status);

	List<Xt_Apply> getApplyList(int page,int rows,String applyName,String name_pinyin,int status);

	ApplyInfo getApplyById(String id);

	int updateApplyById(String id,String finsher);

	int updateApply(ApplyInfo applyInfo);

}
