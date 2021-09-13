package com.axelor.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.annotation.Nullable;
import javax.persistence.EntityManager;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class Greeter implements Greet {
	
	@Inject
	Provider<EntityManager> emp;

	@Retention(RetentionPolicy.RUNTIME)
	public
	@interface Message {}
	
	@Retention(RetentionPolicy.RUNTIME)
	public
	@interface Count {}
	

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.METHOD)
	public
	@interface NotOnWeekends {}
	
		private final String message;
		private final int count;
		
		
		@Inject
		Greeter(@Message @Nullable String message, @Count int count) {
			this.message = message;
			this.count = count;
		}
		
		
		public void sayHello() {
			for (int i=0; i < count; i++) {
				System.out.println(message);
			}
			System.out.println("Hello java");
		}


	}
