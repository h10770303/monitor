package com.hh.test.pojo.diagnostics;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * avid studio 日志分析
 * @author smg
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "record", propOrder = { "date", "millis", "timezone", "timezoneoffset", "syncdate", "syncmillis",
		"sequence", "hostname", "pid","procname","level","message","thread","threadname","logger","classs","method","line" })
public class Record {
	
	@XmlElement(name = "date")
	private String date;
	@XmlElement(name = "millis")
	private String millis;
	@XmlElement(name = "timezone")
	private String timezone;
	@XmlElement(name = "timezoneoffset")
	private String timezoneoffset;
	@XmlElement(name = "syncdate")
	private String syncdate;
	@XmlElement(name = "syncmillis")
	private String syncmillis;
	@XmlElement(name = "sequence")
	private String sequence;
	@XmlElement(name = "hostname")
	private String hostname;
	@XmlElement(name = "pid")
	private String pid;
	@XmlElement(name = "procname")
	private String procname;
	@XmlElement(name = "level")
	private String level;
	@XmlElement(name = "message")
	private String message;
	@XmlElement(name = "thread")
	private String thread;
	@XmlElement(name = "threadname")
	private String threadname;
	@XmlElement(name = "logger")
	private String logger;
	@XmlElement(name = "class")
	private String classs;// 最后多一个s
	@XmlElement(name = "method")
	private String method;
	@XmlElement(name = "line")
	private String line;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMillis() {
		return millis;
	}
	public void setMillis(String millis) {
		this.millis = millis;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public String getTimezoneoffset() {
		return timezoneoffset;
	}
	public void setTimezoneoffset(String timezoneoffset) {
		this.timezoneoffset = timezoneoffset;
	}
	
	public String getSyncdate() {
		return syncdate;
	}
	public void setSyncdate(String syncdate) {
		this.syncdate = syncdate;
	}
	public String getSyncmillis() {
		return syncmillis;
	}
	public void setSyncmillis(String syncmillis) {
		this.syncmillis = syncmillis;
	}
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getProcname() {
		return procname;
	}
	public void setProcname(String procname) {
		this.procname = procname;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getThread() {
		return thread;
	}
	public void setThread(String thread) {
		this.thread = thread;
	}
	public String getThreadname() {
		return threadname;
	}
	public void setThreadname(String threadname) {
		this.threadname = threadname;
	}
	public String getLogger() {
		return logger;
	}
	public void setLogger(String logger) {
		this.logger = logger;
	}
	public String getClasss() {
		return classs;
	}
	public void setClasss(String classs) {
		this.classs = classs;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	@Override
	public String toString() {
		return "Record [date=" + date + ", millis=" + millis + ", timezone=" + timezone + ", timezoneoffset="
				+ timezoneoffset + ", syncdate=" + syncdate + ", syncmillis=" + syncmillis + ", sequence=" + sequence
				+ ", hostname=" + hostname + ", pid=" + pid + ", procname=" + procname + ", level=" + level
				+ ", message=" + message + ", thread=" + thread + ", threadname=" + threadname + ", logger=" + logger
				+ ", classs=" + classs + ", method=" + method + ", line=" + line + "]";
	}
	

}
