/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Customer extends User {
    private int creditCard;
    
    public Customer(String name, String username, String password, int creditCard) {
        super(name, username, password);
        this.role="customer";
        this.creditCard=creditCard;
    }
    
}
