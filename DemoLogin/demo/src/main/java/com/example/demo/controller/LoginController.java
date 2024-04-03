package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Login;
import com.example.demo.service.LoginService;






@RestController
public class LoginController {
    @Autowired
    LoginService ms;
    @PostMapping("/api/login")
    public ResponseEntity<Login>addelements(@RequestBody Login m)
    {
        Login mm=ms.create(m);
        return new ResponseEntity<>(mm,HttpStatus.CREATED);
    }
    @GetMapping("/api/logins")
    public ResponseEntity<List<Login>> showinfo()
    {
        return new ResponseEntity<>(ms.getAll(),HttpStatus.OK);
    }
    @GetMapping("/api/login/{userName}")
    public ResponseEntity<Login> getById(@PathVariable String userName)
    {
        Login obj=ms.getMe(userName);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    @PutMapping("/api/login/{userName}")
    public ResponseEntity<Login> putMethodName(@PathVariable("userName") String userName, @RequestBody Login m) {
        if(ms.updateDetails(userName,m) == true)
        {
            return new ResponseEntity<>(m,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
@DeleteMapping("/api/login/{userName}")
    public ResponseEntity<Boolean> delete(@PathVariable("userName") String userName)
    {
        if(ms.deleteLogin(userName) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}