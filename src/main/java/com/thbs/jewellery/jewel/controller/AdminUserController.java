package com.thbs.jewellery.jewel.controller;

import com.thbs.jewellery.jewel.model.AdminUser;
import com.thbs.jewellery.jewel.repository.AdminRegisterRepository;
import com.thbs.jewellery.jewel.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

//@RestController
@Controller
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    AdminRegisterRepository adminRegisterRepository;

//    @RequestMapping("/login")
//    public String login()
//    {
//        return "index";
//    }
//    @GetMapping("/all")
//    public List<AdminRegister> adminRegister(){
//       return adminRegisterRepository.findAll();
//    }

//
    @PostMapping("/checkuser/{email}/{password}")
    public AdminUser check(@PathVariable (name = "email") String email, @PathVariable (name = "password") String password)
    {
        AdminUser adminUser=new AdminUser();
        return adminUserService.checkAdmin(adminUser.getEmail(),adminUser.getPassword());
    }

    @RequestMapping(value="/login" , method = RequestMethod.GET)
    public ModelAndView login()
    {
        ModelAndView mv=new ModelAndView("login");
        mv.addObject("adminUser",new AdminUser());
        return mv;
    }

    @RequestMapping(value="/login" , method = RequestMethod.POST)
    public String login(@ModelAttribute("adminUser") AdminUser adminUser)
    {
        AdminUser user=adminUserService.checkAdmin(adminUser.getEmail(),adminUser.getPassword());
        System.out.print(adminUser.getEmail());
        if(Objects.nonNull(user))
        {
            return "redirect:/category";
        }else{
            return "redirect:/login";

        }
    }

    @RequestMapping(value="/register" , method= RequestMethod.GET)
    public ModelAndView register()
    {
        ModelAndView mv=new ModelAndView("register.html");
        mv.addObject("adminUser",new AdminUser());
        return mv;
    }

    @RequestMapping(value="/register",method = RequestMethod.POST)
    public String register(@ModelAttribute("adminUser") AdminUser adminUser)
     {
         adminUserService.addAdmin(adminUser);
         return "redirect:/login";
     }

}
