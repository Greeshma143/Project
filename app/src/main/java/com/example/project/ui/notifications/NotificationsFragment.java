package com.example.project.ui.notifications;

import android.os.Bundle;
import android.provider.DocumentsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.project.Model;
import com.example.project.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
     Button button1,button2,button3;
     EditText editText1,editText3,editText4,editText5,editText6,editText7,editText8;
     TextView textView1,textView2,textView3,textView4,textView5,textView6;
     String ncod,ndes,naut,npub,ntyp,npri;

     Model model;
     DatabaseReference databaseReference;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);


        editText1=(EditText) root.findViewById(R.id.boktit);
        editText3=(EditText)root.findViewById(R.id.cod);
        editText4=(EditText)root.findViewById(R.id.des);
        editText5=(EditText)root.findViewById(R.id.aut);
        editText6=(EditText)root.findViewById(R.id.pub);
        editText7=(EditText)root.findViewById(R.id.typ);
        editText8=(EditText)root.findViewById(R.id.pri);

        textView1=(TextView)root.findViewById(R.id.t1);
        textView2=(TextView)root.findViewById(R.id.t2);
        textView3=(TextView)root.findViewById(R.id.t3);
        textView4=(TextView)root.findViewById(R.id.t4);
        textView5=(TextView)root.findViewById(R.id.t5);
        textView6=(TextView)root.findViewById(R.id.t6);
        button1=(Button)root.findViewById(R.id.sea);
        button2=(Button)root.findViewById(R.id.up);
        button3=(Button)root.findViewById(R.id.del);

        final  String bt;
        bt=editText1.getText().toString().trim();
        model=new Model();

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Library");

        notificationsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String btitle= editText1.getText().toString().trim();
                        Toast.makeText(getActivity(),btitle,Toast.LENGTH_SHORT).show();
                        Query query=databaseReference.orderByChild("titl").equalTo(btitle);
                        query.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                for(DataSnapshot del:dataSnapshot.getChildren())
                                {
                                    del.getRef().removeValue();

                                }
                                Toast.makeText(getActivity(),"data succesfully deleted",Toast.LENGTH_SHORT).show();

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

                       String btitle= editText1.getText().toString().trim();
                        Toast.makeText(getActivity(),btitle,Toast.LENGTH_SHORT).show();
                        Query query=databaseReference.orderByChild("titl").equalTo(btitle);
                        query.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                for(DataSnapshot lib:dataSnapshot.getChildren())
                                {
                                    lib.getRef().child("code").setValue(editText3.getText().toString().trim());
                                    lib.getRef().child("desc").setValue(editText4.getText().toString().trim());
                                    lib.getRef().child("auth").setValue(editText5.getText().toString().trim());
                                    lib.getRef().child("publ").setValue(editText6.getText().toString().trim());
                                    lib.getRef().child("publ").setValue(editText7.getText().toString().trim());
                                    lib.getRef().child("pric").setValue(editText8.getText().toString().trim());
                                    Toast.makeText(getActivity(),"data succesfully updated",Toast.LENGTH_SHORT).show();


                                }


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
                        String bt;
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
                                    String saut = model.auth;
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

                        Toast.makeText(getActivity(), bt + " ", Toast.LENGTH_SHORT).show();


                    }
                });

            }
        });
        return root;
    }
}