package com.example.reddit;

import android.content.Intent;
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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Subreddit extends AppCompatActivity {
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    ArrayList<Post> mThreads;
    TextView get_title;
    TextView get_desc;
    FloatingActionButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subreddit);

        get_title = (TextView) findViewById(R.id.textView);
        get_desc = (TextView) findViewById(R.id.textView4);
        get_title.setText(MainActivity.store.getSubreddit().getTitle());
        get_desc.setText(MainActivity.store.getSubreddit().getDescription());

        button = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        mThreads = new ArrayList<Post>();
        mThreads.add(new Post("title1", "",0, 0, 0));
        mThreads.add(new Post("title2", "", 0, 0, 0));

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
