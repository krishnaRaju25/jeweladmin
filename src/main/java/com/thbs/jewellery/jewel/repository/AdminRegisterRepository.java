package com.thbs.jewellery.jewel.repository;

import com.thbs.jewellery.jewel.model.AdminRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRegisterRepository extends JpaRepository<AdminRegister,String> {
    boolean existsByPassword(String password);
}
