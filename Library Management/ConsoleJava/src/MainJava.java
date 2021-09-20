import Model.BookDetails;
import Service.BookService;
import Service.BookServiceImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MainJava {

    private static Long Index = Long.valueOf(0);
    static Map<Long, BookDetails> mapBook = new LinkedHashMap<>();
    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BookService bookServiceObj = new BookServiceImpl();
    static Map<Long,BookDetails> mapIssued = new LinkedHashMap<>();
    public static void main(String[] args) throws Exception {
        showConsole();
    }
    private static void showConsole() throws Exception {
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

    private static Boolean returnBook() throws Exception{
        displayIssued();
        System.out.println("Enter Id For Return: ");
        Long id = Long.parseLong(br.readLine());
        return bookServiceObj.returnBook(new BookDetails(),mapIssued,id);
    }

    private static Boolean issuedBook() throws Exception{
        System.out.println("Enter Id For Issued: ");
        Long id = Long.parseLong(br.readLine());
        System.out.println("Enter Title: ");
        String title = br.readLine();
        System.out.println("Enter Author: ");
        String author = br.readLine();
        System.out.println("Enter Price: ");
        int price = Integer.parseInt(br.readLine());
        BookDetails bookDetails = new BookDetails(id,title,author,price);
        return bookServiceObj.issuedBook(bookDetails,mapIssued);
    }

    private static void displayIssued() {
        System.out.println("Issued Books: ");
        bookServiceObj.displayBook(new BookDetails(),mapIssued);
    }

    private static Boolean deleteBook() throws Exception{
        displayBook();
        System.out.println("Enter id For Delete: ");
        Long id = Long.parseLong(br.readLine());
        return bookServiceObj.deleteBook(new BookDetails(),mapBook,id);
    }

    private static Boolean updateBook() throws Exception{
        displayBook();

        System.out.println("Enter id For Update: ");
        Long id = Long.parseLong(br.readLine());
        System.out.println("Enter Title: ");
        String title = br.readLine();
        System.out.println("Enter Author: ");
        String author = br.readLine();
        System.out.println("Enter Price: ");
        int price = Integer.parseInt(br.readLine());

        BookDetails bookDetails = new BookDetails(id,title,author,price);
        return bookServiceObj.updateBook(bookDetails,mapBook,id);
    }

    private static Boolean addBook() throws Exception{

        Long id = Index++;
        System.out.println("Enter Title: ");
        String title = br.readLine();
        System.out.println("Enter Author: ");
        String author = br.readLine();
        System.out.println("Enter Price: ");
        int price = Integer.parseInt(br.readLine());
        BookDetails bookDetails = new BookDetails(id,title,author,price);
        return bookServiceObj.addBook(bookDetails,mapBook);
    }

    private static void displayBook() {
        System.out.println("Book Available: ");
        BookDetails bookDetails = new BookDetails();
        bookServiceObj.displayBook(bookDetails,mapBook);
    }
}
