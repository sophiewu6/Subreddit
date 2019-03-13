package com.example.reddit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    static StoreInfo store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        store = new StoreInfo();

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubredditList.class);
                startActivity(intent);
            }
        });
    }

    static public SubredditObject getSubreddit() {
        return store.getSubreddit();
    }

    static public int getPost() {
        return store.getPost();
    }

    static public void setSubreddit(SubredditObject subreddit) {
        store.setSubreddit(subreddit);
    }

    static public void setPost(int post) {
        store.setPost(post);
    }

}
