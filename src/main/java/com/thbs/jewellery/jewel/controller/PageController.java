package com.thbs.jewellery.jewel.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.thbs.jewellery.jewel.model.AdminRegister;
import com.thbs.jewellery.jewel.model.AdminUser;
import com.thbs.jewellery.jewel.repository.AdminRegisterRepository;
import com.thbs.jewellery.jewel.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {
    @Autowired
    AdminUserService adminUserService;
    @Autowired
    AdminRegisterRepository adminRegisterRepository;

    @GetMapping("/hi")
    public String getHomePage(){
        return "index";
    }

    @RequestMapping("/login")
    public String user(AdminRegister user, HttpServletRequest request){
        String username=request.getParameter("email");
        String password=request.getParameter("password");
        AdminUser user1=adminRegisterRepository.findUserByEmail(username).orElse(new AdminUser());
       if(username.equals(user1.getEmail()) && password.equals(user1.getPassword())){
            return "success";
        }
        else {
            return "Error";
        }
    }
    @RequestMapping("/register")
    public String register(Model model,AdminRegister adminRegister)
    {
        model.addAttribute("register",adminUserService.addAdminRegister(adminRegister));
        return "index";
    }

     }
