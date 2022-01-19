package com.thbs.jewellery.jewel.controller;

import com.thbs.jewellery.jewel.model.AdminRegister;
import com.thbs.jewellery.jewel.repository.AdminRegisterRepository;
import com.thbs.jewellery.jewel.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@Controller
public class AdminUserController {
    @Autowired
    AdminUserService adminUserService;

    @Autowired
    AdminRegisterRepository adminRegisterRepository;

//    @RequestMapping("/login")
//    public String login()
//    {
//        return "index";
//    }
    @GetMapping("/all")
    public List<AdminRegister> adminRegister(){
       return adminRegisterRepository.findAll();
    }

    @PostMapping("/addadmin")
    public AdminRegister addAdmin(@RequestBody AdminRegister adminRegister){
        return adminUserService.addAdminRegister(adminRegister);
    }
    @PostMapping("/checkuser/{email}/{password}")
    public String check(@PathVariable (name = "email") String email, @PathVariable (name = "password") String password)
    {
        return adminUserService.checkAdmin(email,password);
    }




}
