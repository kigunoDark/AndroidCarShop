package com.example.kiguno.baseofdate;

public class Person {

    public int _id ;
    public String name ;
    public int age ;

    public Person(int id, String n, int a)
    {
        _id = id;
        name = n;
        age = a;
    }


    // getters
    public int get_id(){return _id;}
    public String get_name(){return name;}
    public int get_age(){return age;}



    //setters
    public void set_id( int _id){this._id = _id;}
    public void set_name(String name) {this.name = name;}
    public void set_age(int age){this.age = age;}

}

