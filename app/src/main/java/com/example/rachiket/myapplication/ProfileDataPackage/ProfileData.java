package com.example.rachiket.myapplication.ProfileDataPackage;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.rachiket.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Harsh Goel on 7/6/2017.
 */

public class ProfileData extends AppCompatActivity {
    public ImageView profilephoto;
    public Button addphoto;
    public Button editprofile;
    public Button setsports;
    public Button questionnaire;
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

        setsports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               List<Integer> sports= sportsCreate();

            }
        });
    }
    public void initialiseUI(){
        profilephoto=(ImageView)findViewById(R.id.ProfilePhoto);
        addphoto=(Button)findViewById(R.id.addphoto);
        editprofile=(Button)findViewById(R.id.edit_profile);
        setsports=(Button)findViewById(R.id.selectsports);
    }
    public List<Integer> sportsCreate(){
        final List<Integer> itemssel=new ArrayList<>();
        AlertDialog.Builder dialogbox = new AlertDialog.Builder(ProfileData.this);
        CharSequence[] sports={"Tennis","Badminton","Table Tennis","Squash"};
        dialogbox.setTitle(" Select Sports ")
                .setMultiChoiceItems(sports, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if(isChecked){
                            itemssel.add(which);
                        }
                        else if(itemssel.contains(which)){
                            itemssel.remove(which);
                        }
                    }
                });
        AlertDialog alert = dialogbox.create();
        alert.show();
        return itemssel;
    }

}
