package com.libmanage.book;

public class BookDetails {
	//This attribute contains book unique ID
	private Long bookID;
	//This attribute contains book unique ID
	private Boolean issued;
	//This attribute contains title of the Book
	private String title;
	//This attribute contains author name
	private String author;
	//This attribute contains publisher name
	private String publisher;
	//This attribute contains total page in the book
	private int totalPage;
	//This attribute contains libraryID
	private Long libraryID;
	//Setter and getter
	public Long getBookID() {
		return bookID;
	}
	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public Long getLibraryID() {
		return libraryID;
	}
	public void setLibraryID(Long libraryID) {
		this.libraryID = libraryID;
	}
	public Boolean getIssued() {
		return issued;
	}
	public void setIssued(Boolean issued) {
		this.issued = issued;
	}	

}