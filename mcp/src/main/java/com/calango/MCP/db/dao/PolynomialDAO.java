/**
 * 
 */
package com.calango.MCP.db.dao;

import java.io.Serializable;
import java.util.List;

import com.calango.MCP.db.model.Polynomial;

/**
 * @author calango
 *
 */
public interface PolynomialDAO extends Serializable {

	List<Polynomial> getPolynominals(int length);
	
	boolean addPolynominal(Polynomial obj);
	
}
