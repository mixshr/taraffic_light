package com.sharenko.tarafficlight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout bulb_1, bulb_2, bulb_3;
    private boolean isStart = false;
    private Button button;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bulb_1 = findViewById(R.id.bulb_1);
        bulb_2 = findViewById(R.id.bulb_2);
        bulb_3 = findViewById(R.id.bulb_3);
        button = findViewById(R.id.button);
    }

    public void onClickStart(View view) {
        if (!isStart) {
            isStart = true;
            button.setText("Stop");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (isStart) {
                        counter++;
                        switch (counter){
                            case 1:
                                bulb_1.setBackgroundColor(getColor(R.color.green));
                                bulb_2.setBackgroundColor(getColor(R.color.grey));
                                bulb_3.setBackgroundColor(getColor(R.color.grey));
                                break;
                            case 2:
                                bulb_1.setBackgroundColor(getColor(R.color.grey));
                                bulb_2.setBackgroundColor(getColor(R.color.yellow));
                                bulb_3.setBackgroundColor(getColor(R.color.grey));
                                break;
                            case 3:
                                bulb_1.setBackgroundColor(getColor(R.color.grey));
                                bulb_2.setBackgroundColor(getColor(R.color.grey));
                                bulb_3.setBackgroundColor(getColor(R.color.red));
                                break;
                            default: counter = 0;
                        }

                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        } else {
            isStart = false;
            button.setText("Start");
            bulb_1.setBackgroundColor(getColor(R.color.grey));
            bulb_2.setBackgroundColor(getColor(R.color.grey));
            bulb_3.setBackgroundColor(getColor(R.color.grey));
            counter = 0;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isStart = false;
    }
}