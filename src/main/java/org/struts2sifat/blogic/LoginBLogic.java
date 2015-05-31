package org.struts2sifat.blogic;

import org.struts2sifat.dao.EmployeeDao;
import org.struts2sifat.entity.Employee;


/**
 *
 *
 */
public class LoginBLogic {

	/**
	 *
	 * @throws Exception
	 */
	public Employee getLoginUser(Employee employee)throws Exception{
		EmployeeDao empdao = new EmployeeDao();

		return empdao.selectByIdAndPassword(employee);

	}

}
