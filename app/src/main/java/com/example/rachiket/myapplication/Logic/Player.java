package com.example.rachiket.myapplication.Logic;


import android.graphics.Bitmap;

import java.util.*;

/**
 * Created by Harsh Goel on 6/26/2017.
 */
//declration of the player class
public class Player implements PlayerInterface{
    //class contains name,password ans string
    private Bitmap profilephoto;
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
    public void setname(String s){
        name=s;
    }
    public String getname(){
        return name;
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
            List<Player> playerlist=new ArrayList<>();
            for(int i=0;i<10;i++){
                Player newplayer=new Player();
                newplayer.setname("Player"+i);
                newplayer.setpassword("password"+i);
                playerlist.add(newplayer);

        }
        return playerlist;
    }
    public Bitmap getProfilephoto(){
        return profilephoto;
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
