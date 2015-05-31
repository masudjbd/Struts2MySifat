package org.struts2sifat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.struts2sifat.common.Common;
import org.struts2sifat.entity.Employee;

/**
 *
 */
public class EmployeeDao extends CommonDao {

	/**
	 */
	private Log log = LogFactory.getLog(this.getClass());

	/**
	 * Constructor
	 *
	 */
	public EmployeeDao() throws NamingException {

		super();

	}


	/**
	 */
	public List<Employee> selectById(String id)
			throws Exception {

		log.debug("Employee ");

		boolean idIsExist = false;

		if (!Common.IsNullOrEmpty(id)) {
			idIsExist = true;
		}

		Connection con = super.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Employee> list = null;

		try {
			StringBuffer sbSQL = new StringBuffer();
			sbSQL.append("select employee_id, employeeName, employee_password, updt_date from T_EMPLOYEE");

			if (idIsExist) {
				sbSQL.append(" where employee_id = ?");
			}

			pstmt = con.prepareStatement(sbSQL.toString());
			//pstmt.setQueryTimeout(CommonDao.getSqlExcuteTimeout());

			if (idIsExist) {
				pstmt.setString(1, id);
			}

			rs = pstmt.executeQuery();

			// Iterate through the data in the result set and display it.
			while (rs.next()) {

				if (list == null) {
					list = new ArrayList<Employee>();
				}

				Employee emp = new Employee();
				emp.setEmployeeId(rs.getString("employee_id"));
				emp.setEmployeeName(rs.getString("employeeName"));
				emp.setPassword(rs.getString("employee_password"));
				emp.setUpdtDate(rs.getDate("updt_date"));
				list.add(emp);
			}
		}

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}
		return list;
	}

	/**
	 */
	public Employee selectByIdAndPassword(Employee employeeInput)
			throws Exception {

		log.debug("Employee (ID and PASSWORD");

		Connection con = super.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Employee result = null;

		try {
			StringBuffer sbSQL = new StringBuffer();
			sbSQL.append("select employee_id, employeeName, employee_password, updt_date from T_EMPLOYEE");
			sbSQL.append(" where employee_id = ? AND employee_password = ?");

			pstmt = con.prepareStatement(sbSQL.toString());
			//pstmt.setQueryTimeout(CommonDao.getSqlExcuteTimeout());

			pstmt.setString(1, employeeInput.getEmployeeId());
			pstmt.setString(2, employeeInput.getPassword());

			rs = pstmt.executeQuery();

			// Iterate through the data in the result set and display it.
			while (rs.next()) {

				result = new Employee();
				result.setEmployeeId(rs.getString("employee_id"));
				result.setEmployeeName(rs.getString("employeeName"));
				result.setPassword(rs.getString("employee_password"));
				result.setUpdtDate(rs.getDate("updt_date"));
			}
		}

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}
		return result;
	}

	/**
	 */
	public int regist(Employee employee)
			throws Exception {

		log.debug(" wee ");

		Connection con = super.getConnection();
		PreparedStatement pstmt = null;
		int rs = 0;

		try {

			String SQL = "INSERT INTO T_EMPLOYEE (employee_id, employeeName, employee_password, updt_date) VALUES (?, ?, ?, ?);";

			pstmt = con.prepareStatement(SQL);
//			pstmt.setQueryTimeout(CommonDao.getSqlExcuteTimeout());

			pstmt.setString(1, employee.getEmployeeId());
			pstmt.setString(2, employee.getEmployeeName());
			pstmt.setString(3, employee.getPassword());
			pstmt.setDate(4, Common.createNewDate());

			// Insert, UpdateはexecuteUpdate
			rs = pstmt.executeUpdate();

		}

		finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}

		return rs;
	}

	/**
	 */
	public int update(Employee employee)
			throws Exception {

		log.debug(" wee ");

		Connection con = super.getConnection();
		PreparedStatement pstmt = null;
		int rs = 0;

		try {

			String SQL = "UPDATE T_EMPLOYEE SET employeeName = ?, employee_password = ?, updt_date = ? WHERE employee_id = ?;";

			pstmt = con.prepareStatement(SQL);
//			pstmt.setQueryTimeout(CommonDao.getSqlExcuteTimeout());

			pstmt.setString(1, employee.getEmployeeName());
			pstmt.setString(2, employee.getPassword());
			pstmt.setDate(3, Common.createNewDate());
			pstmt.setString(4, employee.getEmployeeId());

			// Insert, UpdateはexecuteUpdate
			rs = pstmt.executeUpdate();

		}

		finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}

		return rs;
	}

	/**
	 *
	 */
	public int delete(String employee_id)
			throws Exception {

		log.debug(" wee ");

		Connection con = super.getConnection();
		PreparedStatement pstmt = null;
		int rs = 0;

		try {

			String SQL = "DELETE FROM T_EMPLOYEE WHERE employee_id = ?;";

			pstmt = con.prepareStatement(SQL);
//			pstmt.setQueryTimeout(CommonDao.getSqlExcuteTimeout());

			pstmt.setString(1, employee_id);

			// Insert, UpdateはexecuteUpdate
			rs = pstmt.executeUpdate();

		}

		finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}

		return rs;
	}

}
