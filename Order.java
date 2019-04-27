
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Order {
    private Dish dish;
    private Restaurant rest;
    private double total;
    private Date deliveryDate;
    private Customer cust;
    private int id;
    private int quantity;
    public Order(int id,Restaurant rest, Dish dish, Date date, Customer cust, int quantity){
        this.id=id;
        this.quantity=quantity;
        this.deliveryDate=date;
        this.rest=rest;
        this.dish=dish;
        this.cust=cust;
        this.total=this.rest.getDeliveryCost()+this.dish.getPrice()*this.quantity;
        
    }
    
    
    public String toString(){
        String str="";
        return str+id+"\t"+this.cust.getName()+"\t"+
        this.dish.getName()+"\t"+this.rest.getName()+"\t"+this.total+"/t"+this.deliveryDate.toString()+"\t"+this.quantity;
    }
    
    public double getTotal(){
        return this.total;
    }
    public String dateToString(){
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    return dateFormat.format(this.deliveryDate);
    }
    
    public String getName(){
        return this.dish.getName();
    }
    public int getQtty(){
        return this.quantity;
    }
}
