package com.hh.test.pojo;

public class AssetRelationships {

	private String moid;
	private String anothermoid;
	private int relationshipType;
	public String getMoid() {
		return moid;
	}
	public void setMoid(String moid) {
		this.moid = moid;
	}
	public String getAnothermoid() {
		return anothermoid;
	}
	public void setAnothermoid(String anothermoid) {
		this.anothermoid = anothermoid;
	}
	public int getRelationshipType() {
		return relationshipType;
	}
	public void setRelationshipType(int relationshipType) {
		this.relationshipType = relationshipType;
	}
	@Override
	public String toString() {
		return "AssetRelationships [moid=" + moid + ", anothermoid=" + anothermoid + ", relationshipType="
				+ relationshipType + "]";
	}
	
	

}