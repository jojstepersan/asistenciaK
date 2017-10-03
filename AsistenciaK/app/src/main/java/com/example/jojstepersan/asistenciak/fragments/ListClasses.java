package com.example.jojstepersan.asistenciak.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jojstepersan.asistenciak.R;
import com.example.jojstepersan.asistenciak.adapters.MateriaAdapter;
import com.example.jojstepersan.asistenciak.entities.Materia;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListClasses.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListClasses#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListClasses extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ListClasses() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListClasses.
     */
    // TODO: Rename and change types and number of parameters
    public static ListClasses newInstance(String param1, String param2) {
        ListClasses fragment = new ListClasses();
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

    //create fragments
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main,container);

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

        Log.d("Stiven","tamaño" + materias.size());

        ListView mateariasView=(ListView) view.findViewById(R.id.list_materia);

        MateriaAdapter materiaAdapter=new MateriaAdapter(getContext(),R.layout.list_materia_record_item,materias);

        mateariasView.setAdapter(materiaAdapter);

        mateariasView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

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
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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
