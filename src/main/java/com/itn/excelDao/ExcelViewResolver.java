/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.excelDao;

import java.util.Locale;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

/**
 *
 * @author Hp
 */
public class ExcelViewResolver implements ViewResolver {

    @Override
    public View resolveViewName(String string, Locale locale) throws Exception {
        ExcelView view = new ExcelView();
        return view;
    }
    
}
