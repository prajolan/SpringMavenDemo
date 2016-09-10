/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.excelDao;

import com.itn.Entities.Users;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

/**
 *
 * @author Hp
 */
public class ExcelView extends AbstractExcelView{

    @Override
    protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest requesr, HttpServletResponse response) throws Exception {
        
        // get data model which is passed by the Spring container
        List<Users> allUsers = (List<Users>) model.get("allUsers");
        
        //Create new excel sheet
        HSSFSheet sheet = workbook.createSheet("Java Books");    
        sheet.setDefaultColumnWidth(30);
        
        //create style for header cells
        CellStyle style =  workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);
        
         // create header row
        HSSFRow header = sheet.createRow(0);
         
        header.createCell(0).setCellValue("id");
        header.getCell(0).setCellStyle(style);
        
        header.createCell(1).setCellValue("First Name");
        header.getCell(1).setCellStyle(style);
         
        header.createCell(2).setCellValue("Last Name");
        header.getCell(2).setCellStyle(style);
         
        header.createCell(3).setCellValue("Email Address");
        header.getCell(3).setCellStyle(style);
         
        // create data rows
        int rowCount = 1;
         
        for (Users aUsers : allUsers) {
            HSSFRow aRow = sheet.createRow(rowCount++);
            aRow.createCell(0).setCellValue(aUsers.getId());
            aRow.createCell(1).setCellValue(aUsers.getFirstName());
            aRow.createCell(2).setCellValue(aUsers.getLastName());
            aRow.createCell(3).setCellValue(aUsers.getEmail());
           
        }
         
    
    
    }
    
}
