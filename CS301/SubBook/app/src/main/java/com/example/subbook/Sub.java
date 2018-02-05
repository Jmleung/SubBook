/*
 * Copyright © 2018 Team K. CMPUT301, University of Alberta - All Rights Reserved.
 * You may use distribute or modify this code under terms and conditions of the code of
 * Student Behaviour
 * at University of Alberta.
 * You can find a copy of the license in this project. Otherwise please contact contact@abc.ca.
 */

package com.example.subbook;

/**
 * Created by jmleung on 2018-02-04.
 * The class subscription that consists of a string name, date, cost and comment. All of them
 * are setupt as strings, as such this app cannot sum up the costs of the monthly subscriptions.
 * @author jmleung
 * @version 1.0
 */
public class Sub {
    public String Name;
    private String date;
    private String Cost;
    private String Comment;

    /**
     * Intializes the parameters for the subscription class
     * @param Name String
     * @param date String
     * @param Cost String
     * @param Comment String
     */
    Sub(String Name, String date, String Cost, String Comment){
        this.Name = Name;
        this.date = date;
        this.Cost = Cost;
        this.Comment = Comment;
    }

    /**
     * Assigns the specific values for each parameter for the subscription class.
     * @param Name String
     * @param date String
     * @param Cost String
     * @param Comment String
     */
    public void setSub(String Name, String date, String Cost, String Comment){
        this.Name = Name;
        this.date = date;
        this.Cost = Cost;
        this.Comment = Comment;
    }

    /**
     * This function is for formatted output of the class subscription
     * @return toString() String, a formatted string for output purposes.
     */
    public String toString() {return "|Name: " + Name + " | Date: " + date + " | Cost: " + Cost + " | Comment: " + Comment;}
}
