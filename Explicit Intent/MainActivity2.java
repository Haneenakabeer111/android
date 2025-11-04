package com.example.explicitintents;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){
            String imageindex=bundle.getString("ImageIndex");
            setImage(imageindex);
        }
    }
    private void setImage(String Index){
        ImageView imageView = findViewById(R.id.imageViewCountry);
        switch (Index) {
            case "1":
                imageView.setImageResource(R.drawable.map);
                break;
            case "2":
                imageView.setImageResource(R.drawable.flag);
                break;
            case "3":
                imageView.setImageResource(R.drawable.tajmahal);
                break;
            default:
                imageView.setImageResource(R.drawable.delhi); // fallback
                break;
        }
    }
}


