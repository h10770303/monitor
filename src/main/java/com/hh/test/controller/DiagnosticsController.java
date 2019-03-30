package com.hh.test.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hh.test.manager.DiagnosticsManager;
import com.hh.test.pojo.diagnostics.Log;
import com.hh.test.pojo.diagnostics.Message;
import com.hh.test.pojo.diagnostics.MessageShow;
import com.hh.test.pojo.diagnostics.MessageTime;
import com.hh.test.pojo.diagnostics.ParamPojo;
import com.hh.test.pojo.diagnostics.Record;
import com.hh.test.util.JsonResult;
import com.hh.test.util.PageResult;
import com.hh.test.util.SearchType;

@Controller
public class DiagnosticsController {

	Logger log = LoggerFactory.getLogger(getClass());
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Resource
	private DiagnosticsManager diagnosticsManager;

	/**
	 *上传文件页面
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/uploadlog")
	public String uploadlog(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入uploadlog");
		return "show/logshow/upload";
	}
	
	/**
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/logshow")
	public String logshow(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入logshow");
		return "show/logshow/logshow";
	}
	
	/**
	 * showlog 展示log
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/showlog", method = RequestMethod.POST)
	public PageResult<Message> showlog(@RequestBody SearchType searchType, HttpServletRequest req,
			HttpServletResponse resp) {
		log.info("进入showlog,pageNo={}", searchType);
		 PageResult<Message> pageResult = new PageResult<>();
		 int cnt=diagnosticsManager.getMessageCnt(searchType);
		 List<Message> messages=diagnosticsManager.getMessageBySearchType(searchType);
//		int cnt=toXnewsManager.getProgramFlowBeanBySearchTypeCnt(searchType);
//		List<ProgramFlowBean> programFlowBeansPage = toXnewsManager.getProgramFlowBeanBySearchType(searchType);
//		pageResult.setTotal(cnt);
//		pageResult.setRecords(programFlowBeansPage);
		return pageResult;
	}
	
	
	/**
	 * 上传文件入库过程
	 * @param resp
	 * @return
	 * @throws FileNotFoundException 
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/dealfile", method = RequestMethod.GET)
	@ResponseBody
	public JsonResult<String> dealfile(HttpServletResponse resp) throws FileNotFoundException, ParseException {
		log.info("进入dealfile");
		long time=System.currentTimeMillis();
		String xmlPath = "C:\\Users\\smg\\Desktop\\2018081401.alf";
		String xmlPath2 = "C:\\Users\\smg\\Desktop\\2018081402.alf";
		diagnosticsManager.insertMessage(xmlPath,xmlPath2);
		long time2=System.currentTimeMillis();
		System.out.println("message入库耗时："+(time2-time));
		return new JsonResult<String>().success();
	}
	
	
	
	
	/**
	 * 对日志进行分析
	 * @param resp
	 * @return
	 * @throws FileNotFoundException
	 * @throws ParseException
	 */
	@RequestMapping(value = "/analysisFile", method = RequestMethod.GET)
	@ResponseBody
	public JsonResult<List<MessageShow>> analysisFile(String time,String time2,String id,HttpServletResponse resp) throws FileNotFoundException, ParseException {
		log.info("进入analysisFile"+time+time2+id);
		List<MessageShow> messageShows=new ArrayList<>();
		messageShows =diagnosticsManager.analysisFile(time,time2,id);
//		log.info(messageShows.toString());
		return new JsonResult<List<MessageShow>>(messageShows).success();
	}
	
	/**
	 * 对日志安装时间进行分析
	 * @param resp
	 * @return
	 * @throws FileNotFoundException
	 * @throws ParseException
	 */
	@RequestMapping(value = "/messageGroupTime", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult<List<MessageTime>> messageGroupTime(@RequestBody ParamPojo paramPojo,HttpServletResponse resp) throws FileNotFoundException, ParseException {
		log.info("进入messageGroupTime");
		List<MessageTime> messageTimes=new ArrayList<>();
		messageTimes =diagnosticsManager.messageGroupTime(paramPojo.getStep());
//		log.info(messageTimes.toString());
		return new JsonResult<List<MessageTime>>(messageTimes).success();
	}
	
	
	
	
	
	
	public static void main(String[] args) throws FileNotFoundException, ParseException {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS 'GMT'",Locale.US);
		
		Date dates=new Date();
		System.out.println(sdf.format(dates));
		
		Log log = new Log();
		String xmlPath = "C:\\Users\\smg\\Desktop\\20171229\\20171229.alf";
		log = JAXB.unmarshal(new FileInputStream(xmlPath), Log.class);
		// FileReadUtils.txt2String(new
		// File("C:\\Users\\smg\\Desktop\\StudioD-1-AMSIntegrationService-20171229.002149.00.alf"));

		List<Record> records = log.getRecords();
		List<Message> messages = new ArrayList<>();
		for (Record record : records) {
			if (record.getMessage().contains("Limits")) {
				String message = record.getMessage();
				String[] messageSplit = message.split(",");
				Message msg = new Message();
				msg.setId(messageSplit[0].substring(messageSplit[0].indexOf(":")+2));
				msg.setLimits(messageSplit[1].substring(messageSplit[1].indexOf(":")+2));
				msg.setMarks(messageSplit[2].substring(messageSplit[2].indexOf(":")+2));
				msg.setDuration(messageSplit[3].substring(messageSplit[3].indexOf(":")+2));
				msg.setHostName(record.getHostname());
				msg.setTime(sdf.parse(record.getSyncdate()));
				messages.add(msg);

			}
		}
		
		System.out.println(messages);
		
	}
}
