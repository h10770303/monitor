package com.hh.test.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hh.test.manager.UserManager;

@Controller
public class UserController {

	Logger log = LoggerFactory.getLogger(getClass());

	@Resource
	private UserManager userManager;

	/**
	 * 根据user用户重新定义组织机构  失败
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/setOrganLevel")
	public void setOrganLevel(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入setOrganLevel");
		userManager.setOrganLevel();
		
	}
	
	/**
	 * 第二种方式
	 * @param req
	 * @param resp
	 */
	@ResponseBody
	@RequestMapping("/setUser")
	public void setUser(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入setUser");
		userManager.setUser();
		
	}

	
}
