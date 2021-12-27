package com.library.myproject.service;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.myproject.model.Book;
import com.library.myproject.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBooks(int id) {
		List<Book> books = new ArrayList<>();
		bookRepository.findByBookCategoryId(id).forEach(books::add);
		return books;
	}

	public Optional<Book> getBook(int id) {
		return bookRepository.findById(id);
	}

	public void addBook(Book book) {
		// book.toString();
		bookRepository.save(book);
	}

	public void deleteBook(int id) {
		bookRepository.deleteById(id);
	}

	public void updateBook(Book book) {
		bookRepository.save(book);
	}

	public List<Book> getBookBySoldStatus(Boolean SoldStatus) {
		List<Book> books = new ArrayList<>();
		bookRepository.findBySoldStatus(SoldStatus).forEach(books::add);
		return books;
	}

	public List<Book> getBookByAvaibility(Boolean avaibility) {
		List<Book> books = new ArrayList<>();
		bookRepository.findByAvaibility(avaibility).forEach(books::add);
		return books;
	}

	public List<Book> getBookAddedDate(String since) throws ParseException {
		List<Book> books = new ArrayList<>();
		bookRepository.findAllWithAddedDate(new SimpleDateFormat("yyyy-MM-dd").parse(since)).forEach(books::add);
		return books;
	}

	public List<Book> getBookGivenDate(String since) throws ParseException {
		List<Book> books = new ArrayList<>();
		System.out.println(since + "gulla");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		Date date = format.parse(since);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		System.out.println(year);
		System.out.println(month);

		bookRepository.findAllWithGivenDate(year, month + 1).forEach(books::add);
		return books;
	}

	public List<Book> getBookBetweenDates(String start, String end) throws ParseException {

		return bookRepository.findAllBetweenDates(new SimpleDateFormat("yyyy-MM-dd").parse(start),
				new SimpleDateFormat("yyyy-MM-dd").parse(end));

	}

	public Object overallReport() {
		return bookRepository.getTheReport();
	}

}
