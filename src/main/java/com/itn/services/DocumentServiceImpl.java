/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.services;

import com.itn.Entities.Document;
import com.itn.dao.DocumentDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hp
 */
@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentDao documentDao;
    
    @Override
    public void saveDocument(Document d) {
        documentDao.saveDocument(d);
    }
    
    @Override
    public void deleteDocument(Document d) {
    documentDao.deleteDocument(d);    }
    
    @Override
    public Document retriveByDocumentId(long id) {
return documentDao.retriveByDocumentId(id);    }
    
    @Override
    public List<Document> retriveByUserId(long id) {
return documentDao.retriveByUserId(id);    }
    
}
