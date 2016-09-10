/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.configuration;
//File Upload Import
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
//File Upload Import
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author Hp
 */
public class ProjectInitials extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ProjectConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

//    -------------------File Upload-----------------------------
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement(LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD));

    }
    private static final String LOCATION = "C:\\UploadedFile";
    private static final long MAX_FILE_SIZE = 25 * 1024 * 1024; //for 25 MB, 25 X 1024 X1024, this goes to byte
    private static final long MAX_REQUEST_SIZE = 30 * 1024 * 1024; //for 25 MB, 25 X 1024 X1024, this goes to byte
    private static final int FILE_SIZE_THRESHOLD = 0; //for 25 MB, 25 X 1024 X1024, this goes to byte

 //    -------------------File Upload-----------------------------
}
