package com.hh.test.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.hh.test.dao.ListqDao;
import com.hh.test.dao.MonitorDao;
import com.hh.test.dao.RunDownDao;
import com.hh.test.db.CustomerContextHolder;
import com.hh.test.manager.RunDownManager;
import com.hh.test.pojo.rundown.CheckInterplay;
import com.hh.test.pojo.rundown.InewsMonOn;
import com.hh.test.pojo.rundown.NcStatus;
import com.hh.test.pojo.rundown.RunMsgParam;
import com.hh.test.pojo.rundown.TestRunAlert;
import com.hh.test.pojo.rundown.TestRunMsg;
import com.hh.test.pojo.weixin.OpenId;
import com.hh.test.pojo.weixin.OpenIdLog;
import com.hh.test.statics.MessageType;
import com.hh.test.util.DateUtil;
import com.hh.test.util.UUIDRadom;

@Service
public class RunDownManagerImpl implements RunDownManager {

	Logger log = LoggerFactory.getLogger(getClass());

	@Resource
	private RunDownDao runDownDao;
	@Resource
	private ListqDao listqDao;
	@Resource
	private MonitorDao monitorDao;

	@Override
	public OpenId getOpenIdById(String openId) {
		return runDownDao.getOpenIdById(openId);
	}

	
	public  String buildResponseMessage(Map<String, String> map) {
		  OpenId openid=runDownDao.getOpenIdById(map.get("FromUserName"));
	        String responseMessage = "";
	        String msgType = map.get("MsgType").toString();
	        MessageType messageEnumType = MessageType.valueOf(MessageType.class, msgType.toUpperCase());
	        switch (messageEnumType) {
//	            case TEXT:
//	                //处理文本消息
//	                responseMessage = handleTextMessage(map,content);
//	                break;
//	            case IMAGE:
//	                //处理图片消息
//	                responseMessage = handleImageMessage(map);
//	                break;
//	            case VOICE:
//	                //处理语音消息
//	                responseMessage = handleVoiceMessage(map);
//	                break;
//	            case VIDEO:
//	                //处理视频消息
//	                responseMessage = handleVideoMessage(map);
//	                break;
//	            case SHORTVIDEO:
//	                //处理小视频消息
//	                responseMessage = handleSmallVideoMessage(map);
//	                break;
//	            case LOCATION:
//	                //处理位置消息
//	                responseMessage = handleLocationMessage(map);
//	                break;
//	            case LINK:
//	                //处理链接消息
//	                responseMessage = handleLinkMessage(map);
//	                break;
	            case EVENT:
	            	if(openid!=null){
	            		OpenIdLog openIdLog=new OpenIdLog();
	            		BeanUtils.copyProperties(openid, openIdLog);
	            		openIdLog.setId(UUIDRadom.getUUID());
	            		openIdLog.setCreateTime(new Date());
	            		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
	            		runDownDao.insertOpenIdLog(openIdLog);
	            		responseMessage = handleEventMessage(map,"恭喜您，验证通过！");
	            	}else {
	            		responseMessage = handleEventMessage(map,"验证不通过,系统权限受限，请联系管理员！");
	            	}
	                break;
	            default:
	            	responseMessage=handleTextMessage(map,"无效输入。");
	                break;
	        }
	        return responseMessage;
	    }
	    
	    
	    
	    private  String handleEventMessage(Map<String, String> map, String content) {
	    	 //发送方帐号
	        String fromUserName = map.get("FromUserName");
	        // 开发者微信号
	        String toUserName = map.get("ToUserName");
	        /**
	         * 文本消息XML数据格式
	         * <xml>
	         <ToUserName><![CDATA[toUser]]></ToUserName>
	         <FromUserName><![CDATA[fromUser]]></FromUserName>
	         <CreateTime>1348831860</CreateTime>
	         <MsgType><![CDATA[text]]></MsgType>
	         <Content><![CDATA[this is a test]]></Content>
	         <MsgId>1234567890123456</MsgId>
	         </xml>
	         */
	        return String.format(
	                "<xml>" +
	                        "<ToUserName><![CDATA[%s]]></ToUserName>" +
	                        "<FromUserName><![CDATA[%s]]></FromUserName>" +
	                        "<CreateTime>%s</CreateTime>" +
	                        "<MsgType><![CDATA[text]]></MsgType>" +
	                        "<Content><![CDATA[%s]]></Content>" +
	                        "</xml>",
	                fromUserName, toUserName, new Date().getTime(), content);
		}



		/**
	     * 构造文本消息
	     * @param map 封装了解析结果的Map
	     * @param content 文本消息内容
	     * @return 文本消息XML字符串
	     */
	    private  String handleTextMessage(Map<String, String> map, String content) {
	        //发送方帐号
	        String fromUserName = map.get("FromUserName");
	        // 开发者微信号
	        String toUserName = map.get("ToUserName");
	        /**
	         * 文本消息XML数据格式
	         * <xml>
	         <ToUserName><![CDATA[toUser]]></ToUserName>
	         <FromUserName><![CDATA[fromUser]]></FromUserName>
	         <CreateTime>1348831860</CreateTime>
	         <MsgType><![CDATA[text]]></MsgType>
	         <Content><![CDATA[this is a test]]></Content>
	         <MsgId>1234567890123456</MsgId>
	         </xml>
	         */
	        return String.format(
	                "<xml>" +
	                        "<ToUserName><![CDATA[%s]]></ToUserName>" +
	                        "<FromUserName><![CDATA[%s]]></FromUserName>" +
	                        "<CreateTime>%s</CreateTime>" +
	                        "<MsgType><![CDATA[text]]></MsgType>" +
	                        "<Content><![CDATA[%s]]></Content>" +
	                        "</xml>",
	                fromUserName, toUserName, new Date().getTime(), content);
	    }


		@SuppressWarnings({ "deprecation", "deprecation", "deprecation" })
		@Override
		public TestRunMsg getTestRunMsg(RunMsgParam msgParam) {
			List<String> messages=new ArrayList<String>();
			String beginTime=msgParam.getStartDt();
			String endTime=msgParam.getEndDt();
			Integer day=Integer.parseInt(beginTime.split("-")[2]);
			CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
			List<InewsMonOn> monOns=listqDao.getInewsMonOnByTime(beginTime, endTime);
			CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
			List<NcStatus> ncResarts=listqDao.getNCstatus(beginTime, endTime);
			CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
			List<CheckInterplay> interplays=monitorDao.getCheckInterplay(beginTime, endTime);
			CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
			List<TestRunAlert> alerts=listqDao.getTestRunAlert(beginTime, endTime);
			for (InewsMonOn inewsMonOn : monOns) {
				if(day==inewsMonOn.getDay()){
					String[] time=inewsMonOn.getTime().split(":");
					int hour=Integer.parseInt(time[0]);
					switch (Integer.parseInt(inewsMonOn.getStudio())) {
					case 2:
						if (hour>=5&&hour<=7) {
							inewsMonOn.setStudio("《上海早晨》");
						} else if(hour>=10&&hour<=12) {
							inewsMonOn.setStudio("《媒体大搜索》");
						}else if(hour>=16&&hour<=18) {
							inewsMonOn.setStudio("《新闻报道》");
						}else if(hour>=19&&hour<=21) {
							inewsMonOn.setStudio("《夜新闻》");
						}
						break;
					case 1:
						if (hour>=5&&hour<=7) {
							inewsMonOn.setStudio("《看东方》");
						}else if(hour>=10&&hour<=12){
							inewsMonOn.setStudio("《午间30分》");
						}else if(hour>=16&&hour<=18) {
							inewsMonOn.setStudio("《东方新闻》");
						}else if(hour>=20&&hour<=22) {
							inewsMonOn.setStudio("《今晚60分》");
						}
						break;
					case 7:
						if (hour>=16&&hour<=18) {
							inewsMonOn.setStudio("《新闻坊》");
						}
						break;
					case 9:
						if (hour>=18&&hour<=19) {
							inewsMonOn.setStudio("《Money Talks 财道》");
						}else if(hour>=20&&hour<=21){
							inewsMonOn.setStudio("《Shanghai Live 直播上海 》");
						}
						break;

					default:
						break;
					}
					
				}
			}
			
			
			/**
			 * 审片机
			 */
			if(ncResarts.size()>0){
				List<String> alias=new ArrayList<String>();
				for (NcStatus ncResart : ncResarts) {
					alias.add(ncResart.getAlias());
				}
				
			}
			
			/**
			 * 报警信息
			 */
			for (TestRunAlert alert: alerts) {
				messages.add(alert.getMessage());
			}
			if(interplays.size()>0){
				List<Integer> rm_index=new ArrayList<>();
				for (int i = 0; i < interplays.size(); i++) {
					
					if(!("info").equals(interplays.get(i).getCheckresult())){
						messages.add(interplays.get(i).getCheckinfo().substring(0, interplays.get(i).getCheckinfo().lastIndexOf("!"))+";测试时间为："+DateUtil.dateTimeToString(interplays.get(i).getCheckDate()));
					}
					if(interplays.get(i).getCheckDate().getHours()>12){
						// 将下午的发片测试改到ncstatus中去。 统计规划到下午非编技术巡检中。
						if(("info").equals(interplays.get(i).getCheckresult())){
							NcStatus ncStatus=new NcStatus();
							ncStatus.setAlias(interplays.get(i).getCheckname());
							ncStatus.setCreateDate(interplays.get(i).getCheckDate());
							ncResarts.add(ncStatus);
						}
						rm_index.add(i);
					}
				}
				//使有问题的试机不显示
				for (Integer integer : rm_index) {
					interplays.remove(integer);
				}
			}
			
			
			if(messages.size()==0){
				String message="试机正常";
				messages.add(message);
			}
			
			TestRunMsg runMsg=new TestRunMsg();
			runMsg.setInewsMonOns(monOns);
			runMsg.setNcStatus(ncResarts);
			runMsg.setCheckInterplays(interplays);
			runMsg.setMessages(messages);
			return runMsg;
		}
		
}
