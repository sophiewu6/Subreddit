package com.example.reddit;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Thread extends AppCompatActivity {
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    RecyclerView recyclerView;
    CommentAdapter mAdapter;
    ArrayList<Comment> mThreads;
    Button button;
    TextView subreddit_name;
    TextView thread_title;
    TextView thread_info;
    TextView score;
    private ChildEventListener childEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Subreddit List").child(MainActivity.getSubreddit().getTitle()).child("Thread List").child(MainActivity.getPost().getKey()).child("Comment List");
        mThreads = new ArrayList<Comment>();

        button = findViewById(R.id.add_comment);
        subreddit_name = findViewById(R.id.subreddit);
        thread_title =findViewById(R.id.post_title);
        thread_info = findViewById(R.id.post_text);
        subreddit_name.setText(MainActivity.store.getSubreddit().getTitle());
        thread_title.setText(MainActivity.store.getPost().getTitle());
        thread_info.setText(MainActivity.store.getPost().getText());

        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                mThreads.add(dataSnapshot.getValue(Comment.class));
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

        recyclerView = findViewById(R.id.recyclerView2);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLayoutManager = layoutManager;
        recyclerView.setLayoutManager(rvLayoutManager);

        mAdapter = new CommentAdapter(mThreads, new CommentAdapter.MyAdapterListener() {
            public void deleteButtonOnClick(View v, int position) {
                Comment currentComment = (Comment) mThreads.get(position);
                myRef.child(currentComment.getKey()).removeValue();
                mThreads.remove(currentComment);
                refresh(currentComment.getKey());
            }

            @Override
            public void iconImageViewOnClick(View v, int position) {

            }
        });
        recyclerView.setAdapter((mAdapter));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Thread.this, CreateComment.class);
                startActivity(intent);
            }
        });
    }

    public void refresh(String update) {
        mAdapter.clearComments();

        for (Comment c: mThreads) {
            if (c.getKey().equalsIgnoreCase(update)) {
                mThreads.add(c);
                mAdapter.notifyItemInserted(mThreads.size()-1);
            }
        }
        System.out.println(mThreads);
    }
}
