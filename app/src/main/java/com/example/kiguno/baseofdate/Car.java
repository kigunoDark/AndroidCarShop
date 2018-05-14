package com.example.kiguno.baseofdate;

public class Car {
    public  int id;
    public int year;
    public  int mileage;
    public String i_color;
    public String helm;

    // constructor
    public Car(int i, int y, int m, String c, String h){
        id = i;
        year = y;
        mileage = m;
        i_color= c;
        helm = h;
    }


    //getters
    public int get_Year(){return year;}
    public int get_Mileage(){return mileage;}
    public String get_Color(){return i_color;}
    public String get_Helm(){return helm;}


    //setters
    public void set_Year (int y){this.year = y;}
    public void set_Mileage(int m){this.mileage = m;}
    public void set_Color(String c){this.i_color = c;}
    public  void set_Helm(String h){this.helm = h;}
}
