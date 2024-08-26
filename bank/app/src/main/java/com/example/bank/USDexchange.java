package com.example.bank;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class USDexchange extends AppCompatActivity {

    private TextView titleTextView;
    private TextInputEditText amountEditText;
    private Button exchangeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usdexchange);

        // 初始化 UI 元素
        titleTextView = findViewById(R.id.textView3);
        amountEditText = findViewById(R.id.amountEditText);
        exchangeButton = findViewById(R.id.buttonExchange);

        // 換匯按鈕點擊事件
        exchangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amountText = amountEditText.getText().toString();
                if (!amountText.isEmpty()) {
                    int amount = Integer.parseInt(amountText);
                    // 這裡可以執行換匯邏輯，比如從美金換到新台幣
                    titleTextView.setText("成功換匯: " + amount + " 美金");
                }
            }
        });
    }
}
