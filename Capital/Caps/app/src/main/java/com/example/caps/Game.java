package com.example.caps;

import java.util.List;
import java.util.Map;

import ca.roumani.i2c.Country;
import ca.roumani.i2c.CountryDB;

public class Game {
    private CountryDB db;
    public Game()
    {
        this.db = new CountryDB();
    }
    public String qa()
    {
        List<String> capitals = this.db.getCapitals();
        int n = capitals.size();
        int index = (int)(n*Math.random());
        String c = capitals.get(index);
        Map<String, Country> data =db.getData();
        Country ref = data.get(c);
        if(Math.random()<0.5)
        {
            return "What is the capital of "+ref.getName()+"\n"+ref.getCapital();
        }
        else{
            return ref.getCapital()+" is the capital of?"+"\n"+ref.getName();
        }
    }



    public static void main(String[] args) {
        CountryDB db = new CountryDB();
        List<String> capitals = db.getCapitals();
        System.out.println(capitals.size());
        String c = capitals.get(107);
        System.out.println(c);

        Map<String, Country> data = db.getData();
        System.out.println(data.size());
        Country ref = data.get(c);
        System.out.println(ref.toString());

        Game game = new Game();
        String [] s = game.qa().split("\n");
        System.out.println(s[0]);
        System.out.println(s[1]);
    }
}
// Student Name: Hongce Chen
// This lab was was done with partner Shuyi Shi
//video link: https://www.youtube.com/watch?v=cKg7KyBT2R0