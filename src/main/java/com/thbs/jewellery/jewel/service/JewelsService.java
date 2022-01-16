package com.thbs.jewellery.jewel.service;

import com.thbs.jewellery.jewel.model.Jewels;
import com.thbs.jewellery.jewel.repository.CategoryRepository;
import com.thbs.jewellery.jewel.repository.JewelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class JewelsService {
    @Autowired
    JewelsRepository jewelsRepository;
    @Autowired
    CategoryRepository categoryRepository;
    public List<Jewels> jewelslist(){
        return jewelsRepository.findAll();
    }

    public Jewels addJewels(Jewels jewels){
        return jewelsRepository.save(jewels);
    }

    public Jewels deleteJewels(String name) {
        jewelsRepository.deleteById(name);
        return null;
    }

    public List<Jewels> getOnlyOneCategories(String jewel)
    {
       return jewelsRepository.findByproductType(jewel);
    }




}
