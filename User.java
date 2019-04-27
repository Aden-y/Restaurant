/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public abstract class User {
    private String name;
    private String username;
    private String password;
    protected String role;
    
    
    public User(String name, String username, String password){
        this.name=name;
        this.username=username;
        this.password=password;
    }
        public String getName(){
        return this.name;
    }
      public String getPassword(){
        return this.password;
    }
      public String getRole(){
          return this.role;
      }
      public String getUsername(){
          return this.username;
      }
}
