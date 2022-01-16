package com.thbs.jewellery.jewel.repository;

import com.thbs.jewellery.jewel.model.Jewels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JewelsRepository extends JpaRepository<Jewels,String> {
   // List<Jewels> findAllProductType(String jewel);


    List<Jewels> findByproductType(String jewel); //selecting all necklaces....
}
