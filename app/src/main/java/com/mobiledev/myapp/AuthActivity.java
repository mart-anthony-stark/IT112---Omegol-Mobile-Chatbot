package com.mobiledev.myapp;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import java.util.*;

public class AuthActivity extends Activity {
    private Dialog signupDialog, progressDialog;
	private TextView signupBtn;
	private EditText loginEmail, loginPassword, signupEmail, signupUsername, signupPassword;
	private Button loginBtn, createAccountBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth);
	    getActionBar().hide();
		
		// Select input text components
		//login
		loginEmail = (EditText) findViewById(R.id.loginEmail);
		loginPassword = (EditText) findViewById(R.id.loginPassword);
		
		//Select buttons
		loginBtn = (Button) findViewById(R.id.loginBtn);
		loginBtn.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1){
					login(p1);
				}
		});
		
		signupDialog = new Dialog(AuthActivity.this);
		signupDialog.setTitle("Create an Account");
		signupDialog.setContentView(R.layout.signup_modal);
		
		signupDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		signupDialog.setCancelable(true);
		
		signupBtn = (TextView) findViewById(R.id.signupBtn);
		signupBtn.setOnClickListener(new OnClickListener(){
				public void onClick(View p1){
					// Show dialog modal for signup form
					signupDialog.show();
				}
		});
		
		//signup edit text
		signupUsername = (EditText) signupDialog.findViewById(R.id.signupUsername);
		signupEmail = (EditText) signupDialog.findViewById(R.id.signupEmail);
		signupPassword = (EditText) signupDialog.findViewById(R.id.signupPassword);
		
		// Progress dialog
		progressDialog = new Dialog(AuthActivity.this);
		progressDialog.setTitle("Logging in");
		progressDialog.setContentView(R.layout.progress_dialog);

		progressDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		progressDialog.setCancelable(false);
		
		

		//Creating an account
		createAccountBtn = (Button) signupDialog.findViewById(R.id.createAccountBtn);
		createAccountBtn.setOnClickListener(new OnClickListener(){
				public void onClick(View p1){
					try{
					String email=signupEmail.getText().toString();
					String username = signupUsername.getText().toString();
					String password = signupPassword.getText().toString();
					if(email.equals("") || username.equals("") || password.equals("")){
						Toast.makeText(AuthActivity.this, "All fields are required", Toast.LENGTH_LONG).show();
					}else{
						GlobalState.addUser(username, email, password);
						signupDialog.dismiss();
					}
					}catch(Exception e){
						Toast.makeText(AuthActivity.this,e.getMessage(), Toast.LENGTH_LONG).show();
					}
				}
		});
    }
	void login(View p1){
		User c = GlobalState.users.get(0);
		String email = loginEmail.getText().toString();
		String password = loginPassword.getText().toString();
		User foundUser = GlobalState.findUser("email",email);
		if(foundUser != null){
			if(foundUser.passwordMatch(password)){
				progressDialog.show();
				GlobalState.currentUser = foundUser;
				Timer t = new Timer();
				t.schedule(new TimerTask(){
						public void run(){
							// Adds delay before navigating into main activity
							Intent i = new Intent(AuthActivity.this, MainActivity.class);
							finish();
							startActivity(i);
						}
					}, 2000);
			}else{
				AlertDialog.Builder d = new AlertDialog.Builder(this);
				d.setTitle("Authentication Failed");
				d.setMessage("The password you entered is invalid");
				d.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){
					public void onClick(DialogInterface dialog, int which){
						dialog.dismiss();
					}
				});
				d.create().show();
			}
		}
		else{
			AlertDialog.Builder d = new AlertDialog.Builder(this);
			d.setTitle("Account not found");
			d.setMessage("The email you entered is not registered to an account");
			d.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){
					public void onClick(DialogInterface dialog, int which){
						dialog.dismiss();
					}
				});
			d.create().show();
		}
	}
}
