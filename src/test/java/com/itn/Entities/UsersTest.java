/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.Entities;

import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hp
 */
public class UsersTest {
    
    public UsersTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUsername method, of class Users.
     */
    @org.junit.Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Users instance = new Users();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class Users.
     */
    @org.junit.Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        Users instance = new Users();
        instance.setUsername(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class Users.
     */
    @org.junit.Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Users instance = new Users();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class Users.
     */
    @org.junit.Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        Users instance = new Users();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getState method, of class Users.
     */
    @org.junit.Test
    public void testGetState() {
        System.out.println("getState");
        Users instance = new Users();
        String expResult = "";
        String result = instance.getState();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setState method, of class Users.
     */
    @org.junit.Test
    public void testSetState() {
        System.out.println("setState");
        String state = "";
        Users instance = new Users();
        instance.setState(state);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserProfiles method, of class Users.
     */
    @org.junit.Test
    public void testGetUserProfiles() {
        System.out.println("getUserProfiles");
        Users instance = new Users();
        Set<UserProfile> expResult = null;
        Set<UserProfile> result = instance.getUserProfiles();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserProfiles method, of class Users.
     */
    @org.junit.Test
    public void testSetUserProfiles() {
        System.out.println("setUserProfiles");
        Set<UserProfile> userProfiles = null;
        Users instance = new Users();
        instance.setUserProfiles(userProfiles);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstName method, of class Users.
     */
    @org.junit.Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        Users instance = new Users();
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstName method, of class Users.
     */
    @org.junit.Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        Users instance = new Users();
        instance.setFirstName(firstName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastName method, of class Users.
     */
    @org.junit.Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Users instance = new Users();
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastName method, of class Users.
     */
    @org.junit.Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        Users instance = new Users();
        instance.setLastName(lastName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Users.
     */
    @org.junit.Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Users instance = new Users();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Users.
     */
    @org.junit.Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Users instance = new Users();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Users.
     */
    @org.junit.Test
    public void testGetId() {
        System.out.println("getId");
        Users instance = new Users();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Users.
     */
    @org.junit.Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        Users instance = new Users();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Users.
     */
    @org.junit.Test
    public void testHashCode() {
        System.out.println("hashCode");
        Users instance = new Users();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Users.
     */
    @org.junit.Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Users instance = new Users();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Users.
     */
    @org.junit.Test
    public void testToString() {
        System.out.println("toString");
        Users instance = new Users();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
