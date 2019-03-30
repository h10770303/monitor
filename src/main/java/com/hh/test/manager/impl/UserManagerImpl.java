package com.hh.test.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hh.test.dao.AssetDao;
import com.hh.test.dao.UserDao;
import com.hh.test.db.CustomerContextHolder;
import com.hh.test.manager.UserManager;
import com.hh.test.pojo.user.OrganLevel;
import com.hh.test.pojo.user.Organization;
import com.hh.test.pojo.user.User;
import com.hh.test.pojo.user.User2;
import com.hh.test.pojo.user.UserPojo;

@Service
public class UserManagerImpl implements UserManager {

	Logger log = LoggerFactory.getLogger(getClass());

	@Resource
	private UserDao userDao;

	@Override
	public void setOrganLevel() {

		insertOrganLevel("", 1);
	}
	
	private void insertOrganLevel(String parentId,int level){
		List<Organization> organizations=new ArrayList<>();
		organizations=userDao.getOrganizationByParentId(parentId);
		for (Organization organization : organizations) {
			OrganLevel organLevel=new OrganLevel();
			organLevel.setOrganizationId(organization.getOrganizationId());
			organLevel.setOrganizationName(organization.getOrganizationName());
			organLevel.setOrganizationType(organization.getOrganizationType());
			organLevel.setLevel(level);
			userDao.insertOrgnLevel(organLevel);
			
			insertOrganLevel(organization.getOrganizationId(), level++);
		}
	}

	
	@Override
	public void setUser() {
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		List<UserPojo> userPojos=userDao.getUserPojo();
		for (UserPojo userPojo : userPojos) {
			User2 user2=new User2();
			insertUser2(user2,userPojo.getParentId());
			System.out.println("=======|||"+user2);
			if(user2.getOrganizationId()==null){
				user2.setOrganizationId(userPojo.getOrganizationId());
				user2.setOrganizationName(userPojo.getOrganizationName());
			}
			user2.setUserId(userPojo.getUserId());
			user2.setUserName(userPojo.getUserName());
			user2.setCreateDate(new Date());
			CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
			System.out.println("user2=="+user2);
			userDao.insertUser2(user2);
		}
		
	}

	private void insertUser2(User2 user2,String id){
		Organization organization=new Organization();
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		organization=userDao.getOrganizationById(id);
		System.out.println("id=="+id);
		System.out.println("organization=="+organization);
		if(organization!=null){
			if (("e341ddccde214791a57be2d9f8d6115f").equals(organization.getParentId())
					||("215b35c2a2d047f08f7bfb29a324d266").equals(organization.getParentId())
					||("a41383e284bb4e7d96c2adcd1c911a35").equals(organization.getParentId())
					||("608fbe5f17f44010ab1a966f544bdd8b").equals(organization.getParentId())) {
				user2.setOrganizationId(organization.getOrganizationId());
				user2.setOrganizationName(organization.getOrganizationName());
				System.out.println("user2reut=="+user2);
			}else{
				System.out.println("======"+organization.getParentId());
				insertUser2(user2,organization.getParentId());
			}
		}
		
	}

}
