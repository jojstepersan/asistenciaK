package co.edu.konradlorenz.takeassistance.activities;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.Result;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import co.edu.konradlorenz.takeassistance.R;
import co.edu.konradlorenz.takeassistance.entities.Assistance;
import co.edu.konradlorenz.takeassistance.entities.Student;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QRActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{


    private ZXingScannerView scannerView;
    DatabaseReference database= FirebaseDatabase.getInstance().getReference();
    DatabaseReference ref=database.child("user/teacher/");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_take_assistance);
    }

    public void btnEscaner(View v){

        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }

    public static String result2;

    @Override
    public void handleResult(Result result) {

        result2 = result.getText();
        Log.v("HandleResult", result.getText());
        Log.v("resultado string",result2);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Resultado del scaner");
        builder.setMessage(result.getText());
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        scannerView.resumeCameraPreview(this);
        try {
            long id = Long.valueOf(result2.toString());
            Log.d("code", id + "");
            int i;
            boolean flag=true;
            for (i = 0; i < ClassesActivity.currentClass.getStudents().size(); i++) {
                Student currentStudent = ClassesActivity.currentClass.getStudents().get(i);
                Log.d("code", currentStudent.getName() + " code " + i);
                if (id == currentStudent.getCode()) {
                    if (currentStudent.getAssistances() == null)
                        currentStudent.setAssistances(new ArrayList<Assistance>());
                    currentStudent.getAssistances().add(new Assistance(new Date(), true));
                    ref.child(ClassesActivity.key).setValue(ClassesActivity.teacher);
                    Toast.makeText(this, "asistencia exitosa", Toast.LENGTH_SHORT).show();
                    break;
                }
                if(i==ClassesActivity.currentClass.getStudents().size()-1)
                    flag=true;
            }
            if (flag)
                Toast.makeText(this, "Este estudiante no es del grupo", Toast.LENGTH_SHORT).show();

            //  code.setHint("code");

        } catch (Exception e) {
            Toast.makeText(this, "solo valores numericos", Toast.LENGTH_SHORT).show();

        }
    }
}


