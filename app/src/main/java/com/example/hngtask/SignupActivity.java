package com.example.hngtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {
Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final EditText nameEdiText = (EditText) findViewById(R.id.editTextName);
        final EditText emailEditText = (EditText) findViewById(R.id.editTextEmail);
        final EditText passwordEditext = (EditText) findViewById(R.id.editTextPassword);
        final EditText confirmPassEditText = (EditText) findViewById(R.id.editTextConfirmPassword);

        Button signup = (Button) findViewById(R.id.signupReal);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                String userName = nameEdiText.getText().toString().trim();
                String userEmail = emailEditText.getText().toString().trim();
                String userPassword = passwordEditext.getText().toString().trim();
                String userConfirmPassword = confirmPassEditText.getText().toString().trim();

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(userEmail + userPassword + "data", userName + "\n" + userEmail);
                editor.commit();

                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
