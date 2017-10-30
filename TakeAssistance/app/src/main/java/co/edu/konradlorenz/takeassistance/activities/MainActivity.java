package co.edu.konradlorenz.takeassistance.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import co.edu.konradlorenz.takeassistance.R;
import co.edu.konradlorenz.takeassistance.fragments.ListClassesFragment;
import co.edu.konradlorenz.takeassistance.fragments.ListStudentFragment;
import co.edu.konradlorenz.takeassistance.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager manager=getSupportFragmentManager();
            FragmentTransaction transaction=manager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    transaction.replace(R.id.fragmento_activity_main,new ListClassesFragment()).commitNow();
                    return true;
                case R.id.navigation_dashboard:
                    transaction.replace(R.id.fragmento_activity_main,new ListStudentFragment()).commitNow();
                    return true;
                case R.id.navigation_notifications:
                    transaction.replace(R.id.fragmento_activity_main,new ProfileFragment()).commit();

                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
