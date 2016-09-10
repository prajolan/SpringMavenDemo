/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.services;

import com.itn.Entities.Users;
import java.util.List;

/**
 *
 * @author Hp
 */
public interface UserService {
    public void save(Users u);

    public void update(Users u);

    public Users findById(long id);

    public Users findByUserName(String username);

    public void deleteById(long id);

    public void deleteAll();

    public List<Users> findAll();
}
