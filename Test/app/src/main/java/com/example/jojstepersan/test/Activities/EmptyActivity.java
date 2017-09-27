package com.example.jojstepersan.test.Activities;

import android.icu.text.AlphabeticIndex;
import android.sax.RootElement;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jojstepersan.test.Adapters.RecordAdapter;
import com.example.jojstepersan.test.Entities.Record;
import com.example.jojstepersan.test.R;

import java.util.ArrayList;

public class EmptyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
        //traer la lista de la interfaz
        ListView recordsView=(ListView)findViewById(R.id.list_record);
        //crear un adapter
        ArrayList<Record> records=new ArrayList<>();
        records.add(new Record(1,300,101010,"mario vegeta 777"));
        records.add(new Record(2,301,101010,"goku ferando 85"));
        records.add(new Record(3,302,101010,"la rosa de guadalupe"));
        records.add(new Record(4,303,101010,"El brayan"));
        records.add(new Record(5,305,101010,"La valentina mi perro"));
        RecordAdapter adapter=new RecordAdapter(this,R.layout.activity_empty,records);
        recordsView.setAdapter(adapter);

    }
}
