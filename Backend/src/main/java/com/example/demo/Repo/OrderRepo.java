package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Orders;

public interface OrderRepo extends JpaRepository<Orders, Long> {

}
