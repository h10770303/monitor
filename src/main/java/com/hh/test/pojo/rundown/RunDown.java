package com.hh.test.pojo.rundown;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="root")
public class RunDown {

	@XmlElement(name = "text")
	private List<TextRunDown> textRunDowns;

	public List<TextRunDown> getTextRunDowns() {
		return textRunDowns;
	}

	public void setTextRunDowns(List<TextRunDown> textRunDowns) {
		this.textRunDowns = textRunDowns;
	}

	@Override
	public String toString() {
		return "RunDown [textRunDowns=" + textRunDowns + "]";
	}
	
	
	
	
	
	
}
