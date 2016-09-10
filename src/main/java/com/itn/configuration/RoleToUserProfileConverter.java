/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.configuration;

import com.itn.Entities.UserProfile;
import com.itn.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hp
 */
@Service //This is in buisness layer
public class RoleToUserProfileConverter implements Converter<Object, UserProfile>{
    
     @Autowired
    UserProfileService userProfileService;

    @Override
    public UserProfile convert(Object s) {
        //Converting object s to string and then converting it to long
        Long id = Long.parseLong((String)s);
        return userProfileService.findById(id);
    }
    
}
