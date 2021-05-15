package com.java8.stream.supporting.entity;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private  String bookName;
    private int releaseYear;
    private  String bookId;
    public static List<Book>  bookList;
    
	public Book(String bookName, int releaseYear, String bookId) {
		
		this.bookName = bookName;
		this.releaseYear = releaseYear;
		this.bookId = bookId;
	}

	public Book() {
		bookList = new ArrayList<>();
		bookList.add(new Book("Book A", 1954, "100"));
		bookList.add(new Book("Book B", 1963, "200"));
		bookList.add(new Book("Book B", 1963, "250"));
		bookList.add(new Book("Book C", 1910, "300"));	
		bookList.add(new Book("Book D", 1990, "400"));
		bookList.add(new Book("Book E", 1905, "500"));
	}

	public  String  getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public  String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", releaseYear=" + releaseYear + ", bookId=" + bookId + "]";
	}
    
    
    // getters and setters
	
	
}