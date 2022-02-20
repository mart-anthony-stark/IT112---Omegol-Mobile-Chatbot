package com.mobiledev.myapp;

public class User
{
	public String username;
	public String email;
	public String password;
	User(String username, String email, String password){
		this.username=username;
		this.email=email;
		this.password=password;
	}
	boolean passwordMatch(String pass){
		return password.equals(pass);
	}
}
