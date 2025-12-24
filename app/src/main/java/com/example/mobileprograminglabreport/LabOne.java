package com.example.mobileprograminglabreport;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

class MainActivity extends AppCompatActivity
{

    TextView txtResult;
    double num1 = 0;
    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_one);
        txtResult = findViewById(R.id.txtResult);
    }

    public void numberClick(View view) {
        Button b = (Button) view;
        if (txtResult.getText().toString().equals("0"))
            txtResult.setText(b.getText().toString());
        else
            txtResult.append(b.getText().toString());
    }

    public void operatorClick(View view) {
        Button b = (Button) view;
        num1 = Double.parseDouble(txtResult.getText().toString());
        operator = b.getText().toString();
        txtResult.setText("0");
    }

    public void equalClick(View view) {
        double num2 = Double.parseDouble(txtResult.getText().toString());
        double result = 0;

        switch (operator) {
            case "+": result = num1 + num2; break;
            case "-": result = num1 - num2; break;
            case "*": result = num1 * num2; break;
            case "/": result = num1 / num2; break;
        }

        txtResult.setText(String.valueOf(result));
    }

    public void clearClick(View view) {
        txtResult.setText("0");
        num1 = 0;
        operator = "";
    }
}
