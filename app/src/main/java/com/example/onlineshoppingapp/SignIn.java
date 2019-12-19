package com.example.onlineshoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlineshoppingapp.Common.Common;
import com.example.onlineshoppingapp.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignIn extends AppCompatActivity {
    EditText editUserName, editPassword;
    Button btnSignIn, btnForgetPassword;
    SharedPreferences myPrefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        myPrefs = getSharedPreferences("prefID", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = myPrefs.edit();


        editUserName = (MaterialEditText) findViewById(R.id.edtUserName);
        editPassword = (MaterialEditText) findViewById(R.id.edtPassword);
        btnSignIn = (Button)findViewById(R.id.btnSignIn);

        //init firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnForgetPassword = (Button) findViewById(R.id.btnForgetPassword);

        btnForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog =  new ProgressDialog(SignIn.this);
                mDialog.setMessage("Please Waiting..");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if(dataSnapshot.child(editUserName.getText().toString()).exists()) {
                            mDialog.dismiss();
                            User user = dataSnapshot.child(editUserName.getText().toString()).getValue(User.class);
                            Toast.makeText(SignIn.this, user.password, Toast.LENGTH_LONG).show();

                        } else {
                            mDialog.dismiss();
                            Toast.makeText(SignIn.this, "User not exist", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog =  new ProgressDialog(SignIn.this);
                mDialog.setMessage("Please Waiting..");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if(dataSnapshot.child(editUserName.getText().toString()).exists()) {
                            mDialog.dismiss();
                            User user = dataSnapshot.child(editUserName.getText().toString()).getValue(User.class);
                            if(user.password.equals(editPassword.getText().toString())) {
                                Toast.makeText(SignIn.this, "Susccfully", Toast.LENGTH_LONG).show();
                                Common.currentUser = user;
                                Intent homeIntent = new Intent(SignIn.this, Home.class);
                                startActivity(homeIntent);
                            } else {
                                Toast.makeText(SignIn.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            mDialog.dismiss();
                            Toast.makeText(SignIn.this, "User not exist", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });


    }
}
