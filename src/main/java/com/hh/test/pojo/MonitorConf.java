package com.hh.test.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "programNodes", "bussinessNodes" })// 节点属性
@XmlRootElement(name = "monitorConf")
public class MonitorConf {

	@XmlElement(name = "programNode")// 节点信息
	private List<ProgramNode> programNodes;
	@XmlElement(name = "bussinessNodes") //节点信息
	private BussinessNodes bussinessNodes;
	public List<ProgramNode> getProgramNodes() {
		return programNodes;
	}
	public void setProgramNodes(List<ProgramNode> programNodes) {
		this.programNodes = programNodes;
	}
	public BussinessNodes getBussinessNodes() {
		return bussinessNodes;
	}
	public void setBussinessNodes(BussinessNodes bussinessNodes) {
		this.bussinessNodes = bussinessNodes;
	}
	@Override
	public String toString() {
		return "MonitorConf [programNodes=" + programNodes + ", bussinessNodes=" + bussinessNodes + "]";
	}

	

}