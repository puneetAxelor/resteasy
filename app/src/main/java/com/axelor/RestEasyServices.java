package com.axelor;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.axelor.resource.HelloResource;

@ApplicationPath("/restapi")
public class RestEasyServices extends Application {

	private Set < Object > singletons = new HashSet < Object > ();

    public RestEasyServices() {
        singletons.add(new HelloResource());
    }

    @Override
    public Set < Object > getSingletons() {
        return singletons;
    }
}
