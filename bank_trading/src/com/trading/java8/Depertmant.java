package com.trading.java8;

public class Depertmant {
	
	private int depId;
	private String depName;
	
	
	public Depertmant(int depId, String depName) {
		super();
		this.depId = depId;
		this.depName = depName;
	}
	/**
	 * @return the depId
	 */
	public int getDepId() {
		return depId;
	}
	/**
	 * @param depId the depId to set
	 */
	public void setDepId(int depId) {
		this.depId = depId;
	}
	/**
	 * @return the depName
	 */
	public String getDepName() {
		return depName;
	}
	/**
	 * @param depName the depName to set
	 */
	public void setDepName(String depName) {
		this.depName = depName;
	}
	@Override
	public String toString() {
		return "Depertmant [depId=" + depId + ", depName=" + depName + "]";
	}


}
