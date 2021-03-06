package com.example.reddit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateSubreddit extends AppCompatActivity {
    Button button;
    Button backButton;
    EditText get_title;
    EditText get_desc;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_subreddit);
        button = (Button) findViewById(R.id.button2);
        backButton = findViewById(R.id.back);

        get_title = (EditText) findViewById(R.id.subredditTitle);
        get_desc = (EditText) findViewById(R.id.subreddit_desc);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = get_title.getText().toString();
                String desc = get_desc.getText().toString();
                SubredditObject sub = new SubredditObject(title, desc);
                mDatabase.child("Subreddit List").child(sub.getTitle()).setValue(sub);
                Intent intent = new Intent(CreateSubreddit.this, SubredditList.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateSubreddit.this, SubredditList.class);
                startActivity(intent);
            }
        });


    }
}
