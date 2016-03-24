package com.firstapp.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.text.ParseException;

public class MainActivity extends AppCompatActivity {

    protected EditText musername;
    protected EditText muserEmail;
    protected EditText muserPassword;
    protected Button mregisterButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parse.initialize(this, "Hs8PL7Xcw7ygKrjGIyWBZSTZb2XPSKDEzSgRsQRn", "0wumthH4MsoVB6alJQJfy9C5uIXv4WfvazxxtVaO");


        //ParseObject.registerSubclass(RegisterActivity.class);
        musername = (EditText)findViewById(R.id.usernameRegisterEditText);
        muserEmail = (EditText)findViewById(R.id.emailRegisterEditText);
        muserPassword = (EditText)findViewById(R.id.passwordRegisterEditText);
        mregisterButton = (Button)findViewById(R.id.button);

        //listener
        mregisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get username,email and password
                String username = musername.getText().toString().trim();
                String password = muserPassword.getText().toString().trim();
                String email = muserEmail.getText().toString().trim();

                ParseUser user = new ParseUser();
                user.setUsername(username);
                user.setPassword(password);
                user.setEmail(email);
                Log.i("Username:", username);
                Log.i("Password:",password);
                Log.i("Email",email);
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {
                        if(e == null){
                            //user signed up successfully
                            Toast.makeText(MainActivity.this, "Success Welcome", Toast.LENGTH_LONG).show();
                        }
                        else{
                            //there was an error signing up user

                            Toast.makeText(MainActivity.this,"Fishy",Toast.LENGTH_LONG).show();
                        }
                    }


                });
            }
        });


    }
}
