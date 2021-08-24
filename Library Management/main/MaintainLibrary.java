package com.libmanage.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.libmanage.book.*;
import com.libmanage.common.*;
import com.libmanage.library.*;

public class MaintainLibrary {
	
	//This attribute stores library related information
	static Map<Long, LibraryDetails> LibraryMap = new TreeMap<Long, LibraryDetails>(); 
	//This attribute stores book related information
	static Map<Long, BookDetails> BookMap = new TreeMap<Long, BookDetails>();
	//This attribute store library and book association	
	static Map<Long, Set> LibraryBookAssociation = new TreeMap<Long, Set>();
	//This attribute helps to take input from keyboard
	//static Scanner scanner = new Scanner(System.in);
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader bufferedReader = new BufferedReader(isr);
	//Instantiate KWLibrary object to call methods 
	static Library LibraryObj = new LibraryImpl();
	//Instantiate KWBook object to call methods
	static Book BookObj = new BookImplmpl();
	//Declare variable to generate unique number
	static Long index = 0l;
	
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("********************************************");
		System.out.println("  Welcome to KnowledgeWala Library  ");
		System.out.println("********************************************");
		System.out.println("--- Please select you obtion to take action --- ");
		//Call method to display menu
		mainMenu();		
		//Call scanner to get value as input
		//Scanner scanner = new Scanner(System.in);
		//set boolean to exit application
		Boolean isNotExit = true;
		//Start loop to get option multiple time
		while(isNotExit){
			System.out.println("********* Please Enter your Option *********");
			try{
			Integer selectedOption = Integer.valueOf(bufferedReader.readLine());
			//Call method to take action based on input value
			
				action(selectedOption);
			}catch (Exception e) {
				System.out.println("Error Input : "+e.getMessage());	
				continue;
			}
						
		}	
	}
	/**
	 * This method helps to stop current running Java Virtual Machine.
	 */
	private static void  stopApplication(){
		// Call method to stop application
		System.exit(1);
	}
	/**
	 * This method helps to invoke action based on selected options from the menu.
	 * @param selectedOption
	 * 		- Contains options value from 1 to 6
	 * @throws IOException 
	 */
	private static void action(Integer selectedOption) throws IOException{	
		//pass selected input parameter
		switch(selectedOption){	
		case 0: 
			System.out.println("****Library Details****"+Constants.LINECHANGE);
			//Call method to display Library Information
			iterateAndDispLibraryMap(LibraryMap);
			//Call method to display main menu
			mainMenu();
			break;
			
		case 1: 
			System.out.println("****Library and Book Association Details****"+Constants.LINECHANGE);
			//Call method to display Books associated to Library
			displayLibraryBookAss(LibraryBookAssociation);
			//Call method to display main menu
			mainMenu();
			break;
		case 2:
			System.out.println("****Display Existing Available Books****"+Constants.LINECHANGE);
			//Call method to display library information
			displayAvailableBookInfo(BookMap);
			break;
		case 3:
			System.out.println("****Display Existing Issued Books****"+Constants.LINECHANGE);
			//call method to display issued books
			displayIssuedBookInfo(BookMap);
			//Call method to display main menu
			mainMenu();
			break;
		case 4:
			System.out.println("****Add New Libray****"+Constants.LINECHANGE);
			//Call method to add Library
			addLibrary();
			//Call method to display main menu
			mainMenu();
			break;
		case 5:
			System.out.println("****Add New Book****"+Constants.LINECHANGE);
			//Call method to add Book
			addBook();
			//Call method to display main menu
			mainMenu();
			break;
		case 6:
			System.out.println("****Issue a Book****"+Constants.LINECHANGE);
			//Call method to issue Book
			issueBook();
			//Call method to display main menu
			mainMenu();
			break;
		case 7:
			System.out.println("****Delete a Book****"+Constants.LINECHANGE);
			//Call method to issue Book
			deleteBook(BookMap);
			//Call method to display main menu
			mainMenu();
			break;
		case 8:
			System.out.println("Application Stoped......Have a Nice Day! :)");
			//Call method to stop application
			stopApplication();
			//Call method to display main menu
			mainMenu();
			break;
		default:
			System.out.println("Option Not Recognized!");
			//Call method to display main menu
			mainMenu();
			break;
		
		}
	}
	/**
	 * This method helps to create main menu.
	 */
	private static void mainMenu() {
		//Instantiate FormattedColumns Object to print line
		FormattedColumns formattedColumnsObj = new FormattedColumns();
		//Add lines of record
		formattedColumnsObj
				.addLine(
						"********** MAIN MENU **********")
				.addLine(
						"Press '0' To Display Existing Libraries")
				.addLine(
						"Press '1' To Display Existing Libraries and Books Details")
				.addLine("Press '2' To Display Existing Available Books")
				.addLine("Press '3' To Display Existing Issues Books")
				.addLine("Press '4' To Add New Libray")
				.addLine("Press '5' To Add New Book")
				.addLine("Press '6' Issue a Book")
				.addLine("Press '7' Delete a Book")
				.addLine("Press '8' To Stop Application");
		//print the output
		formattedColumnsObj.print();
		
	}
	/**
	 * This method helps to add book.
	 * 
	 * @return Boolean
	 * 		- Contains Boolean value as true or false
	 * @throws IOException 
	 */
	private static Boolean addBook() throws IOException{
		try{
			//Scanner tempScanner = new Scanner(System.in);
			//Set default values
			BookDetails bookDetails = new BookDetails();
			bookDetails.setTotalPage((int) (Math.random()*100));
			bookDetails.setBookID(++index);
			bookDetails.setIssued(false);	
			
			//get Book details as input		
			System.out.println("Enter Book Title -");
			bookDetails.setTitle(bufferedReader.readLine());
			System.out.println("Enter Book Author -");
			bookDetails.setAuthor(bufferedReader.readLine() );
			System.out.println("Enter Associated LibraryID -");
			bookDetails.setLibraryID(Long.valueOf(bufferedReader.readLine()));			
			System.out.println("Enter Publisher -");
			bookDetails.setPublisher(bufferedReader.readLine());
			//Check Library ID available or Not
			validateLibraryID(bookDetails);
			
			return BookObj.addBook(bookDetails,BookMap);
		}catch(NumberFormatException nfe){
			nfe.getMessage();
			
		}		
		return Boolean.FALSE.booleanValue();
		
	}
	
	/**
	 * This method helps to issue a book.
	 * 
	 * @return Boolean
	 * 		- Contains Boolean value as true or false
	 * @throws IOException 
	 */
	private static Boolean issueBook() throws IOException{
		
		//Check Map empty
		if(BookMap.isEmpty()){
			System.out.println("No Book Added Yet!");		
			
			return Boolean.FALSE.booleanValue();
		}else{			
			try{
				displayAvailableBookInfo(BookMap);
				System.out.println("Enter BookID from above to issue");
				Long bookID = Long.valueOf(bufferedReader.readLine());
				if(BookMap.containsKey(bookID)){					
					//update book
					BookMap.get(bookID).setIssued(Boolean.TRUE.booleanValue());
				}else{
					System.out.println("BookID Not available!");
					//return true once book issues
					return Boolean.TRUE.booleanValue();
				}				
				//return true once book issues
				return Boolean.TRUE.booleanValue();
			}catch(NumberFormatException nfe){
				nfe.getMessage();
				
			}
		}		
		return Boolean.FALSE.booleanValue();
		
	}
	
	/**
	 * This method helps to delete a book.
	 * 
	 * @return Boolean
	 * 		- Contains Boolean value as true or false
	 * @throws IOException 
	 */
	private static Boolean deleteBook(Map<Long,BookDetails> BookMap) throws IOException{
		//Check Map empty
		if(BookMap.isEmpty()){
			System.out.println("No Book Added Yet!");		
			
			return Boolean.FALSE.booleanValue();
		}else{			
			try{
				displayAvailableBookInfo(BookMap);
				System.out.println("Enter BookID from above to delete");
				Long bookID = Long.valueOf(bufferedReader.readLine());
				if(BookMap.containsKey(bookID)){
					
					//Call method to delete book
					BookObj.deleteBook(bookID, BookMap);
				}else{
					System.out.println("BookID Not available!");
					//return true once book issues
					return Boolean.TRUE.booleanValue();
				}			
				
				//return true once book issues
				return Boolean.TRUE.booleanValue();
			}catch(NumberFormatException nfe){
				nfe.getMessage();
				
			}
		}			
		
		return Boolean.FALSE.booleanValue();
		
	}
	
	
	/**
	 * This method helps to add Library information.
	 * 
	 * @return Boolean
	 * @throws IOException 
	 */
	private static Boolean addLibrary() throws IOException {
		
		//Scanner tempScanner = new Scanner(System.in);
		//Set default values
		LibraryDetails libraryDetails = new LibraryDetails();
		libraryDetails.setLibraryID(++index);
		libraryDetails.setIsActive(Boolean.TRUE.booleanValue());
		libraryDetails.setIsPublicLibrary(Boolean.TRUE.booleanValue());
		LibraryObj.addLibrary(libraryDetails, LibraryMap);
		
		//get Library details as input		
		System.out.println("Enter Library Name -");
		String name = bufferedReader.readLine();
		libraryDetails.setName(name);
		System.out.println("Enter Library Address -");
		String address = bufferedReader.readLine();
		libraryDetails.setAddress(address);
		System.out.println("Enter Library Owner Name -");
		String ownerName = bufferedReader.readLine();
		libraryDetails.setOwnerName(ownerName);
		
		return Boolean.TRUE.booleanValue();

	}
	/**
	 * This method helps to display library and book association information.
	 * 
	 * @param LibraryBookAssociation
	 * 		- Contains map  with bookID and LibraryID information
	 */
	private static void displayLibraryBookAss(
			Map<Long, Set> kwLibraryBookAssociation) {
		//Check Empty and return
		if(LibraryBookAssociation.isEmpty()){
			System.out.println("No Book assigned to Library Yet!"+Constants.LINECHANGE);
			
			return;
		}		
		//Iterate Map
		Iterator<Entry<Long, Set>> itr = kwLibraryBookAssociation.entrySet()
				.iterator();
		//Instantiate FormattedColumns object to print
		FormattedColumns formattedColumnsObj = new FormattedColumns();
		formattedColumnsObj.addLine(Constants.LibraryName,Constants.TITLE,Constants.AUTHOR,Constants.PUBLISHER);
		while (itr.hasNext()) {
			Entry<Long, Set> entry = itr.next();
			Long key = entry.getKey();			
			Iterator itrSet = entry.getValue().iterator();
			while (itrSet.hasNext()) {
				Long bookID = (Long) itrSet.next();
				if(BookMap.containsKey(bookID)){
					BookDetails bookDetails = BookMap.get(bookID);
					formattedColumnsObj.addLine(LibraryMap.get(key).getName(),
							bookDetails.getTitle(), bookDetails.getAuthor(),
							bookDetails.getPublisher());				
				}				
			}
		}
		//Print output
		formattedColumnsObj.print();		
	}
	/**
	 * This method helps to iterate Library Map
	 * 
	 * @param LibraryMap
	 * 		- Contains Library details
	 * @return Boolean
	 * 		- Contains true/false once records available then true otherwise false
	 */
	private static Boolean iterateAndDispLibraryMap(Map<Long, LibraryDetails> LibraryMap){
		
		if(LibraryMap.isEmpty()){
			System.out.println("No Library Added Yet!");
			
			return Boolean.FALSE.booleanValue();
		}
		//Iterate Map
		Iterator<Entry<Long, LibraryDetails>> itr = LibraryMap.entrySet()
		.iterator();
		//Instantiate FormattedColumns object to print
		FormattedColumns formattedColumnsObj = new FormattedColumns();		
		formattedColumnsObj.addLine(Constants.LIBRARYID,Constants.LibraryName);
		while (itr.hasNext()) {
			Entry<Long, LibraryDetails> entry = itr.next();
			formattedColumnsObj.addLine(entry.getKey().toString(),entry.getValue().getName());			
		}
		//Print output
		formattedColumnsObj.print();

		return Boolean.TRUE.booleanValue();
	}

	/**
	 * This method helps to validate library ID while adding books. it set 0
	 * once ID not available.
	 * 
	 * @param BookDetails
	 * 		- Contains Books details
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	@SuppressWarnings("unchecked")
	private static void validateLibraryID(BookDetails bookDetails) throws NumberFormatException, IOException{
		//Check library ID available in the map or not
		if(!LibraryMap.containsKey(bookDetails.getLibraryID())){			
			System.out.println("Entered Library ID not available, Added Default Value as 0!");
			//Iterate Library Map
			if(iterateAndDispLibraryMap(LibraryMap)){ 
				//get Input again if library available
				System.out.println("Enter Associated LibraryID -");
				bookDetails.setLibraryID(Long.valueOf(bufferedReader.readLine()));
				validateLibraryID(bookDetails);
			}else{
				//set 0 once it is not available
				bookDetails.setLibraryID(0l);
			}
		}else{
			Set bookIDSet = LibraryBookAssociation.get(bookDetails.getLibraryID());
			if(bookIDSet == null){
				bookIDSet = new HashSet();
			}
			//Set BookID
			bookIDSet.add(bookDetails.getBookID());
			//Add BookID corresponding to its Library ID
			LibraryBookAssociation.put(bookDetails.getLibraryID(), bookIDSet);
		}
		
	}
	
	/**
	 * This method helps to display all available book.
	 * 
	 * @param BookMap
	 * 		- Contains Books information in the map
	 */	
	public static void displayAvailableBookInfo(Map<Long, BookDetails> BookMap) {
		//Check Map empty
		if(BookMap.isEmpty()){
			System.out.println("No Book Added Yet!");		

			return;
		}else{
			//Call method to display book
			BookObj.displayAvailableBookInfo(BookMap);

		}
	}
	/**
	 * This method helps to display all issued book.
	 * 
	 * @param BookMap
	 * 		- Contains Books information in the map
	 */	
	public static void displayIssuedBookInfo(Map<Long, BookDetails> BookMap) {
		//Check Map empty
		if(BookMap.isEmpty()){
			System.out.println("No Book Added Yet!");		

			return;
		}else{
			//Call method to display book
			BookObj.displayIssuedBookInfo(BookMap);

		}
	}

}
