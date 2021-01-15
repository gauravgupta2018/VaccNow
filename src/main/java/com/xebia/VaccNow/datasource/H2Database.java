package com.xebia.VaccNow.datasource;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@Profile(value = {"local","test"})
@EnableJpaRepositories(basePackages= {"com.xebia.VaccNow.datasource.Repo"}, entityManagerFactoryRef = "h2FactoryManager", transactionManagerRef = "h2transactionManager")
public class H2Database {

	Logger logger = LoggerFactory.getLogger(H2Database.class);
	
	@Autowired
	Environment env;
	
	@Bean(name="h2DataSource")
	public DataSource h2dataSource() {
		
		logger.info("Initializing Datasource bean");
		System.out.println("Gaurav");
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(this.env.getProperty("datasource.driverClassName"));
		config.setUsername(this.env.getProperty("datasource.username"));
		config.setPassword(this.env.getProperty("datasource.password"));
		config.setDriverClassName(this.env.getProperty("datasource.driverClassName"));
		config.setJdbcUrl(this.env.getProperty("datasource.url"));
		HikariDataSource dataSource  = new HikariDataSource(config);
		return dataSource;
	}
	
	@Bean(name="h2FactoryManager")
	public LocalContainerEntityManagerFactoryBean h2entityfactoryManager() {
		logger.info("Initializing factory manager bean");
		
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		HibernateJpaVendorAdapter adapter  = new HibernateJpaVendorAdapter();
		Map<String, String> properties = new HashMap<String,String>();
		properties.put("hibernate.dialect",this.env.getProperty("database-platform") );
		properties.put("hibernate.showsql", "true");
		
		entityManager.setJpaPropertyMap(properties);
		entityManager.setDataSource(h2dataSource());
		entityManager.setJpaVendorAdapter(adapter);
		entityManager.setPackagesToScan("com.xebia.VaccNow.datasource.Repo");
		entityManager.setPersistenceUnitName("H2DatabaseUnit");
		return entityManager;
	}
	
	@Bean(name="h2transactionManager")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager jpa = new JpaTransactionManager();
		jpa.setEntityManagerFactory(h2entityfactoryManager().getObject());
		return jpa;
	}
}
