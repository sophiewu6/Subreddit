package com.example.reddit;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class write_thread extends AppCompatActivity {
    private ImageButton imageBtn; private static final int GALLERY_REQUEST_CODE = 2;
    private Uri uri = null; private EditText textTitle; private EditText textDesc;
    private Button postBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_thread);
    }
}
