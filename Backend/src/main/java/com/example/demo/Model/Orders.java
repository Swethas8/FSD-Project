package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Orders {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
private Long pid;
private String pname;
private Long tot;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Long getPid() {
	return pid;
}
public void setPid(Long pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public Long getTot() {
	return tot;
}
public void setTot(Long tot) {
	this.tot = tot;
}

}
