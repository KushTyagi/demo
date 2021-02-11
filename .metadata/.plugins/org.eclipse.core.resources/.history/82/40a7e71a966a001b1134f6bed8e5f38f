package com.example.demo.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.entity.Userentity;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.example.demo.dao","com.example.demo.repo","com.example.demo.entity.Userentity"},
        entityManagerFactoryRef = "userEntityManagerFactory",
        transactionManagerRef= "userTransactionManager"
)
public class UserDataBaseConfiguration {

	/*
	 * DataSourceProperties object to get the instance of data source builder
	
	*/
	
	@Bean
	@Primary
	@ConfigurationProperties("user.datasource")
	public DataSourceProperties userDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	/*
	 * DataSourceBuilder object use the data base properties which is found in application.properties file to create data source object 
	  
	*/
	@Bean
	@Primary
	public DataSource userDataSource() {
		return userDataSourceProperties().initializeDataSourceBuilder()
				.type(HikariDataSource.class).build();
	}
	
	/*
	 * We use EntityManagerFactoryBean bean to obtain the instance of EntityManager 
	 * 
	*/
	@Primary
	@Bean("userEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean userEntityManagerFactory(EntityManagerFactoryBuilder builder) {
      		return builder.dataSource(userDataSource()).packages(Userentity.class).build();
	}
	
	/*
	 * PlatformTransactionManager helps the commit or roll-back the transaction
	 * Transaction manager requires a reference to the EntityManagerFactoryBean therefore we will use the @Qualifier annotation to auto-wire the entity manager 
    */
	@Primary
    @Bean("userTransactionManager")
	public PlatformTransactionManager userTransactionManager(@Qualifier("userEntityManagerFactory") LocalContainerEntityManagerFactoryBean userEntityManagerFactoryBean) {
		return new JpaTransactionManager(userEntityManagerFactoryBean.getObject());
	}
	
	
}


