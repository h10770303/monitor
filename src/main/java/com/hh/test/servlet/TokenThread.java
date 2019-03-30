package com.hh.test.servlet;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hh.test.pojo.weixin.AccessToken;
import com.hh.test.util.WeiXinGZH;

public class TokenThread implements Runnable {

	 private static Logger log = LoggerFactory.getLogger(TokenThread.class);
	    // 第三方用户唯一凭证
	    public static String appid = "";
	    // 第三方用户唯一凭证密钥
	    public static String appsecret = "";
	    public static AccessToken accessToken = null;

	    public void run() {
	        while (true) {
	            try {
	                accessToken = WeiXinGZH.getAccessToken(appid, appsecret);
	                log.info("accessToken=="+accessToken.toString());
	                if (null != accessToken&&!accessToken.getAccessToken().equals(CacheClass.getCache("accessToken"))) {
	                	CacheClass.setCache("accessToken", accessToken.getAccessToken(), new Date().getTime());
	                    log.info("获取access_token成功，有效时长{}秒 token:{}", accessToken.getExpiresIn(), accessToken.getAccessToken());
	                    Thread.sleep((accessToken.getExpiresIn()-200)*1000);
//	                    Thread.sleep((60)*1000);
	                } else {
	                	log.info("accessToken==空");
	                    // 如果access_token为null，10秒后再获取
	                    Thread.sleep(60 * 1000);
	                }
	            } catch (InterruptedException e) {
	                try {
	                	log.info("异常");
	                    Thread.sleep(60 * 1000);
	                } catch (InterruptedException e1) {
	                    log.error("{}", e1);
	                }
	                log.error("{}", e);
	            }
	        }
	    }

}
