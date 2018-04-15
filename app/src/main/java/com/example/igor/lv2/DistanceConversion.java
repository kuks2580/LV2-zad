package com.example.igor.lv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class DistanceConversion extends AppCompatActivity {

    EditText editText;
    Spinner format1;
    Spinner format2;
    Button converter;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance_conversion);

        setUpUi();

    }

    public void setUpUi(){
        editText = (EditText) findViewById(R.id.editText);
        format1 = (Spinner) findViewById(R.id.format1);
        format2 = (Spinner) findViewById(R.id.format2);
        converter = (Button) findViewById(R.id.converter);
        result = (TextView) findViewById(R.id.resultTextView);

        converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first = format1.getSelectedItem().toString();
                String second = format2.getSelectedItem().toString();
                double value = Double.parseDouble(editText.getText().toString());
                double convertedValue = convert(first, second, value);
                result.setText(value+" "+first+" = "+convertedValue+" "+second);
            }
        });
    }

    public double convert(String format1, String format2, double value) {

        switch (format1) {
            case "Kilometers": {
                switch (format2) {
                    case "Kilometers":
                        value = value;
                        break;
                    case "Meters":

                        value = value * 1000;
                        break;
                    case "Miles":

                        value = value * 0.621371192;
                        break;
                    case "Feets":

                        value = value * 3280.8399;
                        break;
                }
                break;
            }

            case "Meters": {
                switch (format2) {
                    case "Kilometers":
                        value = value / 1000;
                        break;
                    case "Meters":

                        value = value;
                        break;
                    case "Miles":
                        value = value * 0.000621371192;
                        break;
                    case "Feets":

                        value = value * 3.2808399;
                        break;
                }
                break;
            }

            case "Miles": {
                switch (format2) {
                    case "Kilometers":
                        value = value * 1.609344;
                        break;
                    case "Meters":

                        value = value* 1609.344;
                        break;
                    case "Miles":
                        value = value;
                        break;
                    case "Feets":
                        value = value * 5280;
                        break;
                }
                break;
            }

            case "Feet": {
                switch (format2) {
                    case "Kilometers":
                        value = value * 0.0003048;
                        break;
                    case "Meters":

                        value = value* 0.3048;
                        break;
                    case "Miles":
                        value = value*0.000189393939;
                        break;
                    case "Feets":
                        value = value;
                        break;
                }
                break;
            }
        }
        return value;
    }
}
