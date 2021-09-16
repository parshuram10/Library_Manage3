package Model;

public class BookDetails {

    private Long id;
    private String bookTitle;
    private String bookAuthor;
    private int price;

    public BookDetails(){

    }
    public BookDetails(Long id, String bookTitle, String bookAuthor, int price) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public int getPrice() {
        return price;
    }
}
