package com.hh.test.pojo;

import java.util.Arrays;

public class PostParam {
	private String[] ids;

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	@Override
	public String toString() {
		return "PostParam [ids=" + Arrays.toString(ids) + "]";
	}
	
	

}
