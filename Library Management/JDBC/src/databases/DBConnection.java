package databases;

import java.sql.*;
import java.util.Scanner;

public class DBConnection implements DBConnectionService {
    private static String url = "jdbc:mysql://localhost:3306/bookjdbc?characterEncoding=latin1";
    private static String user = "root";
    private static String pass = "Parshuram@1234";

    @Override
    public void displayBook(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,user,pass);

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from books");
            while(rs.next())
                System.out.println(rs.getInt(1)+"      "+rs.getString(2)+"      "
                        +rs.getString(3)+"      "+rs.getInt(4));
            con.close();
        }catch(Exception e)
        { System.out.println(e);
        }
    }

    @Override
    public void addBooks(String title,String author,int price) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,pass);
            String sql = "INSERT INTO books VALUES (?, ?, ?, ?)";
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setInt(1,0);
            stmt.setString(2,title);
            stmt.setString(3, author);
            stmt.setInt(4, price);
            int row=stmt.executeUpdate();
            if(row>0){
                System.out.println("Insert");
            }else {
                System.out.println("Not Insert");
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBooks(int id) {
        PreparedStatement stmt = null;
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            System.out.println("Want to update:\n1.Title\n2.Author\n3.Price");
            int ch = sc.nextInt();
            if(ch==1) {
                stmt = con.prepareStatement("UPDATE books SET title = ? WHERE id = ?");
                System.out.println("Enter Name For Update");
                String name = sc.next();
                stmt.setString(1, name);
                stmt.setInt(2, id);
            }else if(ch==2) {
                stmt = con.prepareStatement("UPDATE books SET author = ? WHERE id = ?");
                System.out.println("Enter Author For Update");
                String author = sc.next();
                stmt.setString(1, author);
                stmt.setInt(2, id);
            }else if(ch==3) {
                stmt = con.prepareStatement("UPDATE books SET author = ? WHERE id = ?");
                System.out.println("Enter Price For Update");
                double price = sc.nextDouble();
                stmt.setDouble(1, price);
                stmt.setInt(2, id);
            }
            int row=stmt.executeUpdate();
            if(row>0){
                System.out.println("Update");
            }else {
                System.out.println("Not Update");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void returnBook(int id) {
        try {
            addReturnBook(id);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,pass);
            PreparedStatement stmt=con.prepareStatement("delete from issue where id=?");
            stmt.setInt(1, id);
            int i=stmt.executeUpdate();
            if(i>0) {
                System.out.println(i+" Return Book");
            }else {
                System.out.println("Return Book Fails");
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void searchBook(String name) {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            PreparedStatement stmt=con.prepareStatement("select * from books where title=?");
            stmt.setString(1, name);
            int i=0;
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                System.out.print(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
                i=1;
            }
            if(i==0) {
                System.out.println("No Books Founds ):");
            }
            System.out.println();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    private static void addReturnBook(int id) {
        String name =null,author = null;
        int price = 0;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            PreparedStatement stmt=con.prepareStatement("select * from issue where id=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                name=rs.getString(2);
                author=rs.getString(3);
                price = rs.getInt(4);

            }
            String sql = "INSERT INTO books VALUES (?, ?, ?, ?)";
            PreparedStatement stmt1=con.prepareStatement(sql);
            stmt1.setInt(1,id);
            stmt1.setString(2,name);
            stmt1.setString(3, author);
            stmt1.setInt(4, price);
            stmt1.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void displayIssued() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,pass);

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from issue order by id ASC");
            while(rs.next())
                System.out.println(rs.getInt(1)+"      "+rs.getString(2)+"      "+rs.getString(3)+"      "+rs.getFloat(4));

            con.close();
        }catch(Exception e)
        { System.out.println(e);
        }
    }

    @Override
    public void issuedBook(int id) {
        String name = null,author = null;
        double price = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            PreparedStatement stmt=con.prepareStatement("select * from books where id=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                name=rs.getString(2);
                author=rs.getString(3);
                price = rs.getDouble(4);

            }
            String sql = "INSERT INTO issue VALUES (?, ?, ?, ?)";
            PreparedStatement stmt1=con.prepareStatement(sql);
            stmt1.setInt(1,id);
            stmt1.setString(2,name);
            stmt1.setString(3, author);
            stmt1.setDouble(4, price);
            int row=stmt1.executeUpdate();
            if(row>0){
                System.out.println("Issue Book Success");
                deleteBooks(id);
            }else {
                System.out.println("Not Issue");
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBooks(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,pass);
            PreparedStatement stmt=con.prepareStatement("delete from books where id=?");
            stmt.setInt(1, id);
            int i=stmt.executeUpdate();
            if(i>0) {
                System.out.println(i+" records deleted");
            }else {
                System.out.println("records not deleted");
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
