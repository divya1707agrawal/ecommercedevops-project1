package com.niit.shoppingcart.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext arg0) throws ServletException {

		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		  rootContext.register(ApplicationContextConfig.class);
		  rootContext.register(ApplicationContextConfig.class);
	         
	        ServletRegistration.Dynamic dispatcher = arg0.addServlet(
	                "SpringDispatcher", new DispatcherServlet(rootContext));
	        dispatcher.setLoadOnStartup(1);
	        dispatcher.addMapping("/");
	       
	        
	
	}

}
