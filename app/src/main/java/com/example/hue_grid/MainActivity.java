package com.example.hue_grid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button play, help, credit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.play);
        help = findViewById(R.id.help);
        credit = findViewById(R.id.credits);

        play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                try {

                    Intent in = new Intent(getApplicationContext(),MainActivity2.class);
                    startActivity(in);
                    finish();
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}