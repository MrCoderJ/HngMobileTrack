package com.example.hngtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button signUpBtn = (Button) findViewById(R.id.signupLess);
        final EditText emailEdit = (EditText) findViewById(R.id.editTextEmailL);
        final EditText passwordEdit = (EditText) findViewById(R.id.editTextPasswordL);
        Button loginMan = (Button) findViewById(R.id.loginMain);

        loginMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail = emailEdit.getText().toString().trim();
                String passwordUser = passwordEdit.getText().toString().trim();

                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);

                String userDetails = preferences.getString(userEmail + passwordUser + "data", "Username or Password Incorrect");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("display", userDetails);
                editor.commit();

                Intent displayScreen = new Intent(MainActivity.this, DashboardActivity.class);
                startActivity(displayScreen);
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}
