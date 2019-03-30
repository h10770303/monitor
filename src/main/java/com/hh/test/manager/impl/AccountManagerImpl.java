package com.hh.test.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.hh.test.dao.AccountApplyDao;
import com.hh.test.dao.RunDownDao;
import com.hh.test.dao.entity.Xt_Apply;
import com.hh.test.db.CustomerContextHolder;
import com.hh.test.manager.AccountManager;
import com.hh.test.pojo.ApplyInfo;
import com.hh.test.pojo.weixin.OpenIdLog;
import com.hh.test.util.ArraysUtil;
import com.hh.test.util.DateUtil;
import com.hh.test.util.UUIDRadom;

@Service
public class AccountManagerImpl implements AccountManager {

	Logger log = LoggerFactory.getLogger(getClass());

	@Resource
	private AccountApplyDao applyDao;
	@Resource
	private RunDownDao runDownDao;

	@Override
	public void toApply(ApplyInfo applyInfo, String flag) {
		Xt_Apply xt_Apply = new Xt_Apply();
		BeanUtils.copyProperties(applyInfo, xt_Apply);
		xt_Apply.setInews(ArraysUtil.Array2String(applyInfo.getInews()));
		xt_Apply.setVideos(ArraysUtil.Array2String(applyInfo.getVideos()));
		xt_Apply.setXnews(ArraysUtil.Array2String(applyInfo.getXnews()));
		xt_Apply.setStatus(Integer.parseInt(flag));
		xt_Apply.setCreateDate(new Date());
		xt_Apply.setId(UUIDRadom.getUUID());
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		System.out.println(xt_Apply);
		applyDao.toApply(xt_Apply);

	}

	@Override
	public int getApplyListToal(int page, int rows, String applyName, String name_pinyin, int status) {
		page = -1;
		List<Xt_Apply> applies = applyDao.getAppList(page, rows, applyName, name_pinyin, status);
		return applies.size();
	}

	@Override
	public List<Xt_Apply> getApplyList(int page, int rows, String applyName, String name_pinyin, int status) {
		page = (page - 1)*rows;
		List<Xt_Apply> applies = applyDao.getAppList(page, rows, applyName, name_pinyin, status);
		return applies;
	}

	@Override
	public ApplyInfo getApplyById(String id) {
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		List<Xt_Apply> list = applyDao.getApplyById(id);
		ApplyInfo applyInfo = new ApplyInfo();
		Xt_Apply xt_Apply = list.get(0);
		BeanUtils.copyProperties(xt_Apply, applyInfo);
		applyInfo.setInews(xt_Apply.getInews().split("、"));
		applyInfo.setVideos(xt_Apply.getVideos().split("、"));
		applyInfo.setXnews(xt_Apply.getXnews().split("、"));
		return applyInfo;
	}

	@Override
	public int updateApplyById(String id,String finsher) {
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		List<Xt_Apply> list = applyDao.getApplyById(id);
		Xt_Apply xt_Apply = list.get(0);
		int status = xt_Apply.getStatus();
		if(status!=2){
			return 0;
		}
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		int result = applyDao.updateApplyById(id, status+1, finsher, new Date());
		return result;
	}

	@Override
	public int updateApply(ApplyInfo applyInfo) {
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		List<Xt_Apply> list = applyDao.getApplyById(applyInfo.getId());
		Xt_Apply xt_Apply = list.get(0);
		int status = xt_Apply.getStatus();
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		List<OpenIdLog> openIdLogs = new ArrayList<>();
		openIdLogs = runDownDao.getOpenIdLogByDate(DateUtil.dateToString(new Date()));
		String user = openIdLogs.get(0).getAlias();
		if (xt_Apply.getStatus() == 1) {
			if (!(user).equals(xt_Apply.getLeaderName())) {
				return 0;
			}
		}
		int result = applyDao.updateApply(applyInfo.getId(), status, applyInfo.getAccountType(),
				ArraysUtil.Array2String(applyInfo.getInews()), ArraysUtil.Array2String(applyInfo.getVideos()),
				ArraysUtil.Array2String(applyInfo.getXnews()), new Date());
		return result;
	}
}
