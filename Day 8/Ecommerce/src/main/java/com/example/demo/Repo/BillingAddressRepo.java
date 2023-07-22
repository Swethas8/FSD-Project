package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.BillingAddress;

public interface BillingAddressRepo extends JpaRepository<BillingAddress, Long> {

}
