package com.hh.test.statics;

import java.util.HashMap;
import java.util.Map;

public class VoteStatic {

	/**
	 * 投票之星对应关系
	 */
	public final static int XIYOUZHIXING = 1;
	public final static int SANGUOZHIXING = 2;
	public final static int SHUIHUZHIXING = 3;
	public final static int HONGLOUZHIXING = 4;

	public final static Map<Integer, Object> starMap = new HashMap<>();

	static {
		starMap.put(XIYOUZHIXING, "西游之星（22人选4人）");
		starMap.put(SANGUOZHIXING, "三国之星（22人选4人）");
		starMap.put(SHUIHUZHIXING, "水浒之星（22人选4人）");
		starMap.put(HONGLOUZHIXING, "红楼之星（23人选4人）");

	}

	/**
	 * 投票人所在部门
	 */
	public final static int ZHONGXINLINGDAO = 1;
	public final static int QUNZHONGZUZHI = 2;
	public final static int BANGONGSHI = 3;
	public final static int ZONGBIANSHI = 4;
	public final static int RENLIZIYUAN = 5;
	public final static int GUANGGAOJINGYING = 6;
	public final static int ZHIZUOBU = 7;
	public final static int PINPAITUIGUAN = 8;
	public final static int CAIWUBU = 9;
	public final static int SHANGSHIXINWENZHONGXIN = 10;
	public final static int ZONGHEJIEMUZHONGXIN = 11;
	public final static int KNEWSXINWEN = 12;
	public final static int WAIYUZHONGXIN = 13;

	/**
	 * 投票人对应map队列
	 */
	public final static Map<Integer, Object> voteMap = new HashMap<>();
	static {
		voteMap.put(ZHONGXINLINGDAO, "中心领导");
		voteMap.put(QUNZHONGZUZHI, "工青妇 群众组织");
		voteMap.put(BANGONGSHI, "办公室筹建小组成员");
		voteMap.put(ZONGBIANSHI, "总编室筹建小组成员");
		voteMap.put(RENLIZIYUAN, "人力资源部筹建小组成员");
		voteMap.put(GUANGGAOJINGYING, "广告经营管理部筹建小组成员");
		voteMap.put(ZHIZUOBU, "制作部筹建小组成员");
		voteMap.put(PINPAITUIGUAN, "品牌推广部筹建小组成员");
		voteMap.put(CAIWUBU, "财务部");
		voteMap.put(SHANGSHIXINWENZHONGXIN, "上视新闻中心");
		voteMap.put(ZONGHEJIEMUZHONGXIN, "综合节目中心");
		voteMap.put(KNEWSXINWEN, "Knews新闻中心");
		voteMap.put(WAIYUZHONGXIN, "外语节目中心");
	}

}
