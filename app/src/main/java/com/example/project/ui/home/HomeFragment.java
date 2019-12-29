package com.example.project.ui.home;

import android.os.Bundle;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final EditText e1,e2,e3,e4,e5,e6,e7;
        final Button button1;



        final Model model ;

        final DatabaseReference databaseReference;
        e1=(EditText) root.findViewById(R.id.cod);
        e2=(EditText) root.findViewById(R.id.tit);
        e3=(EditText) root.findViewById(R.id.des);
        e4=(EditText) root.findViewById(R.id.aut);
        e5=(EditText) root.findViewById(R.id.pub);
        e6=(EditText) root.findViewById(R.id.typ);
        e7=(EditText) root.findViewById(R.id.pri);
        button1=(Button)root.findViewById(R.id.sub);
        model=new Model();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Library");



        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final String s1,s2,s3,s4,s5,s6,s7;
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
                      final  String c,t,d,a,p,t1,p1;
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
                                    Toast.makeText(getActivity(), "Successfully Added", Toast.LENGTH_LONG).show();

                                } else {
                                    Toast.makeText(getActivity(), "error", Toast.LENGTH_LONG).show();

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
        });
        return root;
    }
}