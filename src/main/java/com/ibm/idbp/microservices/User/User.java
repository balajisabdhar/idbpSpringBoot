package com.ibm.idbp.microservices.User;


public class User {
    
    private String userName;
    private String password;

    public String getUserName(){
        return userName;
    }

    public String getPassword(){
        return password;
    }

    public void setUsername(String username){
        this.userName = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

}
