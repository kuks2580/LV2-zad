package com.example.igor.lv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class WeightConversion extends AppCompatActivity {

    EditText editText;
    Spinner format1;
    Spinner format2;
    Button converter;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_conversion);

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
            case "Kilograms": {
                switch (format2) {
                    case "Kilograms":
                        value = value;
                        break;
                    case "Grams":

                        value = value * 1000;
                        break;
                    case "Pounds":

                        value = value * 2.20462262;
                        break;
                    case "Ounces":

                        value = value * 35.2739619;
                        break;
                }
                break;
            }

            case "Grams": {
                switch (format2) {
                    case "Kilograms":
                        value = value / 1000;
                        break;
                    case "Grams":

                        value = value;
                        break;
                    case "Pounds":
                        value = value * 0.00220462262;
                        break;
                    case "Ounces":

                        value = value * 0.0352739619;
                        break;
                }
                break;
            }

            case "Pounds": {
                switch (format2) {
                    case "Kilograms":
                        value = value * 0.45359237;
                        break;
                    case "Grams":

                        value = value* 453.59237 ;
                        break;
                    case "Pounds":
                        value = value;
                        break;
                    case "Ounces":
                        value = value * 16;
                        break;
                }
                break;
            }

            case "Ounces": {
                switch (format2) {
                    case "Kilograms":
                        value = value * 0.0283495231;
                        break;
                    case "Grams":

                        value = value* 28.3495231;
                        break;
                    case "Pounds":
                        value = value*0.0625;
                        break;
                    case "Ounces":
                        value = value;
                        break;
                }
                break;
            }
        }
        return value;
    }
}
