package com.example.bank;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Deposit extends AppCompatActivity {

    private TextView titleTextView;
    private TextInputEditText amountEditText;
    private Button depositButton, withdrawButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);

        // 初始化 UI 元素
        titleTextView = findViewById(R.id.textView3);
        amountEditText = findViewById(R.id.amountEditText);  // 對應你的 TextInputEditText
        depositButton = findViewById(R.id.button4);
        withdrawButton = findViewById(R.id.button5);

        // 存款按鈕點擊事件
        depositButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amountText = amountEditText.getText().toString();
                if (!amountText.isEmpty()) {
                    int amount = Integer.parseInt(amountText);
                    // 這裡可以執行存款邏輯，比如更新餘額等
                    titleTextView.setText("成功存入: " + amount + " 新台幣");
                }
            }
        });

        // 提款按鈕點擊事件
        withdrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amountText = amountEditText.getText().toString();
                if (!amountText.isEmpty()) {
                    int amount = Integer.parseInt(amountText);
                    // 這裡可以執行提款邏輯，比如檢查餘額是否足夠，然後更新餘額
                    titleTextView.setText("成功提取: " + amount + " 新台幣");
                }
            }
        });
    }
}
