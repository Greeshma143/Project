package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Stulog extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stulog);
        e1=(EditText)findViewById(R.id.use2);
        e2=(EditText)findViewById(R.id.pas2);
        b1=(Button) findViewById(R.id.log2);
        b2=(Button) findViewById(R.id.reg2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ob=new Intent(getApplicationContext(),Sturegi.class);
                startActivity(ob);
            }
        });
    }
}
