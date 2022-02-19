package com.mobiledev.myapp;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import java.util.*;

public class Splash extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
		//Remove title bar
		getActionBar().hide();
		
		GlobalState.addUser("test","test@gmail.com","password");
		
		Timer t = new Timer();
		t.schedule(new TimerTask(){
				@Override
				public void run()
				{
					// TODO: Implement this method
					Intent intent = new Intent(Splash.this, AuthActivity.class);
					finish();
					startActivity(intent);
				}
		},2000);
    }
    
}
