package com.libmanage.book;

import java.util.Map;

import com.libmanage.book.*;

public interface Book {
	
	public Boolean addBook(BookDetails BookDetails,Map<Long, BookDetails> BookMap);

	/**
	 * This method helps to delete book details from the map.
	 * 
	 * @param bookID
	 *            -Contains BookID information
	 * @param BookMap
	 *            - Contains Books Map
	 * @return Boolean - Contains true or false value based on record deletion
	 */
	public Boolean deleteBook(Long bookID,Map<Long, BookDetails> BookMap);

	/**
	 * This method helps to update book information.
	 * 
	 * @param BookDetails
	 *            - Contains Book Details
	 * @param BookMap
	 *            - Contains Book in the map
	 * @return BookDetails - Contains Book details
	 */
	public BookDetails updateBook(BookDetails BookDetails,Map<Long, BookDetails> BookMap);
	
	/**
	 * This method helps to display all available book.
	 * 
	 * @param BookMap
	 * 		- Contains Books information in the map
	 */
	public void displayAvailableBookInfo(Map<Long, BookDetails> BookMap);
	
	/**
	 * This method helps to display all issued book.
	 * 
	 * @param BookMap
	 * 		- Contains Books information in the map
	 */
	public void displayIssuedBookInfo(Map<Long, BookDetails> BookMap);
}

