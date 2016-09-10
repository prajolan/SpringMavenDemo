/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.services;

import com.itn.Entities.Users;
import com.itn.dao.UserDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hp
 */
@Service//Tells the compiler that this is service class and resides in Buisness Layer
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Users> findAll() {
       List<Users> display = userDao.findAll();
       return display;
    }

    @Override
    public void save(Users u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        userDao.save(u);
    }

    @Override
    public Users findById(long id) {
        return userDao.findById(id);
    }

    @Override
    public Users findByUserName(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public void deleteById(long id) {
        userDao.deleteById(id);
    }

    @Override
    public void update(Users u) {
        Users user = userDao.findById(u.getId());
        user.setFirstName(u.getFirstName());
        user.setLastName(u.getLastName());
        user.setEmail(u.getEmail());
        
    }

    @Override
    public void deleteAll() {
        userDao.deleteAll();
    }
    
}
