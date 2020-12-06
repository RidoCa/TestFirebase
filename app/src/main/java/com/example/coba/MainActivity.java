package com.example.coba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab_add;
    RecyclerAdapter recyclerAdapter;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    ArrayList<Mahasiswa> listMahasiswa;
    RecyclerView rv_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab_add = findViewById(R.id.fb_add);
        rv_view = findViewById(R.id.rv_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rv_view.setLayoutManager(layoutManager);
        rv_view.setItemAnimator(new DefaultItemAnimator());


        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogForm dialogForm = new DialogForm();
                dialogForm.show(getSupportFragmentManager(), "form");
            }
        });

        showData();

    }

    private void showData(){
        databaseReference.child("Data").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listMahasiswa = new ArrayList<>();
                for(DataSnapshot item : snapshot.getChildren()){
                    Mahasiswa mahasiswa = item.getValue(Mahasiswa.class);
                    mahasiswa.setKey(item.getKey());
                    listMahasiswa.add(mahasiswa);
                }
                recyclerAdapter = new RecyclerAdapter(listMahasiswa);
                rv_view.setAdapter(recyclerAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}