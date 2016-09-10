/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.configuration;

import com.itn.excelDao.ExcelViewResolver;
import com.itn.excelDao.PdfViewResolver;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * This class is an example of a concrete class
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.itn")//Handler Mapper
////Reads application.properties from class path and loads it to the environment
//@PropertySource(value = "classpath:views.properties")
public class ProjectConfiguration extends WebMvcConfigurerAdapter {

//    a converter who will be responsible for converting an id into an Object.This is required to handle one-to-many relationship in JSP. 
//    During User creation, A User can be allocated multiple roles/userProfiles, and so we need a converter to map a particular role/userProfile 
    //to a user based on profile id. Below provided is the converter class.
    @Autowired
    RoleToUserProfileConverter roleToUserProfileConverter;
    
//    @Bean  
//    public ResourceBundleViewResolver resourceBundleViewResolver() {  
//	ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
//        resolver.setOrder(1);
//	resolver.setBasename("views");
//        return resolver;  
//    }
    
    


    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setSuffix(".jsp");
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setOrder(2);//we need this when there is more than one resolver
        registry.viewResolver(viewResolver);

    }
    
    @Bean(name = "multipartResolver")
    public StandardServletMultipartResolver resolver() {
        return new StandardServletMultipartResolver();
    }

//    This is used to activate bootstrap or any extra resources such as css, bootstrap images etc
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    //Converter is required while you have a enum class and where you want to convert an object to string
    //and then to Long or int
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(roleToUserProfileConverter);
    }
    
//    ----------------------Converting file to Xcel/PDF and downloading it-----------------
    
    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
 
        // Define all possible view resolvers
        List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
 
        resolvers.add(excelViewResolver());
        resolvers.add(pdfViewResolver());
         
        resolver.setViewResolvers(resolvers);
        return resolver;
    }
    
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.ignoreAcceptHeader(true).defaultContentType(
                MediaType.TEXT_HTML);
    }
    
     @Bean
    public ViewResolver excelViewResolver() {
        return new ExcelViewResolver();
    }
    
    @Bean
    public ViewResolver pdfViewResolver() {
        return new PdfViewResolver();
    }
   
    
    //    ----------------------Converting file to Xcel/PDF and downloading it-----------------

    
    

}
