package com.libmanage.library;

public class LibraryDetails{
	//This attribute contains library unique ID
	private Long libraryID;
	//This attribute contains library name
	private String name;
	//This attribute contains library address as String
	private String address;
	//This attribute contains Boolean which enable or disable library
	private Boolean isActive;
	//This attribute contains owner name
	private String ownerName;
	//This attribute contains Boolean value which indicate public library or not
	private Boolean isPublicLibrary;
	//setter and getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public Boolean getIsPublicLibrary() {
		return isPublicLibrary;
	}
	public void setIsPublicLibrary(Boolean isPublicLibrary) {
		this.isPublicLibrary = isPublicLibrary;
	}
	public Long getLibraryID() {
		return libraryID;
	}
	public void setLibraryID(Long libraryID) {
		this.libraryID = libraryID;
	}	
}
