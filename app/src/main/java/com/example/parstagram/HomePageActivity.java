package com.example.parstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseUser;

public class HomePageActivity extends AppCompatActivity {

    public static final String TAG = "HomePage activity";
    private TextView tvUsername;
    private Button btnPost;
    private Button btnSignOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        tvUsername = findViewById(R.id.tvUsername);
        btnPost = findViewById(R.id.btnPost);
        btnSignOut = findViewById(R.id.btnSignOut);

        tvUsername.setText(ParseUser.getCurrentUser().getUsername());

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goMainActivity();
            }
        });

    }

    private void signOut() {
        ParseUser.logOut();
        ParseUser currentUser = ParseUser.getCurrentUser();

        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }

    private void goMainActivity(){

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}