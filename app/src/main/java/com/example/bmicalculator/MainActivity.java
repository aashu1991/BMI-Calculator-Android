package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText_age, editText_height, editText_weight;
    Button button_cal, button_clear;
    Spinner spinner;
    TextView textView_bmiValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_age = findViewById(R.id.editText_age);
        editText_height = findViewById(R.id.editText_height);
        editText_weight = findViewById(R.id.editText_weight);
        textView_bmiValue = findViewById(R.id.textView_bmiValue);
        button_cal = findViewById(R.id.button_cal);
        button_clear = findViewById(R.id.button_clear);
        spinner = findViewById(R.id.spinner);

        button_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner.getSelectedItem().toString();
                String string_age = editText_age.getText().toString().trim();
                int age = Integer.parseInt(string_age);

                String string_height = editText_height.getText().toString().trim();
                double height = Double.parseDouble(string_height);
                double height_m = height/100;

                String string_weight = editText_weight.getText().toString().trim();
                double weight = Double.parseDouble(string_weight);

                String string_bmiValue = String.valueOf((weight)/(height_m*height_m));
                double bmiValue  = Double.parseDouble(string_bmiValue);

                if (bmiValue<18.5) {
                    textView_bmiValue.setText("Underweight");
                }
                else if (bmiValue >= 18.5 && bmiValue < 25) {
                    textView_bmiValue.setText("Normal");
                }
                else if (bmiValue >= 25 && bmiValue < 30) {
                    textView_bmiValue.setText("Overweight");
                }
//                else if (bmiValue >= 18.5 && bmiValue < 25) {
//                    textView_bmiValue.setText("Normal");
//                }
//                else if (bmiValue >= 25 && bmiValue < 30) {
//                    textView_bmiValue.setText("Overweight");
//                }
//                else if (bmiValue >=30 && bmiValue < 35) {
//                    textView_bmiValue.setText("Obese Class 1");
//                }
//                else if (bmiValue >=35 && bmiValue < 40) {
//                    textView_bmiValue.setText("Obese Class 2");
//                }
                else if (bmiValue >= 30){
                    textView_bmiValue.setText("Obesity");
                }
            }
        });

        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText_age.setText("");
                editText_height.setText("");
                editText_weight.setText("");
                textView_bmiValue.setText("");
                spinner.setSelection(0);

            }
        });

    }
}