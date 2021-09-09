package admin;

import java.util.Map;

public interface BookService {

    Boolean addBook(BookDetails bookDetails,Map<Long,BookDetails> bookDetailsMap);

    void displayBook(BookDetails bookDetails,Map<Long,BookDetails> bookDetailsMap);

    Boolean updateBook(BookDetails bookDetails,Map<Long,BookDetails> bookDetailsMap,Long key);

    Boolean deleteBook(BookDetails bookDetails,Map<Long,BookDetails> bookDetailsMap,Long key);

    Boolean issuedBook(BookDetails bookDetails,Map<Long,BookDetails> bookIsuued);

    Boolean returnBook(BookDetails bookDetails,Map<Long,BookDetails> bookIssued,Long key);
}
