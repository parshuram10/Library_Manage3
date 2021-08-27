package MLibrary;
import java.sql.*;
import java.util.Scanner;
public class Main {
	
	static final String url = "jdbc:mysql://localhost:3306/Library?characterEncoding=latin1";
	static final String url1 = "jdbc:mysql://localhost:3306/Library";
	static final String user = "root";
	static final String pass = "Parshuram@1234";
	public static void main(String[] args) {
	
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
			}
			
		}else if(n==2) {
			System.out.println("================Student1================");
			System.out.println("studentName: ");
			String studName = sc.next();
			System.out.println("studentPassword: ");
			String studPass = sc.next();
			if(studLog.equals(studName) && studLogPass.equals(studPass)){
				showConsole();
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
					displayRecord();
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
	
	private static void searchBook() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Title for Search: ");
		String name = sc.next();
		
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

	private static void displayIssue() {
		// TODO Auto-generated method stub
		System.out.println("Display Issued book...");
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
	
	private static void returnBook() {
		// TODO Auto-generated method stub
		displayIssue();
		System.out.println("Enter Id For return the Books");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(url,user,pass);  
			PreparedStatement stmt=con.prepareStatement("delete from issue where id=?");
			stmt.setInt(1, id);
			int i=stmt.executeUpdate();  
			if(i>0) {
				System.out.println(i+" Return Book");  
				addReturnBook(id);
			}else {
				System.out.println("Return Book Fails"); 
			}
			
		}catch(Exception e) {
	    	e.printStackTrace();
		}
	}
	
	private static void addReturnBook(int id) {
		String name = null,author = null;
		double price = 0;
		try {          
			          
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,user,pass);
				PreparedStatement stmt=con.prepareStatement("select * from issue where id=?");
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					name=rs.getString(2);
					author=rs.getString(3);
					price = rs.getDouble(4);
					
				}
				String sql = "INSERT INTO books VALUES (?, ?, ?, ?)";
				PreparedStatement stmt1=con.prepareStatement(sql);  
				stmt1.setInt(1,id);
				stmt1.setString(2,name);
				stmt1.setString(3, author);
				stmt1.setDouble(4, price);
			    stmt1.executeUpdate();
			}catch(Exception e) {
			e.printStackTrace();
			}
	}
	private static void issuedBook() {
		// TODO Auto-generated method stub
		displayRecord();
		System.out.println("Inserting records into the table...");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id");
		int id = sc.nextInt();
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
				deleteIssueBook(id);
			}else {
				System.out.println("Not Issue");
			}
			
		}catch(Exception e) {
		e.printStackTrace();
		}
	}
	private static void deleteIssueBook(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(url,user,pass);  
			PreparedStatement stmt=con.prepareStatement("delete from books where id=?");
			stmt.setInt(1, id);
			int i=stmt.executeUpdate();  
		}catch(Exception e) {
	    	e.printStackTrace();
		}
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
			ResultSet rs=stmt.executeQuery("select * from books order by id ASC");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"      "+rs.getString(2)+"      "+rs.getString(3)+"      1"+rs.getFloat(4));  
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
		PreparedStatement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(url,user,pass);
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
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	static void deleteBook() {
		displayRecord();
		System.out.println("Enter Id For delete the Recrods");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
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
