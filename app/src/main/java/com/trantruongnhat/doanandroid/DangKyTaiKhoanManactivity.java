package com.trantruongnhat.doanandroid;

import android.content.Intent;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.trantruongnhat.doanandroid.MainActivity;

public class DangKyTaiKhoanManactivity extends AppCompatActivity {
    EditText edt1,edt2,edt3,edt4,edt5;
    Button btnDangKiTaiKhoanHeThong,btnQuayLaiTrangDangNhap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);

        AnhXa();

        btnDangKiTaiKhoanHeThong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edt1.length() == 0){
                    Toast.makeText(DangKyTaiKhoanManactivity.this, "Bạn chưa nhập Gmail", Toast.LENGTH_SHORT).show();
                }else if(edt2.length() == 0){
                    Toast.makeText(DangKyTaiKhoanManactivity.this, "Bạn chưa nhập số điện thoại", Toast.LENGTH_SHORT).show();
                }else if(edt3.length() == 0){
                    Toast.makeText(DangKyTaiKhoanManactivity.this, "Bạn chưa nhập UserName", Toast.LENGTH_SHORT).show();
                }else if(edt4.length() == 0){
                    Toast.makeText(DangKyTaiKhoanManactivity.this, "Bạn chưa nhập mật khẩu", Toast.LENGTH_SHORT).show();
                }else if(edt5.length() == 0){
                    Toast.makeText(DangKyTaiKhoanManactivity.this, "Bạn chưa nhâp lại mật khẩu", Toast.LENGTH_SHORT).show();
                }else if(edt4.getText().toString().equals(edt5.getText().toString()) == false){
                    Toast.makeText(DangKyTaiKhoanManactivity.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(DangKyTaiKhoanManactivity.this, "Bạn đã đăng kí thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnQuayLaiTrangDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangKyTaiKhoanManactivity.this , MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void AnhXa(){

        btnDangKiTaiKhoanHeThong = (Button) findViewById(R.id.DangKyTaiKhoan);
        btnQuayLaiTrangDangNhap = (Button) findViewById(R.id.QuayLaiTrangDangNhap);
        edt1 = (EditText) findViewById(R.id.Gmail);
        edt2 = (EditText) findViewById(R.id.NhapSoDT);
        edt3 = (EditText) findViewById(R.id.NhapUsernName);
        edt4 = (EditText) findViewById(R.id.NhapPassWord);
        edt5 = (EditText) findViewById(R.id.NhapLaiPassWord);
    }
}
