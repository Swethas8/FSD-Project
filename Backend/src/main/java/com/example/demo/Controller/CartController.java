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

import com.example.demo.Model.Cart;
import com.example.demo.Service.CartService;


@RestController
@RequestMapping("/cart")
public class CartController {
@Autowired
private CartService service;

@GetMapping("/{id}")
public Cart GetCartById(@PathVariable Long id){
	return service.getCartByID(id);
}
@PostMapping("")
public Cart AddCart(@RequestBody Cart cart) {
	return service.addCart(cart);
}
@PutMapping("/{id}")
public Cart EditCart(@RequestBody Cart cart,@PathVariable Long id) {
	return service.editCart(id, cart);
}
@DeleteMapping("/{id}")
public String DeleteCart(@PathVariable Long id) {
	return service.deleteCart(id);
}
}
