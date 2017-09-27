/**
 * 
 */
package com.calango.MCP.db.factory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

/**
 * @author calango
 *
 */
public class DefaultPool {

	private static BoneCP connectionPool = null;
	
	public static void init(final String path) {
		System.out.println(path);
		ResourceBundle properties = ResourceBundle.getBundle(path);
		try {
			Class.forName(properties.getString("JDBC.DRIVER"));
			BoneCPConfig config = new BoneCPConfig();
			config.setJdbcUrl(properties.getString("JDBC.URL"));
			config.setUsername(properties.getString("JDBC.USERNAME")); 
			config.setPassword(properties.getString("JDBC.PASSWORD"));
			config.setMinConnectionsPerPartition(5);
			config.setMaxConnectionsPerPartition(10);
			config.setPartitionCount(1);
			connectionPool = new BoneCP(config);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	public static void dispose() {
		if (connectionPool != null ) {
			connectionPool.shutdown();
		}
	}
	
	public static Connection getConnection() {
		try {
			return connectionPool.getConnection();
		} catch (SQLException e) {
			System.err.println("Connection error!");
			return null;
		}
	}
}
