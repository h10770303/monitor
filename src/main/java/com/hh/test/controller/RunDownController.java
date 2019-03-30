package com.hh.test.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.hh.test.manager.RunDownManager;
import com.hh.test.pojo.rundown.RunDown;
import com.hh.test.pojo.weixin.WeChatQRCode;
import com.hh.test.servlet.CacheClass;
import com.hh.test.util.HttpRequestUtil;
import com.hh.test.util.JsonResult;
import com.hh.test.util.SHA1;
import com.hh.test.util.WeiXinGZH;
import com.hh.test.util.WeiXinUtil;

/**
 * 上海早晨串联单发布
 * 
 * @author smg
 *
 */
@Controller
public class RunDownController {

	Logger log = LoggerFactory.getLogger(getClass());
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	@Value("${appID}")
	private String appID;
	private static String Token = "hmw2018";
	private String checked = null;
	@Value("${shzc.checked}")
	private String ischecked;

	@Resource
	private RunDownManager rundownManager;

	@RequestMapping(value = "/wx", method = RequestMethod.GET)
	@ResponseBody
	public void getWeixin(HttpServletRequest request, HttpServletResponse response, Model model) {

		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");

		List<String> params = new ArrayList<String>();
		params.add(Token);
		params.add(timestamp);
		params.add(nonce);
		// 1. 将token、timestamp、nonce三个参数进行字典序排序
		Collections.sort(params, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		// 2. 将三个参数字符串拼接成一个字符串进行sha1加密
		String temp = SHA1.encode(params.get(0) + params.get(1) + params.get(2));
		if (temp.equals(signature)) {
			try {
				response.getWriter().write(echostr);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("没有传回去数据，");
		}
		log.info("token验证通过。");
	}

	/**
	 * 微信登陆认证
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/wx", method = RequestMethod.POST)
	public void getWeixinPost(HttpServletRequest request, HttpServletResponse response, Model model)
			throws IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String responseMessage;
		try {
			Map<String, String> map = WeiXinUtil.parseXml(request);
			responseMessage = rundownManager.buildResponseMessage(map);
			log.info("responseMessage=" + responseMessage);
			if (responseMessage.equals("")) {
				responseMessage = "未正确响应";
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseMessage = "未正确响应";
		}

		if (responseMessage.contains("验证通过")) {
			checked = "1";
		} else {
			checked = "0";

		}
		response.getWriter().println(responseMessage);

	}

	@RequestMapping(value = "/hasChecked", method = RequestMethod.GET)
	@ResponseBody
	public JsonResult<String> hasChecked(HttpServletRequest request, HttpServletResponse response, Model model)
			throws IOException {
		log.info("扫描二维码是否验证,checked===" + checked);
		return new JsonResult<String>(checked).success();

	}

	@RequestMapping("/wxcode")
	public String wxcode(HttpServletRequest req, HttpServletResponse resp, Model model) {
		checked = null;
		return "rundown/wxcode";
	}
	@RequestMapping("/sweep")
	public String sweep(HttpServletRequest req, HttpServletResponse resp, Model model) {
		checked = null;
		return "rundown/sweep";
	}

	/**
	 * 获取二维码页面
	 * 
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping("/getWxCode")
	@ResponseBody
	public JsonResult<String> getWxCode(HttpServletRequest req, HttpServletResponse resp, Model model) {
		WeChatQRCode qrCode = null;
		String token = CacheClass.getCache("accessToken");
		String createUrl = "https://api.weixin.qq.com/cgi-bin/qrcode/create";
		TreeMap<String, String> params = new TreeMap<String, String>();
		params.put("access_token", token);
		Map<String, Integer> intMap = new HashMap<String, Integer>();
		intMap.put("scene_id", 123);
		Map<String, Map<String, Integer>> mapMap = new HashMap<String, Map<String, Integer>>();
		mapMap.put("scene", intMap);
		//
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("expire_seconds", 604800);
		paramsMap.put("action_name", "QR_SCENE");
		paramsMap.put("action_info", mapMap);
		String data = new Gson().toJson(paramsMap);
		data = HttpRequestUtil.HttpsDefaultExecute(HttpRequestUtil.POST_METHOD, createUrl, params, data);
		try {
			qrCode = new Gson().fromJson(data, WeChatQRCode.class);
		} catch (JsonSyntaxException e) {
			qrCode = null;
			e.printStackTrace();
		}

		model.addAttribute("ticket", qrCode.getTicket());
		String reuslt = qrCode == null ? null : qrCode.getTicket();
		checked = null;
		return new JsonResult<String>(reuslt).success();
	}
	
	/**
	* 获取签名算法
	*/
	@RequestMapping("/getSign")
	@ResponseBody
	public JSONObject getSign(String url){
	JSONObject jsonObject=new JSONObject();
	System.out.println("url=="+url);
	Map<String, String> ret =WeiXinGZH.sign(url);
	System.out.println("map="+ret.toString());
	jsonObject.put("weixin", ret);
	return jsonObject;
	}
	
	

	/**
	 * 上海早晨串联单展示页面
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/shzc")
	public String getshzc(HttpServletRequest req, HttpServletResponse resp, Model model) {
		System.out.println(ischecked);
		if (("true").equals(ischecked)) {
			String ip = req.getRemoteAddr();
			log.info("进入shzc,访问用户的ip:" + ip);
			if (checked != null) {
				return "rundown/shzc";
			} else {
				return "rundown/nopermit";
			}
		} else {
			return "rundown/shzc";

		}
	}

	/**
	 * 上海早晨串联单登录查询页面
	 * 
	 * @param req
	 * @param resp
	 * @param model
	 * @return
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest req, HttpServletResponse resp, Model model) {
		return "rundown/login";
	}

	@RequestMapping("/nopermit")
	public String nopermit(HttpServletRequest req, HttpServletResponse resp, Model model) {
		return "rundown/nopermit";
	}

	/**
	 * 上海早晨串联单实时查询
	 * 
	 * @param response
	 */
	@RequestMapping("/islogin.do")
	@ResponseBody
	public JsonResult<String> islogin(@RequestParam("userName") String userName, HttpServletResponse resp) {
		try {
			log.info("userName==" + URLDecoder.decode(userName, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new JsonResult<String>().success();

	}

	/**
	 * 上海早晨串联单实时查询
	 * 
	 * @param response
	 */
	@RequestMapping("/getshzc.do")
	@ResponseBody
	public JsonResult<RunDown> getshzc(@RequestParam("cName") String cName, HttpServletResponse resp) {
		// Z:\xwfschedule\stv.szzc
		// Z:\xwfschedule\stv.szzc0700
		// Z:\xwfschedule\stv.szzc0830
		String path = "Z:\\xwfschedule\\stv.";
		if (!("").equals(cName)) {
			path = path + cName;
		}

		Date date = new Date();
		String xmlName = sdf.format(date) + ".xml";
		path = path + "\\" + xmlName;
		log.info("当前串联地址为：" + path);

		File file = new File(path);
		if (!file.exists()) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, -1);
			xmlName = sdf.format(cal.getTime()) + ".xml";
			path = "";
			path = "Z:\\xwfschedule\\stv." + cName + "\\" + xmlName;
			log.info("获取前一天的串联单地址：" + path);
		}

		RunDown runDown = new RunDown();
		try {
			runDown = JAXB.unmarshal(new FileInputStream(path), RunDown.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return new JsonResult<RunDown>().fail(1, e.getMessage());
		}

		return new JsonResult<RunDown>(runDown).success();
	}
	
	@RequestMapping("/wechat/jsapisign.do")
	@ResponseBody
	public JsonResult<RunDown> jsapisign( HttpServletResponse resp) {
		
		return new JsonResult<RunDown>().success();
	}

	
}
