package com.example.travelabapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GroupActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton buttonMessage;
    private Button budgetButton;
    private Button locationButton;
    private Button flightsButton;
    private Button accommodationButton;
    private Button eventsButton;
    private FirebaseAuth firebaseAuth;
    public String gname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        buttonMessage = (ImageButton) findViewById(R.id.messageButton);
        buttonMessage.setOnClickListener(this);

        budgetButton = (Button) findViewById(R.id.budgetButton);
        budgetButton.setOnClickListener(this);

        locationButton = (Button) findViewById(R.id.locationButton);
        locationButton.setOnClickListener(this);

        flightsButton = (Button) findViewById(R.id.flightsButton);
        flightsButton.setOnClickListener(this);

        accommodationButton = (Button) findViewById(R.id.accommodationButton);
        accommodationButton.setOnClickListener(this);

        eventsButton = (Button) findViewById(R.id.eventsButton);
        eventsButton.setOnClickListener(this);

        firebaseAuth = firebaseAuth.getInstance();
        final FirebaseUser user = firebaseAuth.getCurrentUser();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        DatabaseReference ref2 = ref.child("Users").child(user.getDisplayName()).child("Group");

        ref2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                gname = dataSnapshot.getValue(String.class);
                Log.e("TIG", user.getDisplayName());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("TEG", "error");
            }
        });
    }

    @Override
    public void onClick(View view) {
        if(view == buttonMessage) {
            finish();
            startActivity(new Intent(this, MessageActivity.class));;
        }

        if(view == budgetButton) {
            Intent intent = new Intent(getBaseContext(), BudgetActivity.class);
            intent.putExtra("Group name", gname);
            Log.e("LOGGER", gname);
            finish();
            startActivity(intent);
        }

        if(view == locationButton) {
            finish();
            startActivity(new Intent(this, LocationActivity.class));;
        }

        if(view == flightsButton) {
            finish();
            startActivity(new Intent(this, FlightsActivity.class));;
        }

        if(view == accommodationButton) {
            finish();
            startActivity(new Intent(this, AccomidationActivity.class));;
        }

        if(view == eventsButton) {
            finish();
            startActivity(new Intent(this, EventsActivity.class));;
        }
    }
}
