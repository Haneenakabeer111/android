package com.example.explicitintents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OnIndexSendButtonClicked(View view){
        Intent intent=new Intent(this, MainActivity2.class);
        EditText editText=(EditText)findViewById(R.id.editTextIndex);
        String index=editText.getText().toString();
        intent.putExtra("ImageIndex",index);
        startActivity(intent);
    }
}