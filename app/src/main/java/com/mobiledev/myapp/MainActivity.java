package com.mobiledev.myapp;
 
import android.app.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.widget.LinearLayout.*;

import android.view.View.OnClickListener;
import android.graphics.drawable.*;
import java.util.*;

public class MainActivity extends Activity { 
	private ScrollView scrollView;
	private LinearLayout msgField;
	private Button sendBtn;
	private EditText chatInput;
	private String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		getActionBar().hide();
		
		// GET layout views
		scrollView = findViewById(R.id.scrollView);
		msgField = findViewById(R.id.msgField);
		sendBtn = findViewById(R.id.sendBtn);
		chatInput = findViewById(R.id.chatInput);
		
		username = GlobalState.currentUser.username;
		//Initial bot message
		sendMessage("bot", "Hi "+username);
		
		// Method to run to send a message from user
        sendBtn.setOnClickListener(new OnClickListener(){
				public void onClick(View p1){
					// Send message
					String msg = chatInput.getText().toString();
					sendMessage("user", msg);
					response(msg);
					chatInput.setText("");
					Timer t = new Timer();
					t.schedule(new TimerTask(){
							public void run(){
								scrollView.fullScroll(View.FOCUS_DOWN);
							}
						},500);
					
				}
			});
	}
	
	// Sends a message from either user or bot
	void sendMessage(String sender,String msg){
		TextView tx= new TextView(this);
		LayoutParams params = new LayoutParams(
			LayoutParams.WRAP_CONTENT,      
			LayoutParams.WRAP_CONTENT
		);
		int bg = sender.equals("user") ? R.drawable.chat_bg : R.drawable.radius;
		params.setMargins(0, 0, 0, 10);
		params.gravity = sender.equals("user") ? Gravity.RIGHT : Gravity.LEFT;
		tx.setLayoutParams(params);
        tx.setText(msg);
		tx.setTextSize(20);
		tx.setTextColor(Color.parseColor("#FFFFFF"));
		tx.setPadding(20,10,20,10);
		tx.setBackgroundResource(bg);
		
		msgField.addView(tx);
	}
	
	//Method to determine the chatbot response
	void response(String msg){
		String[][] req = GlobalState.req;
		String[][] res = GlobalState.res;
		
		for(int i=0; i< req.length; i++){
			try{
			boolean includesMsg = Arrays.asList(req[i]).contains(msg.toLowerCase());
			Toast.makeText(this, String.valueOf(includesMsg), Toast.LENGTH_LONG).show();
			if(includesMsg) {
				int last = res[i].length - 1;
				Random r = new Random();
				int randIdx = r.nextInt(last+1);
				sendMessage("bot", res[i][randIdx]);
			}
			}catch(Exception e){
				Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
			}
		}
	}
} 
