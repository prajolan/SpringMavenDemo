/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.controller;

import com.itn.Entities.Users;
import com.itn.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Hp
 */
//this is equivalent to having @Controller and @ResponseBody
//This controller is used while making restfull application, This controller will always have ResponseEntity
@RestController

public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/user/{name}")
    public Users user(@PathVariable String name) {//REST Endpoint.

        Users user = new Users(name, "Hello");
        return user;
    }

    
    @RequestMapping(value = "/users/", method = RequestMethod.GET)
    public ResponseEntity<List<Users>> list() {
        List<Users> users = userService.findAll();
        //List should be checked with .isEmpty() not null
        if (users.isEmpty()) {
            return new ResponseEntity<List<Users>>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
        }
    }
    
    //-------------------Retrieve Single User--------------------------------------------------------
     
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> getUser(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        Users user = userService.findById(id);
        //Object should be checked with null
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Users>(user, HttpStatus.OK);
    }
        //-------------------Create User--------------------------------------------------------

    @RequestMapping(value = "/user/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@RequestBody Users user,    UriComponentsBuilder ucBuilder) {
 
        if (userService.findByUserName(user.getUsername())!=null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
 
        userService.save(user);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    //------------------- Update a User --------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Users> updateUser(@PathVariable("id") long id, @RequestBody Users user) {
        System.out.println("Updating User " + id);
         
        Users currentUser = userService.findById(id);
         
        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
        }
 
        userService.update(user);
        return new ResponseEntity<Users>(currentUser, HttpStatus.OK);
    }
 
    //------------------- Delete a User --------------------------------------------------------
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Users> deleteUser(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);
 
        Users user = userService.findById(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
        }
 
        userService.deleteById(id);
        return new ResponseEntity<Users>(HttpStatus.NO_CONTENT);
    }
 
     
    //------------------- Delete All Users --------------------------------------------------------
     
    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<Users> deleteAllUsers() {
        System.out.println("Deleting All Users");
 
        userService.deleteAll();
        return new ResponseEntity<Users>(HttpStatus.NO_CONTENT);
    }
 

 

}
