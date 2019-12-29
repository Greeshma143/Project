package com.example.project.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final EditText ed1,ed3,ed4,ed5,ed6,ed7,ed8;
        final Button button;
        final TextView tt1,tt2,tt3,tt4,tt5,tt6;

        final DatabaseReference databaseReference;
        ed1=(EditText)root.findViewById(R.id.boktit);
        button=(Button)root.findViewById(R.id.sea);
        ed3=(EditText)root.findViewById(R.id.cod);
        ed4=(EditText)root.findViewById(R.id.des);
        ed5=(EditText)root.findViewById(R.id.aut);
        ed6=(EditText)root.findViewById(R.id.pub);
        ed7=(EditText)root.findViewById(R.id.typ);
        ed8=(EditText)root.findViewById(R.id.pri);
        tt1=(TextView)root.findViewById(R.id.t1);
        tt2=(TextView)root.findViewById(R.id.t2);
        tt3=(TextView)root.findViewById(R.id.t3);
        tt4=(TextView)root.findViewById(R.id.t4);
        tt5=(TextView)root.findViewById(R.id.t5);
        tt6=(TextView)root.findViewById(R.id.t6);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Library");
        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String bt;
                        bt = ed1.getText().toString().trim();
                        Query query = databaseReference.orderByChild("titl").equalTo(bt);
                        query.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                for (DataSnapshot lib : dataSnapshot.getChildren()) {
                                    Model model = lib.getValue(Model.class);

                                    String scod = model.code;
                                    String sdes = model.desc;
                                    String saut = model.auth;
                                    String spub = model.publ;
                                    String styp = model.type;
                                    String spri = model.pric;

                                    ed3.setText(scod);
                                    ed4.setText(sdes);
                                    ed5.setText(saut);
                                    ed6.setText(spub);
                                    ed7.setText(styp);
                                    ed8.setText(spri);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }

                        });
                        tt1.setVisibility(View.VISIBLE);
                        tt2.setVisibility(View.VISIBLE);
                        tt3.setVisibility(View.VISIBLE);
                        tt4.setVisibility(View.VISIBLE);
                        tt5.setVisibility(View.VISIBLE);
                        tt6.setVisibility(View.VISIBLE);
                        ed3.setVisibility(View.VISIBLE);
                        ed4.setVisibility(View.VISIBLE);
                        ed5.setVisibility(View.VISIBLE);
                        ed6.setVisibility(View.VISIBLE);
                        ed7.setVisibility(View.VISIBLE);
                        ed8.setVisibility(View.VISIBLE);

                        Toast.makeText(getActivity(), bt + " ", Toast.LENGTH_SHORT).show();


                    }
                });

            }
        });
        return root;
    }
}