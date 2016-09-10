/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.dao;

import com.itn.Entities.Document;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Hp
 */
@Repository
public class DocumentDaoImpl extends AbstractDao<Long, Document> implements DocumentDao{

    @Override
    public void saveDocument(Document d) {
        persist(d);
    }

    @Override
    public void deleteDocument(Document d) {
        delete(d);
    }

    @Override
    public Document retriveByDocumentId(long id) {
       return getByKey(id);
    }

    @Override
    public List<Document> retriveByUserId(long idd) {
        Query query = getSession().createQuery("SELECT d FROM Document d WHERE d.user.id =:jpt");
        query.setParameter("jpt", idd);
        return query.list();
    }
    
}
