package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Sturegi extends AppCompatActivity {
    EditText e1,e2,e3,e5,e6,e7,e8,e9;
    Button button,b1;
    Spinner s;
    String nam,adno,pla,dis,par,mob,pas,ema,cpas,n,a,p,d,p1,m,p2,e,c;
    StuModel stuModel;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sturegi);
        e1=(EditText)findViewById(R.id.nam);
        e2=(EditText)findViewById(R.id.adno);
        e3=(EditText)findViewById(R.id.plc);
        s=(Spinner)findViewById(R.id.spi);
        e5=(EditText)findViewById(R.id.par);
        e6=(EditText)findViewById(R.id.mob);
        e7=(EditText)findViewById(R.id.eml);
        e8=(EditText)findViewById(R.id.passs);
        e9=(EditText)findViewById(R.id.repa);
        button=(Button)findViewById(R.id.regi);
        b1=(Button)findViewById(R.id.adlog);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Login");
        stuModel=new StuModel();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ob=new Intent(getApplicationContext(),Stulog.class);
                startActivity(ob);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nam = e1.getText().toString().trim();
                adno = e2.getText().toString().trim();
                pla = e3.getText().toString().trim();
                dis = s.getSelectedItem().toString().trim();
                par = e5.getText().toString().trim();
                mob = e6.getText().toString().trim();
                ema = e7.getText().toString().trim();
                pas = e8.getText().toString().trim();
                cpas = e9.getText().toString().trim();

                if (nam.isEmpty()) {
                    e1.setError("Name is required");
                    e1.requestFocus();
                } else if (adno.isEmpty()) {
                    e2.setError(" Admission number is required");
                    e2.requestFocus();
                } else if (pla.isEmpty()) {
                    e3.setError("place is required");
                    e3.requestFocus();
                }
                else if (par.isEmpty()) {
                    e5.setError("parentname is required");
                    e5.requestFocus();
                } else if (mob.isEmpty()) {
                    e6.setError("mobile No is required");
                    e6.requestFocus();
                } else if (ema.isEmpty()) {
                    e7.setError("email  is required");
                    e7.requestFocus();
                }else if (pas.isEmpty()) {
                    e8.setError("Password is required");
                    e8.requestFocus();
                }else if (!pas.equals("cpas")) {

                    e9.setError("password does not match");
                    e9.requestFocus();
                }
                else {

                    stuModel.setName(nam);
                    stuModel.setAdno(adno);
                    stuModel.setPlce(pla);
                    stuModel.setDis(dis);
                    stuModel.setPar(par);
                    stuModel.setMob(mob);
                    stuModel.setEml(ema);
                    stuModel.setPass(pas);

                    n = stuModel.getName();
                    a = stuModel.getAdno();
                    p = stuModel.getPlce();
                    d = stuModel.getDis();
                    p1 = stuModel.getPar();
                    m = stuModel.getMob();
                    e = stuModel.getEml();
                    p2 = stuModel.getPass();

                    databaseReference.push().setValue(stuModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Succes", Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
