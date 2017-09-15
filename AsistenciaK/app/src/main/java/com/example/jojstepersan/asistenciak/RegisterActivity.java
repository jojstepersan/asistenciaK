package com.example.jojstepersan.asistenciak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {
    Button login2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        login2=(Button)findViewById(R.id.buttonRegister);

        login2.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         Intent siguiente = new Intent(RegisterActivity.this, LoginActivity.class);
                                         startActivity(siguiente);
                                     }
                                 }

        );
    }
}
