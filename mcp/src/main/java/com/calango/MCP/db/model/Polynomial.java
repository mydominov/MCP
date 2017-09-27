/**
 * 
 */
package com.calango.MCP.db.model;

import java.io.Serializable;

/**
 * @author calango
 *
 */
public class Polynomial implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private int id;
	
	/**
	 * 
	 */
	private String function;
	
	/**
	 * 
	 */
	private int length;
	
	/**
	 * 
	 */
	private String number;
	
	/**
	 * 
	 */
	private Property property;
	
	
	/**
	 * 
	 */
	private int t;
	
	/**
	 * 
	 */
	private short j;

	/**
	 * 
	 */
	public Polynomial() {
		super();
	}

	/**
	 * @param function
	 * @param length
	 * @param number
	 * @param property
	 * @param t
	 * @param j
	 */
	public Polynomial(String function, int length, String number, Property property, int t, short j) {
		super();
		this.function = function;
		this.length = length;
		this.number = number;
		this.property = property;
		this.t = t;
		this.j = j;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the function
	 */
	public String getFunction() {
		return function;
	}

	/**
	 * @param function the function to set
	 */
	public void setFunction(String function) {
		this.function = function;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the property
	 */
	public Property getProperty() {
		return property;
	}

	/**
	 * @param property the property to set
	 */
	public void setProperty(Property property) {
		this.property = property;
	}

	/**
	 * @return the t
	 */
	public int getT() {
		return t;
	}

	/**
	 * @param t the t to set
	 */
	public void setT(int t) {
		this.t = t;
	}

	/**
	 * @return the j
	 */
	public short getJ() {
		return j;
	}

	/**
	 * @param j the j to set
	 */
	public void setJ(short j) {
		this.j = j;
	}
	
}
