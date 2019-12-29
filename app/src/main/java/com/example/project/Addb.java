package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Addb extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6,e7;
    Button b1;
    String s1,s2,s3,s4,s5,s6,s7,c,t,d,a,p,t1,p1;
    Model model;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addb);
        e1=(EditText)findViewById(R.id.cod);
        e2=(EditText)findViewById(R.id.tit);
        e3=(EditText)findViewById(R.id.des);
        e4=(EditText)findViewById(R.id.aut);
        e5=(EditText)findViewById(R.id.pub);
        e6=(EditText)findViewById(R.id.typ);
        e7=(EditText)findViewById(R.id.pri);
        b1=(Button)findViewById(R.id.sub);
        model=new Model();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Library");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = e1.getText().toString().trim();
                s2 = e2.getText().toString().trim();
                s3 = e3.getText().toString().trim();
                s4 = e4.getText().toString().trim();
                s5 = e5.getText().toString().trim();
                s6 = e6.getText().toString().trim();
                s7 = e7.getText().toString().trim();

                if (s1.isEmpty()) {
                    e1.setError("Code is required");
                    e1.requestFocus();
                } else if (s2.isEmpty()) {
                    e2.setError(" Title is required");
                    e2.requestFocus();
                } else if (s3.isEmpty()) {
                    e3.setError("Description is required");
                    e3.requestFocus();
                } else if (s4.isEmpty()) {
                    e4.setError("Author is required");
                    e4.requestFocus();
                } else if (s5.isEmpty()) {
                    e5.setError("Publisher is required");
                    e5.requestFocus();
                } else if (s6.isEmpty()) {
                    e6.setError("Type is required");
                    e6.requestFocus();
                } else if (s7.isEmpty()) {
                    e7.setError("Price is required");
                    e7.requestFocus();
                }

                model.setCode(s1);
                model.setTitl(s2);
                model.setDesc(s3);
                model.setAuth(s4);
                model.setPubl(s5);
                model.setType(s6);
                model.setPric(s7);

                c = model.getCode();
                t = model.getTitl();
                d = model.getDesc();
                a = model.getAuth();
                p = model.getPubl();
                t1 = model.getType();
                p1 = model.getPric();

                databaseReference.push().setValue(model).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Successfully Added", Toast.LENGTH_LONG).show();

                        } else {
                            Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();

                        }

                    }
                });
                e7.setText("");
                e6.setText("");
                e5.setText("");
                e4.setText("");
                e3.setText("");
                e2.setText("");
                e1.setText("");


            }
        });
    }
}
