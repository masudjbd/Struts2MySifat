package org.struts2sifat.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import org.struts2sifat.common.Consts;

import com.opensymphony.xwork2.ActionSupport;

 
public class LogoutAction extends ActionSupport {
	 
	private static final long serialVersionUID = 1L;

	 
	public String execute() {

		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute(Consts.SESSION_KEY_EMPLOYEE);
		return SUCCESS;
	}
}
