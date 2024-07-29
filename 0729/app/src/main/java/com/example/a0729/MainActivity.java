package com.example.a0729;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import static android.Manifest.permission.CALL_PHONE;
import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CALL_PHONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 當按下按鈕時打開逢甲大學官網
                String url = "https://www.fcu.edu.tw";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 當按下按鈕時打開逢甲大學地圖
                String geoUri = "geo:24.1816994,120.6472528?q=24.1816994,120.6472528(Feng Chia University)";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
                startActivity(intent);
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 當按下按鈕時直接撥打電話
                if (ContextCompat.checkSelfPermission(MainActivity.this, CALL_PHONE) != PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{CALL_PHONE}, REQUEST_CALL_PHONE);
                } else {
                    makePhoneCall();
                }
            }
        });
    }

    private void makePhoneCall() {
        String phone = "tel:0928455366"; // 替換為實際電話號碼
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse(phone));
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL_PHONE) {
            if (grantResults.length > 0 && grantResults[0] == PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(this, "撥打電話權限被拒絕", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
