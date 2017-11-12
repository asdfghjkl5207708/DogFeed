package com.example.myapplication1;


public class Data {
    private String name;
    private String time;
    private String place;
    private String nameHolder, timeHolder;

    public Data(){}

    public Data(String name, String time, String place){
        this.name = name;
        this.time = time;
        this.place = place;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setTime(String time){
        this.time = time;
    }
    public void setPlace(String place){ this.place = place; }

    public String getName(){return name;}
    public String getTime(){return time;}
    public String getPlace(){return place;}

}
