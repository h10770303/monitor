package com.hh.test.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "pdfBean"})// 节点属性
@XmlRootElement(name = "pdfBeans")
public class PdfBeans {
	
	@XmlElement(name = "pdfBean")// 节点信息
	private List<PdfBean> pdfBean;

	public List<PdfBean> getPdfBeans() {
		return pdfBean;
	}

	public void setPdfBeans(List<PdfBean> pdfBean) {
		this.pdfBean = pdfBean;
	}

	@Override
	public String toString() {
		return "PdfBeans [pdfBean=" + pdfBean + "]";
	}
	
	
}
