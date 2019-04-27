/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Dish {
    private String name;
    private double cost;
    
    
    public Dish(String name, double cost){
        this.name=name;
        this.cost=cost;
        
    }
    
    public double getPrice(){
        return this.cost;
    }
    public String toString(){
        String st="";
        return st+this.name+"\t\t"+this.cost;
    } 
    public void setPrice(double p){
        this.cost=p;
    }
     public String getName(){
        return this.name;
    }
}

