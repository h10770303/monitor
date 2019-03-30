package com.hh.test.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hh.test.pojo.weixin.Notify;

/**
 * 微信企业号
 * @author smg
 *
 */
public class WeiXinUtil {

	/**
	 * 微信发送消息
	 * 
	 * @param mobiles
	 * @param beginTime
	 * @param endTime
	 */
	public static void sendMessage(String tousers, String beginTime,String endTime,String duanxinCptnType) {
		
		CloseableHttpClient httpClient = null;
		HttpGet method = null;
		CloseableHttpResponse result = null;
		   String[]touser=tousers.split(",");
		   for (String string : touser) {
			   String url = "http://10.27.137.145:8080/weixin/sendMessage.do";
			   url += "?message=xnews二级汇聚:" + duanxinCptnType + ":between=" + beginTime + "and" + endTime + "数量为0,请检查是否正常!";
			   url += "&touser=" + string;
			   method = new HttpGet(url);
			   try {
				   httpClient = MultiThreadedHttpClient.getInstance4();
				   RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(9000).setConnectTimeout(9000).build();//设置请求和
				   method.setConfig(requestConfig);
				   result = httpClient.execute(method);
			   } catch (ClientProtocolException e) {
				   // TODO Auto-generated catch block
				   e.printStackTrace();
			   } catch (IOException e) {
				   // TODO Auto-generated catch block
				   e.printStackTrace();
			   } finally {
				   method.releaseConnection();
			   }
			   
			   HttpEntity resEntity = result.getEntity();
			   
			   System.out.println("调用post后返回结果：" + resEntity);
		}
	}
	
	public static void sendNotifyMessage(String tousers, String message,Notify notify) {
		
		CloseableHttpClient httpClient = null;
		HttpPost method = null;
		CloseableHttpResponse result = null;
		String[]touser=tousers.split(",");
		for (String string : touser) {
			String url = "http://10.27.137.145:8080/weixin/sendNotifyMessage.do";
			url += "?message="+message;
//			url += "?message=xnews二级汇聚:" + duanxinCptnType + ":between=" + beginTime + "and" + endTime + "数量为0,请检查是否正常!";
			url += "&touser=" + string;
			method = new HttpPost(url);
			ObjectMapper mapper=new ObjectMapper();
			try {
				String s_notify=mapper.writeValueAsString(notify);
				StringEntity entity=new StringEntity(s_notify, ContentType.APPLICATION_JSON);
				method.setEntity(entity);
				httpClient = MultiThreadedHttpClient.getInstance4();
				result = httpClient.execute(method);
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				method.releaseConnection();
			}
			
			HttpEntity resEntity = result.getEntity();
			
			System.out.println("调用post后返回结果：" + resEntity);
		}
	}
	
	
	public static void sendBatMessage(String tousers,String message) {
		
		CloseableHttpClient httpClient = null;
		HttpGet method = null;
		String[]touser=tousers.split(",");
		for (String string : touser) {
			String url = "http://10.27.137.145:8080/weixin/sendMessage.do";
			url += "?touser=" + string;
			url += "&message=" + message.replace(" ", "");
			method = new HttpGet(url);
			httpClient = MultiThreadedHttpClient.getInstance4();
			CloseableHttpResponse result = null;
			try {
				RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(9000).setConnectTimeout(9000).build();//设置请求和
				method.setConfig(requestConfig);
				result = httpClient.execute(method);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				method.releaseConnection();
			}
			
			HttpEntity resEntity = result.getEntity();
			
			System.out.println("调用post后返回结果：" + resEntity);
		}
	}
	
	/**
	 * 试机报警信息
	 * @param tousers
	 * @param message
	 * @param notify
	 */
	public static void sendRunMsgMessage(String tousers, String message,List<String> messges) {
		
		CloseableHttpClient httpClient = null;
		HttpPost method = null;
		CloseableHttpResponse result = null;
		String[]touser=tousers.split(",");
		for (String string : touser) {
			String url = "http://10.27.137.145:8080/weixin/runMsgMessag.do";
			url += "?message="+message;
			url += "&touser=" + string;
			method = new HttpPost(url);
			ObjectMapper mapper=new ObjectMapper();
			try {
				String s_notify=mapper.writeValueAsString(messges);
				StringEntity entity=new StringEntity(s_notify, ContentType.APPLICATION_JSON);
				method.setEntity(entity);
				httpClient = MultiThreadedHttpClient.getInstance4();
				result = httpClient.execute(method);
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				method.releaseConnection();
			}
			
			HttpEntity resEntity = result.getEntity();
			
			System.out.println("调用post后返回结果：" + resEntity);
		}
	}
	
	
	
	public static void main(String[] args) throws JsonProcessingException {
		
		CloseableHttpClient httpClient = null;
		HttpGet method = null;
		String tousers="humingwei,humingwei";
		String message="S9 cg2 A10缓存删除批出命令7天未执行，上次执行日志为: 2018/06/06 周三 7:52:20.71已完成!";
		String[]touser=tousers.split(",");
		for (String string : touser) {
			String url = "http://10.27.137.145:8080/weixin/sendMessage.do";
			url += "?touser=" + string;
			url += "&message=" + message.replace(" ", "");
			method = new HttpGet(url);
			httpClient = MultiThreadedHttpClient.getInstance4();
			CloseableHttpResponse result = null;
			try {
				RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(9000).setConnectTimeout(9000).build();//设置请求和
				method.setConfig(requestConfig);
				result = httpClient.execute(method);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				method.releaseConnection();
			}
			
			HttpEntity resEntity = result.getEntity();
			
			System.out.println("调用post后返回结果：" + resEntity);
		}
		
	}
	
	
	
	/**
	 * 微信xml 转map 的工具类
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public static Map<String, String> parseXml(HttpServletRequest req) throws Exception{
		 Map<String, String> map = new HashMap<String, String>();
		 InputStream inputStream = req.getInputStream();
		 SAXReader reader = new SAXReader();
		 Document document = reader.read(inputStream);
		 Element root = document.getRootElement();
		 List<Element> elementList = root.elements();
		 for (Element e : elementList) {
			 System.out.println(e.getName() + "|" + e.getText());
			  map.put(e.getName(), e.getText());
		 }
		 inputStream.close();
		 inputStream = null; 
		 return map;
	}
}
