package com.example.bank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class NTDActivity extends AppCompatActivity {

    private double ntdBalance = 0.0;
    private EditText etAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ntdactivity);

        etAmount = findViewById(R.id.et_amount);
    }

    public void GoBack(View view) {
        try {
            String amountText = etAmount.getText().toString();
            if (amountText.isEmpty()) {
                Toast.makeText(this, "請輸入金額", Toast.LENGTH_SHORT).show();
                return;
            }

            double amount = Double.parseDouble(amountText);
            if (view.getId() == R.id.tontd) {
                ntdBalance += amount; // 存款
            } else if (view.getId() == R.id.ntdto) {
                if (ntdBalance >= amount) {
                    ntdBalance -= amount; // 提款
                } else {
                    Toast.makeText(this, "餘額不足", Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            TextView ntdBalanceView = findViewById(R.id.ntdBalance);
            ntdBalanceView.setText(String.valueOf(ntdBalance));

            // 返回結果到 MainActivity
            Intent resultIntent = new Intent();
            resultIntent.putExtra("ntdBalance", ntdBalance);
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
