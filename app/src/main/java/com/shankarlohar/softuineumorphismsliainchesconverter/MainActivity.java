package com.shankarlohar.softuineumorphismsliainchesconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView resultText;
    EditText inchesText;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setElement();
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inches = inchesText.getText().toString();
                if(inches.isEmpty()) Toast.makeText(MainActivity.this,"You haven't enterd any value..",Toast.LENGTH_LONG).show();
                else {
                    double toMeters = calculateMeterResult(inches);
                    displayResult(toMeters);
                }
            }
        });
    }

    private void setElement() {
        inchesText = findViewById(R.id.inchesEditText);
        calculateButton = findViewById(R.id.calculateButton);
        resultText = findViewById(R.id.resultTextView);
    }

    private double calculateMeterResult(String inches) {
        return Integer.parseInt(inches) * 0.0254;
    }

    private void displayResult(double toMeters) {
        DecimalFormat decimalFormatter = new DecimalFormat("0.00");
        String result = decimalFormatter.format(toMeters);
        resultText.setText("Given inches are equivalnet to " + result + " meters.");
    }
}