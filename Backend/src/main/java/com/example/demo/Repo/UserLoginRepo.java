package com.example.demo.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.UserLogin;


@Repository
public interface UserLoginRepo extends JpaRepository<UserLogin, Long> {
    UserLogin findByEmailAndPassword(String email,String password);
}
