package com.library.myproject.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import com.library.myproject.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	public List<Book> findByBookCategoryId(int id);

	public List<Book> findBySoldStatus(Boolean soldStatus);

	public List<Book> findByAvaibility(Boolean avaibility);

	@Query(value = "SELECT * FROM books b WHERE b.added_date= :date", nativeQuery = true)
	public List<Book> findAllWithAddedDate(@Param("date") Date date);

	@Query(value = "SELECT * FROM books b WHERE EXTRACT(YEAR FROM b.added_date)= :year AND EXTRACT(MONTH FROM b.added_date)= :month", nativeQuery = true)
	public List<Book> findAllWithGivenDate(@Param("year") int year, @Param("month") int month);

	@Query(value = "SELECT * FROM books b WHERE b.added_date BETWEEN :date1 AND :date2", nativeQuery = true)
	public List<Book> findAllBetweenDates(@Param("date1") Date date1, @Param("date2") Date date2);

//	@Query(value = "SELECT t1.category_name category,sum(t2.sold_status) sold,sum(t2.price) revenue FROM bookcategories t1 INNER JOIN books t2 ON t1.id=t2.book_category_id WHERE t2.sold_status=true GROUP BY t1.category_name", nativeQuery = true)
//	public List<Map<String, Object>> findByReport();
	@Query(nativeQuery= true, value="call annualReport()")
	public List<Map<String, Object>> getTheReport();

}
