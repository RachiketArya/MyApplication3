package com.example.rachiket.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rachiket.myapplication.Logic.Player;

import java.util.*;

public class MainActivity extends Activity {
    public static List<Player> All;
    public EditText password;
    public EditText name;
    public Button Login;
    public Button sign_up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initialiseUI();

    }
    //check the profilelogin for the entered data
    public void checkprofile(View view){
        boolean flag=false;
        //local data compared
        for(int i=0;i<All.size();i++) {
            if (All.get(i).getname().equals(name.getText().toString()) &&
                    All.get(i).getpassword().equals(password.getText().toString()))
                {
                       Player.playerselect=i;
                    flag=true;
                    break;
                }
        }
        if(flag==false){
            Toast toast = Toast.makeText(getApplicationContext(),"Incorrect Username/Password",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,10);
            toast.show();
        }
        else{
            Intent intent = new Intent(this, menuAfterLogin.class);
            startActivity(intent);
            finish();
        }
    }


    public void signup(View view){
        Intent i = new Intent(this, Signup.class);
        startActivity(i);
        finish();
    }
    //initialising the UI elements
    public void initialiseUI(){
        password=(EditText)findViewById(R.id.password);
        name=(EditText)findViewById(R.id.name);
        Login=(Button)findViewById(R.id.login);
        sign_up=(Button)findViewById(R.id.signup);
        if(Player.addedplayer==false){
            All=Player.allplayers();
        }
    }
/*To confirm if tool bar is removed
*/

}