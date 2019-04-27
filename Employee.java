/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Employee extends User{
    private Restaurant restaurant;
    
    public Employee(String name, String username, String password, Restaurant rest) {
        super(name, username, password);
        this.role="employee";
        this.restaurant=rest;
    }

}
