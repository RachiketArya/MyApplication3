package com.example.rachiket.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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
/**
 * Created by Harsh Goel on 6/26/2017.
 */
//declaration of the signup class
public class Signup extends AppCompatActivity {
    //UI components
    public EditText name;
    public EditText pass;
    public EditText confirmpass;
    public Button confirmbut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.sign_up);
       // getSupportActionBar().setHomeButtonEnabled(true);
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initialiseUI();

    }
    //initialises the UI of the signup activity
    public void initialiseUI(){
        name=(EditText)findViewById(R.id.name);
        pass=(EditText)findViewById(R.id.pass);
        confirmpass=(EditText)findViewById(R.id.confirmpass);
        confirmbut=(Button)findViewById(R.id.confirmbut);
    }
    //addprofile invoked when button confirm is clicked
    public void addprofile(View view) {
        //adds the profilelogin if the password and confirm password strings match
        String password = pass.getText().toString();
        String confirmpassword = pass.getText().toString();
        boolean checkpass=analyse_password(password,confirmpassword);
        if(checkpass==true){
            AlertDialog.Builder dialogbox=new AlertDialog.Builder(Signup.this);
            dialogbox.setMessage("Do You Want To Proceed ?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Player newplayer = new Player();
                            newplayer.setname(name.getText().toString());
                            newplayer.setpassword(pass.getText().toString());
                            Player.addedplayer=true;
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
    */
}
