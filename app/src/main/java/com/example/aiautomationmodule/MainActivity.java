    package com.example.aiautomationmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextOne;
    EditText editTextTwo;
    Button buttonOne;
    TextView textViewOne;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextOne=(EditText)findViewById(R.id.et_email);
        editTextTwo=(EditText)findViewById(R.id.et_pass);
        buttonOne=(Button)findViewById(R.id.btn1);
        textViewOne=(TextView)findViewById(R.id.tv_goto_signin);


        textViewOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(i);
            }
        });

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail = editTextOne.getText().toString();
                String pass = editTextTwo.getText().toString();
                if(mail.equals("bhatnagaryash01@gmail.com")  && pass.equals("12345678")){
                    Intent i = new Intent(MainActivity.this,BrowseActivity.class);
                    startActivity(i);
                }else {
                    Toast.makeText(MainActivity.this,
                            "User doesn't exists",
                            Toast.LENGTH_LONG).show();
                }

                editTextOne.setText("");
                editTextTwo.setText("");
            }
        });

    }

}