package com.hh.test.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hh.test.manager.Pd100Manager;
import com.hh.test.pojo.pd1000.Pdduration;
import com.hh.test.pojo.pd1000.Pdduration2;

/**
 * pd1000的测试
 * @author smg
 *
 */
@Controller
public class Pd1000Controller {

	Logger log = LoggerFactory.getLogger(getClass());

	@Resource
	private Pd100Manager pd1000Manager;

	
	@ResponseBody
	@RequestMapping("/getPd1000")
	public String getPd1000(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入getPd1000");
		List<Pdduration> list=new ArrayList<Pdduration>();
		list=pd1000Manager.getPd1000();
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/getPd1000Distic")
	public String getPd1000Distic(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入getPd1000Distic");
		List<Pdduration2> list=new ArrayList<Pdduration2>();
		list=pd1000Manager.getPd1000Distic();
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/getPlaying")
	public String getPlaying(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入getPlaying");
		List<Pdduration> list=new ArrayList<Pdduration>();
		list=pd1000Manager.getPlaying();
		return "index";
	}
	@ResponseBody
	@RequestMapping("/getPlayingDistic")
	public String getPlayingDistic(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入getPlayingDistic");
		List<Pdduration2> list=new ArrayList<Pdduration2>();
		list=pd1000Manager.getPlayingDistic();
		return "index";
	}

}
