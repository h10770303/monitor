package com.hh.test.pojo.bean;

import java.util.List;

public class DataShow {

	private List<ProgramFlowBean> programFlowBeans;
	private List<ToXnewsCnt> toXnewsCnts;

	public List<ProgramFlowBean> getProgramFlowBeans() {
		return programFlowBeans;
	}

	public void setProgramFlowBeans(List<ProgramFlowBean> programFlowBeans) {
		this.programFlowBeans = programFlowBeans;
	}

	public List<ToXnewsCnt> getToXnewsCnts() {
		return toXnewsCnts;
	}

	public void setToXnewsCnts(List<ToXnewsCnt> toXnewsCnts) {
		this.toXnewsCnts = toXnewsCnts;
	}

	@Override
	public String toString() {
		return "DataShow [programFlowBeans=" + programFlowBeans + ", toXnewsCnts=" + toXnewsCnts + "]";
	}

}
