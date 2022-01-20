package com.thbs.jewellery.jewel.service;

import com.thbs.jewellery.jewel.model.Category;
import com.thbs.jewellery.jewel.repository.AdminRegisterRepository;
import com.thbs.jewellery.jewel.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
   private CategoryRepository categoryRepository;

    public List<Category> categories(){
        return categoryRepository.findAll();
    }


    public void addCategory(Category category){
         categoryRepository.save(category);
    }

    public void deleteById(String product) {   //EARRING

     categoryRepository.deleteByProduct(product);  // deleteby---name (MODEL attribute name)
    }


}
