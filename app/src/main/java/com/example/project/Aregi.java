package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Aregi extends AppCompatActivity {
    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aregi);
        b1=(Button)findViewById(R.id.addb);
        b2=(Button)findViewById(R.id.seab);
        b3=(Button)findViewById(R.id.delb);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ob2=new Intent(getApplicationContext(),Delb.class);
                startActivity(ob2);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ob1=new Intent(getApplicationContext(),Seab.class);
                startActivity(ob1);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ob=new Intent(getApplicationContext(),Addb.class);
                startActivity(ob);
            }
        });
    }
}
