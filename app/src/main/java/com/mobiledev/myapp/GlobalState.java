package com.mobiledev.myapp;

import java.util.*;
import android.renderscript.*;
import android.webkit.*;

public class GlobalState{
	public static ArrayList<User> users = new ArrayList<>();
	public static User currentUser;
	
	public static String[][] req = { { "hello", "hi", "hey" },
		{ "how are you?", "how do you do?" },
		{ "good morning" },
		{ "good afternoon" },
		{ "good evening" },
		{ "good night" },
		{ "i love you!", "i love you" },
		{ "i hate you!", "i hate you", "anong pake ko?", "who cares?", "k" },
		{ "i'm okay", "likewise", "same" },
		{ "what is your name?", "who are you?" },
		{ "are you a human?", "do you sleep?", "do you have emotions?", "does my crush likes me too?",
			"are you breathing?" },
		{ "are you programmed?", "am i handsome?", "am i beautiful?", "are you single?", "can i court you?" },
		{ "i'm feeling down", "i'm not okay", "i need help", "can you help me?", "i'm sad" },
		{ "i need money" },
		{ "my crush rejected me", "she broke up with me" },
		{ "i failed my class", "i failed" },
		{ "goodbye", "bye", "sayonara", },
		{ "just kidding", "joke", "jk"},
		{"bad", "bored", "tired", "sad"},
		};

	public static String[][] res = { { "Hi babe", "What can I do for you?", "What’s up?" },
		{ "I am good, how about you?", "I'm fine, how about you?" },
		{ "Good morning to you too" },
		{ "Good afternoon to you too" },
		{ "Good evening to you too" },
		{ "Good night!", "Oyasumi" },
		{ "I love you too!", "eew", "yuck", "Thanks, pero pogi gusto ko" },
		{ "Kilalanin mo binabangga mo!", "k", "idc", "Hindi mo na ba ako mahal?", "awts gege :<"},
		{ "That’s great!", "Okay", "That's nice" },
		{ "My name is Lou", "I am Lou" },
		{ "No", "Nahh", "Nope" },
		{ "Yes", "Of course", "Absolutely yes!" },
		{ "What seems to be the problem?", "anong chika?" },
		{ "Sorry, I’m broke", "Asan ang pake ko?" },
		{ "Maybe she’s not for you", "haha daserv", "Ako nalang kasi", "Buti nga hehe"},
		{ "That’s okay, sometimes you have to fail in order to learn" },
		{ "Goodbye!", "Farewell", "Till next time" },
		{"Nakakatawa yon?", "HAHAHA", "I know haha" },
		{ "Why?", "Cheer up buddy", "I'd recommend you to watch exo vids, they are my happy pill"}
	};

	public static String[] defaultReply = {
		"Sorry but I can't understand you", "Go on...", "Try again", "I'm listening...",
        "Bro what?",
        "Share mo lang?",
        "Hmmm...",
        "Nice to hear that",
        "What are you trying to say?"};
	
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
