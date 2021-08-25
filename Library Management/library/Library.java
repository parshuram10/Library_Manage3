package com.libmanage.library;

import java.util.Map;

import com.libmanage.library.*;

public interface Library {
	
	public void addLibrary(LibraryDetails LibraryDetails,Map<Long, LibraryDetails> map);
	
	public void searchKWLibrary(String Name,Map<Long, LibraryDetails> map);
	
	public void updateKwLibrary(LibraryDetails libraryDetails,Map<Long, LibraryDetails> map);
	
	public void displayLibraryInfo(Map<Long, LibraryDetails> LibraryMap);

}
