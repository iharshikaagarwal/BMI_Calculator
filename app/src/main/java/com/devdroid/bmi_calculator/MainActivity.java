package com.devdroid.bmi_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textresult = findViewById(R.id.textresult);
        EditText edtheightinch = findViewById(R.id.edtheightinch);
        EditText edtheightft = findViewById(R.id.edtheightft);
        EditText edtweight = findViewById(R.id.edtweight);
        AppCompatButton btncal = findViewById(R.id.btncal);
        LinearLayout LinrMain = findViewById(R.id.LinrMain);

        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int wt = Integer.parseInt(edtweight.getText().toString());
                    int ft = Integer.parseInt(edtheightft.getText().toString());
                    int in = Integer.parseInt(edtheightinch.getText().toString());

                    // formula
                    int totalIn = ft * 12 + in;
                    double totalcm = totalIn * 2.54; // Correct conversion from inches to cm
                    double totalm = totalcm / 100;
                    double bmi = wt / (totalm * totalm);

                    if (bmi >= 25 && bmi <=29.9 ) {
                        textresult.setText("You are overweight");
                        LinrMain.setBackgroundColor(getResources().getColor(R.color.ColorOv));
                    } else if (bmi < 18.5 ) {
                        textresult.setText("You are underweight");
                        LinrMain.setBackgroundColor(getResources().getColor(R.color.ColorUm));
                    } else if (bmi>=18.5 && bmi<=24.9){
                        textresult.setText("You are healthy");
                        LinrMain.setBackgroundColor(getResources().getColor(R.color.ColorHealty));
                    }
                    else {
                        textresult.setText("Your are suffering from obesity");
                        LinrMain.setBackgroundColor(getResources().getColor(R.color.ColorObs));
                    }
                } catch (NumberFormatException e) {
                    textresult.setText("Please enter valid numbers");
                }
            }
        });
    }
}
