package com.library.myproject.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.myproject.model.Book;
import com.library.myproject.model.BookCategory;

import com.library.myproject.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;

	@RequestMapping("/cat")
	public String demo(){
		return "hello";
	}

	@RequestMapping("/categories/{categoryId}/books")
	public List<Book> getAllBooks(@PathVariable int categoryId) {
		return bookService.getAllBooks(categoryId);
	}

	@RequestMapping("/categories/{categoryId}/books/{bookId}")
	public Optional<Book> getBook(@PathVariable int bookId) {
		return bookService.getBook(bookId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/categories/{categoryId}/books")
	public void addBook(@RequestBody Book book, @PathVariable int categoryId) {
		book.setBookCategory(new BookCategory(categoryId, ""));
		book.toString();
		bookService.addBook(book);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/categories/{categoryId}/books/{bookId}")
	public void deleteBook(@PathVariable int bookId) {
		bookService.deleteBook(bookId);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/categories/{categoryId/books/{bookId}")
	public void updateBook(@PathVariable int categoryId, @PathVariable int bookId, @RequestBody Book book) {
		book.setBookCategory(new BookCategory(categoryId, ""));
		System.out.println(categoryId);
		bookService.updateBook(book);
	}

	@RequestMapping("/categories/bookstatus/{soldStatus}")
	public List<Book> getBookBySoldStatus(@PathVariable("soldStatus") boolean SoldStatus) {
		return bookService.getBookBySoldStatus(SoldStatus);
	}

	@RequestMapping("/categories/bookavaibility/{avaibility}")
	public List<Book> getBookByAvaibility(@PathVariable("avaibility") boolean avaibility) {
		return bookService.getBookByAvaibility(avaibility);
	}

	@RequestMapping("/categories/added-since/{since}")
	public List<Book> getBookByAddedDate(@PathVariable("since") @DateTimeFormat(pattern = "yyyy-MM-dd") Date since)
			throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = dateFormat.format(since);
		System.out.println(date);
		return bookService.getBookAddedDate(date);
	}

	@RequestMapping("/categories/search/{since}")
	public List<Book> getAllBookByGivenDate(@PathVariable("since") @DateTimeFormat(pattern = "yyyy-MM") Date since)
			throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		String date = dateFormat.format(since);
		System.out.println(date);
		return bookService.getBookGivenDate(date);
	}

	@RequestMapping("/categories/betweendates/{startDate}/{endDate}")
	public List<Book> getAllBookBetweenDates(
			@PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) throws ParseException {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date1 = dateFormat.format(startDate);
		String date2 = dateFormat.format(endDate);

		System.out.println(date1 + "  and  " + date2);
		return bookService.getBookBetweenDates(date1, date2);
	}

	@RequestMapping("/categories/report")
	public ResponseEntity<Object> getOverallReport() {
		return new ResponseEntity<Object>(bookService.overallReport(), HttpStatus.OK);
	}

}
