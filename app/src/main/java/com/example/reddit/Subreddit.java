package com.example.reddit;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Subreddit extends AppCompatActivity {
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    RecyclerView recyclerView;
    RecyclerView.Adapter<ThreadAdapter.ViewHolder> mAdapter;
    ArrayList<Post> mThreads;
    TextView get_title;
    TextView get_desc;
    FloatingActionButton button;
    private ChildEventListener childEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subreddit);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Subreddit List").child(MainActivity.getSubreddit().getTitle());

        get_title = (TextView) findViewById(R.id.textView);
        get_desc = (TextView) findViewById(R.id.textView4);
        get_title.setText(MainActivity.store.getSubreddit().getTitle());
        get_desc.setText(MainActivity.store.getSubreddit().getDescription());

        button = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        mThreads = new ArrayList<Post>();

        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                System.out.println
                if (dataSnapshot.getValue() == Post.class) {
                    System.out.println("1");
                    mThreads.add(dataSnapshot.getValue(Post.class)); }
                mAdapter.notifyItemInserted(mThreads.size()-1);
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

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLayoutManager = layoutManager;

        recyclerView.setLayoutManager(rvLayoutManager);
        mAdapter = new ThreadAdapter(mThreads);
        recyclerView.setAdapter((mAdapter));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Subreddit.this, WriteThread.class);
                startActivity(intent);
            }
        });
    }
}
