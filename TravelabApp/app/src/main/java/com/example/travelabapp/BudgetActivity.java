package com.example.travelabapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.acl.Group;

public class BudgetActivity extends AppCompatActivity implements View.OnClickListener {
    public String name;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private EditText editText2;
    private TextView textView8, textView7, textView3;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        name = getIntent().getStringExtra("Group name");
        Log.e("LOG", name);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);

        firebaseAuth = firebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        submit = findViewById(R.id.submit);
        editText2 = findViewById(R.id.editText2);
        textView8 = findViewById(R.id.textView8);
        textView7 = findViewById(R.id.textView7);
        textView3 = findViewById(R.id.textView3);

        submit.setOnClickListener(this);
    }

    public void onClick(View view) {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        String money = editText2.getText().toString();

        if (view == submit) {
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
            if(name == null)
            {
                Log.e("LOG", "missing");
            }


            DatabaseReference ref2 = ref.child("Groups").child(name);
            ref2.child("Budget").child("1").setValue(money);
            ref2.child("Total Budget").setValue(money);
            ref2.child("Minimum Budget").setValue(money);

            setContentView(R.layout.activity_budgetshow);

            textView8.setText(money);
            textView7.setText(money);
            textView3.setText(money);

        }
    }
}
