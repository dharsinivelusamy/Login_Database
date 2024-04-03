package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Login;
import com.example.demo.repository.LoginRepo;



@Service
public class LoginService {
    @Autowired
    LoginRepo mr;
    public Login create (Login mm)
    {
        return mr.save(mm);
    }
    public List<Login> getAll()
    {
        return mr.findAll();
    }
    public Login getMe(String userName)
    {
        return mr.findById(userName).orElse(null);
    }
    public boolean updateDetails(String userName,Login mm)
        {
            if(this.getMe(userName)==null)
            {
                return false;
            }
            try{
                mr.save(mm);
            }
            catch(Exception e)
            {
                return false;
            }
            return true;
        }
public boolean deleteLogin(String userName)
        {
            if(this.getMe(userName) == null)
            {
                return false;
            }
            mr.deleteById(userName);
            return true;
        }

}
