package com.hh.test.pojo;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BussinessNodes", propOrder = { "bussinessNode"})
public class BussinessNodes {

	@XmlElement(name = "bussinessNode")
	private List<BussinessNode> bussinessNode;

	@Override
	public String toString() {
		return "BussinessNodes [bussinessNode=" + bussinessNode + "]";
	}

	public List<BussinessNode> getBussinessNode() {
		return bussinessNode;
	}

	public void setBussinessNode(List<BussinessNode> bussinessNode) {
		this.bussinessNode = bussinessNode;
	}

	

}