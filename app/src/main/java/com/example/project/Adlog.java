package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Adlog extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;
    String username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adlog);
        e1=(EditText)findViewById(R.id.use);
        e2=(EditText)findViewById(R.id.pas);
        b1=(Button) findViewById(R.id.log);
        b2=(Button) findViewById(R.id.reg);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              username=e1.getText().toString().trim();
              password=e2.getText().toString().trim();
              if(username.equals("mgcollege")&&password.equals("12345"))
              {
               Intent ob=new Intent(getApplicationContext(),Bott.class);
               startActivity(ob);
              }
              else
              {
                  Toast.makeText(getApplicationContext(),"INCORRECT PASSWORD OR USERNAME",Toast.LENGTH_SHORT).show();

              }
            }
        });

    }
}
