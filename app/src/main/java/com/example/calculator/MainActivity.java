package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextUtils;  // Added for easier null/empty checks

import com.example.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    public EditText e1, e2;
    public TextView t1;
    int num1, num2;

    // Method to validate and get the numbers from the input fields
    public boolean getNumbers() {
        e1 = findViewById(R.id.num1);
        e2 = findViewById(R.id.num2);
        t1 = findViewById(R.id.result);

        String s1 = e1.getText().toString().trim();
        String s2 = e2.getText().toString().trim();

        // Input validation
        if (TextUtils.isEmpty(s1)) {
            e1.setError("Please enter value 1");
            return false;
        }
        if (TextUtils.isEmpty(s2)) {
            e2.setError("Please enter value 2");
            return false;
        }

        try {
            // Convert input to integers
            num1 = Integer.parseInt(s1);
            num2 = Integer.parseInt(s2);
        } catch (NumberFormatException e) {
            t1.setText("Error: Invalid number format");
            return false;
        }

        return true;
    }

    public void doSum(View v) {
        if (getNumbers()) {
            int sum = num1 + num2;
            t1.setText(String.valueOf(sum));
        }
    }

    public void clearTextNum1(View v) {
        e1.getText().clear();
    }

    public void clearTextNum2(View v) {
        e2.getText().clear();
    }

    public void doPow(View v) {
        if (getNumbers()) {
            double result = Math.pow(num1, num2);
            t1.setText(String.valueOf(result));
        }
    }

    public void doSub(View v) {
        if (getNumbers()) {
            int result = num1 - num2;
            t1.setText(String.valueOf(result));
        }
    }

    public void doMul(View v) {
        if (getNumbers()) {
            int result = num1 * num2;
            t1.setText(String.valueOf(result));
        }
    }

    public void doDiv(View v) {
        if (getNumbers()) {
            if (num2 == 0) {
                t1.setText("Error: Division by zero");
            } else {
                double result = num1 / (num2 * 1.0);
                t1.setText(String.valueOf(result));
            }
        }
    }

    public void doMod(View v) {
        if (getNumbers()) {
            if (num2 == 0) {
                t1.setText("Error: Division by zero");
            } else {
                double result = num1 % num2;
                t1.setText(String.valueOf(result));
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize EditTexts and TextView
        e1 = findViewById(R.id.num1);
        e2 = findViewById(R.id.num2);
        t1 = findViewById(R.id.result);
    }
}