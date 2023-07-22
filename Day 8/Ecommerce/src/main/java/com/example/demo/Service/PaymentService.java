package com.example.demo.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Payment;
import com.example.demo.Repo.PaymentRepo;
@Service
public class PaymentService {
@Autowired
 private PaymentRepo prepo;
    public List <Payment> getPayment(){
    	return prepo.findAll();
    }
    public Payment addPayment(Payment payment) {
    	return prepo.save(payment);
    }
    public Payment editPayment(Long cardnum,Payment payment) {
    	Payment xpay=prepo.findById(cardnum).orElse(null);
    	if(xpay != null) {
    		xpay.setCardnum(payment.getCardnum());
    		xpay.setName(payment.getName());
    		xpay.setExpiration(payment.getExpiration());
    		xpay.setCvv(payment.getCvv());

    		return prepo.saveAndFlush(xpay);
    	}
    	else {
    		return null;
    	}
    }
    public String deletePayment(Long cardnum) {
    	Payment xpay=prepo.findById(cardnum).orElse(null);
    	if(xpay !=null) {
    		prepo.deleteById(cardnum);
    		return "Payment deleted"+ cardnum;
    	}
    	else {
    		return "Invalid Cardnumber";
    	}
    }
}
