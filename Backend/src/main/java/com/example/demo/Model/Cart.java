package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cart {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
private String productname;
private Long count;
private Long price;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public Long getCount() {
	return count;
}
public void setCount(Long count) {
	this.count = count;
}
public Long getPrice() {
	return price;
}
public void setPrice(Long price) {
	this.price = price;
}

}
