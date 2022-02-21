package com.mobiledev.myapp;

import android.app.*;
import android.content.*;
import android.os.*;
import android.widget.*;
import java.util.*;

public class Splash extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
		//Remove title bar
		getActionBar().hide();
		
		GlobalState.addUser("test user","test@gmail.com","password");
		
		
		Timer t = new Timer();
		t.schedule(new TimerTask(){
				public void run(){
					Intent intent = new Intent(Splash.this, AuthActivity.class);
					finish();
					startActivity(intent);
				}
		},3000);
    }
    
}
