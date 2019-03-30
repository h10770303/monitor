package com.hh.test.util.weixin;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hh.test.statics.MessageType;

public class MessageHandlerUtil {

	Logger log = LoggerFactory.getLogger(getClass());
	/**
     * 根据消息类型构造返回消息
     * @param map 封装了解析结果的Map
     * @return responseMessage(响应消息)
     */
    public static String buildResponseMessage(Map map,String content) {
        //响应消息
        String responseMessage = "";
        //得到消息类型
        String msgType = map.get("MsgType").toString();
//        log "MsgType:" + msgType);
        //消息类型
        MessageType messageEnumType = MessageType.valueOf(MessageType.class, msgType.toUpperCase());
        switch (messageEnumType) {
//            case TEXT:
//                //处理文本消息
//                responseMessage = handleTextMessage(map,content);
//                break;
//            case IMAGE:
//                //处理图片消息
//                responseMessage = handleImageMessage(map);
//                break;
//            case VOICE:
//                //处理语音消息
//                responseMessage = handleVoiceMessage(map);
//                break;
//            case VIDEO:
//                //处理视频消息
//                responseMessage = handleVideoMessage(map);
//                break;
//            case SHORTVIDEO:
//                //处理小视频消息
//                responseMessage = handleSmallVideoMessage(map);
//                break;
//            case LOCATION:
//                //处理位置消息
//                responseMessage = handleLocationMessage(map);
//                break;
//            case LINK:
//                //处理链接消息
//                responseMessage = handleLinkMessage(map);
//                break;
            case EVENT:
                //处理事件消息,用户在关注与取消关注公众号时，微信会向我们的公众号服务器发送事件消息,开发者接收到事件消息后就可以给用户下发欢迎消息
                responseMessage = handleEventMessage(map,"验证通过,欢迎登录早鸟新闻辅助系统！");
                break;
            default:
            	responseMessage=handleTextMessage(map,"无效输入。");
                break;
        }
        //返回响应消息
        return responseMessage;
    }
    
    
    
    private static String handleEventMessage(Map<String, String> map, String content) {
    	 //发送方帐号
        String fromUserName = map.get("FromUserName");
        // 开发者微信号
        String toUserName = map.get("ToUserName");
        System.out.println("ffff="+fromUserName);
        System.out.println("ttttt="+toUserName);
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
    private static String handleTextMessage(Map<String, String> map, String content) {
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
}
