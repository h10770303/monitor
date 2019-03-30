package com.hh.test.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

public class DuanXinUtil {

	/**
	 * 发送短信
	 * 
	 * @param mobiles
	 * @param beginTime
	 * @param endTime
	 */
	public static void smsSend(String mobiles, String beginTime,String endTime,String duanxinCptnType) {
		
		String[] mobiless = mobiles.split(",");
		CloseableHttpClient httpClient = null;
		HttpGet method = null;
		for (String mobile : mobiless) {
			String url = "http://10.27.137.145:8080/SMSAgent/sms?Username=caihuachen&Password=111111&Keyword=ieirieroioer";
			url += "&Content=xnews二级汇聚数量为0,请检查是否正常";
			url += "&Mobile=" + mobile;
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
	
	
	
	
	public static void main(String[] args) {
		String url="http://10.27.137.145:8080/SMSAgent/sms?Username=caihuachen&Password=111111&Keyword=ieirieroioer&Content=xnews二级汇聚:aptn:between=2018-01-12 15:18:00and2018-01-12 14:18:00数量为0，请检查是否正常！&Mobile=15821225096";
		CloseableHttpClient httpClient = null;
		HttpGet method = null;
		method = new HttpGet(url);
		httpClient = MultiThreadedHttpClient.getInstance4();
		CloseableHttpResponse result = null;
		try {
			result = httpClient.execute(method);
		}catch(IOException e){
			
		}
		HttpEntity resEntity = result.getEntity();
		System.out.println("res"+resEntity);
	}
}
