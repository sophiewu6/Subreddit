package com.example.reddit;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class SubredditList extends AppCompatActivity {
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    FloatingActionButton button;
    ListView listView;
    private ChildEventListener childEventListener;
    ArrayAdapter<SubredditObject> mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subreddit_list);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Subreddit List");

        ArrayList<SubredditObject> subredditList = new ArrayList<SubredditObject>();

        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                mAdapter.add(dataSnapshot.getValue(SubredditObject.class));
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };

        myRef.addChildEventListener(childEventListener);

        button = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        listView = (ListView) findViewById(R.id.listView);

        mAdapter = new SubredditAdapter(this, subredditList);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubredditList.this, CreateSubreddit.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SubredditList.this, Subreddit.class);
                startActivity(intent);
            }
        });
        listView.setAdapter(mAdapter);
    }
}
