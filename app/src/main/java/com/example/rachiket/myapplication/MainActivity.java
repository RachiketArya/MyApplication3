package com.example.rachiket.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.*;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sportsBut = (Button) findViewById(R.id.button);
        sportsBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Sports.class);
                startActivity(i);
            }
        });

        Button profileBut = (Button) findViewById(R.id.button2);
        sportsBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MyProfile.class);
                startActivity(i);
            }
        });

        Button chatBut = (Button) findViewById(R.id.button3);
        sportsBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Chats.class);
                startActivity(i);
            }
        });

        Button calendarBut = (Button) findViewById(R.id.button4);
        sportsBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Calendar.class);
                startActivity(i);
            }
        });
    }


}