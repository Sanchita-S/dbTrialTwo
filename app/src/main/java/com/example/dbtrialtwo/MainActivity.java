package com.example.dbtrialtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtName, txtLast;
    Button btnSave, btnDisplay;
    DatabaseHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        txtName = (EditText) findViewById(R.id.txtName);
        txtLast = (EditText) findViewById(R.id.txtLast);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnDisplay = (Button) findViewById(R.id.btnDisplay);
        myDB = new DatabaseHelper(this);


        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewListContents.class);
                startActivity(intent);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname = txtName.getText().toString();
                String flast = txtLast.getText().toString();
                if (fname.length() != 0 && flast.length() != 0) {
                    AddData(fname, flast);
                    txtLast.setText("");
                    txtName.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "You must put something in the text field!", Toast.LENGTH_LONG).show();
                }
            }

        });
    }


            public void AddData(String firstName,String lastName){
                boolean insertData = myDB.addData(firstName,lastName);

                if(insertData==true){
                    Toast.makeText(MainActivity.this,"Successfully Entered Data!",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"Something went wrong :(.",Toast.LENGTH_LONG).show();
                }

    }
}