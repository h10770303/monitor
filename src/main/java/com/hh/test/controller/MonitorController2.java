package com.hh.test.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hh.test.manager.MonitorManager;
import com.hh.test.pojo.AssetByTime;
import com.hh.test.util.JsonResult;

@Controller
public class MonitorController2 {

	Logger log = LoggerFactory.getLogger(getClass());
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Resource
	private MonitorManager monitorManager;

	

	/**
	 * 获取各资源数据
	 */
	@ResponseBody
	@RequestMapping("/getAssetBytime")
	public String getAssetBytime(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入getAssetBytime");
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		String[] types = { "clue", "topic", "title" };
		String site = "";
		String beginTime = sdf.format(date);
		String endTime = sdf.format(cal.getTime());
		System.out.println("beginTime=" + beginTime);
		System.out.println("endTime=" + endTime);
		for (int i = 0; i < types.length; i++) {
			monitorManager.insertClueBytime(types[i], site, beginTime, endTime);
			if (("clue").equals(types[i])) {
				site = "报片";
				monitorManager.insertClueBytime(types[i], site, beginTime, endTime);
			}
		}
		return "index";
	}

	/**
	 * 查询asset数据在页面上显示
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/getMonitor")
	public String getMonitor(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入getMonitor");
		return "monitor/node";
	}

	/**
	 * 获取线索、选题、报道的数量
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAsset")
	public JsonResult<Map<String, Integer>> getAsset(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入getAsset");
		List<AssetByTime> assetByTimes = new ArrayList<AssetByTime>();
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		String beginTime = sdf.format(date);
		String endTime = sdf.format(cal.getTime());
		System.out.println("beginTime=" + beginTime);
		System.out.println("endTime=" + endTime);
		assetByTimes = monitorManager.searchAsset(null, beginTime, endTime);
		int clue = 0, topic = 0, title = 0;
		Map<String, Integer> map =new HashMap<>();
		for (AssetByTime assetByTime : assetByTimes) {
			if (assetByTime.getType().equals("clue")) {
				clue+=assetByTime.getNumber();
				map.put("clue", clue);
			} else if (assetByTime.getType().equals("topic")) {
				topic+=assetByTime.getNumber();
				map.put("topic", topic);
			} else if (assetByTime.getType().equals("title")) {
				title+=assetByTime.getNumber();
				map.put("title", title);
			}
		}
		log.info("获取的数据：" + map);
		return new JsonResult<Map<String,Integer>>(map).success();
	}
	
	/**
	 * 获取各线索具体数据：全媒报片、区县台、cptn、美联社等。
	 * @param req
	 * @param resp
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAssetList")
	public JsonResult<Map<String, Integer>> getAssetList(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入getAssetList");
		List<AssetByTime> assetByTimes = new ArrayList<AssetByTime>();
		List<String> key=new ArrayList<String>();
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		String beginTime = sdf.format(date);
		String endTime = sdf.format(cal.getTime());
		System.out.println("beginTime=" + beginTime);
		System.out.println("endTime=" + endTime);
		assetByTimes = monitorManager.searchAsset(null, beginTime, endTime);
		Map<String, Integer> map =new HashMap<>();
		for (AssetByTime assetByTime : assetByTimes) {
			if (assetByTime.getType().equals("clue")) {
				map.put(assetByTime.getName(),assetByTime.getNumber());
				key.add(assetByTime.getName());
			}
		}
		System.out.println(map);
		return new JsonResult<Map<String,Integer>>(map).success();
	}
	
	/**
	 * 获取报道数量：电视报道数量、数字报道数量、送看看数量、
	 * @param req
	 * @param resp
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTitleList")
	public JsonResult<Map<String, Integer>> getTitleList(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入getAssetList");
		List<AssetByTime> assetByTimes = new ArrayList<AssetByTime>();
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		String beginTime = sdf.format(date);
		String endTime = sdf.format(cal.getTime());
		System.out.println("beginTime=" + beginTime);
		System.out.println("endTime=" + endTime);
		assetByTimes = monitorManager.searchAsset(null, beginTime, endTime);
		Map<String, Integer> map =new HashMap<>();
		for (AssetByTime assetByTime : assetByTimes) {
			if (assetByTime.getType().equals("title")) {
				map.put(assetByTime.getName(),assetByTime.getNumber());
			}
		}
		System.out.println(map);
		return new JsonResult<Map<String,Integer>>(map).success();
	}

}
