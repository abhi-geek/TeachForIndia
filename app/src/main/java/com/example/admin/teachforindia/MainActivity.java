package com.example.admin.teachforindia;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.lang.UCharacterEnums;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.text.TextUtilsCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.AuthUI.SignInIntentBuilder;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;import java.security.ProtectionDomain;

import static com.example.admin.teachforindia.R.id.text;
import static com.google.firebase.auth.FirebaseAuth.*;

public class MainActivity extends AppCompatActivity{

    private DatabaseReference mDatabase;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private EditText name;
    private EditText phone;
    private EditText email;
    private EditText message;
    private EditText locality;
    private Button submitBtn;
    int userId=0;
    User u1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = database.getReference("Volunteers");

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        locality = (EditText) findViewById(R.id.locality);
        message = (EditText) findViewById(R.id.message);
        submitBtn = (Button) findViewById(R.id.submit);
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        final Intent intent = new Intent(MainActivity.this,homePage.class);

        u1 = new User(name.getText().toString(),email.getText().toString(),phone.getText().toString(),locality.getText().toString(),message.getText().toString());

        submitBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            //String id=mDatabase.push().getKey();
                mDatabase.setValue(u1);
                //Toast.makeText(MainActivity.this, "Thank you for Signing Up!", Toast.LENGTH_LONG).show();
                name.setText("");
                email.setText("");
                phone.setText("");
                locality.setText("");
                message.setText("");
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
        });

        alertDialogBuilder.setMessage("Thank you for Signing Up. You will be informed about futher actions via Email.");
        alertDialogBuilder.setPositiveButton("yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(MainActivity.this,"Sign Up Successful!",Toast.LENGTH_LONG).show();
                        startActivity(intent);

                    }
                });

    }

}
