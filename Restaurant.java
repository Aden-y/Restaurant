
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Restaurant {
    private String foodType;
    private String name;//Name of the Restaursnt
    private double minPrice;
    private double deliveryCost;
    private int rating;
    private String street;
    private int address;
    private String city;
    private ArrayList<Dish> dishes;
    private String offers;//Yes or no
    
    
    public  Restaurant(String name, String foodType, String street, 
            int address, int rating, 
            double minPrice, double deliveryCost,
            ArrayList<Dish> dishes, String city,String offers){
        this.city=city.toLowerCase();
        this.name=name;
        this.foodType=foodType;
        this.street=street.toLowerCase();
        this.deliveryCost=deliveryCost;
        this.minPrice=minPrice;
        this.rating=rating;
        this.dishes=dishes;
        this.offers=offers;
    }
    
    public String getType(){
        return this.foodType;
    }
    public void displayDishesInAssending(){
        ArrayList<Dish> tempDishes=new  ArrayList<Dish>();
        double min=Float.MAX_VALUE;
        int index=0;
        for(int j=0 ; j < this.dishes.size(); j++){
                    for(int i=0 ; i<this.dishes.size();i++){
            double tempMin=this.dishes.get(i).getPrice();
            if(tempMin<=min){
                min=tempMin;
                index=i;
            }
            
        }
        tempDishes.add(this.dishes.get(index));
        this.dishes.get(index).setPrice(Float.MAX_VALUE);
        }
        this.dishes=tempDishes;
        tempDishes=null;
        System.out.println("Dished In "+this.name+" Soated In Ascending Order");
        for (int i=0; i<this.dishes.size(); i++){
            System.out.println((i+1)+"\t"+this.dishes.get(i).toString());
            
        }
    }
    
       public void displayDishesInDescending(){
        ArrayList<Dish> tempDishes=new  ArrayList<Dish>();
        double max=0.0;
        int index=0;
        for(int j=0 ; j < this.dishes.size(); j++){
            for(int i=0 ; i<this.dishes.size();i++){
            double tempMax=this.dishes.get(i).getPrice();
            if(tempMax >= max){
                max=tempMax;
                index=i;
            }
            
        }
        tempDishes.add(this.dishes.get(index));
        this.dishes.get(index).setPrice(Float.MIN_VALUE);
        }
        this.dishes=tempDishes;
        tempDishes=null;
        
          System.out.println("Dished In "+this.name+" Soated In Descending Order");
        for (int i=0; i<this.dishes.size(); i++){
            System.out.println((i+1)+"\t"+this.dishes.get(i).toString());
        }
    } 

    public double getDeliveryCost(){
        return this.deliveryCost;
    }
       public String getName(){
        return this.name;
    }
       public String getCity(){
           return this.city;
       }
       public String getStreet(){
           return this.street;
       }
       public String toString(){
           String str=""+this.name+"\t"+this.address+"\t"
                   + this.foodType+"\t"+this.minPrice+"\t"
                   + this.deliveryCost+"\t"
                   + this.rating+"\t" 
                   + this.offers;
           return str;
       }
       public ArrayList<Dish> getDishes(){
           return this.dishes;
       }
}
