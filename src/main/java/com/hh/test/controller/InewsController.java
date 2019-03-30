package com.hh.test.controller;

import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hh.test.manager.RunDownManager;
import com.hh.test.pojo.rundown.RunMsgParam;
import com.hh.test.pojo.rundown.TestRunMsg;
import com.hh.test.util.JsonResult;

/**
 * 上视技术科试机记录信息
 * 
 * @author smg
 *
 */
@Controller
public class InewsController {

	Logger log = LoggerFactory.getLogger(getClass());
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	

	@Resource
	private RunDownManager rundownManager;

	

	@RequestMapping("/testRun")
	public String testRun(HttpServletRequest req, HttpServletResponse resp, Model model) {
		return "show/inews/testRun";
	}
	
	
	/**
	 * 展示试机详细信息
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping("/testRunMsg")
	@ResponseBody
	public JsonResult<TestRunMsg> testRunMsg(@RequestBody RunMsgParam msgParam,  HttpServletRequest req, HttpServletResponse resp, Model model) {
		TestRunMsg result=rundownManager.getTestRunMsg(msgParam);
		return new JsonResult<TestRunMsg>(result).success();
	}
	
	
	
	

}
