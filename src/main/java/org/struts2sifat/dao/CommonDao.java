package org.struts2sifat.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.MissingResourceException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.struts2sifat.common.Common;
import org.struts2sifat.common.Consts;


 
public class CommonDao {


	/**
	 */
	protected DataSource ds = null;

	/**
	 */
	public CommonDao() throws NamingException {

		Context context = new InitialContext();
		ds = (DataSource) context.lookup(Consts.JDBC_CONNECT_STRING);

	}

	/**
	 *
	 */
	public Connection getConnection() throws SQLException {
		return ds.getConnection();

	}


	/**
	 */
	public static Integer getNullableInt(String colName, ResultSet rs)
			throws SQLException {

		int colValue = rs.getInt(colName);
		if (rs.wasNull()) {
			return null;
		}
		return colValue;
	}

	/**
	 */
	public static Double getNullableDouble(String colName, ResultSet rs)
			throws SQLException {

		Double colValue = rs.getDouble(colName);
		if (rs.wasNull()) {
			return null;
		}
		return colValue;
	}

	/**
	 */
	public static int getSqlExcuteTimeout() {

		int timeout = 30;

		try {
			timeout = Common.GetResourcesInteger("sql.timeout");
		} catch (MissingResourceException e) {
		}

		return timeout;
	}

}
