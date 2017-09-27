/**
 * 
 */
package com.calango.MCP.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.calango.MCP.db.dao.PolynomialDAO;
import com.calango.MCP.db.factory.DefaultPool;
import com.calango.MCP.db.helper.RowMapper;
import com.calango.MCP.db.model.Polynomial;

/**
 * @author calango
 *
 */
public class PolynomialDAOImpl implements PolynomialDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String getPolinomial = "SELECT * FROM polynomial AS p WHERE p.length = ?";
	
	private static final String addPolinomial = "INSERT INTO polynomial (function, length, number, property, t, j) VALUES (?,?,?,?,?,?)";

	/**
	 * 
	 */
	public PolynomialDAOImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.calango.SelfMatrixLinearSequentialMachines.db.dao.PolynominalDAO#getPolynominals(java.lang.String, int)
	 */
	@Override
	public List<Polynomial> getPolynominals(int length) {
		
		try (Connection con = DefaultPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(getPolinomial);
			ps.setInt(1, length);
			return RowMapper.mapPolinomialList(ps.executeQuery());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	/* (non-Javadoc)
	 * @see com.calango.SelfMatrixLinearSequentialMachines.db.dao.PolynominalDAO#addPolynominal(com.calango.SelfMatrixLinearSequentialMachines.db.model.Polynomial)
	 */
	@Override
	public boolean addPolynominal(Polynomial obj) {
		
		try (Connection con = DefaultPool.getConnection()) {
			PreparedStatement ps = con.prepareStatement(addPolinomial);
			ps.setString(1, obj.getFunction());
			ps.setInt(2, obj.getLength());
			ps.setString(3, obj.getNumber());
			ps.setString(4, obj.getProperty().toString());
			ps.setInt(5, obj.getT());
			ps.setShort(6, obj.getJ());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
