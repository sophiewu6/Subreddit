package com.example.reddit;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateComment extends AppCompatActivity {
    Button button;
    TextView post_title;
    EditText comment_text;
    Comment new_comment;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_comment);
        this.post_title = findViewById(R.id.post_title);
        post_title.setText(MainActivity.getPost().getTitle());
        this.comment_text = findViewById(R.id.comment_text);

        button = findViewById(R.id.send);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = comment_text.getText().toString();
                new_comment = new Comment(text,0, "");
                Intent intent = new Intent(CreateComment.this, Thread.class);
                mDatabase.child("Subreddit List").child(MainActivity.getSubreddit().getTitle()).child(MainActivity.getPost().getKey()).child(new_comment.getKey()).setValue(new_comment);
                startActivity(intent);
            }
        });
    }
}
