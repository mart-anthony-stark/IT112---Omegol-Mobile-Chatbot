package com.mobiledev.myapp;

import java.util.*;
import android.renderscript.*;
import android.webkit.*;

public class GlobalState{
	public static ArrayList<User> users = new ArrayList<>();
	public static User currentUser;
	
	public static void addUser(String username, String email, String password){
		users.add(new User(username, email,password));
	}
	
	public static User findUser(String field, String value){
		for(User user:users){
			switch(field){
				case "email":
					if(user.email.equals(value))
						return user;
					break;
				case "username":
					if(user.username.equals(value))
						return user;
					break;
			}
		}
		
		return null;
	}
}
