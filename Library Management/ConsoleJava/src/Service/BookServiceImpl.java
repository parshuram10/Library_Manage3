package Service;

import Model.BookDetails;

import java.util.Map;

public class BookServiceImpl implements BookService{

    @Override
    public Boolean addBook(BookDetails bookDetails, Map<Long, BookDetails> bookDetailsMap) {
        bookDetailsMap.put(bookDetails.getId(),bookDetails);
        return Boolean.TRUE.booleanValue();
    }

    @Override
    public Boolean updateBook(BookDetails bookDetails, Map<Long, BookDetails> bookDetailsMap, Long key) {
        bookDetailsMap.replace(key,bookDetails);
        return Boolean.TRUE.booleanValue();
    }

    @Override
    public Boolean deleteBook(BookDetails bookDetails, Map<Long, BookDetails> bookDetailsMap, Long key) {
        bookDetailsMap.remove(key);
        return Boolean.TRUE.booleanValue();
    }

    @Override
    public Boolean issuedBook(BookDetails bookDetails, Map<Long, BookDetails> bookIsuued) {
        bookIsuued.put(bookDetails.getId(),bookDetails);
        return Boolean.TRUE.booleanValue();
    }

    @Override
    public Boolean returnBook(BookDetails bookDetails, Map<Long, BookDetails> bookIssued, Long key) {
        bookIssued.remove(key);
        return Boolean.TRUE.booleanValue();
    }

    @Override
    public void displayBook(BookDetails bookDetails, Map<Long, BookDetails> bookDetailsMap) {

        for(Map.Entry<Long,BookDetails> bookDetailsEntry : bookDetailsMap.entrySet()){
            Long key = bookDetailsEntry.getKey();
            bookDetails = bookDetailsEntry.getValue();
            System.out.println("id"+"         "+"Title"+"         "+"Author"+"         "+"Price");
            System.out.println(key.toString()+"   "+bookDetails.getBookTitle()+"   "+bookDetails.getBookAuthor()
            +"   "+bookDetails.getPrice());
        }
    }
}
