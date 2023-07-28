package com.example.demo.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Category;
import com.example.demo.Repo.CategoryRepo;


@Service
public class CategoryService {
@Autowired
 private CategoryRepo crepo;
    public Category getCategoryByID(Long id){
    	return crepo.findById(id).get();
    }
    public Category addCategory(Category category) {
    	return crepo.save(category);
    }
    public Category editCategory(Long id,Category category) {
    	Category xcat=crepo.findById(id).orElse(null);
    	if(xcat != null) {
    		xcat.setName(category.getName());
    		return crepo.saveAndFlush(xcat);
    	}
    	else {
    		return null;
    	}
    }
    public String deleteCategory(Long id) {
    	Category xcat=crepo.findById(id).orElse(null);
    	if(xcat !=null) {
    		crepo.deleteById(id);
    		return "Category deleted"+ id;
    	}
    	else {
    		return "Invalid ProductId";
    	}
    }
}
