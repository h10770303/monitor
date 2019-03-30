package com.hh.test.pojo;

public class iNews {

	private String password;
	private String user;
	private int port;
	private int ip;

	@Override
	public String toString() {
		return "iNews [password=" + password + ", user=" + user + ", port=" + port + ", ip=" + ip + "]";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getIp() {
		return ip;
	}

	public void setIp(int ip) {
		this.ip = ip;
	}

}