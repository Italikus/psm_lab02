package com.example.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private EditText value;
    private EditText res;
    private RadioGroup rg;

    Button button;

    double resultValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        value = (EditText) findViewById(R.id.editTextNumber);
        res = (EditText) findViewById(R.id.result);
        rg = (RadioGroup) findViewById(R.id.unitGroup);

        res.setFocusableInTouchMode(false);

        button = (Button) findViewById(R.id.runCalculate);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String radioChecked =
                        ((RadioButton) findViewById(rg.getCheckedRadioButtonId()))
                                .getText().toString();

                switch (radioChecked) {
                    case "cm":
                        resultValue = Double.parseDouble(value.getText().toString()) * 100.0;
                        break;
                    case "km":
                        resultValue = Double.parseDouble(value.getText().toString()) * 0.001;
                        break;
                    case "mile":
                        resultValue = Double.parseDouble(value.getText().toString()) * 0.000621371192;
                        break;
                    case "ly":
                        resultValue = Double.parseDouble(value.getText().toString()) * 1.057000834025e-16;
                        break;
                    default:
                        break;
                }
                res.setText(String.format("%.1f", resultValue));

            }
        });
    }

//    Button btn;

//    public void calculate(View view) {
//
//        final String radioChecked =
//                ((RadioButton) findViewById(rg.getCheckedRadioButtonId()))
//                        .getText().toString();
//
//        double resultValue = 0;
//        switch (radioChecked) {
//            case "cm":
//                resultValue = Double.parseDouble(String.valueOf(value)) * 100;
//                break;
//            case "km":
//                resultValue = Double.parseDouble(String.valueOf(value)) * 0.001;
//                break;
//            case "mile":
//                resultValue = Double.parseDouble(String.valueOf(value)) * 0.000621371192;
//                break;
//            case "ly":
//                resultValue = Double.parseDouble(String.valueOf(value)) * 1.057000834025e-16;
//                break;
//            default:
//                break;
//        }
//        res.setText((int) resultValue);
//    }
}