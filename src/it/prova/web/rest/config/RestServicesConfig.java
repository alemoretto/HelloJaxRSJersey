package it.prova.web.rest.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import it.prova.web.rest.resources.AutomobileResource;

public class RestServicesConfig extends Application {
	 public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(AutomobileResource.class);
        return classes;
	}
}