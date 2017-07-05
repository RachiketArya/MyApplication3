package com.example.rachiket.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.rachiket.myapplication.Logic.Player;

/**
 * Created by Rachiket on 19-06-2017.
 */

public class MyProfile extends AppCompatActivity {

    public TextView name;
    public RatingBar rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        initialiseUI();
        //setting profile
        name.setText(MainActivity.All.get(Player.playerselect).getname());
        rating.setRating((float)MainActivity.All.get(Player.playerselect).getRating().getRatingNetSkill());

    }
    //initialising the elements of the user interface
    public void initialiseUI(){
        name=(TextView)findViewById(R.id.name);
        rating=(RatingBar)findViewById(R.id.ratingBar3);

    }

}
