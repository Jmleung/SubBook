package com.example.subbook;

import java.util.Date;

/**
 * Created by Tarakol on 2018-02-05.
 */

public class Sub {
    private String Name;
    private Date date;
    private String Cost;
    private String Comment;

    Tweet(String Name, Date date, String Cost, String Comment){
        this.Name = Name;
        this.date = date;
        this.Cost = Cost;
        this.Comment = Comment;
    }

    public void setSub(String Name, Date date, String Cost, String Comment){
        this.Name = Name;
        this.date = date;
        this.Cost = Cost;
        this.Comment = Comment;
    }

    public String toString() {return Name + " | " + date.toString() + " | " + Cost + " | " + Comment};
}
