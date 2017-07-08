package com.example.rachiket.myapplication.ProfileDataPackage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.rachiket.myapplication.R;

/**
 * Created by Harsh Goel on 7/6/2017.
 */

public class ProfileData extends AppCompatActivity {
    public ImageView profilephoto;
    public Button addphoto;
    public Button editprofile;
    public Button setsports;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        initialiseUI();
        /*TODO
        addphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent().setClass(v.getContext(),photohandle.class);
                startActivityForResult(intent,);
            }
        });*/
        /*TODO
        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        */
        /*TODO
        setsports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }
        */

    }
    public void initialiseUI(){
        profilephoto=(ImageView)findViewById(R.id.ProfilePhoto);
        addphoto=(Button)findViewById(R.id.addphoto);
        editprofile=(Button)findViewById(R.id.edit_profile);
        setsports=(Button)findViewById(R.id.selectsports);



    }

}
