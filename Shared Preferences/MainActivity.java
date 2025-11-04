package com.example.sharedpreferences;

import android.content.SharedPreferences;  // ✅ Add this
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;                 // ✅ Add this

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText usernameEt, mobileEt, emailEt, pass1Et, pass2Et;
    Button submitBtn;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEt = findViewById(R.id.username);
        mobileEt = findViewById(R.id.mobile);
        emailEt = findViewById(R.id.Email);
        pass1Et = findViewById(R.id.password);
        pass2Et = findViewById(R.id.repass);
        submitBtn = findViewById(R.id.submit);

        sharedPreferences = getSharedPreferences("UserDetails", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEt.getText().toString().trim();
                String mobileStr = mobileEt.getText().toString().trim();
                String email = emailEt.getText().toString().trim();
                String pass1 = pass1Et.getText().toString().trim();
                String pass2 = pass2Et.getText().toString().trim();

                if (username.isEmpty()) {
                    usernameEt.setError("Username is empty");
                    usernameEt.requestFocus();
                    return;
                }
                if (mobileStr.isEmpty()) {
                    mobileEt.setError("Mobile number is empty");
                    mobileEt.requestFocus();
                    return;
                }
                if (email.isEmpty()) {
                    emailEt.setError("Input email");
                    emailEt.requestFocus();
                    return;
                }
                if (pass1.isEmpty()) {
                    pass1Et.setError("Enter Password");
                    pass1Et.requestFocus();
                    return;
                }
                if (pass1.length() < 6) {
                    pass1Et.setError("Length must be minimum 6 characters");
                    pass1Et.requestFocus();
                    return;
                }
                if (!pass2.equals(pass1)) {
                    pass2Et.setError("Password not matched");
                    pass2Et.requestFocus();
                    return;
                }

                Toast.makeText(MainActivity.this, "Registration successful", Toast.LENGTH_LONG).show();

                // ✅ Save user data
                editor.putString("keyusername", username);
                editor.putString("keymobile", mobileStr); // store as string to avoid parse error
                editor.putString("keymail", email);
                editor.putString("keypassword", pass2);
                editor.apply();
            }
        });
    }
}
