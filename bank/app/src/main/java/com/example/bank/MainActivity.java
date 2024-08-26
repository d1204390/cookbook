package com.example.bank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private double ntdBalance = 0.0;
    private double usdBalance = 0.0;
    private double jpyBalance = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GotoNTD(View view) {
        Intent intent = new Intent(this, NTDActivity.class);
        intent.putExtra("ntdBalance", ntdBalance);
        startActivityForResult(intent, 1); // 啟動 NTDActivity 並等待結果
    }

    public void Exchange(View view) {
        Intent intent = new Intent(this, ExchangeActivity.class);
        intent.putExtra("ntdBalance", ntdBalance); // 傳遞台幣餘額給 ExchangeActivity
        startActivityForResult(intent, 2); // 啟動 ExchangeActivity 並等待結果
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1 || requestCode == 2) {
                // 更新台幣餘額
                ntdBalance = data.getDoubleExtra("ntdBalance", 0.0);
                TextView ntdBalanceView = findViewById(R.id.NTDbalance);
                ntdBalanceView.setText(String.valueOf(ntdBalance));

                // 如果是換匯操作，更新外幣餘額
                if (requestCode == 2) {
                    usdBalance = data.getDoubleExtra("usdBalance", usdBalance);
                    jpyBalance = data.getDoubleExtra("jpyBalance", jpyBalance);

                    TextView usdBalanceView = findViewById(R.id.usdBalance);
                    TextView jpyBalanceView = findViewById(R.id.jpyBalance);

                    usdBalanceView.setText(String.valueOf(usdBalance));
                    jpyBalanceView.setText(String.valueOf(jpyBalance));
                }
            }
        }
    }
}
