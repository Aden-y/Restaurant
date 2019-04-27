/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Staff extends User{
    private Restaurant restaurant;
    
    public Staff(String name, String username, String password, Restaurant rest) {
        super(name, username, password);
        this.role="staff";
        this.restaurant=rest;
    }

}