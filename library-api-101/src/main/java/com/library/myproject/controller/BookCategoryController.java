package com.library.myproject.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.myproject.model.BookCategory;

import com.library.myproject.service.BookCategoryService;


@RestController
public class BookCategoryController {
	@Autowired
	private BookCategoryService bookCategoryService;
	
	@RequestMapping("/categories")
	public ResponseEntity<Object> getAllCategories(){
		return new ResponseEntity<Object>(bookCategoryService.getAllCategories(), HttpStatus.OK);
//		return bookCategoryService.getAllCategories();
	}

	@RequestMapping("/categories/{id}")
	public Optional<BookCategory> getCategory(@PathVariable int id){
		return bookCategoryService.getCategory(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/categories")
	public void addCategory(@RequestBody BookCategory bookCategory) {
		bookCategoryService.addCategory(bookCategory);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/categories/{id}")
	public void deleteCategory(@PathVariable int id) {
		bookCategoryService.deleteCategory(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/categories/{id}")
	public void updateCategory(@PathVariable int id,@RequestBody BookCategory bookCategory) {
		bookCategoryService.updateCategory(bookCategory);
	}
}
