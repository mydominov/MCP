/**
 * 
 */
package com.calango.MCP.db.helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.calango.MCP.db.model.Polynomial;
import com.calango.MCP.db.model.Property;

/**
 * @author calango
 *
 */
public class RowMapper {

	public static List<Polynomial> mapPolinomialList(ResultSet resultSet) throws SQLException {
		List<Polynomial> result = new LinkedList<>();
		Polynomial temp;
		while (resultSet.next()) {
			temp = new Polynomial();
			temp.setId(resultSet.getInt(1));
			temp.setFunction(resultSet.getString(2));
			temp.setLength(resultSet.getInt(3));
			temp.setNumber(resultSet.getString(4));
			temp.setProperty(Property.valueOf(resultSet.getString(5)));
			temp.setT(resultSet.getInt(6));
			temp.setJ(resultSet.getShort(7));
			result.add(temp);
		}
		return result;
	}
}
