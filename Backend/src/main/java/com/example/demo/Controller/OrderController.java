package com.example.demo.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Orders;
import com.example.demo.Service.OrderService;
@RestController
@RequestMapping("/orders")
public class OrderController {
@Autowired
private OrderService service;

@GetMapping("/{id}")
public List<Orders> GetOrder(){
	return service.getOrder();
}
@PostMapping("")
public Orders AddOrder(@RequestBody Orders order) {
	return service.addOrder(order);
}
@PutMapping("/{id}")
public Orders EditOrder(@RequestBody Orders order,@PathVariable Long id) {
	return service.editOrder(id, order);
}
@DeleteMapping("/{pid}")
public String DeleteOrder(@PathVariable Long pid) {
	return service.deleteOrder(pid);
}
}
