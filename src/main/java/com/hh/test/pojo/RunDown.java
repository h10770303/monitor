package com.hh.test.pojo;

/**
 * CCTV 串联单解析
 * @author smg
 *
 */
public class RunDown {

	private String cName;
	private String pName;
	private String pUrl;
	private String time;

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpUrl() {
		return pUrl;
	}

	public void setpUrl(String pUrl) {
		this.pUrl = pUrl;
	}


	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "RunDown [cName=" + cName + ", pName=" + pName + ", pUrl=" + pUrl + ", time=" + time + "]";
	}

}
