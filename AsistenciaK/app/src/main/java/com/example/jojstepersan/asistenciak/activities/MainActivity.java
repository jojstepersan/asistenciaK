package com.example.jojstepersan.asistenciak.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListViewCompat;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jojstepersan.asistenciak.R;
import com.example.jojstepersan.asistenciak.adapters.MateriaAdapter;
import com.example.jojstepersan.asistenciak.entities.Materia;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Materia> materias=new ArrayList<>();

        Materia m1=new Materia(2020,"calculo integral",1);
        Materia m2=new Materia(2021,"Calculo diferencial",51);
        Materia m3=new Materia(3031,"Construccion de aplicaciones",51);
        Materia m4=new Materia(3030,"Ingenieria de softwqare",1);
        Materia m5=new Materia(1015,"cultura iii",5);

        materias.add(m1);
        materias.add(m2);
        materias.add(m3);
        materias.add(m4);
        materias.add(m5);

        ListView mateariasView=(ListView)findViewById(R.id.list_materia);

        MateriaAdapter materiaAdapter=new MateriaAdapter(this,R.layout.list_materia_record_item,materias);

        mateariasView.setAdapter(materiaAdapter);

        //mTextMessage = (TextView) findViewById(R.id.message);
   //     BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
     //   navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
