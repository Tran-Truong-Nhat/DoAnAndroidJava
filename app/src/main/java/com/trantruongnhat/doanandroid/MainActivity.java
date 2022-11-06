package com.trantruongnhat.doanandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt1 , edt2;
    Button btnDangNhap,btnTroGiup,btnQuenMatKhau;
    Button btnThoat;
    TextView txtDangKi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edt1.length() == 0){
                    Toast.makeText(MainActivity.this, "Bạn chưa nhập tài khoản", Toast.LENGTH_SHORT).show();
                }else if(edt1.length() < 5){
                    Toast.makeText(MainActivity.this, "Tài khoản chưa đủ độ dài", Toast.LENGTH_SHORT).show();
                }else if(edt2.length() == 0){
                    Toast.makeText(MainActivity.this, "Bạn chưa nhập mật khẩu", Toast.LENGTH_SHORT).show();
                }else if(edt2.length() < 5){
                    Toast.makeText(MainActivity.this, "Mật khẩu chưa đủ độ dài ", Toast.LENGTH_SHORT).show();
                } else{
                    Intent intent = new Intent(MainActivity.this, ThongTinMainActivity.class);
                    startActivity(intent);
                }
            }
        });
        txtDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DangKyTaiKhoanManactivity.class);
                startActivity(intent);
            }
        });
        btnQuenMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentForget = new Intent();
                intentForget.setAction(Intent.ACTION_VIEW);
                intentForget.setData(Uri.parse("https://support.google.com/accounts/answer/7682439?hl=vi"));
                startActivity(intentForget);
            }
        });
        btnTroGiup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Vui lòng liên hệ 09***", Toast.LENGTH_SHORT).show();
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_DeviceDefault_Dialog_Alert);
                builder.setTitle("Bạn chắc chắn muốn thoát ");
                builder.setMessage("Vui lòng chọn bên dưới");
                builder.setIcon(R.drawable.ic_baseline_warning_24);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finishAffinity();
                        System.exit(0);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });

    }


    private void AnhXa(){
        edt1 = (EditText) findViewById(R.id.Username);
        edt2 = (EditText) findViewById(R.id.Password);

        txtDangKi = (TextView) findViewById(R.id.DangKi);
        btnDangNhap = (Button) findViewById(R.id.Login);
        btnQuenMatKhau = (Button) findViewById(R.id.QuenMatKhau);
        btnTroGiup = (Button) findViewById(R.id.TroGiup) ;
        btnThoat = (Button) findViewById(R.id.Thoat);
    }
}