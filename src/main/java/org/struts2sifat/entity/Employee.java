/**
 *
 */
package org.struts2sifat.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class Employee implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 */
	private String employeeId;

	/**
	 */
	private String employeeName;

	/**
	 */
	private String password;

	/**
	 */
	private Date updtDate;

	/**
	 */
	public Employee() {
	}

	/**
	 *
	 */
	public Employee(String employee_id, String employeeName, String password) {
		this.employeeId = employee_id;
		this.employeeName = employeeName;
		this.password = password;
	}

 
	@Override
	public String toString() {
		return "Employee ["
				+ (employeeId != null ? "employeeId=" + employeeId + ", " : "")
				+ (employeeName != null ? "employeeName=" + employeeName + ", "
						: "")
				+ (password != null ? "password=" + password + ", " : "")
				+ (updtDate != null ? "updtDate=" + updtDate : "") + "]";
	}

	/**
	 *
	 * @return employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 *
	 */
	public void setEmployeeId(String employee_id) {
		this.employeeId = employee_id;
	}

	/**
	 *
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 *
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 *
	 * @return updtDate
	 */
	public Date getUpdtDate() {
		return updtDate;
	}

	/**
	 *
	 */
	public void setUpdtDate(Date updt_date) {
		this.updtDate = updt_date;
	}

	/**
	 *
	 * @return employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 *
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


}
