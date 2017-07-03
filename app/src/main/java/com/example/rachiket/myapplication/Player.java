package com.example.rachiket.myapplication;
import com.example.rachiket.myapplication.PlayerInterface;


import java.util.*;

/**
 * Created by Harsh Goel on 6/26/2017.
 */
//declration of the player class
public class Player implements PlayerInterface{
    //class contains name,password ans string
    private String name;
    public static boolean addedplayer=false;
    public static int playerselect;
    private String password;
    private int rating;
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
            newplayer.setRating(obj.nextInt(5)+1);
            playerlist.add(newplayer);

        }
        return playerlist;
    }
    public int getRating(){
        return rating;
    }
    public void setRating(int k){
        rating = k;
    }
}
