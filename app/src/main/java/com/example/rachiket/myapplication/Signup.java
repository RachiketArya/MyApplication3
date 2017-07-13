package com.example.rachiket.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rachiket.myapplication.Logic.Player;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Harsh Goel on 6/26/2017.
 */
//declaration of the signup class
public class Signup extends AppCompatActivity {
    //UI components
    public EditText email;
    public EditText pass;
    public EditText confirmpass;
    public Button confirmbut;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
       // getSupportActionBar().setHomeButtonEnabled(true);
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initialiseUI();

    }
    //initialises the UI of the signup activity
    public void initialiseUI(){
        email=(EditText)findViewById(R.id.email);
        pass=(EditText)findViewById(R.id.pass);
        confirmpass=(EditText)findViewById(R.id.confirmpass);
        confirmbut=(Button)findViewById(R.id.confirmbut);
        auth=FirebaseAuth.getInstance();
    }
    //addprofile invoked when button confirm is clicked
    public void addprofile(View view) {
        //adds the profilelogin if the password and confirm password strings match
        String password = pass.getText().toString();
        String confirmpassword = pass.getText().toString();
        boolean checkpass=analyse_password(password,confirmpassword);
        //Dialog box is shown
        if(checkpass==true){
            AlertDialog.Builder dialogbox=new AlertDialog.Builder(Signup.this);
            dialogbox.setMessage("Do You Want To Proceed ?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog,int which) {
                            Player newplayer = new Player();
                            newplayer.setEmail(email.getText().toString());
                            newplayer.setpassword(pass.getText().toString());
                            Player.addedplayer=true;
                            firebaseadd(newplayer.getEmail(),newplayer.getpassword());
                            Intent intent=new Intent()
                                    .setClass(Signup.this,MainActivity.class);
                            startActivity(intent);
                            Signup.this.finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert=dialogbox.create();
            alert.show();
        }

    }
    public void firebaseadd(String s1,String s2){
        auth.createUserWithEmailAndPassword(s1,s2)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){
                            //display some message here
                            Toast.makeText(getApplicationContext(),"Successfully registered",Toast.LENGTH_LONG).show();
                        }else{
                            //display some message here
                            Toast.makeText(getApplicationContext(),"Registration Error",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
    public boolean analyse_password(String pass1,String pass2){

        if (pass1.equals(pass2)) {
            if (pass.length() < 8) {
                Toast toast = Toast.makeText(getApplicationContext(),"Password too short(above 8 chars)",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,10);
                toast.show();
                return false;
            } else if (pass1.isEmpty() || pass2.isEmpty()) {
                Toast toast = Toast.makeText(getApplicationContext(),"Password not entered",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,10);
                toast.show();
                return false;
            } else {
                return true;
            }
        }
        else{
            AlertDialog.Builder dialogbox = new AlertDialog.Builder(Signup.this);
            dialogbox.setMessage("Passwords Dont Match ")
                    .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = dialogbox.create();
            alert.show();
            return false;
        }
    }
    public void signin(View view){
        Intent intent=new Intent()
                .setClass(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    /*public boolean onCreatOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
    }
    *
    /*Toadd: 1.toasts for empty fields
    2.to confirm tool bar is invisible
     */
}
