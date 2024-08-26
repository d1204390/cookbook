package com.example.bank;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Deposit extends AppCompatActivity {

    private TextView balanceTextView;
    private EditText amountEditText;
    private Button depositButton, withdrawButton;
    private int balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);

        // 初始化 UI 元素
        balanceTextView = findViewById(R.id.balanceTextView);
        amountEditText = findViewById(R.id.amountEditText);
        depositButton = findViewById(R.id.depositButton);
        withdrawButton = findViewById(R.id.withdrawButton);

        // 從 Intent 或其他來源獲取初始餘額
        balance = getIntent().getIntExtra("BALANCE_NTD", 0);
        balanceTextView.setText("NTD餘額: " + balance);

        // 存款按鈕點擊事件
        depositButton.setOnClickListener(v -> {
            int amount = Integer.parseInt(amountEditText.getText().toString());
            balance += amount;
            balanceTextView.setText("NTD餘額: " + balance);
        });

        // 提款按鈕點擊事件
        withdrawButton.setOnClickListener(v -> {
            int amount = Integer.parseInt(amountEditText.getText().toString());
            if (balance >= amount) {
                balance -= amount;
                balanceTextView.setText("NTD餘額: " + balance);
            } else {
                // 你可以在這裡添加提示，告知餘額不足
            }
        });
    }
}
