package com.hh.test.pojo;

/**
 * kankanCMS对接
 * 
 * @author fu_leisen
 *
 */
public class KankanInfo {
	private String moid;
	private String kankanMoid;
	private String url;
	private String title;
	private String count;

	public String getMoid() {
		return moid;
	}

	public void setMoid(String moid) {
		this.moid = moid;
	}

	public String getKankanMoid() {
		return kankanMoid;
	}

	public void setKankanMoid(String kankanMoid) {
		this.kankanMoid = kankanMoid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "KankanInfo [moid=" + moid + ", kankanMoid=" + kankanMoid + ", url=" + url + ", title=" + title
				+ ", count=" + count + "]";
	}
	
}
