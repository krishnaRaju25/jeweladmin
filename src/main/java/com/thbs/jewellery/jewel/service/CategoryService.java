package com.thbs.jewellery.jewel.service;

import com.thbs.jewellery.jewel.model.Category;
import com.thbs.jewellery.jewel.repository.AdminRegisterRepository;
import com.thbs.jewellery.jewel.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
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

     this.categoryRepository.deleteByProduct(product);  // deleteby---name (MODEL attribute name)
    }

    public Category update(String product)
    {
        Optional<Category> optional = categoryRepository.findByProduct(product);
        Category category = null;
        if (optional.isPresent()) {
            category = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + product);
        }
        return category;
    }

}
