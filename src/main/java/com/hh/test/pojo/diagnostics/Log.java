package com.hh.test.pojo.diagnostics;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * avid 日志分析
 * @author smg
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "records"})
@XmlRootElement(name = "log")
public class Log {
	@XmlElement(name = "record")
	private List<Record> records;

	public List<Record> getRecords() {
		return records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}

	@Override
	public String toString() {
		return "Log [records=" + records + "]";
	}

}
