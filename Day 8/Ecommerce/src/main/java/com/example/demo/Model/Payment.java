package com.example.demo.Model;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity
public class Payment {
@Id
private Long cardnum;
private String name;
private String expiration;
private Long cvv;
public Long getCardnum() {
	return cardnum;
}
public void setCardnum(Long cardnum) {
	this.cardnum = cardnum;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getExpiration() {
	return expiration;
}
public void setExpiration(String expiration) {
	this.expiration = expiration;
}
public Long getCvv() {
	return cvv;
}
public void setCvv(Long cvv) {
	this.cvv = cvv;
}

}
