/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.dao;

import com.itn.Entities.UserProfile;
import java.util.List;

/**
 *
 * @author Hp
 */
public interface UserProfileDao {
    List<UserProfile> findAll();
     
    UserProfile findByType(String type);
     
    UserProfile findById(Long id);
    
}
