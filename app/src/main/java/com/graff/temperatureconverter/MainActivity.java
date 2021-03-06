package com.graff.temperatureconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.inputValue);
    }

    public void onClick(View view) {

        Log.d("MainActivity", "Entered onClick()");

        switch (view.getId()) {

            case R.id.button1:
                RadioButton celsiusButton = (RadioButton) findViewById(R.id.radio0);
                RadioButton fahrenheitButton = (RadioButton) findViewById(R.id.radio1);
                TextView degreeLabel = (TextView) findViewById(R.id.degreeLabel);

                /* Invalid numbers will have a length of 0; recognize and remind user to use numbers */
                if (text.getText().length() == 0) {
                    Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_LONG).show();
                    return;
                }

                float inputValue = Float.parseFloat(text.getText().toString());

                if (celsiusButton.isChecked()) {
                    text.setText(String.valueOf(ConverterUtil.convertFahrenheitToCelsius(inputValue)));
                    celsiusButton.setChecked(false);
                    fahrenheitButton.setChecked(true);
                    degreeLabel.setText(R.string.degreesC);
                }
                else {
                    text.setText(String.valueOf(ConverterUtil.convertCelsiusToFahrenheit(inputValue)));
                    fahrenheitButton.setChecked(false);
                    celsiusButton.setChecked(true);
                    degreeLabel.setText(R.string.degreesF);
                }
                break;
        }
    }

    public void onRadioClick(View view) {

        Log.d("MainActivity", "Entered onRadioClick()");

        RadioButton celsiusButton = (RadioButton) findViewById(R.id.radio0);
        RadioButton fahrenheitButton = (RadioButton) findViewById(R.id.radio1);
        TextView degreeLabel = (TextView) findViewById(R.id.degreeLabel);

        if (celsiusButton.isChecked()) {
            degreeLabel.setText(R.string.degreesF);
        }
        else {
            degreeLabel.setText(R.string.degreesC);
        }
    }

}
