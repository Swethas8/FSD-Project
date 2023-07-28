package com.example.demo.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Orders;
import com.example.demo.Repo.OrderRepo;
@Service
public class OrderService {
@Autowired
 private OrderRepo orepo;
    public List <Orders> getOrder(){
    	return orepo.findAll();
    }
    public Orders addOrder(Orders order) {
    	return orepo.save(order);
    }
    public Orders editOrder(Long id,Orders order) {
    	Orders xord=orepo.findById(id).orElse(null);
    	if(xord != null) {
    		xord.setId(order.getId());
    		xord.setPid(order.getPid());
    		xord.setPname(order.getPname());
    		xord.setTot(order.getTot());

    		return orepo.saveAndFlush(xord);
    	}
    	else {
    		return null;
    	}
    }
    public String deleteOrder(Long pid) {
    	Orders xord=orepo.findById(pid).orElse(null);
    	if(xord !=null) {
    		orepo.deleteById(pid);
    		return "Order deleted"+ pid;
    	}
    	else {
    		return "Invalid Orderid";
    	}
    }
}
