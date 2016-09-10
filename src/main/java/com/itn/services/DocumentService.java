/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.services;

import com.itn.Entities.Document;
import java.util.List;

/**
 *
 * @author Hp
 */
public interface DocumentService {
     void saveDocument(Document d);
    void deleteDocument(Document d);
    Document retriveByDocumentId(long id);
    List<Document> retriveByUserId(long id);
    
    
}
