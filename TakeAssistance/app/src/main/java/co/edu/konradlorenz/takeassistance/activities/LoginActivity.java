package co.edu.konradlorenz.takeassistance.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import co.edu.konradlorenz.takeassistance.R;

public class LoginActivity extends AppCompatActivity {

    private Button buttonLogin;
    private EditText editTextUser;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Set up the login form.
        editTextUser = (EditText) findViewById(R.id.userEmail);
        editTextPassword = (EditText) findViewById(R.id.password);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener((OnClickListener) this);


    }

    private void userLogin(String userEmail, String pass) {


    }
}

