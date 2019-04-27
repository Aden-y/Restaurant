
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Main {
    private ArrayList<User> users=new ArrayList<User>();
    private ArrayList<Restaurant> restaurants= new ArrayList<Restaurant>();
    private  Scanner console=new Scanner(System.in);
    private ArrayList<Order> orders= new ArrayList<Order>();
    private int orderId=1;
    
    public void removeOrder(){
       if(orders.isEmpty()){
           System.err.println("No orders!");
           return;
       }
       orders.remove(0);
    }
    public void listRestaursnts(){
        if(restaurants.isEmpty()){
            System.err.println("No restaurants to list.");
            return;
        }
        System.out.println("Name\tAdtrss\tFood type\tMinimum Price\tDelivery cost\tRating\tOffers");
        for(Restaurant r: restaurants){
            System.out.println(r.toString());
        }
    }
    
    public void performStaff(){
        Staff st=(Staff)validateCredentials("staff");
        if(st!=null){
                   boolean exit=false;
        while(!exit){
                    System.out.print("\nWhat would you like to do?\n1. List orders.\n"
                + "2. Delete oldest order.\n3. Exit.\nYour response :");
        int response=Integer.parseInt(console.nextLine());
        if(response<1 || response > 3){
            System.err.println("Invalid response");
        }else{
            if(response==1){
                listOrders();
            }else if(response==2){
                removeOrder();
            }else if (response==3){
                exit=true;
                break;
            }
        }
        } 
        }
    }
    public void performEmployee(){
        Employee emp=(Employee)validateCredentials("employee");
        if(emp!=null){
           boolean exit=false;
           while(!exit){
               System.out.print("What would you like to do?\n1. Add user."
                       +"\n2. Add restaursnt."
                       +"\n3. Delete user."
                       +"\n4. List restaurants."
                       +"\n5. Exit."
                       +"\nYour response :");
               
               int response=Integer.parseInt(console.nextLine());
               if(response <1 || response > 5){
                   System.err.println("Invalid response.");
               }else{
                   if(response==1){
                       addUser();
                   }else if(response==2){
                       addRestaurant();
                   }else if(response==3){
                       deregisterUser();
                   }else if(response==4){
                       listRestaursnts();
                   }else if(response==5){
                       exit=true;
                       break;
                   }
               }
           }
            
        }
    
    }
    public void listOrders(){
        if(orders.isEmpty()){
            System.err.println("Orders list is empty");
            return;
        }
        System.out.println("Order ID\tCustomer Name\tDish Name\tRestauran Name\tTotal Amount\tDelivery Date\tQuantity");
        for(Order o: orders){
            System.out.println(o.toString());
        }
    }
    public void addRestaurant(){
        System.out.println("\nEnter the details of the new restaurant.");
        System.out.print("Name :");
        String name=console.nextLine();
        System.out.print("Food type :");
        String foodType=console.nextLine();
          System.out.print("City :");
        String city=console.nextLine();
        System.out.print("Street :");
        String street=console.nextLine();
        System.out.print("Address :"); 
        int address=Integer.parseInt(console.nextLine());
        System.out.print("Rating (0 to 5):");
        int rating=Integer.parseInt(console.nextLine());
        if(rating>5 || rating <1){
            System.err.println("Invalid rating");
         }else{
            System.out.print("Minimum price for orders :");
            double minPrice=Double.parseDouble(console.nextLine());
            if(minPrice <=0.0){
                System.err.println("Invalid minimum price");
            }else{
            System.out.print("Delivery cost :");
            double deliveryCost=Double.parseDouble(console.nextLine());
            if(deliveryCost<0.0){
                System.out.println("Invalid Delivery cost");
            }else{
                System.out.print("Are offers available? Yes or No :");
                String offers=console.nextLine();
                if(offers.toLowerCase().equals("no") || offers.toLowerCase().equals("yes")){
             ArrayList<Dish> dishes = addDishes();
          if(dishes!=null){
            Restaurant restNew=new Restaurant ( name,  foodType,  street, 
             address,  rating, 
             minPrice,  deliveryCost,
             dishes,  city, offers) ; 
            
            restaurants.add(restNew);
            
              System.out.println("\nNew Restaursnt Addes Successflly");
            }    
                }else{
                    System.err.println("Invalid response for offers");
                }
            }
            }
        }
        
    }
    
    
    
    public void deregisterUser(){
        System.out.println("Enter the username :");
        String username=console.nextLine();
         if(users.isEmpty()){
            System.err.println("No users in the system");
        }
        boolean found=false;

        for(User user: users){
            if(user.getUsername().equals(username)){
                found=true;
                users.remove(user);
            }
        }
        if(!found){
            System.err.println("Delete failed. Could not find user by the given usename");
        }
    }
    
    public ArrayList<Restaurant> locateRestaurant(String street, String city, String type){
        ArrayList<Restaurant> rests=new ArrayList<Restaurant>();
        for(int i=0; i<restaurants.size(); i++){
            Restaurant rest=restaurants.get(i);
            if(rest.getCity().equals(city) && rest.getStreet().equals(street) && rest.getType().equals(type)){
                rests.add(rest);
            }
        }
       return rests; 
    }
    
    public ArrayList<Dish> addDishes(){
        ArrayList<Dish> ret=new ArrayList<Dish>();
        boolean done=false;
        while(!done){
            System.out.println("\nAdd new dish.(Use 'd' if done)");
            System.out.print("Name :");
            String name=console.nextLine();
            if(name.toLowerCase().equals("d")){
                done=true;
                break;
            }else{
                System.out.print("Price :");
                String ps=console.nextLine();
               if(ps.toLowerCase().equals("d")){
                   done=true;
                   break;
               }else{
                    double price=Double.parseDouble(ps);
                    Dish dish=new Dish( name,  price);
                    ret.add(dish);
               }
                
            }
        }
        
        
        if(ret.size()==0){
            System.err.println("You did not add any dish");
            return null;
        }else{
            return ret;
        }
    }
    public void addUser(){
        System.out.print("\nEnter name of the customer :");
        String name=console.nextLine();
        System.out.print("Enter username :");
        String username=console.nextLine();
        System.out.print("Enter password :");
        String password=console.nextLine();
        System.out.print("Enter role :");
        String role=console.nextLine().toLowerCase();
        
        if(role.equals("customer")){
            System.out.print("Enter Credit number :");
            int credit=Integer.parseInt(console.nextLine());
            Customer cust=new Customer(name,username,password,credit);
        }else if(role.equals("employee") || role.equals("staff")){
            if(restaurants.size()==0){
            System.err.println("Please add restaurants first");
            }else{
                System.out.println("\nPlease select the restaurant to post user :");
                for(int i=0; i<restaurants.size(); i++){
                Restaurant res=restaurants.get(i);
                System.out.println((i+1)+" "+res.getName());
                }
                System.out.print("\nYour Response :");
                int resp=Integer.parseInt(console.nextLine());
                if( resp < 1 || resp>restaurants.size()){
                    System.err.println("Invalid choice");
                }else{
                    Restaurant toPost=restaurants.get(resp-1);
                  if(role.equals("staff")){
                  Staff staff=new Staff( name,  username,  password, toPost) ;
                  users.add(staff);
                }else{
                  Employee employee=new Employee( name,  username,  password, toPost);
                  users.add(employee);
                }   
                }

            }
        }else{
            System.err.println("Invalid role");
        }
        
    }
    public void performCustomer(){
        Customer cust= (Customer)validateCredentials("customer");
        if(cust!=null){
         boolean exit=false;
         while(!exit){
             System.out.println("\nWhat would you like to do?");
             System.out.print("1. Make Orders.\n2 .Exit.\nYour Response  :");
             int response=Integer.parseInt(console.nextLine());
             if(response > 2 || response < 1){
                 System.err.println("Invalid response");
             }else{
                 if(response==1){
                        try{
            System.out.print("Enter street to deliver the food :");
            String street=console.nextLine().toLowerCase();
            System.out.print("Enter the city :");
            String city=console.nextLine().toLowerCase();
            System.out.print("Enter the distance :");
            int dist=Integer.parseInt(console.nextLine());
            System.out.print("Enter food types :");
            String  type=console.nextLine();
            ArrayList<Restaurant> rests=locateRestaurant(street,city,type);
            if(rests.size()==0){
                System.out.println("Sorry. We could not find any restaursnt matching");
            }else{
                System.out.println("\nPlease select a resturant");
                System.out.println("No\tName\tAddress\tType of foods\tMinimum Price for an order\tDelivery Cost\tRating from customers\tOffers available");
                
                for(int i=0; i < rests.size(); i++){
                System.out.println((i+1)+"\t"+rests.get(i).toString());
                }
                int select=Integer.parseInt(console.nextLine());
                if(select> rests.size() || select<1){
                    System.err.println("Invalid option");
                }else{
                Restaurant rest=rests.get(select-1);                
                System.out.println("\nIn which order would you like to display the dishes");
                System.out.println("1. Assending");
                System.out.println("2. Descending");
                System.out.print("Enter Order :");
                int order=Integer.parseInt(console.nextLine());
                if(order>2 || order < 1){
                System.err.println("Invalid option");
                }else{
                System.out.println("\nPick a dish to order for");
                if(order==1){
                rest.displayDishesInAssending();
                }else{
                rest.displayDishesInDescending();
                }
                int dish=Integer.parseInt(console.nextLine());
                if(dish>rest.getDishes().size() || dish<1){
                System.err.println("Invalid option");
                }else{
                Dish dishSeected=rest.getDishes().get(dish-1);
                System.out.println("Enter date mm/dd/yyyy and time hh:mm of delivery:");
                System.out.print("Date :");
                String dateString=console.nextLine();
                    try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = dateFormat.parse(dateString);
                   // System.out.println(dateFormat.format(date));
                                   
                System.out.print("Time :");
                String time=console.nextLine();
                System.out.print("Ouantity :");
                int qty=Integer.parseInt(console.nextLine());
                if(qty<1){
                    System.err.println("Quantity must be more than 0");
                }else{
               Order orderN=new Order( orderId, rest,  dishSeected,  date,  cust, qty);
                orders.add(orderN);
                orderId++;  
                               System.out.println("\nCongratulattions."
               + "\nYou have successfully ordered "+orderN.getQtty()+" of "+orderN.getName()+"\n"
                                       + "A total of $"+orderN.getTotal()+" has been deducted from your account\n"
                                       + "Your order will be delivered on "+orderN.dateToString());
                }

                
                  }
                  catch(Exception e) {
                  System.err.println("Invalid date. Please follow the format");
                  }
   
                }

                }

                }

            }

                
            }catch(NumberFormatException e){
             System.err.println("Invalid number entered");
            }
                 }else{
                     exit=true;
                     break;
                 }
             }
         }
            
        }
    }
    public User validateCredentials(String userType){
        if(users.isEmpty()){
            System.err.println("The Database is still empty.");
            return null;
        }
        System.out.println("\nPlease Enter Your Credentials.");
        System.out.print("Username :");
        String username=console.nextLine();
        boolean found=false;
        for (int i=0; i<users.size();i++){
            User user=users.get(i);
            if(user.getRole().equals(userType)){
                if(user.getUsername().equals(username)){
                found=true;
                System.out.print("Password :");
                String password=console.nextLine();
                if(user.getPassword().equals(password)){
                    return user;
                }else{
                    System.err.println("Incorrect Password");
                    return null;
                }
                    
            }
            }
        }
        if(!found){
            System.err.println("Could not find any user with the entered username");
            return null;
        }
        return null;
    }
    
    public void run(){
        //Here I will Hardcode One User by The name Admin and Password admin and Type Employee 
        ArrayList<Dish> dishes= new ArrayList<Dish>();
        String name="dish";
        double price=0.12;
        for(int i=0; i<50; i++){
            Dish dish=new Dish(name+i,price+0.13);
            dishes.add(dish);
        }
        
        Restaurant rest=new Restaurant("Restaurant","CHINESE","STREET",1525,5,14.56,0.15,dishes,"CITY","YES");
        Restaurant rest1=new Restaurant("Superb Restaursnt","African","STREET1",256,2,12.56,0.16,dishes,"CITY2","NO");
        Employee admin=new Employee("Joakim Adeny","Admin","admin",rest);
        Staff staff=new Staff("Jean Kimani","Staff","staff",rest1);
       // rest.displayDishesInAssending();
       // rest.displayDishesInDescending();
        Customer cust=new Customer( "Test Customer", "Test",  "test",  1234);
        users.add(admin);
        users.add(staff);
        users.add(cust);
        restaurants.add(rest);
        restaurants.add(rest1);
        
        
        
        
        
        
        
        System.out.print("Which user are you?\n1. Customer.\n2. Employee.\n3. Staff\n4. Quit.\nYour response :");
        int response=Integer.parseInt(console.nextLine());
        if(response>4 || response<1){
            System.err.println("\nInvalid User. Rerun the program");
            return;
        }
        if(response==1){
            performCustomer();
        }else if(response==2){
            performEmployee();
        }else if (response==3){
            performStaff();
        }else if(response==4){
            System.exit(0);
        }
        
        
    }
    
    
    public static void main(String[] args){
        Main app=new Main();
        app.run();
        
    }
}
