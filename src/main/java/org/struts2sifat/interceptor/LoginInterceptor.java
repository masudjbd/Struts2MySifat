package org.struts2sifat.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import org.struts2sifat.action.LoginAction;
import org.struts2sifat.blogic.LoginBLogic;
import org.struts2sifat.common.Common;
import org.struts2sifat.common.Consts;
import org.struts2sifat.entity.Employee;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

 
public class LoginInterceptor extends AbstractInterceptor {

	 
	private Log log = LogFactory.getLog(LoginInterceptor.class);


	 
	private static final long serialVersionUID = 1L;

	 
	@Override
	public String intercept(ActionInvocation actioninvocation) throws Exception {

		System.out.println("*** LoginInterceptor START ***");

		 
		HttpSession session = ServletActionContext.getRequest().getSession();
		Employee employee = (Employee) session
				.getAttribute(Consts.SESSION_KEY_EMPLOYEE);

		if (log.isInfoEnabled()) {
		 
			log.info("logged in by:"
					+ (employee == null ? "null" : employee.getEmployeeId()));
		}

		Object action = actioninvocation.getAction();

		if (log.isDebugEnabled()) {
 
			StringBuffer sb = new StringBuffer();
			sb.append("call by :").append(action.getClass().getSimpleName());
			sb.append(" methods:").append(actioninvocation.getInvocationContext().getName());

			log.debug(sb.toString());
		}

		 
		boolean bLoginAction = false;
		if (action instanceof LoginAction) {
			bLoginAction = true;
		}

		 
		if (employee == null || Common.IsNullOrEmpty(employee.getEmployeeId())
				|| Common.IsNullOrEmpty(employee.getPassword())) {

			if (bLoginAction) {

				if (log.isDebugEnabled()) {
					log.debug("1.session not found. loginAction continue.");
				}

				 
				return actioninvocation.invoke();
			} else {

				if (log.isDebugEnabled()) {
					log.debug("2.session not found. foward loginAction.");
				}

				 
				return Consts.ACTION_RESULT_LOGIN;
			}

		} else {

			 
			LoginBLogic loginBL = new LoginBLogic();
			Employee emp = loginBL.getLoginUser(employee);

			if (emp == null) {

				if (log.isDebugEnabled()) {
					log.debug("3.session exists. Employee is not found. forward loginAction.");
				}

				 
				session.removeAttribute(Consts.SESSION_KEY_EMPLOYEE);

				 
				return Consts.ACTION_RESULT_LOGIN;

			} else {

				 
				session.setAttribute(Consts.SESSION_KEY_EMPLOYEE, emp);

				if (bLoginAction) {

					if (log.isDebugEnabled()) {
						log.debug("4.session exists. Employee exists. forward Menu.");
					}

					 
					return Consts.ACTION_RESULT_MENU;
				} else {

					if (log.isDebugEnabled()) {
						log.debug("5.session exists. Employee exists. forward targetAction.");
					}

					 
					return actioninvocation.invoke();
				}
			}

		}
	}
}