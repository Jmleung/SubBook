/*
 * Copyright © 2018 Team K. CMPUT301, University of Alberta - All Rights Reserved.
 * You may use distribute or modify this code under terms and conditions of the code of
 * Student Behaviour
 * at University of Alberta.
 * You can find a copy of the license in this project. Otherwise please contact contact@abc.ca.
 */

package com.example.subbook;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import android.app.Activity;

/**
 * This class is the main body of the app, and takes care of all the buttons
 * input and is the screen that the user sees.
 * @author jmleung
 * @version 1.0
 */
public class MainActivity extends Activity {

    //The file that stores the input data
    private static final String FILENAME = "Subs.sav";
    //All of the text input objects
    private EditText NameText;
    private EditText DateText;
    private EditText CostText;
    private EditText CommentText;
    private ListView SubList;

    //The arraylist and arrayadapter
    private ArrayList<Sub> SubArray;
    private ArrayAdapter<Sub> adapter;

    /**
     * This function initialized all the buttons, and their respective functions
     * needed to receive click input.
     * @Button AddSubB Button to add a new subscription
     * @Button DelSubB Button to delete the most bottom subscription
     * @Button EdSubB Button to edit an already existing subscription
     * @EditText NameText, DateText, CostText, CommentText, the object that take in the string input
     * of each parameter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("LifeCycle ---->", "onCreate is called");
        setContentView(R.layout.activity_main);

        Button AddSubB = (Button) findViewById(R.id.addSubB);
		Button DelSubB = (Button) findViewById(R.id.delSubB);
		Button EdSubB = (Button) findViewById(R.id.edSubB);

        NameText = (EditText) findViewById(R.id.name);
        DateText = (EditText) findViewById(R.id.date);
        CostText = (EditText) findViewById(R.id.cost);

        CommentText = (EditText) findViewById(R.id.comment);
        ListView SubList = (ListView) findViewById(R.id.subList);

        /**
         * The function that makes the addition button react by adding the text written in the
         * text boxes as a new subscription.
         */
        AddSubB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);
                String Name = NameText.getText().toString();
                String date = DateText.getText().toString();
                String Cost = CostText.getText().toString();
                String Comment = CommentText.getText().toString();

                Sub sub = new Sub(Name, date, Cost, Comment);
                SubArray.add(sub);
                adapter.notifyDataSetChanged();
                saveInFile();
            }
        });

        /**
         * The function that deletes the bottom most subscription upon press
         */
        DelSubB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);
                SubArray.remove(SubArray.size()- 1);
                adapter.notifyDataSetChanged();
                saveInFile();
            }
        });
        /**
         * The function that replaces an existing subscription with the new parameters as specified
         * by the data in the text boxes. This is achieved by first looking for the index of the
         * already existing subscription within the arraylist and then using the built-in set() function
         * to do the replacement via index.
         */
        EdSubB.setOnClickListener(new View.OnClickListener() {
//Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
            public void onClick(View v) {
                setResult(RESULT_OK);
                String Name = NameText.getText().toString();
                String date = DateText.getText().toString();
                String Cost = CostText.getText().toString();
                String Comment = CommentText.getText().toString();

                Sub sub = new Sub(Name, date, Cost, Comment);
				if (SubArray.indexOf(sub.Name) != -1){
					SubArray.set(SubArray.indexOf(sub.Name), sub);
				}
                adapter.notifyDataSetChanged();
                saveInFile();
            }
        });
    }

    /**
     * This function initializes variables on strat, including loading up the storage file used to
     * keep track of the subscriptions. This is also where the problematic ArrayAdapter causes
     * errors on execution of the program, this problem was traced through the debugger.
     */
    @Override
    protected void onStart() {

        // TODO Auto-generated method stub
        super.onStart();
        Log.i("LifeCycle --->", "onStart is called");

        loadFromFile();

        adapter = new ArrayAdapter<Sub>(this,android.R.layout.activity_list_item,SubArray);
        SubList.setAdapter(adapter);

    }

    /** From lonelyTwitter lab activity.
     * 2018-01-23
     * Loads items from the Gson file.
     */
    private void loadFromFile() {

        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            Type listType = new TypeToken<ArrayList<Sub>>(){}.getType();
            SubArray = gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            SubArray = new ArrayList<Sub>();
        } catch (IOException e) {
            throw new RuntimeException();
        }

    }

    /** From lonelyTwitter lab activity.
     * 2018-01-23
     * Loads items into the Gson file.
     */
    private void saveInFile() {
        try {

            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(SubArray, out);
            out.flush();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Lifecycle", "onDestroy is called");
    }
}
