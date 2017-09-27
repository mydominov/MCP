package com.calango.MCP.db.model;
/**
 * 
 */

/**
 * @author calango
 *
 */
public class TempValue {

	public TempValue() {
		tempValue = 0;
	}

	private int tempValue;
	
	public void inc(int value) {
		tempValue += value;
	}

	/**
	 * @return the tempValue
	 */
	public int getTempValue() {
		return tempValue;
	}
	
}
