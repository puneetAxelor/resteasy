package com.axelor.factory;

import com.axelor.service.UserService;
import com.axelor.service.UserServiceImpl;

public class UserServiceFactory {

	private static UserService userService;
	
	static {
		userService = new UserServiceImpl();
	}
	
	public static UserService getUserService() {
		return userService;
	}
}
