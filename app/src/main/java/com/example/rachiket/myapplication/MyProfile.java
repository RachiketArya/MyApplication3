package com.example.rachiket.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.RatingBar;

/**
 * Created by Rachiket on 19-06-2017.
 */

public class MyProfile extends AppCompatActivity {

    public EditText name;
    public RatingBar rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

    }
    public void initialiseUI(){
        name=(EditText)findViewById(R.id.name);
        rating=(RatingBar)findViewById(R.id.ratingBar3);

    }

}
