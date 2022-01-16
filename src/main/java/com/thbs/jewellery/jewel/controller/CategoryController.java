package com.thbs.jewellery.jewel.controller;

import com.thbs.jewellery.jewel.model.AdminRegister;
import com.thbs.jewellery.jewel.model.Category;
import com.thbs.jewellery.jewel.model.Jewels;
import com.thbs.jewellery.jewel.service.CategoryService;
import com.thbs.jewellery.jewel.service.JewelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    JewelsService jewelsService;

    @GetMapping("/allcategories")
    public List<Category> categories (){
        return categoryService.categories();
    }

    @PostMapping("/addcategories/{category}")
    public Category addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }

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


}
