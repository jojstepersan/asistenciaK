package co.edu.konradlorenz.takeassistance.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.vision.CameraSource;
import java.util.ArrayList;

import co.edu.konradlorenz.takeassistance.R;
import co.edu.konradlorenz.takeassistance.activities.QRActivity;
import co.edu.konradlorenz.takeassistance.entities.Student;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TakeAssistanceFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TakeAssistanceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TakeAssistanceFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public static ArrayList<Student> students=new ArrayList<>();
    private OnFragmentInteractionListener mListener;

    private CameraSource cameraSource;
    private SurfaceView cameraView;
    private final int MY_PERMISSIONS_REQUEST_CAMERA = 1;
    private String token = "";
    private String tokenanterior = "";
    public TakeAssistanceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TakeAssistanceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TakeAssistanceFragment newInstance(String param1, String param2) {
        TakeAssistanceFragment fragment = new TakeAssistanceFragment();
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
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_take_assistance, container, false);
        Button button=(Button)view.findViewById(R.id.take_assistanse_button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Log.d("click","button submit");
            }
        });
        Button button2=(Button)view.findViewById(R.id.go_to_camara);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("click","button cammera");

                Intent intent = new Intent(getContext(),QRActivity.class);
                startActivity(intent);



            }
        });

       // Button botonQr = (Button) view.findViewById(R.id.go_to_camara);
        //botonQr.setOnClickListener(new View.OnClickListener(){
          //  @Override
           // public void onClick(View view) {
             //   Intent intent = new Intent(,QRActivity.class);
            //}
       // });



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
       //     throw new RuntimeException(context.toString()
         //           + " must implement OnFragmentInteractionListener");
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