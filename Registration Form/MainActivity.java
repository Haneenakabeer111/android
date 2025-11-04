package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get references to UI elements
        EditText username = findViewById(R.id.username);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        EditText userpassword = findViewById(R.id.userpassword);
        Button loginbtn = findViewById(R.id.loginbtn);

        // Set click listener for button
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString().trim();
                String mail = email.getText().toString().trim();
                String pass = password.getText().toString().trim();
                String confirmPass = userpassword.getText().toString().trim();

                // Check empty fields
                if (user.isEmpty() || mail.isEmpty() || pass.isEmpty() || confirmPass.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Check password length
                if (pass.length() < 6) {
                    Toast.makeText(MainActivity.this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Check if passwords match
                if (!pass.equals(confirmPass)) {
                    Toast.makeText(MainActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Success
                Toast.makeText(MainActivity.this, "Welcome " + user + "!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
