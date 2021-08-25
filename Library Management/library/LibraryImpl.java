package com.libmanage.library;

import java.util.Map;
import java.util.Map.Entry;

import com.libmanage.common.*;

public class LibraryImpl implements Library{

	LibraryDetails libraryDetails = new LibraryDetails();

	@Override
	public void displayLibraryInfo(Map<Long, LibraryDetails> LibraryMap) {
		
		java.util.Iterator<Entry<Long, LibraryDetails>> itr = LibraryMap.entrySet().iterator();
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("******* Library Information *******").append(Constants.LINECHANGE);
		while(itr.hasNext()){
			Entry<Long, LibraryDetails> entry = itr.next();
			LibraryDetails libraryDetails = entry.getValue();			
			stringBuilder.append(entry.getKey()).append(Constants.TABSPACE).append(libraryDetails.getName()).append(Constants.TABSPACE).append(libraryDetails.getAddress()).append(Constants.LINECHANGE);
		}
		System.out.println(stringBuilder);
	}
	
	@Override
	public void addLibrary(LibraryDetails LibraryDetails,
			Map<Long, LibraryDetails> map) {
		
		map.put(LibraryDetails.getLibraryID(), LibraryDetails);
		
		//return Boolean.TRUE.booleanValue();
		
	}
	
	@Override
	public void searchKWLibrary(String Name, Map<Long, LibraryDetails> map) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * This method helps to update library information.
	 * 
	 * @param kwLibraryDetails
	 * 		- Contains library details
	 * @param map
	 * 		- Contains libraries information in the map
	 */
	@Override
	public void updateKwLibrary(LibraryDetails LibraryDetails,
			Map<Long, LibraryDetails> map) {
		// TODO Auto-generated method stub
		
	}	

}
