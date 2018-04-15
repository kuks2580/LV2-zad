package com.example.igor.lv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class TemperatureConversion extends AppCompatActivity {

    EditText editText;
    Spinner format1;
    Spinner format2;
    Button converter;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_conversion);

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
            case "Celsius": {
                switch (format2) {
                    case "Celsius":
                        value = value;
                        break;
                    case "Fahrenheit":
                        value = value*9/5+32;
                        break;
                    case "Kelvin":
                        value = value + 273.15;
                        break;
                }
                break;
            }

            case "Fahrenheit": {
                switch (format2) {
                    case "Celsius":
                        value = (value - 32) * 5/9;
                        break;
                    case "Fahrenheit":
                        value = value;
                        break;
                    case "Kelvin":
                        value = (value + 459.67) * 5/9;
                        break;
                }
                break;
            }

            case "Kelvin": {
                switch (format2) {
                    case "Celsius":
                        value = value - 273.15;
                        break;
                    case "Fahrenheit":
                        value = value* 0.3048;
                        break;
                    case "Kelvin":
                        value = value * 9/5 - 459.67;
                        break;
                }
                break;
            }
        }
        return value;
    }

}
