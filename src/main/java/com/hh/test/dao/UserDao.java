package com.hh.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hh.test.pojo.user.OrganLevel;
import com.hh.test.pojo.user.Organization;
import com.hh.test.pojo.user.User2;
import com.hh.test.pojo.user.UserPojo;

public interface UserDao {

	List<Organization> getOrganizationByParentId(String parentId);

	void insertOrgnLevel(OrganLevel organLevel);

	List<UserPojo> getUserPojo();

	Organization getOrganizationById(@Param("parentId")String parentId);

	void insertUser2(User2 user2);
	

}
