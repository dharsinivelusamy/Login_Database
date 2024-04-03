package com.example.demo.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Login {
    @Id
    
    private String userName;
    private String password;
    
    
    public String getuserName() {
        return userName;
    }
    public void setuserName(String userName) {
        this.userName = userName;
    }
    public String getpassword() {
        return password;
    }
    public void setpassword(String password) {
        this.password = password;
    }
    
    public Login( String userName, String password) {
        
        this.userName = userName;
        this.password = password;
        
    }
    public Login() {
    }
    
}

