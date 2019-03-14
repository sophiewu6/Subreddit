package com.example.reddit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Thread extends AppCompatActivity {
    Button button;
    TextView subreddit_name;
    TextView thread_title;
    TextView thread_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        button = findViewById(R.id.add_comment);
        subreddit_name = findViewById(R.id.subreddit);
        thread_title =findViewById(R.id.post_title);
        thread_info = findViewById(R.id.post_text);
        subreddit_name.setText(MainActivity.store.getSubreddit().getTitle());
        thread_title.setText(MainActivity.store.getPost().getTitle());
        thread_info.setText(MainActivity.store.getPost().getText());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Thread.this, CreateComment.class);
                startActivity(intent);
            }
        });
    }
}
