package com.sanjeevaniehr.user.registration.services;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class SanjeevaniServiceApp extends Application {

	@Override
	public Set<Class<?>> getClasses() {

		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(SanveevaniServicesImpl.class);
		return classes;
	}

}
