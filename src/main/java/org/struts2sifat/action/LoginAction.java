package org.struts2sifat.action;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import org.struts2sifat.blogic.LoginBLogic;
import org.struts2sifat.common.Common;
import org.struts2sifat.common.Consts;
import org.struts2sifat.entity.Employee;

import com.opensymphony.xwork2.ActionSupport;

 
public class LoginAction extends ActionSupport {

	 
	private Log log = LogFactory.getLog(LoginAction.class);

	 
	private static final long serialVersionUID = 1L;

	 
	private Employee employee;


 
	public String execute() {

		return SUCCESS;
	}

	 
	public String login() throws Exception {

 		LoginBLogic loginBL = new LoginBLogic();
		employee = loginBL.getLoginUser(employee);

 		if (employee == null) {

			addActionError(getText(Consts.ERROR_MESSAGE_LOGIN_TARGET_NOT_FOUND));
			return  Consts.ACTION_RESULT_LOGIN_FAILED;

		} else {

 			if (log.isInfoEnabled()) {

				log.info("login by: " + employee.getEmployeeId());
			}

			HttpSession newsession = ServletActionContext.getRequest()
					.getSession(true);

			newsession.setAttribute(Consts.SESSION_KEY_EMPLOYEE, employee);

			return Consts.ACTION_RESULT_LOGIN;
		}

	}

	/**
	 */
	public void validateLogin() {

		if ((Common.IsNullOrEmpty(employee.getEmployeeId()))
				|| (Common.IsNullOrEmpty(employee.getPassword()))) {
			addActionError(getText(Consts.ERROR_MESSAGE_LOGIN_EMPTY));
		}

	}


	// getter, setter
	/**
	 *
	 * @return employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	 
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	////////////////////////////////////
	// Setter / Getter


}
