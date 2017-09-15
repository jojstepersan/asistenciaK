package com.example.jojstepersan.asistenciak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MatterActivity extends AppCompatActivity {
    ImageView student,assistance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matter);

        assistance = (ImageView) findViewById(R.id.imageView5);
        assistance.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              Intent siguiente = new Intent(MatterActivity.this, AssistanceActivity.class);
                                              startActivity(siguiente);
                                          }
                                      }
        );

        student= (ImageView) findViewById(R.id.imageView2);

        student.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           Intent siguiente = new Intent(MatterActivity.this, StudentActivity.class);
                                           startActivity(siguiente);
                                       }
                                   }
        );



    }

}
