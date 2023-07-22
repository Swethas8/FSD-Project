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

import com.example.demo.Model.Payment;
import com.example.demo.Service.PaymentService;
@RestController
@RequestMapping("/payment")
public class PaymentController {
@Autowired
private PaymentService service;

@GetMapping("/{cardnum}")
public List<Payment> GetPayment(){
	return service.getPayment();
}
@PostMapping("")
public Payment AddPayment(@RequestBody Payment payment) {
	return service.addPayment(payment);
}
@PutMapping("/{cardnum}")
public Payment EditPayment(@RequestBody Payment payment,@PathVariable Long cardnum) {
	return service.editPayment(cardnum, payment);
}
@DeleteMapping("/{cardnum}")
public String DeletePayment(@PathVariable Long cardnum) {
	return service.deletePayment(cardnum);
}
}
