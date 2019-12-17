package com.example.onlineshoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.onlineshoppingapp.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignUp extends AppCompatActivity {

    MaterialEditText editFullName, editUserName, editEmail, edtPassword, edtPassword2, edtPhone ;
    Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editFullName = (MaterialEditText) findViewById(R.id.edtFullName);
        editUserName = (MaterialEditText) findViewById(R.id.edtUserName);
        edtPassword = (MaterialEditText) findViewById(R.id.edtPassword);
        edtPassword2 = (MaterialEditText) findViewById(R.id.edtPassword2);
        editEmail = (MaterialEditText) findViewById(R.id.edtEmail);
        edtPhone = (MaterialEditText) findViewById(R.id.edtPhone);
        btnSignUp = (Button)findViewById(R.id.btnSignUp);
        //init firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog =  new ProgressDialog(SignUp.this);
                mDialog.setMessage("Please Waiting..");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(editUserName.getText().toString()).exists()) {
                            mDialog.dismiss();
                            Toast.makeText(SignUp.this, "User Already Exist", Toast.LENGTH_SHORT).show();
                        } else {
                            mDialog.dismiss();
                            User user = new User(editFullName.getText().toString(), edtPhone.getText().toString(), edtPassword.getText().toString(), editEmail.getText().toString());
                            table_user.child(editUserName.getText().toString()).setValue(user);
                            Toast.makeText(SignUp.this, "User Created", Toast.LENGTH_SHORT).show();
                            finish();
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
