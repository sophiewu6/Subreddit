package com.example.reddit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateSubreddit extends AppCompatActivity {
    Button button;
    EditText get_title;
    EditText get_desc;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_subreddit);
        button = (Button) findViewById(R.id.button2);

        get_title = (EditText) findViewById(R.id.subredditTitle);
        get_desc = (EditText) findViewById(R.id.subreddit_desc);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = get_title.getText().toString();
                String desc = get_desc.getText().toString();
                mDatabase.child("Subreddit List").setValue(desc);
                Intent intent = new Intent(CreateSubreddit.this, SubredditList.class);
                startActivity(intent);

            }
        });


    }
}
