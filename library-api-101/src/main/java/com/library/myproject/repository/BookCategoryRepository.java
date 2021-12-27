package com.library.myproject.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.library.myproject.model.BookCategory;

@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer> {

	@Query(nativeQuery = true, value = "call testProcedure()")
	List<Map<String, Object>> getTheCategories();

}
