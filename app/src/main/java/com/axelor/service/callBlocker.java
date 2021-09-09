package com.axelor.service;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class callBlocker implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		int i=2;
	    if (i == 1) {
	      throw new IllegalStateException(
	          invocation.getMethod().getName() + " not allowed for now!");
	    }
	
			return invocation.proceed();
	}

}
