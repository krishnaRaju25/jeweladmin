package com.thbs.jewellery.jewel.controller;

import com.thbs.jewellery.jewel.model.AdminUser;
import com.thbs.jewellery.jewel.model.Category;
import com.thbs.jewellery.jewel.model.Jewels;
import com.thbs.jewellery.jewel.repository.CategoryRepository;
import com.thbs.jewellery.jewel.service.CategoryService;
import com.thbs.jewellery.jewel.service.JewelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Transactional //delete custom
@Controller
public class CategoryController {
    @Autowired
   private CategoryService categoryService;
    @Autowired
   private  CategoryRepository categoryRepository;
    @Autowired
    JewelsService jewelsService;

    @GetMapping("/allcategories")
    public List<Category> categories (){
        return categoryService.categories();
    }

//    @PostMapping("/addcategories/{category}")
//    public Category addCategory(@RequestBody Category category){
//        return categoryService.addCategory(category);
//    }

    @PostMapping("/addJewels/{Jewels}")
    public Jewels addJewels(@RequestBody Jewels Jewels){
        return jewelsService.addJewels(Jewels);
    }

    @GetMapping("/allJewelss") //get all jewel
    public List<Jewels> ListAllJewels(){
        return jewelsService.jewelslist();
    }
    @DeleteMapping("/deletejewel/{name}") //delete jewel
    public Jewels Jewels(@PathVariable(name = "name") String name){
        return jewelsService.deleteJewels(name);
    }

    @GetMapping("/getjewel/{jewel}") //get all jewel by one categories
    public List<Jewels> checkByCategories(@PathVariable (name = "jewel") String jewel)
    {
      return jewelsService.getOnlyOneCategories(jewel);
    }

    @RequestMapping(value="/category" , method= RequestMethod.GET)
    public ModelAndView category()
    {
        ModelAndView mv=new ModelAndView("category");
        mv.addObject("category",new Category());
        mv.addObject("listCategory",categoryService.categories());
        return mv;
    }

    @RequestMapping(value="/category",method = RequestMethod.POST)
    public String category(@ModelAttribute("category") Category category)
    {
        categoryService.addCategory(category);
        return "redirect:/category";
    }


   @RequestMapping("/category/delete")
    public String delete(@RequestParam(name="product") String product)
   {
       categoryService.deleteById(product);
       return "redirect:/category";
   }
    @RequestMapping("/category/update")
    public String update(@RequestParam(name="product") String product,Model model)
    {

         Category category= categoryService.update(product);
         model.addAttribute("category",category);
         return "updateproduct";
    }

}
