package com.example.bank;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class JPYexchange extends AppCompatActivity {

    private TextView balanceTextView;
    private EditText amountEditText;
    private Button exchangeButton;
    private int balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jpyexchange);

        // 初始化 UI 元素
        balanceTextView = findViewById(R.id.balanceTextView);
        amountEditText = findViewById(R.id.amountEditText);
        exchangeButton = findViewById(R.id.exchangeButton);

        // 從 Intent 或其他來源獲取初始餘額
        balance = getIntent().getIntExtra("BALANCE_JPY", 0);
        balanceTextView.setText("JPY餘額: " + balance);

        // 換匯按鈕點擊事件
        exchangeButton.setOnClickListener(v -> {
            int amount = Integer.parseInt(amountEditText.getText().toString());
            if (balance >= amount) {
                balance -= amount;
                balanceTextView.setText("JPY餘額: " + balance);
                // 你可以在這裡處理換匯操作，例如將日圓轉換為新台幣
            } else {
                // 你可以在這裡添加提示，告知餘額不足
            }
        });
    }
}
