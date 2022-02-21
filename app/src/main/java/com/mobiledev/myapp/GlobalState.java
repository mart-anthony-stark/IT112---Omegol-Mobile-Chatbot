package com.mobiledev.myapp;

import java.util.*;
import android.renderscript.*;
import android.webkit.*;

public class GlobalState{
	public static ArrayList<User> users = new ArrayList<>();
	public static User currentUser;
	
	public static String[][] req = { { "hello", "hi", "hey" },
		{ "how are you?" },
		{ "good morning" },
		{ "good afternoon" },
		{ "good evening" },
		{ "good night" },
		{ "i love you!" },
		{ "i hate you!" },
		{ "i’m okay", "likewise" },
		{ "what is your name?" },
		{ "are you a human?", "do you sleep?", "do you have emotions?", "does my crush likes me too?",
			"are you breathing?" },
		{ "are you programmed?", "am i handsome?", "am i beautiful?", "are you single?" },
		{ "i’m feeling down", "i’m not okay", "i need help", "can you help me?" },
		{ "i need money" },
		{ "my crush rejected me" },
		{ "i failed my class" },
		{ "goodbye", "bye", "sayonara", } };

	public static String[][] res = { { "Hi babe", "What can I do for you?", "What’s up?" },
		{ "I am good, how about you?" },
		{ "Good morning to you too" },
		{ "Good afternoon to you too" },
		{ "Good evening to you too" },
		{ "Good night!" },
		{ "I love you too!", "eew", "yuck" },
		{ "Kilalanin mo binabangga mo!" },
		{ "That’s great!" },
		{ "My name is Lou" },
		{ "No" },
		{ "Yes" },
		{ "What seems to be the problem?" },
		{ "Sorry, I’m broke", "Asan ang pake ko?" },
		{ "Maybe she’s not for you", "haha daserv", "Ako nalang kasi", "Buti nga hehe"},
		{ "That’s okay, sometimes you have to fail in order to learn" },
		{ "Goodbye!", "Farewell", "Till next time" }
	};
	
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
