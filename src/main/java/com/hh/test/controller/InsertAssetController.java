package com.hh.test.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hh.test.manager.MonitorManager;

/**
 * 从生产数据库获取数据插入临时数据库
 * @author smg
 *
 */
@Controller
public class InsertAssetController {

	Logger log = LoggerFactory.getLogger(getClass());
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Resource
	private MonitorManager monitorManager;

	/**
	 * 获取线索资源 并入库
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/insertAssetBytime")
	public String insertAssetBytime(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入insertAssetBytime");
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		String type = "clue";
		// String site="美联社";
		// String site="区县台视频";
		String[] sites = { "美联社", "路透社", "CPTN", "区县台视频", "报片" };
		String beginTime = sdf.format(date);
		String endTime = sdf.format(cal.getTime());
		System.out.println("beginTime=" + beginTime);
		System.out.println("endTime=" + endTime);
		for (int i = 0; i < sites.length; i++) {
			monitorManager.insertAssetBytime(type, sites[i], beginTime, endTime);
		}
		return "index";
	}


	
	
	/**
	 * 插入在线人数数据
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/insertLogin")
	public String insertLogin(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入insertLogin");
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		String type = "login";
		// String site="美联社";
		// String site="区县台视频";
		String beginTime = sdf.format(date);
		String endTime = sdf.format(cal.getTime());
		System.out.println("beginTime=" + beginTime);
		System.out.println("endTime=" + endTime);
		monitorManager.insertLogin(type, beginTime, endTime);
		return "index";
	}
}
