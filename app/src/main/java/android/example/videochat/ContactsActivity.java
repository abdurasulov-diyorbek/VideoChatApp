package android.example.videochat;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class ContactsActivity extends AppCompatActivity {

    BottomNavigationView navView;
    RecyclerView myContactsList;
    ImageView findPeopleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        myContactsList = findViewById(R.id.contact_list);
        findPeopleBtn = findViewById(R.id.find_people_btn);
        myContactsList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        findPeopleBtn.setOnClickListener(view -> {
            Intent findPeopleIntent = new Intent(ContactsActivity.this, FindPeopleActivity.class);
            startActivity(findPeopleIntent);
        });

    }
    
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch(item.getItemId())
            {
                case R.id.navigation_home:
                    Intent mainIntent = new Intent(ContactsActivity.this, ContactsActivity.class);
                    startActivity(mainIntent);
                    break;

                case R.id.navigation_settings:
                    Intent settingsIntent = new Intent(ContactsActivity.this, SettingsActivity.class);
                    startActivity(settingsIntent);
                    break;

                case R.id.navigation_notifications:
                    Intent notificationIntent = new Intent(ContactsActivity.this, NotificationsActivity.class);
                    startActivity(notificationIntent);
                    break;

                case R.id.navigation_logouts:
                    FirebaseAuth.getInstance().signOut();
                    Intent logoutsIntent = new Intent(ContactsActivity.this, RegistrationActivity.class);
                    startActivity(logoutsIntent);
                    finish();
                    break;
            }
            return true;
        }
    };
}