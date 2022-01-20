package com.thbs.jewellery.jewel.service;

import com.thbs.jewellery.jewel.model.AdminUser;
import com.thbs.jewellery.jewel.repository.AdminRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserService {
    @Autowired
   private AdminRegisterRepository adminRegisterRepository;

    
//    public void addAdminRegister(AdminRegister adminRegister){
//        this.adminRegisterRepository.save(adminRegister);
//    }

    public AdminUser checkAdmin(String email, String password){
       // boolean password1=adminRegisterRepository.equals(password);
       AdminUser adminUser= adminRegisterRepository.findByEmailAndPassword(email,password);
       return adminUser;
    }

    public void addAdmin(AdminUser adminUser)
    {
        adminRegisterRepository.save(adminUser);
    }


}
