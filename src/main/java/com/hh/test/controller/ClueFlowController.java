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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hh.test.manager.MonitorManager;
import com.hh.test.manager.ToXnewsManager;
import com.hh.test.pojo.AssetByTime;
import com.hh.test.pojo.bean.DashBord;
import com.hh.test.pojo.bean.ProgramFlowBean;
import com.hh.test.util.JsonResult;
import com.hh.test.util.SearchType;
import com.hh.test.util.SearchXnews;

/**
 * xnews 监控
 * @author smg
 *
 */
@Controller
public class ClueFlowController {

	Logger log = LoggerFactory.getLogger(getClass());
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Resource
	private MonitorManager monitorManager;

	@Resource
	private ToXnewsManager toXnewsManager;

	/**
	 * avid反推xnews 监控页面
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/avidToXnews")
	public String avidToXnews(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入avidToXnews");
		return "show/avidxnews";
	}
	
	/**
	 * 查询avidtoxnews流程信息
	 * @param searchType
	 * @param req
	 * @param resp
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getAvidToXnewFlow", method = RequestMethod.POST)
	public List<ProgramFlowBean> getAvidToXnewFlow(@RequestBody SearchType searchType, HttpServletRequest req,
			HttpServletResponse resp) {
		log.info("进入getMonitorConfFlow,pageNo={}", searchType);
		List<ProgramFlowBean> programFlowBeansPage = toXnewsManager.getProgramFlowBeanBySearchType(searchType);
		return programFlowBeansPage;
	}
	
	/**
	 * xnews监控页面首页
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/index")
	public String getIndex(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入xnews监控index页面");
		return "show/index";
	}

	/**
	 * 获取线索、选题、报道的数量
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getClueFlow")
	public JsonResult<Map<String, Integer>> getAsset(@RequestBody SearchType maps,HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入getClueFlow json{}",maps);
		List<AssetByTime> assetByTimes = new ArrayList<AssetByTime>();
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		String beginTime = sdf.format(date);
		String endTime = sdf.format(cal.getTime());
		System.out.println("getClueFlow beginTime=" + beginTime);
		System.out.println("getClueFlow endTime=" + endTime);
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
	 * xnews监控首页数据获取
	 */
	@ResponseBody
	@RequestMapping(value="/getDashBord",method=RequestMethod.POST)
	public JsonResult<DashBord> getDashBord(@RequestBody SearchXnews searchXnews ){
		DashBord dashBord=new DashBord();
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		String beginTime = sdf.format(date);
		String endTime = sdf.format(cal.getTime());
		System.out.println("getDashBord beginTime=" + beginTime);
		System.out.println("getDashBord endTime=" + endTime);
		searchXnews.setStartDt(beginTime);
		searchXnews.setEndDt(endTime);
	    dashBord=monitorManager.getDashBord(searchXnews);
		return new JsonResult<DashBord>(dashBord).success();
	}
	
}
