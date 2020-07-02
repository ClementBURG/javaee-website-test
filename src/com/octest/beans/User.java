package com.octest.beans;

public class User {
	private String firstName;
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) throws BeanException {
		if (firstName.length() > 10) {
            throw new BeanException("Le nom est trop grand ! (10 caractères maximum)");
        } else {
        	this.firstName = firstName;
        }
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
