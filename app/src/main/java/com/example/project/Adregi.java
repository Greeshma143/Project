package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

public class Adregi extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6,e7;
    Button b1,b2;
String cod,tit,des,aut,pub,typ,pri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adregi);
        e1=(EditText)findViewById(R.id.cod);
        e2=(EditText)findViewById(R.id.tit);
        e3=(EditText)findViewById(R.id.des);
        e4=(EditText)findViewById(R.id.aut);
        e5=(EditText)findViewById(R.id.pub);
        e6=(EditText)findViewById(R.id.typ);
        e7=(EditText)findViewById(R.id.pri);
        b1=(Button) findViewById(R.id.log);
        b2=(Button) findViewById(R.id.reg);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cod=e1.getText().toString().trim();
                tit=e2.getText().toString().trim();
                des=e3.getText().toString().trim();
                aut=e4.getText().toString().trim();
                pub=e5.getText().toString().trim();
                typ=e6.getText().toString().trim();
                pri=e7.getText().toString().trim();

                Toast.makeText(getApplicationContext(),cod+" "+tit+" "+des+" "+aut+" "+pub+" "+typ+" "+pri,Toast.LENGTH_LONG).show();
            }
        });
    }
}
