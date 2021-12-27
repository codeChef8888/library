package com.library.myproject.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.myproject.model.BookCategory;
import com.library.myproject.repository.BookCategoryRepository;



@Service
public class BookCategoryService{

	@Autowired
	private BookCategoryRepository bookCategoryRepository;

	public Object getAllCategories() {
		List<BookCategory> categories = new ArrayList<>();
		bookCategoryRepository.findAll().forEach(categories::add);
		return categories;
	}

	public Optional<BookCategory> getCategory(int id) {
		return bookCategoryRepository.findById(id);
	}

	public void addCategory(BookCategory bookCategory) {
		bookCategoryRepository.save(bookCategory);
	}

	public void deleteCategory(int id) {
		bookCategoryRepository.deleteById(id);
	}

	public void updateCategory(BookCategory bookCategory) {
		bookCategoryRepository.save(bookCategory);
	}

//	public Object getAllCategories(){
//		return bookCategoryRepository.getTheCategories();
//
//	}
	
//	@PersistenceContext
//	private EntityManager em;
//
//	@SuppressWarnings("unchecked")
//	public List<BookCategory> test() {
//		StoredProcedureQuery query = em.createNamedStoredProcedureQuery("test");
//		return query.getResultList();
//	}

}
