package com.hh.test.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MultiThreadedHttpClient {
	private static final Logger logger = LoggerFactory
			.getLogger(MultiThreadedHttpClient.class);

	private MultiThreadedHttpClient() {

	};

	private static HttpClient httpClient = null;

	private static PoolingHttpClientConnectionManager connManager = null;

	private static RequestConfig defaultRequestConfig = null;
	/**
	 * 获得HttpClient,单例模式
	 * 
	 */
	static {
		HttpClientParams params = new HttpClientParams();
		params.setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
		params.setConnectionManagerTimeout(5000);// 连接不够用的时候等待超时时间

		HttpConnectionManagerParams cmp = new HttpConnectionManagerParams();
		cmp.setConnectionTimeout(30000);// 请求超时
		cmp.setSoTimeout(30000);// 读取超时
		cmp.setDefaultMaxConnectionsPerHost(100);// 针对每个域名（当只有一个域名是）
		cmp.setMaxTotalConnections(200);// 允许最大连接数
		cmp.setStaleCheckingEnabled(true);// 在提交请求之前 测试连接是否可用
		MultiThreadedHttpConnectionManager cm = new MultiThreadedHttpConnectionManager();
		cm.setParams(cmp);

		httpClient = new HttpClient(params, cm);
		// HttpClient()默认使用SimpleHttpConnectionManager，存在并发问题
	}
	// httpclient 4
	static {
		connManager = new PoolingHttpClientConnectionManager();

		defaultRequestConfig = RequestConfig.custom().setSocketTimeout(10000)
				.setConnectTimeout(10000).setConnectionRequestTimeout(10000)
				.build();
	}

	public static HttpClient getInstance() {
		return httpClient;
	}

	public static CloseableHttpClient getInstance4() {
		CloseableHttpClient httpclient = HttpClients.custom()
				.setConnectionManager(connManager)
				.setDefaultRequestConfig(defaultRequestConfig).build();

		return httpclient;

	}

}
