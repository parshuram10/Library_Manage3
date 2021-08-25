package MLibrary;
import java.sql.*;
import java.util.Scanner;
public class Main {
	
	static final String url = "jdbc:mysql://localhost:3306/Library?characterEncoding=latin1";
	static final String url1 = "jdbc:mysql://localhost:3306/Library";
	static final String user = "root";
	static final String pass = "Parshuram@1234";
	public static void main(String[] args) {
		showConsole();
	}
	
	static void showConsole() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("=======Welcome==========");
		System.out.println("Enter 1 for starts");
		int i = sc.nextInt();
		do{
			System.out.println("Enter Yout Choice: \n 1.AddBook \n 2.Display Book \n 3.Update Book\n 4.Delete Book");
			int k = sc.nextInt();
			switch(k){
				case 1:
					addBook();
					break;
				case 2:
					displayRecord();
					break;
				case 3:
					updateBook();
					break;
				case 4:
					deleteBook();
					break;
			}
			System.out.println("Do u want continue: ");
			i=sc.nextInt();
		}while(i==1);
	}
	
	static void addBook(){
		System.out.println("Inserting records into the table...");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id");
		int id = sc.nextInt();
		System.out.println("Enter Name");
		String name = sc.next();
		System.out.println("Enter Author");
		String author = sc.next();
		System.out.println("Enter Price");
		double price = sc.nextDouble();
		try {
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection(url,user,pass);          
				String sql = "INSERT INTO books VALUES (?, ?, ?, ?)";
				PreparedStatement stmt=con.prepareStatement(sql);  
				stmt.setInt(1,id);
				stmt.setString(2,name);
				stmt.setString(3, author);
				stmt.setDouble(4, price);
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
	
	
	static void displayRecord() {
		System.out.println("Display records into the table...");
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(url,user,pass);  
			 
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from books");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));  
			con.close();  
			}catch(Exception e)
		{ System.out.println(e);
		}
	}
	
	static void updateBook() {
		displayRecord();
		System.out.println("Update Books");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id For Update");
		int id = sc.nextInt();
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(url1,user,pass);          
			PreparedStatement stmt = con.prepareStatement("UPDATE items SET val = ? WHERE id = ?");    
			
			int row=stmt.executeUpdate();
			if(row>0){
				System.out.println("Update");	
			}else {
				System.out.println("Not Update");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	static void deleteBook() {
		displayRecord();
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(url,user,pass);  
			PreparedStatement stmt=con.prepareStatement("delete from books where id=?");
			stmt.setString(1, "Harry_poter");
			int i=stmt.executeUpdate();  
			System.out.println(i+" records deleted");  
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
