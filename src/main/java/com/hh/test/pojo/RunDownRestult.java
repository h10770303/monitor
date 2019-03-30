package com.hh.test.pojo;

import java.util.List;

public class RunDownRestult {

	private int error_code;

	private String reason;

	private List<RunDown> result;

	public int getError_code() {
		return error_code;
	}

	public void setError_code(int error_code) {
		this.error_code = error_code;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public List<RunDown> getResult() {
		return result;
	}

	public void setResult(List<RunDown> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "RunDownRestult [error_code=" + error_code + ", reason=" + reason + ", result=" + result + "]";
	}

	
	
	
}