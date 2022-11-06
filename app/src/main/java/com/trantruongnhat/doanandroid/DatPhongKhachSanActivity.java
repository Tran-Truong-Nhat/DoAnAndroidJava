package com.trantruongnhat.doanandroid;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DatPhongKhachSanActivity extends AppCompatActivity {
    EditText edtChonNgayO,edtChonNgayDi;
    Calendar calendarone,calendartwo;
    Button btnTinhNgayO;
    TextView HienThiTongNgayO,TongTienO;

    EditText edtHoTen, edtSDT, edtCCCD;
    TextView txtHoTen, txtSDT, txtCCCD;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangdatphong);

        AnhXa();

        edtChonNgayO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChonNgay1();
            }
        });
        edtChonNgayDi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChonNgay2();
            }
        });

        btnTinhNgayO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int TongNgayO;
                TongNgayO = (int) ((calendartwo.getTimeInMillis() - calendarone.getTimeInMillis()) /(1000*60*60*24));
                float TinhTien = (float) (TongNgayO * 1.2);
                String HoTen = edtHoTen.getText().toString();
                String SDT = edtSDT.getText().toString();
                String CCCD = edtCCCD.getText().toString();
                if(TongNgayO < 0){
                    Toast.makeText(DatPhongKhachSanActivity.this, "Vui lòng nhập đúng thời gian xa nhau", Toast.LENGTH_SHORT).show();
                }
                else{
                    HienThiTongNgayO.setText("Bạn đã đặt ở khách sạn "+ TongNgayO + " Ngày!!!");
                    txtHoTen.setText("Họ Tên: " + HoTen);
                    txtSDT.setText("SĐT: " + SDT);
                    txtCCCD.setText("CMND/CCCD: " + CCCD);
                    TongTienO.setText("Số tiền phải thanh toán: " +TinhTien+" Triệu VNĐ");
                }
            }
        });
    }

    private void AnhXa(){
        edtChonNgayO = (EditText) findViewById(R.id.ChonNgayOID);
        edtChonNgayDi = (EditText) findViewById(R.id.ChonNgayDi);
        HienThiTongNgayO = (TextView) findViewById(R.id.IdHienThiThoiGianO);
        TongTienO = (TextView) findViewById(R.id.IdTinhTien);
        btnTinhNgayO = (Button) findViewById(R.id.IdDemNgayO);

        edtHoTen = (EditText) findViewById(R.id.IdNhapHoTen);
        edtSDT = (EditText) findViewById(R.id.IdNhapSoDienThoai);
        edtCCCD = (EditText) findViewById(R.id.IdNhapCCCD);

        txtHoTen = (TextView) findViewById(R.id.IdHoTen);
        txtSDT = (TextView) findViewById(R.id.IdSDT);
        txtCCCD = (TextView) findViewById(R.id.IdCCCD);



    }

    private void ChonNgay1(){
        calendarone = Calendar.getInstance();
        int Ngay = calendarone.get(Calendar.DATE);
        int Thang = calendarone.get(Calendar.MONTH);
        int Nam = calendarone.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendarone.set(i,i1,i2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                edtChonNgayO.setText(simpleDateFormat.format(calendarone.getTime()));
            }
        },Nam , Thang , Ngay);
        datePickerDialog.show();
    }
    private void ChonNgay2(){
        calendartwo = Calendar.getInstance();
        int Ngay = calendartwo.get(Calendar.DATE);
        int Thang = calendartwo.get(Calendar.MONTH);
        int Nam = calendartwo.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendartwo.set(i,i1,i2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                edtChonNgayDi.setText(simpleDateFormat.format(calendartwo.getTime()));
            }
        },Nam , Thang , Ngay);
        datePickerDialog.show();
    }
}
