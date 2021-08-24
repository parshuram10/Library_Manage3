package com.libmanage.book;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.libmanage.common.*;
/** 
 * This class helps to implement business logic for Books.
 * 
 * @author dsahu1
 *
 */
public class BookImplmpl implements Book{
	
	@Override
	public Boolean addBook(BookDetails BookDetails,Map<Long, BookDetails> BookMap) {
		//Add book to map
		BookMap.put(BookDetails.getBookID(), BookDetails);
		//Return true once book added
		return Boolean.TRUE.booleanValue();
	}
	
	@Override
	public Boolean deleteBook(Long bookID,Map<Long, BookDetails> BookMap) {
		//Iterate Book map
		Iterator<Entry<Long, BookDetails>> itr = BookMap
		.entrySet().iterator();
		//Iterate Books
		while (itr.hasNext()) {			
			Entry<Long, BookDetails> entry = itr.next();
			//Compare bookID and remove
			if(bookID == entry.getKey()){
				
				if(entry.getValue().getIssued()){
					System.out.println("You can not delete issued book!");
					break;
				}
				//Remove book entry from the map
				itr.remove();
				//Return true
				return Boolean.TRUE.booleanValue();
			}			
		}
		//Return false if book not deleted
		return Boolean.FALSE.booleanValue();
	}

	
	@Override
	public BookDetails updateBook(BookDetails BookDetails, Map<Long, BookDetails> BookMap) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void displayAvailableBookInfo(Map<Long, BookDetails> BookMap) {
		
		//Iterate Book map
		Iterator<Entry<Long, BookDetails>> itr = BookMap
				.entrySet().iterator();
		//Instantiate Column object
		FormattedColumns formattedColumnsObj = new FormattedColumns();		
		formattedColumnsObj.addLine(Constants.BOOKID,Constants.AUTHOR,Constants.TITLE);
		//Iterate Books object
		while (itr.hasNext()) {			
			Entry<Long, BookDetails> entry = itr.next();
			BookDetails BookDetails = entry.getValue();
			//Check issued indicator as false
			if(BookDetails!=null && !BookDetails.getIssued()){
				formattedColumnsObj.addLine(entry.getKey().toString(),
						BookDetails.getAuthor(), BookDetails.getTitle());
			}			
		}
		//print the column
		formattedColumnsObj.print();		
	}


	@Override
	public void displayIssuedBookInfo(Map<Long, BookDetails> BookMap) {
		//Iterate Book map
		Iterator<Entry<Long, BookDetails>> itr = BookMap
		.entrySet().iterator();
		//Instantiate Column object
		FormattedColumns formattedColumnsObj = new FormattedColumns();		
		formattedColumnsObj.addLine(Constants.BOOKID,Constants.AUTHOR,Constants.TITLE);
		//Iterate Books object
		while (itr.hasNext()) {			
			Entry<Long, BookDetails> entry = itr.next();
			BookDetails BookDetails = entry.getValue();
			//Check issued indicator and it should be true
			if(BookDetails.getIssued()){				
				formattedColumnsObj.addLine(entry.getKey().toString(),
						BookDetails.getAuthor(), BookDetails.getTitle());
			}			
		}
		//print the column
		formattedColumnsObj.print();
	}

}
