package model;
 
public class User {
	
	private String username;
	private String firstName;
	private String lastName;
	
	public User() {
	}
	
	public User(String firstName, String lastName, String username) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
	}
 
	public String getUsername() {
		return username;
	}
 
	public void setUsername(String userfirstName) {
		this.username = userfirstName;
	}
 
	public String getFirstName() {
		return firstName;
	}
 
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
 
	public String getLastName() {
		return lastName;
	}
 
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}