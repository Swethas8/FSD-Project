package com.example.demo.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Product;
import com.example.demo.Repo.ProductRepo;
@Service
public class ProductService {
@Autowired
 private ProductRepo prepo;
    public List <Product> getProduct(){
    	return prepo.findAll();
    }
    public Product addProduct(Product product) {
    	return prepo.save(product);
    }
    public Product editProduct(Long id,Product product) {
    	Product xpro=prepo.findById(id).orElse(null);
    	if(xpro != null) {
    		xpro.setName(product.getName());
    		xpro.setPrice(product.getPrice());
    		return prepo.saveAndFlush(xpro);
    	}
    	else {
    		return null;
    	}
    }
    public String deleteProduct(Long id) {
    	Product xpro=prepo.findById(id).orElse(null);
    	if(xpro !=null) {
    		prepo.deleteById(id);
    		return "Product deleted"+ id;
    	}
    	else {
    		return "Invalid ProductId";
    	}
    }
}
