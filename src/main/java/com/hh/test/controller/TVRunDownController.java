package com.hh.test.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hh.test.manager.MonitorManager;
import com.hh.test.pojo.RunDown;
import com.hh.test.pojo.RunDownRestult;
import com.hh.test.pojo.param.RundownType;
import com.hh.test.util.MultiThreadedHttpClient;
import com.hh.test.util.PageResult;

/**
 * 北京台 电视节目发布单
 * @author smg
 *
 */
@Controller
public class TVRunDownController {

	Logger log = LoggerFactory.getLogger(getClass());
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Resource
	private MonitorManager monitorManager;

	/**
	 * 电视节目串联单Jsp
	 * 
	 * @param response
	 */
	@RequestMapping("/rundowJsp.do")
	public String rundownjsp(HttpServletResponse resp) {
		log.info("进入电视节目串联单rundowJsp");

		return "rundown/rundown";
	}

	/**
	 * 电视节目串联单
	 * 
	 * @param response
	 */
	@RequestMapping("/rundown.do")
	@ResponseBody
	public PageResult<RunDown> rundown(@RequestBody RundownType rundownType,
			HttpServletResponse resp) {

		String cName=rundownType.getcName();
		PageResult<RunDown>pageResult=new PageResult<>();
		RunDownRestult runDownRestult = null;
		List<RunDown> runDowns =new ArrayList<RunDown>();
		String url = "http://api.avatardata.cn/TVTime/TVlist?key=69f8b0e41acc40ddb81b4f46f3c922d3&code="+cName+"&date=";
		HttpGet method = new HttpGet(url);
		CloseableHttpClient httpClient = MultiThreadedHttpClient.getInstance4();
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(method);
			HttpEntity resEntity = response.getEntity();
			ObjectMapper mapper = new ObjectMapper();
			runDownRestult = mapper.readValue(EntityUtils.toString(resEntity), RunDownRestult.class);
			runDowns=runDownRestult.getResult();
			pageResult.setRecords(runDowns);
			pageResult.setTotal(runDowns.size());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return pageResult;
	}

	public static void main(String[] args) {

		String url = "http://api.avatardata.cn/TVTime/TVlist?key=69f8b0e41acc40ddb81b4f46f3c922d3&code=cctv1&date=";
		HttpGet method = new HttpGet(url);
		CloseableHttpClient httpClient = MultiThreadedHttpClient.getInstance4();
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(method);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		HttpEntity resEntity = response.getEntity();
		int code = response.getStatusLine().getStatusCode();
		System.out.println("code==" + code);
		System.out.println(resEntity.getContentLength());
		try {

			ObjectMapper mapper = new ObjectMapper();
			RunDownRestult runDownRestult = mapper.readValue(EntityUtils.toString(resEntity), RunDownRestult.class);
			System.out.println(runDownRestult);

		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
