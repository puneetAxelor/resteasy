package com.axelor.listener;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;

import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;

import com.axelor.module.HelloModule;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;

@WebListener
public class MyServletContextListener extends GuiceResteasyBootstrapServletContextListener {

	@Override
    protected List<? extends Module> getModules(ServletContext context)
    {
	
        return Arrays.asList(new JpaPersistModule("myFirstJpaUnit"), new HelloModule());
    }
    
    @Override
    public void withInjector(Injector injector)
    {
        injector.getInstance(PersistService.class).start();
    }

}
