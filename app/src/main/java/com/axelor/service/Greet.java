package com.axelor.service;

import com.google.inject.ImplementedBy;

@ImplementedBy(Greeter.class)
public interface Greet {

	public void sayHello();
}
