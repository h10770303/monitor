package com.hh.test.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

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

import com.hh.test.dao.ApplyColumDao;
import com.hh.test.dao.LeaderDao;
import com.hh.test.dao.entity.Xt_Apply;
import com.hh.test.dao.entity.Xt_applyColum;
import com.hh.test.dao.entity.Xt_leader;
import com.hh.test.manager.AccountManager;
import com.hh.test.manager.LeaderManager;
import com.hh.test.pojo.ApplyInfo;
import com.hh.test.util.JsonResult;
import com.hh.test.util.PageResult2;

/**
 * SMG融媒体中心制播系统账号申请
 * 
 * @author smg
 *
 */
@Controller
public class AcountApplyController {

	@Resource
	private AccountManager accountManager;
	@Resource
	private ApplyColumDao applyColumDao;
	@Resource
	private LeaderDao leaderDao;
	@Resource
	private LeaderManager leaderManager;

	Logger log = LoggerFactory.getLogger(getClass());

	@RequestMapping("/applyIndex")
	public String index(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入index");
		return "easyui/hh/index";
	}

	/**
	 * 账号申请页面
	 * 
	 * @return
	 */
	@RequestMapping("/apply")
	public String apply(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入apply");
		return "easyui/hh/apply";
	}

	@RequestMapping("/404")
	public String jsp404(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入404");
		return "404/404";
	}
	@RequestMapping("/applyWxcode")
	public String applyWxcode(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入applyWxcode");
		return "easyui/hh/wxcode";
	}
	@RequestMapping("/applyLeader")
	public String applyLeader(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入applyLeader");
		return "easyui/hh/applyLeader";
	}
	@RequestMapping("/indexAdmin")
	public String indexAdmin(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入indexAdmin");
		return "easyui/hh/indexAdmin";
	}
	@RequestMapping("/applyColum")
	public String applyColum(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入applyColum");
		return "easyui/hh/applyColum";
	}

	@RequestMapping("/applyList")
	public String applyList(String name_pinyin, String flag, HttpServletRequest req, Model model) {
		log.info("进入applyList");
		model.addAttribute("name_pinyin", name_pinyin);
		model.addAttribute("flag", flag);
		return "easyui/hh/applyList";
	}

	/**
	 * 申请提交
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/toApply")
	public JsonResult<String> toApply(@RequestBody ApplyInfo applyInfo, String flag, HttpServletRequest req,
			HttpServletResponse resp) {
		log.info("进入toApply");
		accountManager.toApply(applyInfo, flag);
		return new JsonResult<String>().success();
	}
	
	@ResponseBody
	@RequestMapping("/addLeader")
	public JsonResult<String> addLeader(@RequestBody Xt_leader leader, HttpServletRequest req,
			HttpServletResponse resp) {
		log.info("进入addLeader");
		leaderManager.addLeader(leader);
		return new JsonResult<String>().success();
	}
	@ResponseBody
	@RequestMapping("/addColum")
	public JsonResult<String> addColum(@RequestBody Xt_applyColum applyColum, HttpServletRequest req,
			HttpServletResponse resp) {
		log.info("进入addColum");
		applyColumDao.addColum(applyColum);
		return new JsonResult<String>().success();
	}

	@ResponseBody
	@RequestMapping("/delLeader")
	public JsonResult<String> delLeader(String id,  HttpServletResponse resp) {
		log.info("进入delLeader");
		leaderDao.delLeader(id);
		return new JsonResult<String>().success();
	}
	@ResponseBody
	@RequestMapping("/delColum")
	public JsonResult<String> delColum(String id,  HttpServletResponse resp) {
		log.info("进入delColum");
		applyColumDao.delColum(id);
		return new JsonResult<String>().success();
	}
	@ResponseBody
	@RequestMapping("/loginCheck")
	public JsonResult<String> loginCheck(String userName, String userPwd, HttpServletResponse resp) {
		log.info("进入loginCheck");
		if (("8990").equals(userName) && ("U03454sq").equals(userPwd)) {
			return new JsonResult<String>().success();
		} else {
			return new JsonResult<String>().fail(500);
		}
	}

	@ResponseBody
	@RequestMapping("/updateApply")
	public JsonResult<Integer> updateApply(@RequestBody ApplyInfo applyInfo, HttpServletRequest req,
			HttpServletResponse resp) {
		log.info("进入updateApply");
		int result = accountManager.updateApply(applyInfo);
		if (result == 0) {
			return new JsonResult<Integer>().fail(100, "审核失败！请检查审核领导是否正确！");
		}
		return new JsonResult<Integer>(result).success();
	}

	@ResponseBody
	@RequestMapping("/getApplyById")
	public JsonResult<ApplyInfo> getApplyById(String id, HttpServletRequest req) {
		log.info("进入getApplyById");
		ApplyInfo applyInfo = accountManager.getApplyById(id);
		return new JsonResult<ApplyInfo>(applyInfo).success();
	}

	@ResponseBody
	@RequestMapping("/updateApplyById")
	public JsonResult<Integer> updateApplyById(String id,HttpServletRequest req) {
		log.info("进入updateApplyById");
		String finsher = req.getParameter("finsher");
		   try {
			finsher = URLDecoder.decode(finsher,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		int result = accountManager.updateApplyById(id,finsher);
		if (result == 0) {
			return new JsonResult<Integer>().fail(100, "归档失败！请检查审核领导是否正确！");
		}
		return new JsonResult<Integer>(result).success();
	}

	@ResponseBody
	@RequestMapping("/getApplyList")
	public PageResult2<Xt_Apply> getApplyList(int page, int rows, String applyName, String name_pinyin, int status,
			HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入getApplyList");
		PageResult2<Xt_Apply> pageResult = new PageResult2<Xt_Apply>();
		int size = accountManager.getApplyListToal(page, rows, applyName, name_pinyin, status);
		List<Xt_Apply> list = accountManager.getApplyList(page, rows, applyName, name_pinyin, status);
		pageResult.setTotal(size);
		pageResult.setRows(list);
		return pageResult;
	}
	
	@ResponseBody
	@RequestMapping("/getLeaderList")
	public PageResult2<Xt_leader> getLeaderList(int page, int rows, String userName, String channels,
			HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入getLeaderList");
		PageResult2<Xt_leader> pageResult = new PageResult2<Xt_leader>();
		int size = leaderManager.getLeaderListToal(page, rows, userName, channels);
		List<Xt_leader> list = leaderManager.getLeaderList(page, rows, userName,  channels);
		pageResult.setTotal(size);
		pageResult.setRows(list);
		return pageResult;
	}
	
	@ResponseBody
	@RequestMapping("/getColumList")
	public PageResult2<Xt_applyColum> getColumList(int page, int rows, String columName,
			HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入getColumList");
		PageResult2<Xt_applyColum> pageResult = new PageResult2<Xt_applyColum>();
		int size = leaderManager.getColumListToal(page, rows, columName);
		List<Xt_applyColum> list = leaderManager.getColumList(page, rows, columName);
		pageResult.setTotal(size);
		pageResult.setRows(list);
		return pageResult;
	}
	
	@ResponseBody
	@RequestMapping("/getApplyColum")
	public JsonResult<List<Xt_applyColum>> getApplyColum(String id,HttpServletRequest req) {
		log.info("进入getApplyColum");
		List<Xt_applyColum> result =applyColumDao.getApplyColum();
		return new JsonResult<List<Xt_applyColum>>(result).success();
	}
	@ResponseBody
	@RequestMapping("/getChannel")
	public JsonResult<List<Xt_leader>> getChannel(HttpServletRequest req) {
		log.info("进入getChannel");
		List<Xt_leader> result =leaderDao.getChannel();
		return new JsonResult<List<Xt_leader>>(result).success();
	}

	@ResponseBody
	@RequestMapping("/getLeaderByChannel")
	public JsonResult<List<Xt_leader>> getLeaderByChannel(String channel, HttpServletRequest req) {
		log.info("进入getChannel");
		List<Xt_leader> result = new ArrayList<Xt_leader>();
		try {
			channel = URLDecoder.decode(channel,"UTF-8");
			if (!("0").equals(channel)) {
				result = leaderDao.getLeaderByChannel(channel);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		return new JsonResult<List<Xt_leader>>(result).success();
	}
	

}
