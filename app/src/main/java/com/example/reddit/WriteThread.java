package com.example.reddit;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WriteThread extends AppCompatActivity {
    Button button;
    EditText get_title;
    EditText get_text;
    int test = MainActivity.getTest();
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_thread);

        button = (Button) findViewById(R.id.button3);

        get_title = (EditText) findViewById(R.id.threadTitle);
        get_text = (EditText) findViewById(R.id.threadText);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = get_title.getText().toString();
                String text = get_text.getText().toString();
                Post new_post = new Post(title, text, 0, 0);
                mDatabase.child("Subreddit List").child(sub.getTitle()).setValue(sub);
                Intent intent = new Intent(CreateSubreddit.this, SubredditList.class);
                startActivity(intent);

            }
        });
    }
}
