package com.example.aiautomationmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText editTextMainOne;
    EditText editTextMainTwo;
    Button buttonMainOne;
    TextView textViewSignUpOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editTextMainOne=(EditText)findViewById(R.id.et_sign_up_1);
        editTextMainTwo=(EditText)findViewById(R.id.et__sign_up_2);
        editTextMainTwo=(EditText)findViewById(R.id.et__sign_up_3);
        buttonMainOne=(Button)findViewById(R.id.btn_sign_up_1);
        textViewSignUpOne=(TextView)findViewById(R.id.tv_goto_login);

        DBHelperClass DB = new DBHelperClass(this);

        textViewSignUpOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUpActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

        buttonMainOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = editTextMainOne.getText().toString();
                String pass = editTextMainTwo.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(SignUpActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(SignUpActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(SignUpActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}