package com.example.rachiket.myapplication.Logic;


import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.*;

/**
 * Created by Harsh Goel on 6/26/2017.
 */
//declration of the player class
public class Player implements PlayerInterface{
    //class contains name,password ans string
    private Uri profilephoto;
    private String email;
    private String name;
    public static boolean addedplayer=false;
    public static int playerselect;
    private String password;
    private Rating rating_tennis;
    private Rating rating_squash;
    private Rating rating_tt;
    private Rating rating_badminton;
    public boolean tennisSelect;
    public boolean squashSelect;
    public boolean ttSelect;
    public boolean badmintonSelect;
    // functions overriden from the interface
    public void setEmail(String s){
        email=s;
    }
    public String getEmail(){
        return email;
    }
    public void setpassword(String s){
        password=s;
    }
    public String getpassword(){
        return password;
    }
    //static function tht initialises the random player data useing list interface and arraylist framework
    public static List<Player> allplayers(){
            Random obj=new Random();
        FirebaseAuth auth= FirebaseAuth.getInstance();
            List<Player> playerlist=new ArrayList<>();
            for(int i=0;i<10;i++){
                Player newplayer=new Player();
                newplayer.setEmail("Player"+i+"@gmail.com");
                newplayer.setpassword("password"+i);
                playerlist.add(newplayer);
                auth.createUserWithEmailAndPassword(newplayer.getEmail(),newplayer.getpassword());
                Log.d("Message:","Additions Successful");
        }
        return playerlist;
    }
    public String getName(){
        return name;
    }
    public void setName(String k){
        name=k;
    }
    public Uri getProfilephoto(){
        return profilephoto;
    }
    public void setProfilephoto(Uri photo){
        profilephoto=photo;
    }
    /*
    public Rating getRating(){
        return rating;
    }
    public void setRating(Rating k){
        rating = k;
    }
*/
}
