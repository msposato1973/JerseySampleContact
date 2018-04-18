package com.concretepage;
 
 
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

import org.jboss.resteasy.logging.Logger;

import com.concretepage.ComsumerService;

public class ComsumerApplication extends Application{
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();
	   
    public ComsumerApplication() {
        singletons.add(new ComsumerService());
    }
    
    @Override
    public Set<Class<?>> getClasses()
    {
       return empty;
    }
    
    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
