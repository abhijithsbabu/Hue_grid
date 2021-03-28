package com.example.hue_grid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22;
    Button b23,b24,b25;
    ArrayList<Integer> color_id;
    ArrayList<ArrayList<Button>> btn_rows;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        try {

            b1 = findViewById(R.id.b1);
            b2 = findViewById(R.id.b2);
            b3 = findViewById(R.id.b3);
            b4 = findViewById(R.id.b4);
            b5 = findViewById(R.id.b5);
            b6 = findViewById(R.id.b6);
            b7 = findViewById(R.id.b7);
            b8 = findViewById(R.id.b8);
            b9 = findViewById(R.id.b9);
            b10 = findViewById(R.id.b10);
            b11 = findViewById(R.id.b11);
            b12 = findViewById(R.id.b12);
            b13 = findViewById(R.id.b13);
            b14 = findViewById(R.id.b14);
            b15 = findViewById(R.id.b15);
            b16 = findViewById(R.id.b16);
            b17 = findViewById(R.id.b17);
            b18 = findViewById(R.id.b18);
            b19 = findViewById(R.id.b19);
            b20 = findViewById(R.id.b20);
            b21 = findViewById(R.id.b21);
            b22 = findViewById(R.id.b22);
            b23 = findViewById(R.id.b23);
            b24 = findViewById(R.id.b24);
            b25 = findViewById(R.id.b25);

            btn_rows = new ArrayList<>();
            ArrayList<Button> temp1 = new ArrayList<>();
            ArrayList<Button> temp2 = new ArrayList<>();
            ArrayList<Button> temp3 = new ArrayList<>();
            ArrayList<Button> temp4 = new ArrayList<>();
            ArrayList<Button> temp5 = new ArrayList<>();
            temp1.add(b1);
            temp1.add(b2);
            temp1.add(b3);
            temp1.add(b4);
            temp1.add(b5);
            btn_rows.add(temp1);
            temp2.add(b6);
            temp2.add(b7);
            temp2.add(b8);
            temp2.add(b9);
            temp2.add(b10);
            btn_rows.add(temp2);
            temp3.add(b11);
            temp3.add(b12);
            temp3.add(b13);
            temp3.add(b14);
            temp3.add(b15);
            btn_rows.add(temp3);
            temp4.add(b16);
            temp4.add(b17);
            temp4.add(b18);
            temp4.add(b19);
            temp4.add(b20);
            btn_rows.add(temp4);
            temp5.add(b21);
            temp5.add(b22);
            temp5.add(b23);
            temp5.add(b24);
            temp5.add(b25);
            btn_rows.add(temp5);

            color_id = new ArrayList<>();
            for (int i = 0; i < 25; i++) {
                color_id.add(0);
            }
            initgame();


            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    int finalI = i;
                    int finalJ = j;
                    btn_rows.get(i).get(j).setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {

                            for (int k = 0; k < 5; k++) {
                                if (color_id.get(finalI * 5 + k) == 2 && k != finalJ) {
                                    color_id.set(finalI * 5 + k, 0);
                                }
                                else if(k!= finalJ){
                                    color_id.set(finalI * 5 + k, color_id.get(finalI * 5 + k) + 1);
                                }
                                if (color_id.get(k * 5 + finalJ) == 2) {
                                    color_id.set(k * 5 + finalJ, 0);
                                }
                                else {
                                    color_id.set(k * 5 + finalJ, color_id.get(k * 5 + finalJ) + 1);
                                }
                                if(k != finalJ) {
                                    changeColor(btn_rows.get(finalI).get(k), color_id.get(finalI * 5 + k));
                                }
                                changeColor(btn_rows.get(k).get(finalJ),color_id.get(k * 5 + finalJ));

                            }
                            checkFinish();
                        }
                    });
                }
            }
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }

    private void checkFinish() {

        int cl = color_id.get(0);
        boolean finish = true;
        for (int i = 0; i < 25; i++)
        {
            if(color_id.get(i) != cl)
            {
                finish = false;
                break;
            }
        }
        if(finish)
        {
            Toast.makeText(this, "You won", Toast.LENGTH_SHORT).show();


            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Congratulations. Do you want to play again?");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    initgame();
                    Toast.makeText(getApplicationContext(), "Starting new game", Toast.LENGTH_SHORT).show();
                }
            });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "exiting", Toast.LENGTH_SHORT).show();
                    initgame();
                }
            });

            builder.show();
        }
    }

    private void initgame() {

        Random rand = new Random();
        int a = rand.nextInt(3);
        switch (a)
        {
            case 0:
                color_id.set(0,2);
                color_id.set(9,2);
                color_id.set(23,2);
                color_id.set(1,1);
                color_id.set(7,1);
                color_id.set(16,1);
                color_id.set(19,1);
                color_id.set(20,1);
                color_id.set(21,1);
                color_id.set(24,1);
                break;
            case 1:
                color_id.set(6,2);
                color_id.set(9,2);
                color_id.set(21,2);
                color_id.set(22,2);
                color_id.set(24,2);
                color_id.set(5,1);
                color_id.set(10,1);
                color_id.set(14,1);
                color_id.set(15,1);
                color_id.set(17,1);
                color_id.set(18,1);
                color_id.set(19,1);
                color_id.set(23,1);
                break;
            case 2:
                color_id.set(1,2);
                color_id.set(5,2);
                color_id.set(14,2);
                color_id.set(19,2);
                color_id.set(22,2);
                color_id.set(6,1);
                color_id.set(12,1);
                color_id.set(13,1);
                color_id.set(20,1);
                color_id.set(21,1);
                color_id.set(24,1);
                break;
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                changeColor(btn_rows.get(i).get(j),color_id.get(i*5 + j));
            }
        }
    }

    private void changeColor(Button button, int color) {
        switch (color) {
            case 0:
                button.setBackgroundColor(0xFFFFFF00);
                break;
            case 1:
                button.setBackgroundColor(Color.GREEN);
                break;
            case 2:
                button.setBackgroundColor(Color.RED);
                break;
        }
    }
}