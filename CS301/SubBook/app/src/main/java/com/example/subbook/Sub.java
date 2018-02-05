package com.example.subbook;

/**
 * Created by jmleung on 2018-02-04.
 */

public class Sub {
    public String Name;
    private String date;
    private String Cost;
    private String Comment;

    Sub(String Name, String date, String Cost, String Comment){
        this.Name = Name;
        this.date = date;
        this.Cost = Cost;
        this.Comment = Comment;
    }

    public void setSub(String Name, String date, String Cost, String Comment){
        this.Name = Name;
        this.date = date;
        this.Cost = Cost;
        this.Comment = Comment;
    }


    public String toString() {return "|Name: " + Name + " | Date: " + date + " | Cost: " + Cost + " | Comment: " + Comment;}
}
