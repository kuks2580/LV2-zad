package com.example.igor.lv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class VolumeConversion extends AppCompatActivity {

    EditText editText;
    Spinner format1;
    Spinner format2;
    Button converter;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume_conversion);

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
            case "KM^3": {
                switch (format2) {
                    case "KM^3":
                        value = value;
                        break;
                    case "M^3":
                        value = value* 1000000000;
                        break;
                    case "L":
                        value = value *1000000000;
                        break;
                    case "mL":
                        value = value * 1000000000;
                        break;
                }
                break;
            }

            case "M^3": {
                switch (format2) {
                    case "KM^3":
                        value = value * 0.000000001;
                        break;
                    case "M^3":
                        value = value;
                        break;
                    case "L":
                        value = value * 1000;
                        break;
                    case "mL":

                        value = value * 1000000;
                        break;
                }
                break;
            }

            case "L": {
                switch (format2) {
                    case "KM^3":
                        value = value * 0.000000000001;
                        break;
                    case "M^3":
                        value = value* 0.001;
                        break;
                    case "L":
                        value = value;
                        break;
                    case "mL":
                        value = value * 1000;
                        break;
                }
                break;
            }

            case "mL": {
                switch (format2) {
                    case "KM^3":
                        value = value * 0.0000000000001;
                        break;
                    case "M^3":
                        value = value* 0.000001;
                        break;
                    case "L":
                        value = value / 1000;
                        break;
                    case "mL":
                        value = value;
                        break;
                }
                break;
            }
        }
        return value;
    }

}
