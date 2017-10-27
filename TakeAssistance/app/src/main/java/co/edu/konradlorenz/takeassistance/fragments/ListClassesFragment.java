package co.edu.konradlorenz.takeassistance.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import co.edu.konradlorenz.takeassistance.R;
import co.edu.konradlorenz.takeassistance.adapters.ClassAdapter;
import co.edu.konradlorenz.takeassistance.entities.Class;

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
        ArrayList<Class> materias=new ArrayList<>();

        Class m1=new Class(2020,"calculo integral",1);
        Class m2=new Class(2021,"Calculo diferencial",51);
        Class m3=new Class(3031,"Construccion de aplicaciones",51);
        Class m4=new Class(3030,"Ingenieria de softwqare",1);
        Class m5=new Class(1015,"cultura iii",5);
        Class m6=new Class(1015,"cultura iii",5);
        Class m7=new Class(1015,"cultura iii",5);
        Class m8=new Class(1015,"cultura iii",5);
        Class m9=new Class(1015,"cultura iii",5);
        Class m10=new Class(1015,"cultura iii",5);
        Class m12=new Class(1015,"cultura iii",5);
        Class m11=new Class(1015,"cultura iii",5);
        Class m13=new Class(1015,"cultura iii",5);
        materias.add(m1);
        materias.add(m2);
        materias.add(m3);
        materias.add(m4);
        materias.add(m5);
        materias.add(m6);
        materias.add(m7);
        materias.add(m8);
        //materias.add(m9);
        //materias.add(m10);
       // materias.add(m11);
        //materias.add(m12);
        //materias.add(m13);


        ListView materiasView=(ListView)view.findViewById(R.id.list_classes);
        ClassAdapter classAdapter=new ClassAdapter(getContext(),R.layout.list_materia_record_item,materias);

        materiasView.setAdapter(classAdapter);

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
