package com.example.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.BillingAddress;
import com.example.demo.Service.BillingAddressService;


@RestController
@RequestMapping("/billingAddress")
public class BillingAddressController {
@Autowired
private BillingAddressService service;

@GetMapping("/{id}")
public BillingAddress GetBillingAddressById(@PathVariable Long id){
	return service.getBillingAddressByID(id);
}
@PostMapping("")
public BillingAddress AddBillingAddress(@RequestBody BillingAddress billingAddress) {
	return service.addBillingAddress(billingAddress);
}
@PutMapping("/{id}")
public BillingAddress EditBillingAddress(@RequestBody BillingAddress billingAddress,@PathVariable Long id) {
	return service.editBillingAddress(id, billingAddress);
}
@DeleteMapping("/{id}")
public String DeleteBillingAddress(@PathVariable Long id) {
	return service.deleteBillingAddress(id);
}
}
