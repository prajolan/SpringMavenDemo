/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.Utils;

/**
 *
 * @author Hp
 */
public enum State {
    ACTIVE("Active"),
    INACTIVE("Inactive");
    
    private String state;

    private State(String state) {
        this.state = state;
    }

    public static State getACTIVE() {
        return ACTIVE;
    }

    public static State getINACTIVE() {
        return INACTIVE;
    }

    public String getState() {
        return state;
    }
    
}
