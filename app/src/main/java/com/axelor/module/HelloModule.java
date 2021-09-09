package com.axelor.module;

import com.axelor.resource.HelloResource;
import com.axelor.service.Greet;
import com.axelor.service.Greeter;
import com.axelor.service.UserService;
import com.axelor.service.UserServiceImpl;
import com.axelor.service.callBlocker;
import com.axelor.service.Greeter.Count;
import com.axelor.service.Greeter.Message;
import com.axelor.service.Greeter.NotOnWeekends;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.matcher.Matchers;

public class HelloModule implements Module {

	@Provides @Singleton
	@Count
	static Integer provideCount() {
		return 3;
	}
	
	@Provides @Singleton
	@Message
	static String provideMessage() {
		return "hello world!!!!!!!!!!!!!!!!!!!!!!";
	}
	
	@Override
	public void configure(Binder binder) {
		binder.bind(UserService.class).to(UserServiceImpl.class);
		binder.bind(HelloResource.class);
		binder.bind(Greet.class).to(Greeter.class);
		binder.bindInterceptor(Matchers.any(), Matchers.annotatedWith(NotOnWeekends.class),
		        new callBlocker());
		
	}

}
