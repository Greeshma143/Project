package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Adlog extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adlog);
        e1=(EditText)findViewById(R.id.use);
        e2=(EditText)findViewById(R.id.pas);
        b1=(Button) findViewById(R.id.log);
        b2=(Button) findViewById(R.id.reg);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ob=new Intent(getApplicationContext(),Adregi.class);
                startActivity(ob);
            }
        });
    }
}
