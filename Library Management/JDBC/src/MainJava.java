import databases.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MainJava {

    private static DBConnection dbConnection = new DBConnection();
    public static void main(String[] args){
        System.out.println("================Welcome To Book Shell================");
        displayLogs();
    }
    private static void displayLogs() {
        // TODO Auto-generated method stub
        String adminUsr = "admin";
        String adminPass = "admin123";
        String studLog = "student";
        String studLogPass = "student123";
        System.out.println("Press 1 For Admin\nPress 2 For Student");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n==1) {
            System.out.println("================Admin================");
            System.out.println("UserName: ");
            String username = sc.next();
            System.out.println("Password: ");
            String password = sc.next();
            if(username.equals(adminUsr) && password.equals(adminPass)) {
                showConsole();
            }else {
                System.out.println("Login Failed");
                displayLogs();
            }

        }else if(n==2) {
            System.out.println("================Student1================");
            System.out.println("studentName: ");
            String studName = sc.next();
            System.out.println("studentPassword: ");
            String studPass = sc.next();
            if(studLog.equals(studName) && studLogPass.equals(studPass)){
                showStudentConsole();
            }else{
                System.out.println("Login Failed");
                displayLogs();
            }
        }
        sc.close();
    }

    static void showConsole() {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.println("=======Welcome==========");
        int i=1;
        do{
            System.out.println("Enter Yout Choice: \n 1.AddBook \n 2.Display Book \n 3.Update Book\n 4.Delete Book\n 5.Issued Book\n 6.Display Issue Book\n 7.Return Book\n 8.Search Book");
            int k = sc.nextInt();
            switch(k){
                case 1:
                    addBook();
                    break;
                case 2:
                    displayBook();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    issuedBook();
                    break;
                case 6:
                    displayIssue();
                    break;
                case 7:
                    returnBook();
                    break;
                case 8:
                    searchBook();
                    break;
                default:
                    System.out.println("Enter Correct Choice  ):");
            }
            System.out.println("Do u want continue press 1: ");
            i=sc.nextInt();
        }while(i==1);
        sc.close();
    }
    static void showStudentConsole() {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.println("=======Welcome==========");
        int i=1;
        do{
            System.out.println("Enter Yout Choice: \n 1.Issued Book\n 2.Display Issue Book\n 3.Return Book\n 4.Search Book");
            int k = sc.nextInt();
            switch(k){
                case 1:
                    issuedBook();
                    break;
                case 2:
                    displayIssue();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    searchBook();
                    break;
                default:
                    System.out.println("Enter Correct Choice  ):");
            }
            System.out.println("Do u want continue press 1: ");
            i=sc.nextInt();
        }while(i==1);
        sc.close();
    }

    private static void searchBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Title for Search: ");
        String title = sc.next();
        dbConnection.searchBook(title);
    }

    private static void returnBook() {
        System.out.println("Enter Id For return the Books");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        dbConnection.returnBook(id);
    }

    private static void displayIssue() {
        System.out.println("Displays Number of Issued Books");
        dbConnection.displayIssued();
    }

    private static void issuedBook() {
        displayBook();
        System.out.println("Inserting records into the table...");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Id");
        int id = sc.nextInt();
        dbConnection.issuedBook(id);
    }

    private static void deleteBook() {
        displayBook();
        System.out.println("Enter Id For delete the Recrods");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        dbConnection.deleteBooks(id);
    }

    private static void updateBook() {
        displayBook();
        System.out.println("Update Books");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Id For Update");
        int id = sc.nextInt();
        dbConnection.updateBooks(id);
    }

    private static void addBook() {
        System.out.println("Inserting records into the table...");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name");
        String title = sc.next();
        System.out.println("Enter Author");
        String author = sc.next();
        System.out.println("Enter Price");
        int price = sc.nextInt();
        dbConnection.addBooks(title,author,price);
    }

    static void displayBook(){
        System.out.println("Book Available: ");
        dbConnection.displayBook();
    }
}
