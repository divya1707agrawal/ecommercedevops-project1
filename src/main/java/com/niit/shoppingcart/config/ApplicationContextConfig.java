package com.niit.shoppingcart.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import com.niit.shoppingcart.controller.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.niit.shoppingcart.controller.BackendController;
import com.niit.shoppingcart.controller.Category;
import com.niit.shoppingcart.controller.MyCart;
import com.niit.shoppingcart.controller.Order;
import com.niit.shoppingcart.controller.PaymentMethod;
import com.niit.shoppingcart.controller.Product;
import com.niit.shoppingcart.controller.ProductDAO;
import com.niit.shoppingcart.controller.ProductDAOImpl;
import com.niit.shoppingcart.controller.Supplier;
import com.niit.shoppingcart.controller.BillingAddress;
import com.niit.shoppingcart.controller.ShippingAddress;
@Configuration
@ComponentScan("com.niit.shoppingcart.controller")
@EnableTransactionManagement
public class ApplicationContextConfig {
	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	    viewResolver.setPrefix("/WEB-INF/views/");
	    viewResolver.setSuffix(".jsp");
	    return viewResolver;
	}
	
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
	    dataSource.setUsername("sa");
	    dataSource.setPassword("");
	    
	    return dataSource;
	}	
	@Autowired
    @Bean(name="hibernateProperties")
	public Properties getHibernateProperties() {
	    Properties properties = new Properties();
	    properties.put("hibernate.show_sql", true);
	    properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	    properties.put("hibernate.hbm2ddl.auto", "create");
	
	    return properties;
	}
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
	 
	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	 
	    sessionBuilder.addAnnotatedClasses(Category.class);
	    sessionBuilder.addAnnotatedClasses(Product.class);
	    sessionBuilder.addAnnotatedClasses(Supplier.class);
	    sessionBuilder.addAnnotatedClasses(User.class);
	    sessionBuilder.addAnnotatedClasses(MyCart.class);
	    sessionBuilder.addAnnotatedClasses(Order.class);
	    sessionBuilder.addAnnotatedClasses(BillingAddress.class);
	    sessionBuilder.addAnnotatedClasses(ShippingAddress.class);
	    sessionBuilder.addAnnotatedClasses(PaymentMethod.class);
	    return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
	        SessionFactory sessionFactory) {
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
	 
	    return transactionManager;
	}
	
	//@Autowired
	//@Bean(name = "productDao")
	//public ProductDAO getUserDao(SessionFactory sessionFactory) {
	 //   return new ProductDAOImpl(sessionFactory);
	//}
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getCommonsMultipartResolver() {
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(20971520);   // 20MB
	    multipartResolver.setMaxInMemorySize(1048576);  // 1MB
	    return multipartResolver;
	}
	@Bean(name="springSecurityFilterChain")
	public DelegatingFilterProxy getFilterChainProxy()
    {
		DelegatingFilterProxy obj=new DelegatingFilterProxy();
	return obj;
	}
}




