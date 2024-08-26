package com.example.bank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageView ntdImageView, usdImageView, jpyImageView;
    private TextView ntdBalanceTextView, usdBalanceTextView, jpyBalanceTextView;
    private Button ntdButton, usdButton, jpyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // 啟用沉浸式介面
        setContentView(R.layout.activity_main);

        // 初始化 UI 元素
        ntdImageView = findViewById(R.id.imageView);
        usdImageView = findViewById(R.id.imageView2);
        jpyImageView = findViewById(R.id.imageView3);

        ntdBalanceTextView = findViewById(R.id.textView);
        usdBalanceTextView = findViewById(R.id.textView2);
        jpyBalanceTextView = findViewById(R.id.textView4);

        ntdButton = findViewById(R.id.button3);
        usdButton = findViewById(R.id.button);
        jpyButton = findViewById(R.id.button2);

        // 設置按鈕點擊事件
        ntdButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Deposit.class);
            startActivity(intent);
        });

        usdButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, USDexchange.class);
            startActivity(intent);
        });

        jpyButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, JPYexchange.class);
            startActivity(intent);
        });

        // 設置視窗邊到邊的介面
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
