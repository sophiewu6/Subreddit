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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Subreddit extends AppCompatActivity {
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    RecyclerView recyclerView;
    RecyclerView.Adapter<ThreadAdapter.ViewHolder> mAdapter;
    ArrayList<Post> mThreads;
    TextView get_title;
    TextView get_desc;
    FloatingActionButton button;
    Button backButton;
    private ChildEventListener childEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subreddit);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Subreddit List").child(MainActivity.getSubreddit().getTitle()).child("Thread List");

        get_title = (TextView) findViewById(R.id.textView);
        get_desc = (TextView) findViewById(R.id.textView4);
        get_title.setText(MainActivity.store.getSubreddit().getTitle());
        get_desc.setText(MainActivity.store.getSubreddit().getDescription());

        button = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        backButton = findViewById(R.id.back);

        mThreads = new ArrayList<Post>();

        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                //if (dataSnapshot.getValue().getClass() == HashMap.class) {
                mThreads.add(dataSnapshot.getValue(Post.class)); //}
                Collections.sort(mThreads);
                mAdapter.notifyItemInserted(mThreads.size()-1);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
               mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                mAdapter.notifyDataSetChanged();
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
        mAdapter = new ThreadAdapter(mThreads, new ThreadAdapter.MyAdapterListener() {
            public void titleTextViewOnClick(View v, int position) {
                Intent intent = new Intent(Subreddit.this, Thread.class);
                MainActivity.store.setPost(mThreads.get(position));
                startActivity(intent);
            }

            @Override
            public void upvoteImageViewOnClick(View v, int position) {
                MainActivity.store.setPost(mThreads.get(position));
                MainActivity.getPost().upvote();
                myRef.child(MainActivity.getPost().getKey()).setValue(MainActivity.getPost());

            }
            @Override
            public void downvoteImageViewOnClick(View v, int position) {
                MainActivity.store.setPost(mThreads.get(position));
                MainActivity.getPost().downvote();
                myRef.child(MainActivity.getPost().getKey()).setValue(MainActivity.getPost());
            }

            public void deleteButtonOnClick(View v, int position) {
                Post currentPost = (Post) mThreads.get(position);
                myRef.child(currentPost.getKey()).removeValue();
                mThreads.remove(currentPost);
                //refresh(currentComment.getKey());
            }
        });
        recyclerView.setAdapter((mAdapter));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Subreddit.this, WriteThread.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Subreddit.this, SubredditList.class);
                startActivity(intent);
            }
        });
    }
}
