package com.hh.test.pojo.rundown;

import java.util.Date;

/**
 * 试机报警信息
 * @author smg
 *
 */
public class TestRunAlert {
	
	private String id;
	private String message;
	
	private Date createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "TestRunAlert [id=" + id + ", message=" + message + ", createTime=" + createTime + "]";
	}
	
}
