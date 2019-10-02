package com.spring.Configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import static org.hibernate.cfg.Environment.*;
@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = {
		@ComponentScan("com.spring.DAO"),
		@ComponentScan("com.spring.service")
})
public class AppConfig {
	@Autowired
	private Environment env;
	@Bean
	public LocalSessionFactoryBean getSessionFactory(){
		LocalSessionFactoryBean factorybean = new LocalSessionFactoryBean();
		Properties properties = new Properties();
		
		// Setting up the JDBC Properties
		
		properties.put(DRIVER, env.getProperty("mysql.driver"));
		properties.put(URL, env.getProperty("mysql.url"));
		properties.put(USER, env.getProperty("mysql.user"));
		properties.put(PASS , env.getProperty("mysql.password"));
		
		// Setting up the Hibernate Properties
		
		properties.put(SHOW_SQL , env.getProperty("hibernte.show_sql"));
		properties.put(HBM2DDL_AUTO , env.getProperty("hibernate.hhm2ddl.auto"));
		
		// Setting up the C3P0 Properties
		
		properties.put(C3P0_MIN_SIZE , env.getProperty("hibernate.c3p0.min_size"));
		properties.put(C3P0_MAX_SIZE , env.getProperty("hibernate.c3p0.max_size"));
		properties.put(C3P0_ACQUIRE_INCREMENT , env.getProperty("hibernate.c3p0.acquire_increment"));
		properties.put(C3P0_TIMEOUT , env.getProperty("hibernate.c3p0.Lineout"));
		properties.put(C3P0_MAX_STATEMENTS , env.getProperty("hibernate.c3p0.max_statement"));
		
		factorybean.setHibernateProperties(properties);
		factorybean.setPackagesToScan("com.spring.Model");
		return factorybean;
	
}	
		@Bean
		public HibernateTransactionManager gettransactionmnager() {
			HibernateTransactionManager transctionmanager = new HibernateTransactionManager();
			transctionmanager.setSessionFactory(getSessionFactory().getObject());
			return transctionmanager;
			
		}
}
