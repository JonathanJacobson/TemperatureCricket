package com.anyitrecruitment.temperaturecricket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText etNumber;
    Button btnCalculate;
    TextView tvTemperature;
    DecimalFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber = findViewById(R.id.etNumber);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvTemperature = findViewById(R.id.tvTemperature);

        tvTemperature.setVisibility(View.GONE);
        formatter = new DecimalFormat("#0.00");

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etNumber.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String chirpNumber = etNumber.getText().toString().trim();
                    int chirps = Integer.parseInt(chirpNumber);
                    double temperature = (chirps / 3.0) + 4;
                    String result = "The approximate temperature outside is: " + formatter.format(temperature) + "\u00B0" + "C";

                    tvTemperature.setText(result);
                    tvTemperature.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}