package com.ibm.idbp.microservices.LoginModule;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.idbp.microservices.User.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins ="*")
public class LoginModuleController {
    
    @RequestMapping("/resource")
    public Map<String,Object> home() {
      Map<String,Object> model = new HashMap<String,Object>();
      model.put("id", UUID.randomUUID().toString());
      model.put("content", "Hello World");
      return model;
    }

    @PostMapping(value="/login")
    public Map<String,Object> loginUser(@RequestBody User userData) {
        //TODO: process POST request
        
        System.out.println("First Log"+userData.getUserName());
        if(userData.getUserName().equals("ibmadmin") && userData.getPassword().equals("P@ssw0rd")){
            System.out.println("Login Succedded");
            Map<String,Object> model = new HashMap<String,Object>();
            model.put("Token", UUID.randomUUID().toString());
            model.put("StatusCode","200");
            model.put("StatusResponse", "Login Succedded");
            return  model;
        } else {
            if(!userData.getUserName().equals("ibmadmin")){
                System.out.println("First Log"+userData.getUserName());
                Map<String,Object> model = new HashMap<String,Object>();
                model.put("StatusCode","201");
                model.put("response", "Username is Wrong");
                return  model;
            } else if(!userData.getPassword().equals("P@ssw0rd")){
                Map<String,Object> model = new HashMap<String,Object>();
                model.put("StatusCode","201");
                model.put("response", "Password is Wrong");
                return  model;
            }
        }
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("StatusCode","500");
        model.put("response", "Internal Error");
        return model;
    }
    
}
