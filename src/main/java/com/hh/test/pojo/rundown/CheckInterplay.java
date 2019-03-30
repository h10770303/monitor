package com.hh.test.pojo.rundown;

import java.util.Date;

/**
 * interplay 试机
 * 
 * @author smg
 *
 */
public class CheckInterplay {

	private String id;
	private String checktime;
	private Date checkDate;
	private String checkname;
	private String checkresult;
	private String checkinfo;

	

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getChecktime() {
		return checktime;
	}

	public void setChecktime(String checktime) {
		this.checktime = checktime;
	}

	public void setCheckname(String checkname) {
		this.checkname = checkname;
	}

	public String getCheckname() {
		return checkname;
	}

	public void setCheckresult(String checkresult) {
		this.checkresult = checkresult;
	}

	public String getCheckresult() {
		return checkresult;
	}

	public void setCheckinfo(String checkinfo) {
		this.checkinfo = checkinfo;
	}

	public String getCheckinfo() {
		return checkinfo;
	}

	@Override
	public String toString() {
		return "CheckInterplay [checktime=" + checktime + ", checkDate=" + checkDate + ", checkname=" + checkname
				+ ", checkresult=" + checkresult + ", checkinfo=" + checkinfo + "]";
	}

}
