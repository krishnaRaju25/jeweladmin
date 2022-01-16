package com.thbs.jewellery.jewel.repository;

import com.thbs.jewellery.jewel.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,String> {
}
