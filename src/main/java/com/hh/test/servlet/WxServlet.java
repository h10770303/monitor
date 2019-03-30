package com.hh.test.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hh.test.util.SHA1;
import com.hh.test.util.WeiXinUtil;

public class WxServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String Token = "hmw2018"; // 这个是之前在微信上填写的Token数据，可以自定义

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			response.getWriter().write(echostr);
		} else {
			System.out.println("没有传回去数据，");
		}
		System.out.println("token验证通过。");
	}
	
	public void doPOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("post请求");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String responseMessage;
		try {
			            //解析微信发来的请求,将解析后的结果封装成Map返回
			            Map<String,String> map = WeiXinUtil.parseXml(request);
			            System.out.println("FromUserName="+map.get("FromUserName"));
			            System.out.println("ToUserName="+map.get("ToUserName"));
//			            responseMessage = MessageHandlerUtil.buildResponseMessage(map);
//			            System.out.println(responseMessage);
//			            if(responseMessage.equals("")){
//			               responseMessage ="未正确响应";
//			           }
			         } catch (Exception e) {
			             e.printStackTrace();
			            System.out.println("发生异常："+ e.getMessage());
			            responseMessage ="未正确响应";
			         }
			         //发送响应消息
//			        response.getWriter().println(responseMessage);
			        response.getWriter().println("为正常响应");
		System.out.println(" 恢复信息。");
	}

}
