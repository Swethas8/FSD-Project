package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private String name;
private long price;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getPrice() {
	return price;
}
public void setPrice(long price) {
	this.price = price;
}

}
