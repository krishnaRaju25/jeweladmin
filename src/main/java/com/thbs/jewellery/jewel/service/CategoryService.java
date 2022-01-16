package com.thbs.jewellery.jewel.service;

import com.thbs.jewellery.jewel.model.AdminRegister;
import com.thbs.jewellery.jewel.model.Category;
import com.thbs.jewellery.jewel.repository.AdminRegisterRepository;
import com.thbs.jewellery.jewel.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> categories(){
        return categoryRepository.findAll();
    }


    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category deleteCategory(String category){
        categoryRepository.deleteById(category);
        return null;
    }
}
