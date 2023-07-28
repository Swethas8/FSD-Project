package com.example.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Category;
import com.example.demo.Service.CategoryService;


@RestController
@RequestMapping("/category")
public class CategoryController {
@Autowired
private CategoryService service;

@GetMapping("/{id}")
public Category GetCategoryById(@PathVariable Long id){
	return service.getCategoryByID(id);
}
@PostMapping("")
public Category AddCategory(@RequestBody Category category) {
	return service.addCategory(category);
}
@PutMapping("/{id}")
public Category EditCategory(@RequestBody Category category,@PathVariable Long id) {
	return service.editCategory(id, category);
}
@DeleteMapping("/{id}")
public String DeleteCategory(@PathVariable Long id) {
	return service.deleteCategory(id);
}
}
