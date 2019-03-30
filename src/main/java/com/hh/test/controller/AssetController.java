package com.hh.test.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hh.test.manager.AssetManager;
import com.hh.test.pojo.AssetXnews;

@Controller
public class AssetController {

	Logger log = LoggerFactory.getLogger(getClass());

	@Resource
	private AssetManager assetManager;

	/**
	 * 获取所有资产
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAssetXnews")
	public String getAssetXnews(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入getAssetXnews");
		List<AssetXnews> assetXnewss=new ArrayList<AssetXnews>();
		assetXnewss=assetManager.getAssetXnews();
		log.info(assetXnewss.toString());
		return "index";
	}

	/**
	 * 插入新的资产
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/insertAssetXnews")
	public String insertAssetXnews(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入insertAssetXnews");
		AssetXnews assetXnews=new AssetXnews();
		assetXnews.setAssetName("hhtest0531");
		assetXnews.setAssetSite("区县台");
		assetXnews.setAssetType("cule");
		assetXnews.setTime(new Date());
		assetManager.insertAssetXnews(assetXnews);
		return "index";
	}

	/**
	 * 删除指定资产
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteAssetXnews")
	public String deleteAssetXnews(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入insertAssetXnews");
		assetManager.deleteAssetXnews("hhtest0531");
		return "index";
	}

	/**
	 * 查找指定资产
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
//	@ResponseBody   返回页面无
	@RequestMapping("/findAssetXnews")
	public String findAssetXnews(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入insertAssetXnews");
		AssetXnews assetXnews=new AssetXnews();
		String assetName="hhtest0531";
		assetXnews=assetManager.findAssetXnews(assetName);
		log.info("assetXnews=="+assetXnews);
		return "map";
	}
}
