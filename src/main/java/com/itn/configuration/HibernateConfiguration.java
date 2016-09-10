/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.configuration;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Hp
 */
@Configuration
@ComponentScan({"com.itn"}) 
@EnableTransactionManagement
//Reads application.properties from class path and loads it to the environment
@PropertySource(value = "classpath:application.properties")
public class HibernateConfiguration {
    @Autowired
    private Environment env;
   
    @Bean
    public Properties prop(){
       Properties prop = new Properties();
       prop.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
       prop.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
       prop.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
       prop.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
        
        return prop;
    }
    
    @Bean
    public DataSource ds(){
        DriverManagerDataSource dm = new DriverManagerDataSource();
        dm.setDriverClassName(env.getRequiredProperty("hibernate.driver_class"));
        dm.setUrl(env.getRequiredProperty("hibernate.url"));
        dm.setUsername(env.getRequiredProperty("hibernate.username"));
        dm.setPassword(env.getRequiredProperty("hibernate.password"));
        return dm;
    }
    
    @Bean
    public LocalSessionFactoryBean sessionFac(){
        LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
        sf.setHibernateProperties(prop());
        sf.setDataSource(ds());
        sf.setPackagesToScan(new String[]{"com.itn.Entities"});
        return sf;
    }
    
    @Bean
    @Autowired 
    public HibernateTransactionManager tm(SessionFactory sf){
        HibernateTransactionManager htm = new HibernateTransactionManager();
        htm.setSessionFactory(sf);
        return htm;
    }
    
    
    
    
    
}
