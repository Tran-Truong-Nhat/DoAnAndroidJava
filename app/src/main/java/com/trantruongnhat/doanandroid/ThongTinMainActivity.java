package com.trantruongnhat.doanandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.GravityInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class ThongTinMainActivity extends AppCompatActivity {

//    Button DangXuat;

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    //NavigationView navigationView;
    ListView lv;

    ArrayList<DongMenuActivity> dongMenuList;
    MenuAdapter menuAdapterBai2;

    GridView gridViewKhachSan;
    ArrayList<GridviewKhachSanActivity> gridviewKhachSanActivityArrayList;
    GridviewKhachSanAdapter gridviewKhachSanAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtin);

        AnhXa();
        actionToolBar();
        actionMenu();
        actionGridviewKhachSan();
        menuAdapterBai2 = new MenuAdapter(this,R.layout.activity_menu_adapter,dongMenuList);
        lv.setAdapter(menuAdapterBai2);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.setClassName("com.android.settings", "com.android.settings.LanguageSettings");
                    startActivity(intent);
                }else if(i == 1){
                    Intent intentMess = new Intent();
                    intentMess.setAction(Settings.ACTION_SETTINGS);
                    startActivity(intentMess);
                }else {
                    Intent intent = new Intent(ThongTinMainActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        gridviewKhachSanAdapter = new GridviewKhachSanAdapter(this,R.layout.activity_gridview_khachsan,gridviewKhachSanActivityArrayList);
        gridViewKhachSan.setAdapter(gridviewKhachSanAdapter);

        gridViewKhachSan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(getApplicationContext(),DatPhongKhachSanActivity.class);
                    startActivity(intent);
            }
        });
    }

    private void actionMenu() {
        dongMenuList = new ArrayList<>();
        dongMenuList.add(new DongMenuActivity("\tNgôn Ngữ",R.drawable.ic_baseline_language_24));
        dongMenuList.add(new DongMenuActivity("Cài Đặt",R.drawable.ic_baseline_settings_24));
        dongMenuList.add((new DongMenuActivity("Đăng Xuất",R.drawable.ic_baseline_logout_24)));

    }

    private void actionToolBar() {
        setSupportActionBar(toolbar);
 //       getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

//    private void setSupportActionBar(Toolbar toolbar) {
//    }

    private void AnhXa() {
//        DangXuat = (Button) findViewById(R.id.MenuDangXuatID);
        toolbar = (Toolbar) findViewById(R.id.ToolBar1ID);
        drawerLayout = (DrawerLayout) findViewById(R.id.DrawerID);
       // navigationView = (NavigationView) findViewById(R.id.NavigationID);
        lv = (ListView) findViewById(R.id.ListViewID);

        gridViewKhachSan = (GridView) findViewById(R.id.Gridview1);

    }

    private void actionGridviewKhachSan(){
        gridviewKhachSanActivityArrayList = new ArrayList<>();
        gridviewKhachSanActivityArrayList.add(new GridviewKhachSanActivity(R.drawable.ks1,"Lotte Hotel"));
        gridviewKhachSanActivityArrayList.add(new GridviewKhachSanActivity(R.drawable.ks2,"Beach Resort"));
        gridviewKhachSanActivityArrayList.add(new GridviewKhachSanActivity(R.drawable.ks3,"Vinpearl Resort"));
        gridviewKhachSanActivityArrayList.add(new GridviewKhachSanActivity(R.drawable.ks4,"Salinda PQ"));
        gridviewKhachSanActivityArrayList.add(new GridviewKhachSanActivity(R.drawable.ks5,"Sheraton Grand"));
        gridviewKhachSanActivityArrayList.add(new GridviewKhachSanActivity(R.drawable.ks1,"Anantara Ho An"));
        gridviewKhachSanActivityArrayList.add(new GridviewKhachSanActivity(R.drawable.ks7,"Sofitel Legend"));
        gridviewKhachSanActivityArrayList.add(new GridviewKhachSanActivity(R.drawable.ks14,"Angsana Lang "));
        gridviewKhachSanActivityArrayList.add(new GridviewKhachSanActivity(R.drawable.ks9,"Waverly Phu Quoc Island"));
        gridviewKhachSanActivityArrayList.add(new GridviewKhachSanActivity(R.drawable.ks10," Residences"));
        gridviewKhachSanActivityArrayList.add(new GridviewKhachSanActivity(R.drawable.ks11,"Cheraton SG"));
        gridviewKhachSanActivityArrayList.add(new GridviewKhachSanActivity(R.drawable.ks12,"Vinpearl Resort"));
        gridviewKhachSanActivityArrayList.add(new GridviewKhachSanActivity(R.drawable.ks13,"Premier Village"));
        gridviewKhachSanActivityArrayList.add(new GridviewKhachSanActivity(R.drawable.ks14,"Vinpearl Resort"));
        gridviewKhachSanActivityArrayList.add(new GridviewKhachSanActivity(R.drawable.ks15,"Meliá Vinpearl"));
        gridviewKhachSanActivityArrayList.add(new GridviewKhachSanActivity(R.drawable.ks1,"LOTTE HOTEL"));
        gridviewKhachSanActivityArrayList.add(new GridviewKhachSanActivity(R.drawable.ks2,"Fusion Suites"));
        gridviewKhachSanActivityArrayList.add(new GridviewKhachSanActivity(R.drawable.ks3,"The Anam"));


    }

    //Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.MenuTroGiupID:
                Intent intentQuestion = new Intent();
                intentQuestion.setAction(Intent.ACTION_VIEW);
                intentQuestion.setData(Uri.parse("https://hotelcareers.vn/quy-trinh-dat-phong-khach-san.html"));
                startActivity(intentQuestion);
                break;

        }
        return super.onOptionsItemSelected(item);
    }


}

