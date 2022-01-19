package com.thbs.jewellery.jewel.service;

import com.thbs.jewellery.jewel.model.AdminRegister;
import com.thbs.jewellery.jewel.repository.AdminRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserService {
    @Autowired
    AdminRegisterRepository adminRegisterRepository;
    public AdminRegister addAdminRegister(AdminRegister adminRegister){
        return adminRegisterRepository.save(adminRegister);
    }

    public String checkAdmin(String email,String password){
       // boolean password1=adminRegisterRepository.equals(password);
        if(adminRegisterRepository.existsById(email) && adminRegisterRepository.existsByPassword(password))
        {
            System.out.print( "your login succesfully");
        }else{
            System.out.print( "login unsuccessfull");
        }
      return null;

    }

}
