package com.hh.test.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hh.test.manager.MapManager;

@Controller
public class MapController {

	Logger log = LoggerFactory.getLogger(getClass());

	@Resource
	private MapManager mapManager;


	/**
	 * 地图查询
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/mapJsp")
	public String mapJsp(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入mapJsp");
		return "map";
	}
	
	
	/**
	 * 获取数据
	 * @param req
	 * @param resp
	 * @return
	 */
    @ResponseBody  
	@RequestMapping("/findMap")
	public List<String> findMap(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入findMap");
		String deviceId="12号车沪JZ0739";
		List<String> lbss=mapManager.getDeviceLbsByDeviceId(deviceId);
		log.info("lbss=="+lbss);
		return lbss;
	}
}
