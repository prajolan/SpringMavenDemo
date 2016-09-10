/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.excelDao;

import com.itn.Entities.Users;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;

/**
 *
 * @author Hp
 */
public class PdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {

        //Users user = (Users) model.get("user");
         List<Users> userlist = (List<Users>) model.get("allUsers");

        PdfPTable table = new PdfPTable(4);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.getDefaultCell().setBackgroundColor(Color.lightGray);

        table.addCell("ID");
        table.addCell("First Name");
        table.addCell("Last Name");
        table.addCell("Email");

        for(Users users:userlist){
        table.addCell(users.getId().toString());
        table.addCell(users.getFirstName());
        table.addCell(users.getLastName());
        table.addCell(users.getEmail());
        }

        document.add(table);

    }

}
