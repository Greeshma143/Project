package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Delb extends AppCompatActivity {
    Button button1,button2,button3;
    EditText editText1,editText3,editText4,editText5,editText6,editText7,editText8;
    TextView textView1,textView2,textView3,textView4,textView5,textView6;
    String  bt,ncod,ndes,naut,npub,ntyp,npri;
    Model model;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delb);
        editText1=(EditText)findViewById(R.id.boktit);
        editText3=(EditText)findViewById(R.id.cod);
        editText4=(EditText)findViewById(R.id.des);
        editText5=(EditText)findViewById(R.id.aut);
        editText6=(EditText)findViewById(R.id.pub);
        editText7=(EditText)findViewById(R.id.typ);
        editText8=(EditText)findViewById(R.id.pri);

        textView1=(TextView)findViewById(R.id.t1);
        textView2=(TextView)findViewById(R.id.t2);
        textView3=(TextView)findViewById(R.id.t3);
        textView4=(TextView)findViewById(R.id.t4);
        textView5=(TextView)findViewById(R.id.t5);
        textView6=(TextView)findViewById(R.id.t6);
        button1=(Button)findViewById(R.id.sea);
        button2=(Button)findViewById(R.id.up);
        button3=(Button)findViewById(R.id.del);
        model=new Model();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Library");
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bt=editText1.getText().toString().trim();
                Query query=databaseReference.orderByChild("titl").equalTo(bt);
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot del:dataSnapshot.getChildren())
                        {
                            del.getRef().removeValue();
                            Toast.makeText(getApplicationContext(),"data succesfully deleted",Toast.LENGTH_SHORT).show();

                        }
                        textView1.setVisibility(View.INVISIBLE);
                        textView2.setVisibility(View.INVISIBLE);
                        textView3.setVisibility(View.INVISIBLE);
                        textView4.setVisibility(View.INVISIBLE);
                        textView5.setVisibility(View.INVISIBLE);
                        textView6.setVisibility(View.INVISIBLE);
                        editText5.setVisibility(View.INVISIBLE);
                        editText3.setVisibility(View.INVISIBLE);
                        editText4.setVisibility(View.INVISIBLE);
                        editText7.setVisibility(View.INVISIBLE);
                        editText6.setVisibility(View.INVISIBLE);
                        editText8.setVisibility(View.INVISIBLE);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ncod=editText3.getText().toString().trim();
                ndes=editText4.getText().toString().trim();
                naut=editText5.getText().toString().trim();
                npub=editText6.getText().toString().trim();
                ntyp=editText7.getText().toString().trim();
                npri=editText8.getText().toString().trim();
                Query query=databaseReference.orderByChild("titl").equalTo(bt);
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot lib:dataSnapshot.getChildren())
                        {
                            lib.getRef().child("code").setValue(ncod);
                            lib.getRef().child("desc").setValue(ndes);
                            lib.getRef().child("auth").setValue(naut);
                            lib.getRef().child("publ").setValue(npub);
                            lib.getRef().child("type").setValue(ntyp);
                            lib.getRef().child("pric").setValue(npri);
                        }
                        Toast.makeText(getApplicationContext(),"data succesfully updated",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bt = editText1.getText().toString().trim();
                Query query = databaseReference.orderByChild("titl").equalTo(bt);
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot lib:dataSnapshot.getChildren())
                        {
                            Model model = lib.getValue(Model.class);

                            String scod = model.code;
                            String sdes = model.desc;
                            String saut = model.desc;
                            String spub = model.publ;
                            String styp = model.type;
                            String spri = model.pric;

                            editText3.setText(scod);
                            editText4.setText(sdes);
                            editText5.setText(saut);
                            editText6.setText(spub);
                            editText7.setText(styp);
                            editText8.setText(spri);
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                textView1.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.VISIBLE);
                textView4.setVisibility(View.VISIBLE);
                textView5.setVisibility(View.VISIBLE);
                textView6.setVisibility(View.VISIBLE);
                editText3.setVisibility(View.VISIBLE);
                editText4.setVisibility(View.VISIBLE);
                editText5.setVisibility(View.VISIBLE);
                editText6.setVisibility(View.VISIBLE);
                editText7.setVisibility(View.VISIBLE);
                editText8.setVisibility(View.VISIBLE);

                Toast.makeText(getApplicationContext(), bt + " ", Toast.LENGTH_SHORT).show();


            }
        });
    }
}
