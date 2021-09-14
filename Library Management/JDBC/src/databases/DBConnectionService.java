package databases;

public interface DBConnectionService {
    void displayBook();
    void addBooks(String title,String author,int price);
    void updateBooks(int id);
    void deleteBooks(int id);
    void issuedBook(int id);
    void displayIssued();
    void returnBook(int id);
    void searchBook(String name);
}
