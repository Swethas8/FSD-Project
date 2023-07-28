package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.BillingAddress;
import com.example.demo.Repo.BillingAddressRepo;


@Service
public class BillingAddressService {
@Autowired
 private BillingAddressRepo brepo;
    public BillingAddress getBillingAddressByID(Long id){
    	return brepo.findById(id).get();
    }
    public BillingAddress addBillingAddress(BillingAddress billingAddress) {
    	return brepo.save(billingAddress);
    }
    public BillingAddress editBillingAddress(Long id,BillingAddress billingAddress) {
    	BillingAddress xbil=brepo.findById(id).orElse(null);
    	if(xbil != null) {
    		xbil.setFname(billingAddress.getFname());
    		xbil.setLname(billingAddress.getLname());
    		xbil.setAddress(billingAddress.getAddress());
    		xbil.setAddress2(billingAddress.getAddress2());
    		xbil.setCountry(billingAddress.getCountry());
    		xbil.setState(billingAddress.getState());
    		xbil.setPincode(billingAddress.getPincode());

    		return brepo.saveAndFlush(xbil);
    	}
    	else {
    		return null;
    	}
    }
    public String deleteBillingAddress(Long id) {
    	BillingAddress xbil=brepo.findById(id).orElse(null);
    	if(xbil !=null) {
    		brepo.deleteById(id);
    		return "Billing address deleted"+ id;
    	}
    	else {
    		return "Invalid ID";
    	}
    }
}
