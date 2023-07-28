package com.example.demo.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Cart;
import com.example.demo.Repo.CartRepo;


@Service
public class CartService {
@Autowired
 private CartRepo crepo;
    public Cart getCartByID(Long id){
    	return crepo.findById(id).get();
    }
    public Cart addCart(Cart cart) {
    	return crepo.save(cart);
    }
    public Cart editCart(Long id,Cart cart) {
    	Cart xcar=crepo.findById(id).orElse(null);
    	if(xcar != null) {
    		xcar.setProductname(cart.getProductname());
    		return crepo.saveAndFlush(xcar);
    	}
    	else {
    		return null;
    	}
    }
    public String deleteCart (Long id) {
    	Cart xcat=crepo.findById(id).orElse(null);
    	if(xcat !=null) {
    		crepo.deleteById(id);
    		return "Category deleted"+ id;
    	}
    	else {
    		return "Invalid ProductId";
    	}
    }
}
