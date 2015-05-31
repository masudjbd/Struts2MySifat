package org.struts2sifat.interceptor;

import java.util.List;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.config.entities.ExceptionMappingConfig;
import com.opensymphony.xwork2.interceptor.ExceptionHolder;
import com.opensymphony.xwork2.interceptor.ExceptionMappingInterceptor;

 
public class SampleExceptionMappingInterceptor extends ExceptionMappingInterceptor {

	 
	private static final long serialVersionUID = 1L;

	 
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		System.out.println("*** SampleExceptionMappingInterceptor ***");

		String result = "";

		try {
			result = invocation.invoke();
		} catch (Exception e) {

			 
			if (isLogEnabled()) {
				handleLogging(e);
			}

			List<ExceptionMappingConfig>  exceptionMappings = invocation
					.getProxy().getConfig().getExceptionMappings();

			String mappedResult = this.findResultFromExceptions(
					exceptionMappings, e);


			if (mappedResult != null) {

				Exception ex = e;

				result = mappedResult;
				publishException(invocation, new ExceptionHolder(ex));

			} else {
				throw e;
			}
		}

		return result;
	}

}