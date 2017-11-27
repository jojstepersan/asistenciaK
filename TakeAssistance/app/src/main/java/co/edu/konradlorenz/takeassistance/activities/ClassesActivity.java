package co.edu.konradlorenz.takeassistance.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import co.edu.konradlorenz.takeassistance.R;
import co.edu.konradlorenz.takeassistance.adapters.ClassAdapter;
import co.edu.konradlorenz.takeassistance.entities.Class;
import co.edu.konradlorenz.takeassistance.entities.Student;
import co.edu.konradlorenz.takeassistance.entities.Teacher;
import co.edu.konradlorenz.takeassistance.fragments.ListStudentFragment;
import co.edu.konradlorenz.takeassistance.fragments.TakeAssistanceFragment;

public class ClassesActivity extends AppCompatActivity {

    private Intent intent;
    public static Teacher teacher;
    public static String key;
    public static Class currentClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent=new Intent(this,MainActivity.class);
        setContentView(R.layout.activity_classes);
     //   View view=inflater.inflate(R.layout.fragment_list_classes,container,false);

        DatabaseReference database= FirebaseDatabase.getInstance().getReference();
        final ArrayList<Class> materias=new ArrayList<>();
        DatabaseReference ref=database.child("user/teacher/");
        //DatabaseReference ref2=database.child("user/teacher/").child("classes").child("students").child("assistances");
        ListView materiasView=(ListView)findViewById(R.id.list_classes);
        final ClassAdapter classAdapter=new ClassAdapter(this,R.layout.list_materia_record_item,materias);

        materiasView.setAdapter(classAdapter);

        //DatabaseReference post=ref.child("");
        //post.push().setValue(new Teacher("diego","vivas",102030,"diego.vivas@conradlorenz.edu.co"));



        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
               Log.d("add",dataSnapshot.getValue().getClass().getName()+" id: "+dataSnapshot.getKey());
                teacher = dataSnapshot.getValue(Teacher.class);
                key=dataSnapshot.getKey();
                ArrayList<Class> aux= (ArrayList<Class>) teacher.getClasses();
                for (int i = 0; i <aux.size() ; i++) {
                    materias.add(aux.get(i));
                    }
                classAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {}
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Class string = dataSnapshot.getValue(Class.class);
                materias.remove(string);
                classAdapter.notifyDataSetChanged();


            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        materiasView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(ClassesActivity.this,materias.get(i).getName(),Toast.LENGTH_SHORT).show();

            ListStudentFragment.students=new ArrayList<Student>();//materias.get(i).getStudents();
            TakeAssistanceFragment.students=new ArrayList<Student>();
                currentClass=materias.get(i);
            for (int j = 0; j <materias.get(i).getStudents().size() ; j++) {
                ListStudentFragment.students.add(materias.get(i).getStudents().get(j));
                TakeAssistanceFragment.students.add(materias.get(i).getStudents().get(j));
            }
            startActivity(intent);


            }
        });
    }
}
