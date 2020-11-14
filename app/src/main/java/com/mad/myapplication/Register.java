package com.mad.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

         EditText userName = (EditText) findViewById(R.id.etNewName);
         EditText password = (EditText) findViewById(R.id.etNewPassword);
         EditText email = (EditText) findViewById(R.id.etNewEmail);
         Button btnRegister = (Button)findViewById(R.id.btnNewRegister);



        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = userName.getText().toString();
                if (name.isEmpty()) {
                    userName.setError("Please fill the userName");
                    return;
                }

                String pass = password.getText().toString();
                if (pass.isEmpty()) {
                    password.setError("Please fill the password");
                    return;
                }

                String mail = email.getText().toString();
                if (mail.isEmpty()) {
                    email.setError("Please fill the Email");
                    return;
                }

                preferences = getSharedPreferences("Userinfo", 0);

                User user = new User(name, pass, mail);

                AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);
                builder.setTitle("Success");
                builder.setMessage("Congratulations you have successfully registered");
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Register.this, MainActivity.class);
                        intent.putExtra("Key_Name", user.getUsername());
                        intent.putExtra("Key_Email", user.getEmail());

                        startActivity(intent);


                    }
                });
                builder.show();

                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                String newUser = userName.getText().toString();
                String newPassword = password.getText().toString();
                String newEmail = email.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();

                editor.putString(newUser + newPassword + "data", newUser + "\n" + newEmail);
                editor.commit();


            }
        });


            }
        }
