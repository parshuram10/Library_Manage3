import admin.BookDetails;
import admin.BookService;
import admin.BookServiceImpl;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MapMain {

    private static Long Index = Long.valueOf(0);
    private static Long ISUIndex = Long.valueOf(0);
    static Map<Long, BookDetails> mapBook = new TreeMap<>();
    static Scanner sc = new Scanner(System.in);
    static BookService bookServiceObj = new BookServiceImpl();
    static Map<Long,BookDetails> mapIssued = new TreeMap<>();
    public static void main(String args[]){

        System.out.println("************Welcome to Library*******************");
        showConsole();
    }

    private static void showConsole(){
        int n=1;
        do {
            System.out.println("Enter Choice: \n1.AddBook\n2.Display Book " +
                    "\n3.Update Book \n4.Delete Book \n5.IssuedBook \n6.ReturnBook \n7.Display Issued");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            Boolean success = false;
            switch (ch) {
                case 1:
                    success = addBook();
                    if (success == true) {
                        System.out.println("Book Added");
                    } else {
                        System.out.println("Book Not Added");
                    }
                    break;
                case 2:
                    displayBook();
                    break;
                case 3:
                    success = updateBook();
                    if (success == true) {
                        System.out.println("Book Updated");
                    } else {
                        System.out.println("Book Not Updated");
                    }
                    break;
                case 4:
                    success = deleteBook();
                    if (success == true) {
                        System.out.println("Book Deleted");
                    } else {
                        System.out.println("Book Not Deleted");
                    }
                    break;
                case 5:
                    success = issuedBook();
                    if (success == true) {
                        System.out.println("Book Issued");
                    } else {
                        System.out.println("Book Not Issued");
                    }
                    break;
                case 6:
                    success = returnBook();
                    if (success == true) {
                        System.out.println("Book Return");
                    } else {
                        System.out.println("Book Not Return");
                    }
                    break;
                case 7:
                    displayIssued();
                    break;
                default:
                    System.out.println("Enter Valid Choice.");
            }
            System.out.println("Do you Want to System");
            n = sc.nextInt();
        }while(n==1);
    }

    private static Boolean returnBook() {

        BookDetails bookDetails = new BookDetails();
        System.out.println("Enter Id for return: ");
        Long key = Long.valueOf(sc.nextInt());
        return bookServiceObj.returnBook(bookDetails,mapIssued,key);
    }

    private static void displayIssued() {
        System.out.println("Issued Books");
        BookDetails bookDetails = new BookDetails();
        bookServiceObj.displayBook(bookDetails,mapIssued);
    }

    private static Boolean issuedBook() {

        System.out.println("Enter id For Issued: ");
        Long id= Long.valueOf(sc.nextInt());
        BookDetails bookDetails1 = mapBook.get(id);
        String title = bookDetails1.getTitle();
        String author = bookDetails1.getAuthor();
        String lang = bookDetails1.getLang();
        String price = bookDetails1.getPrice();

        return bookServiceObj.issuedBook(bookDetails1,mapIssued);
    }

    private static Boolean updateBook() {
        BookDetails bookDetails = new BookDetails();

        System.out.println("Enter Id For Update: ");
        Long key = Long.valueOf(sc.nextInt());
        System.out.println("Enter Title For Update:: ");
        bookDetails.setTitle(sc.next());
        System.out.println("Enter Author For Update:: ");
        bookDetails.setAuthor(sc.next());
        System.out.println("Enter Language of Book For Update:: ");
        bookDetails.setLang(sc.next());
        System.out.println("Enter Price For Update:: ");
        bookDetails.setPrice(sc.next());
        return bookServiceObj.updateBook(bookDetails,mapBook,key);
    }

    private static Boolean deleteBook() {

        displayBook();
        BookDetails bookDetails = new BookDetails();
        System.out.println("Enter key For delete Book: ");
        Long key = Long.valueOf(sc.nextInt());
        return bookServiceObj.deleteBook(bookDetails,mapBook,key);
    }

    private static Boolean addBook(){

        BookDetails bookDetails = new BookDetails();

        bookDetails.setId(Index++);
        System.out.println("Enter Title: ");
        bookDetails.setTitle(sc.next());
        System.out.println("Enter Author: ");
        bookDetails.setAuthor(sc.next());
        System.out.println("Enter Language of Book: ");
        bookDetails.setLang(sc.next());
        System.out.println("Enter Price: ");
        bookDetails.setPrice(sc.next());

        return bookServiceObj.addBook(bookDetails,mapBook);
    }

    private static void displayBook(){
        System.out.println("Available Books");
        BookDetails bookDetails = new BookDetails();
        bookServiceObj.displayBook(bookDetails,mapBook);
    }

}
