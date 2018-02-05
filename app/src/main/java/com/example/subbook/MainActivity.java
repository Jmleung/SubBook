
package com.example.subbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
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
import java.util.Date;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

   /* public void AddSub(View view) {
        Intent Addition = new Intent(this, AddSubcriptionActivity.class);
        startActivity(Addition);
    }*/

    private static final String FILENAME = "Subs.sav";
    private EditText NameText;
    private EditText DateText;
    private EditText CostText;
    private EditText CommentText;
    private ListView SubList;

    private ArrayList<Sub> SubArray;
    private ArrayAdapter<Sub> adapter;

    Button AddSubB = (Button) findViewById(AddSubB);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AddSubB.setOnClickListener(new View.OnClickListener() {
            @Override
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


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
