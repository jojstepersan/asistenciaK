package co.edu.konradlorenz.takeassistance.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import co.edu.konradlorenz.takeassistance.R;
import co.edu.konradlorenz.takeassistance.adapters.ClassAdapter;
import co.edu.konradlorenz.takeassistance.entities.Assistance;
import co.edu.konradlorenz.takeassistance.entities.Class;
import co.edu.konradlorenz.takeassistance.entities.Student;
import co.edu.konradlorenz.takeassistance.entities.Teacher;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListClassesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListClassesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListClassesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ArrayList<String > arrayList=new ArrayList<>();
    private ListView listView;
    private ArrayAdapter<String > adapter;

    private OnFragmentInteractionListener mListener;

    public ListClassesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListClassesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListClassesFragment newInstance(String param1, String param2) {
        ListClassesFragment fragment = new ListClassesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_list_classes,container,false);

        DatabaseReference database=FirebaseDatabase.getInstance().getReference();
        final ArrayList<Class> materias=new ArrayList<>();
        DatabaseReference ref=database.child("user/teacher/");
        ListView materiasView=(ListView)view.findViewById(R.id.list_classes);
        final ClassAdapter classAdapter=new ClassAdapter(getContext(),R.layout.list_materia_record_item,materias);

        materiasView.setAdapter(classAdapter);

        //DatabaseReference post=ref.child("");
        //post.push().setValue(new Teacher("diego","vivas",102030,"diego.vivas@conradlorenz.edu.co"));



        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.d("add",dataSnapshot.getValue().getClass().getName()+" id: "+dataSnapshot.getKey());
                Teacher string = dataSnapshot.getValue(Teacher.class);

                Log.w("class",string.getClasses().get(0).getName());
                ArrayList<Class> aux= (ArrayList<Class>) string.getClasses();
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
                Toast.makeText(getContext(),materias.get(i).getName(),Toast.LENGTH_SHORT).show();

                ListStudentFragment.students=new ArrayList<Student>();//materias.get(i).getStudents();
                ListStudentFragment.students.clear();
                for (int j = 0; j <materias.get(i).getStudents().size() ; j++) {
                    ListStudentFragment.students.add(materias.get(i).getStudents().get(j));
                }



            }
        });

        return view;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
//            throw new RuntimeException(context.toString()
  //                  + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
