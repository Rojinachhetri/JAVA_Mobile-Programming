package com.example.androidapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

     EditText nameEditText, emailEditText, mobileEditText;
     Spinner employeeTypeSpinner;
     CheckBox hourlyCheckBox, monthlyCheckBox;
     RadioButton radioButtonYes, radioButtonNo;
     Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.editTextText);
        emailEditText = findViewById(R.id.editTextText1);
        mobileEditText = findViewById(R.id.editTextText2);
        employeeTypeSpinner = findViewById(R.id.spinner_example1);
        hourlyCheckBox = findViewById(R.id.hourlyCheckBox);
        monthlyCheckBox = findViewById(R.id.monthlyCheckBox);
        radioButtonYes = findViewById(R.id.radioButton_yes);
        radioButtonNo = findViewById(R.id.radioButton_no);
        submitButton = findViewById(R.id.button);

        // Populate Spinner with data
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.employee_type_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        employeeTypeSpinner.setAdapter(adapter);

        // Handle Spinner item selection
        employeeTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Selected: " + selectedItem, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String mobile = mobileEditText.getText().toString();
                if (name.isEmpty() || email.isEmpty() || mobile.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    // You can add more validation for email and mobile formats here
                    Toast.makeText(MainActivity.this, "Account created for " + name + " with email " + email, Toast.LENGTH_SHORT).show();
                }
            }
        });

        radioButtonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Available for overtime", Toast.LENGTH_SHORT).show();
            }
        });

        radioButtonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Not available for overtime", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
