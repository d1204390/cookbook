package com.example.yourpackagename;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class CalculateBMIActivity extends AppCompatActivity {

    private EditText weightEditText;
    private EditText heightEditText;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_bmi);

        weightEditText = findViewById(R.id.editTextWeight);
        heightEditText = findViewById(R.id.editTextHeight);
        calculateButton = findViewById(R.id.buttonCalculate);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightStr = weightEditText.getText().toString();
        String heightStr = heightEditText.getText().toString();

        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            weightEditText.setError("請輸入體重");
            heightEditText.setError("請輸入身高");
            return;
        }

        double weight = Double.parseDouble(weightStr);
        double height = Double.parseDouble(heightStr);

        double bmi = weight / (height * height);
        String bmiCategory = getBMICategory(bmi);

        String result = String.format("您的BMI是：%.2f\n%s", bmi, bmiCategory);

        Intent resultIntent = new Intent();
        resultIntent.putExtra("bmiResult", result);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    private String getBMICategory(double bmi) {
        if (bmi < 18.5) {
            return "過輕";
        } else if (bmi >= 18.5 && bmi < 24) {
            return "正常範圍";
        } else if (bmi >= 24 && bmi < 27) {
            return "過重";
        } else if (bmi >= 27 && bmi < 30) {
            return "輕度肥胖";
        } else if (bmi >= 30 && bmi < 35) {
            return "中度肥胖";
        } else {
            return "重度肥胖";
        }
    }
}
1