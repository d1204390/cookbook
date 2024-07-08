package com.example.temperatureapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextCelsius;
    private EditText editTextFahrenheit;
    private TextView textViewFahrenheitResult;
    private TextView textViewCelsiusResult;
    private Button buttonToFahrenheit;
    private Button buttonToCelsius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 初始化UI元件
        editTextCelsius = findViewById(R.id.editTextCelsius);
        editTextFahrenheit = findViewById(R.id.editTextFahrenheit);
        textViewFahrenheitResult = findViewById(R.id.textViewFahrenheitResult);
        textViewCelsiusResult = findViewById(R.id.textViewCelsiusResult);
        buttonToFahrenheit = findViewById(R.id.buttonToFahrenheit);
        buttonToCelsius = findViewById(R.id.buttonToCelsius);

        // 設置按鈕點擊事件
        buttonToFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String celsiusInput = editTextCelsius.getText().toString();
                if (!celsiusInput.isEmpty()) {
                    double celsius = Double.parseDouble(celsiusInput);
                    double fahrenheit = celsiusToFahrenheit(celsius);
                    textViewFahrenheitResult.setText("華氏溫度: " + String.format("%.2f", fahrenheit));
                } else {
                    Toast.makeText(MainActivity.this, "請輸入攝氏溫度", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonToCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fahrenheitInput = editTextFahrenheit.getText().toString();
                if (!fahrenheitInput.isEmpty()) {
                    double fahrenheit = Double.parseDouble(fahrenheitInput);
                    double celsius = fahrenheitToCelsius(fahrenheit);
                    textViewCelsiusResult.setText("攝氏溫度: " + String.format("%.2f", celsius));
                } else {
                    Toast.makeText(MainActivity.this, "請輸入華氏溫度", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private double celsiusToFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    private double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
