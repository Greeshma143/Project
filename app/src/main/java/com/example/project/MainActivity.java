package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.ad);
        b2=(Button)findViewById(R.id.stu);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ob1=new Intent(getApplicationContext(),Stulog.class);
                startActivity(ob1);

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ob=new Intent(getApplicationContext(),Adlog.class);
                startActivity(ob);
            }
        });
    }
}
