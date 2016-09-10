/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.dao;

import com.itn.Entities.UserProfile;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Hp
 */
@Repository //This lies in persistance layer
public class UserProfileDaoImpl extends AbstractDao<Long, UserProfile> implements UserProfileDao {

    @Override
    public List<UserProfile> findAll() {
        Query query = getSession().createQuery("SELECT u FROM UserProfile u"); //to display all queries
        return query.list();
    }

    @Override
    public UserProfile findByType(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserProfile findById(Long id) {
        return getByKey(id);
    }

}
