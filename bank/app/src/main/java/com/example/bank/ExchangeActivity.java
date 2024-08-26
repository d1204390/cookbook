package com.example.bank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ExchangeActivity extends AppCompatActivity {

    private EditText etAmount, etRate;
    private double ntdBalance = 0.0;
    private double usdBalance = 0.0;
    private double jpyBalance = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);

        etAmount = findViewById(R.id.et_amount);
        etRate = findViewById(R.id.et_rate);

        // 從 MainActivity 接收台幣餘額
        Intent intent = getIntent();
        ntdBalance = intent.getDoubleExtra("ntdBalance", 0.0);
    }

    public void changeCoin(View view) {
        try {
            String amountText = etAmount.getText().toString();
            String rateText = etRate.getText().toString();
            if (amountText.isEmpty() || rateText.isEmpty()) {
                Toast.makeText(this, "請輸入金額和匯率", Toast.LENGTH_SHORT).show();
                return;
            }

            double amount = Double.parseDouble(amountText);
            double rate = Double.parseDouble(rateText);
            double result;

            if (view.getId() == R.id.tontd) {
                // 美金換新台幣
                result = amount * rate;
                ntdBalance += result;
                usdBalance += amount;
            } else {
                // 新台幣換美金
                result = amount / rate;
                if (ntdBalance >= amount) {
                    ntdBalance -= amount;
                    usdBalance += result;
                } else {
                    Toast.makeText(this, "台幣餘額不足，無法換匯", Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            TextView resultView = findViewById(R.id.result);
            resultView.setText(String.valueOf(result));

            // 更新台幣餘額和換匯結果，回傳給 MainActivity
            Intent resultIntent = new Intent();
            resultIntent.putExtra("ntdBalance", ntdBalance);
            resultIntent.putExtra("usdBalance", usdBalance);
            resultIntent.putExtra("jpyBalance", jpyBalance);
            setResult(RESULT_OK, resultIntent);
            finish(); // 結束活動並返回 MainActivity

        } catch (NumberFormatException e) {
            Toast.makeText(this, "請輸入有效的數字", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "發生錯誤", Toast.LENGTH_SHORT).show();
        }
    }
}
