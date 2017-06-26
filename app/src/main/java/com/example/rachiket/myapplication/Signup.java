package com.example.rachiket.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.*;
import com.example.rachiket.myapplication.Player;
/**
 * Created by Harsh Goel on 6/26/2017.
 */
//declaration of the signup class
public class Signup extends AppCompatActivity {
    //UI components
    public EditText name;
    public EditText pass;
    public EditText confirmpass;
    public EditText rating;
    public TextView alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        initialiseUI();
    }
    //initialises the UI of the signup activity
    public void initialiseUI(){
        name=(EditText)findViewById(R.id.name);
        pass=(EditText)findViewById(R.id.pass);
        rating=(EditText)findViewById(R.id.rating);
        confirmpass=(EditText)findViewById(R.id.confirmpass);
        alert=(TextView)findViewById(R.id.alert);
    }
    //addprofile invoked when button confirm is clicked
    public void addprofile(View view){
        //adds the profile if the password and confirm password strings match
        if(pass.getText().toString().equals(confirmpass.getText().toString())) {
            Player newplayer = new Player();
            newplayer.setname(name.getText().toString());
            newplayer.setpassword(pass.getText().toString());
            newplayer.setRating(Integer.getInteger(rating.getText().toString()));
            MainActivity.All.add(newplayer);
            finish();
        }
        else{
            alert.setText("Passwords dont match");
        }

    }

}
