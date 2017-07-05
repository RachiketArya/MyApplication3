package com.example.rachiket.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.rachiket.myapplication.Logic.Player;
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
    public Button confirmbut;
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
        confirmbut=(Button)findViewById(R.id.confirmbut);
    }
    //addprofile invoked when button confirm is clicked
    public void addprofile(View view) {
        //adds the profile if the password and confirm password strings match
        String password = pass.getText().toString();
        String confirmpassword = pass.getText().toString();
        boolean checkpass=analyse_password(password,confirmpassword);
        if(checkpass==true){
            Player newplayer = new Player();
            newplayer.setname(name.getText().toString());
            newplayer.setpassword(pass.getText().toString());
            Player.addedplayer=true;
            finish();
            Intent intent=new Intent()
                    .setClass(this,MainActivity.class);
            startActivity(intent);
            finish();
        }

    }
    public boolean analyse_password(String pass1,String pass2){

        if (pass1.equals(pass2)) {
            if (pass.length() < 8) {
                alert.setTextColor(getResources().getColor(R.color.red));
                alert.setTextSize(9);
                alert.setText("Passwords too small");
                return false;
            } else {
                return true;
            }
        }
        else{
            alert.setTextColor(getResources().getColor(R.color.red));
            alert.setTextSize(9);
            alert.setText("Passwords dont match");
            return false;
        }

    }

}
