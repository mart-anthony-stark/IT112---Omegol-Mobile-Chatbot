package com.mobiledev.myapp;
 
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.LinearLayout.*;
import android.content.res.*;

public class MainActivity extends Activity { 
	private TextView welcomeTxt;
	private LinearLayout msgField;
	private Button sendBtn;
	private EditText chatInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		getActionBar().hide();
		
		msgField = findViewById(R.id.msgField);
		sendBtn = findViewById(R.id.sendBtn);
		chatInput = findViewById(R.id.chatInput);
		
		welcomeTxt = findViewById(R.id.welcomeBot);
		welcomeTxt.setText("Hello "+GlobalState.currentUser.username+" :>");
    	
        sendBtn.setOnClickListener(new OnClickListener(){
				public void onClick(View p1){
					// Send message
					String msg = chatInput.getText().toString();
					sendMessage(msg);
					chatInput.setText("");
				}
			});
	}
	void sendMessage(String msg){
		TextView tx= new TextView(this);
		LayoutParams params = new LayoutParams(
			LayoutParams.WRAP_CONTENT,      
			LayoutParams.WRAP_CONTENT
		);
		params.setMargins(0, 0, 0, 10);
		params.gravity = Gravity.RIGHT;
		tx.setLayoutParams(params);
        tx.setText(msg);
		tx.setTextSize(20);
		tx.setPadding(10,10,10,10);
		tx.setBackgroundResource(R.drawable.chat_bg);

		msgField.addView(tx);
	}
} 
