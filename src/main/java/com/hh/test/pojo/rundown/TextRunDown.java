package com.hh.test.pojo.rundown;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "text", propOrder = { "num", "words", "rate", "formname", "storyid", "videoid", "presenter", "daoyu",
		"bianhou", "jiwei", "title", "vdaoyuztc", "tihuazimu", "airtype", "second", "jingbian", "airdate", "writer",
		"createby", "createdate", "modifyby", "modifydate", "txt" })

public class TextRunDown {

	@XmlElement(name = "num")
	private int num;
	@XmlElement(name = "words")
	private String words;
	@XmlElement(name = "rate")
	private String rate;
	@XmlElement(name = "formname")
	private String formname;
	@XmlElement(name = "storyid")
	private String storyid;
	@XmlElement(name = "video-id")
	private String videoid;
	@XmlElement(name = "presenter")
	private String presenter;
	@XmlElement(name = "daoyu")
	private String daoyu;
	@XmlElement(name = "bianhou")
	private String bianhou;
	@XmlElement(name = "jiwei")
	private String jiwei;
	@XmlElement(name = "title")
	private String title;
	@XmlElement(name = "v-daoyuztc")
	private String vdaoyuztc;
	@XmlElement(name = "tihuazimu")
	private String tihuazimu;
	@XmlElement(name = "airtype")
	private String airtype;
	@XmlElement(name = "second")
	private String second;
	@XmlElement(name = "jingbian")
	private String jingbian;
	@XmlElement(name = "air-date")
	private String airdate;
	@XmlElement(name = "writer")
	private String writer;
	@XmlElement(name = "create-by")
	private String createby;
	@XmlElement(name = "create-date")
	private long createdate;
	@XmlElement(name = "modify-by")
	private String modifyby;
	@XmlElement(name = "modify-date")
	private long modifydate;
	@XmlElement(name = "txt")
	private String txt;

	public int getNum() {
		return num;
	}

	public String getWords() {
		return words;
	}

	public String getRate() {
		return rate;
	}

	public String getFormname() {
		return formname;
	}

	public String getStoryid() {
		return storyid;
	}

	public String getVideoid() {
		return videoid;
	}

	public String getPresenter() {
		return presenter;
	}

	public String getDaoyu() {
		return daoyu;
	}

	public String getBianhou() {
		return bianhou;
	}

	public String getJiwei() {
		return jiwei;
	}

	public String getTitle() {
		return title;
	}

	public String getVdaoyuztc() {
		return vdaoyuztc;
	}

	public String getTihuazimu() {
		return tihuazimu;
	}

	public String getAirtype() {
		return airtype;
	}

	public String getSecond() {
		return second;
	}

	public String getJingbian() {
		return jingbian;
	}

	public String getAirdate() {
		return airdate;
	}

	public String getWriter() {
		return writer;
	}

	public String getCreateby() {
		return createby;
	}

	public long getCreatedate() {
		return createdate;
	}

	public String getModifyby() {
		return modifyby;
	}

	public long getModifydate() {
		return modifydate;
	}

	public String getTxt() {
		return txt;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setWords(String words) {
		this.words = words;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public void setFormname(String formname) {
		this.formname = formname;
	}

	public void setStoryid(String storyid) {
		this.storyid = storyid;
	}

	public void setVideoid(String videoid) {
		this.videoid = videoid;
	}

	public void setPresenter(String presenter) {
		this.presenter = presenter;
	}

	public void setDaoyu(String daoyu) {
		this.daoyu = daoyu;
	}

	public void setBianhou(String bianhou) {
		this.bianhou = bianhou;
	}

	public void setJiwei(String jiwei) {
		this.jiwei = jiwei;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setVdaoyuztc(String vdaoyuztc) {
		this.vdaoyuztc = vdaoyuztc;
	}

	public void setTihuazimu(String tihuazimu) {
		this.tihuazimu = tihuazimu;
	}

	public void setAirtype(String airtype) {
		this.airtype = airtype;
	}

	public void setSecond(String second) {
		this.second = second;
	}

	public void setJingbian(String jingbian) {
		this.jingbian = jingbian;
	}

	public void setAirdate(String airdate) {
		this.airdate = airdate;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	public void setCreatedate(long createdate) {
		this.createdate = createdate;
	}

	public void setModifyby(String modifyby) {
		this.modifyby = modifyby;
	}

	public void setModifydate(long modifydate) {
		this.modifydate = modifydate;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	@Override
	public String toString() {
		return "TextRunDown [num=" + num + ", words=" + words + ", rate=" + rate + ", formname=" + formname
				+ ", storyid=" + storyid + ", videoid=" + videoid + ", presenter=" + presenter + ", daoyu=" + daoyu
				+ ", bianhou=" + bianhou + ", jiwei=" + jiwei + ", title=" + title + ", vdaoyuztc=" + vdaoyuztc
				+ ", tihuazimu=" + tihuazimu + ", airtype=" + airtype + ", second=" + second + ", jingbian=" + jingbian
				+ ", airdate=" + airdate + ", writer=" + writer + ", createby=" + createby + ", createdate="
				+ createdate + ", modifyby=" + modifyby + ", modifydate=" + modifydate + ", txt=" + txt + "]";
	}

}
