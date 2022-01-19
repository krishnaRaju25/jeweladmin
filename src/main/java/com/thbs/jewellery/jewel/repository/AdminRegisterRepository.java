package com.thbs.jewellery.jewel.repository;

import com.thbs.jewellery.jewel.model.AdminRegister;
import com.thbs.jewellery.jewel.model.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRegisterRepository extends JpaRepository<AdminRegister,String> {
    boolean existsByPassword(String password);

    Optional<AdminUser> findUserByEmail(String email);}
