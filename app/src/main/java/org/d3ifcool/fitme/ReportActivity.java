package org.d3ifcool.fitme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.prolificinteractive.materialcalendarview.CalendarDay;

import org.d3ifcool.fitme.adapter.AdapterListReport;
import org.d3ifcool.fitme.database.DbHelper;
import org.d3ifcool.fitme.model.DataListReport;

import java.util.ArrayList;

public class ReportActivity extends AppCompatActivity {
    private DrawerLayout myDrawer;
    private ActionBarDrawerToggle myToggle;
    private CalendarView calendarView;
    private TextView txtTanggal, txtBerat, txtGerakan;
    String bulan;
    int tgl, bln, thn;
    DbHelper dbHelper;
    protected Cursor cursorBrt, cursorGrkn;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<DataListReport> array = new ArrayList<>();
    private AdapterListReport adapterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);
        array.clear();

        myDrawer = findViewById(R.id.report_drawer);
        myToggle = new ActionBarDrawerToggle(this, myDrawer, R.string.open, R.string.close);
        myDrawer.addDrawerListener(myToggle);
        myToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.nv_report);
        setupDrawerContent(navigationView);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        txtTanggal = findViewById(R.id.txt_tanggal);
        txtBerat = findViewById(R.id.txt_Berat);
        CalendarDay cld = new CalendarDay();
        tgl = cld.getDay();
        bln = cld.getMonth();
        thn = cld.getYear();

        dbHelper = new DbHelper(getBaseContext());

        SQLiteDatabase dbhit = dbHelper.getReadableDatabase();
        try {
            cursorBrt = dbhit.rawQuery("SELECT berat FROM beratbadan where tanggal = "+tgl+";", null);
            cursorGrkn = dbhit.rawQuery("SELECT gerakan FROM gerakanselesai where tanggal = "+tgl+";", null);
            String tampilBrt = "", tampilGrkn = "";
            array.clear();
            for (int i = 0; i < cursorBrt.getCount(); i++) {
                cursorBrt.moveToPosition(i);
                tampilBrt = String.valueOf(cursorBrt.getInt(0)) + " Kg \n";
                txtBerat.setText(tampilBrt);
            }
//            for (int i = 0; i < cursorGrkn.getCount(); i++) {
//                cursorGrkn.moveToPosition(i);
//                tampilGrkn = String.valueOf(cursorGrkn.getString(1));
//            }
            for (int j = 0; j < cursorGrkn.getCount(); j++) {
                cursorGrkn.moveToPosition(j);
                tampilGrkn = String.valueOf(cursorGrkn.getString(0));
                array.add(new DataListReport(tampilGrkn));
            }
            cursorBrt.close();
            cursorGrkn.close();
            adapterList = new AdapterListReport(ReportActivity.this, array);
            adapterList.notifyDataSetChanged();
            recyclerView.setAdapter(adapterList);
            recyclerView.setLayoutManager(new LinearLayoutManager(ReportActivity.this));
        }catch (SQLException e)
        {
            txtBerat.setText("-");
            txtGerakan.setText("-");
        }

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                switch (i1) {
                    case 1:
                        bulan = "Januari";
                        break;
                    case 2:
                        bulan = "Februari";
                        break;
                    case 3:
                        bulan = "Maret";
                        break;
                    case 4:
                        bulan = "April";
                        break;
                    case 5:
                        bulan = "Mei";
                        break;
                    case 6:
                        bulan = "Juni";
                        break;
                    case 7:
                        bulan = "Juli";
                        break;
                    case 8:
                        bulan = "Agustus";
                        break;
                    case 9:
                        bulan = "September";
                        break;
                    case 10:
                        bulan = "Oktober";
                        break;
                    case 11:
                        bulan = "November";
                        break;
                    case 12:
                        bulan = "Desember";
                        break;
                }
//                int result = Integer.valueOf(bulan);
//                String date = (result + 1) + "/" + i2 + "/" + i;
                txtTanggal.setText(String.valueOf(i2) + ", " + bulan + " " + String.valueOf(i));
                txtTanggal.setVisibility(View.VISIBLE);
                String tampilBrt = "", tampilGrkn = "";
                try {
                    SQLiteDatabase dbhit = dbHelper.getReadableDatabase();
                    cursorBrt = dbhit.rawQuery("SELECT berat FROM beratbadan where tanggal = "+String.valueOf(i2)+";", null);
                    cursorGrkn = dbhit.rawQuery("SELECT gerakan FROM gerakanselesai where tanggal = "+String.valueOf(i2)+";", null);
                    array.clear();
                    if (cursorBrt.getCount()==0)
                    {
                        txtBerat.setText("-");
                    }
                    if (cursorGrkn.getCount()==0)
                    {
                        array.add(new DataListReport("-"));
                    }
                    else {
                        cursorBrt.moveToPosition(cursorBrt.getCount()-1);
                        tampilBrt = String.valueOf(cursorBrt.getInt(0)) + " Kg \n";
                        for (int j = 0; j < cursorGrkn.getCount(); j++) {
                            cursorGrkn.moveToPosition(j);
                            tampilGrkn = String.valueOf(cursorGrkn.getString(0));
                            array.add(new DataListReport(tampilGrkn));
                        }
                        cursorBrt.close();
                        cursorGrkn.close();
                        txtBerat.setText(tampilBrt);
                    }
                    adapterList = new AdapterListReport(ReportActivity.this, array);
                    adapterList.notifyDataSetChanged();
                    recyclerView.setAdapter(adapterList);
                    recyclerView.setLayoutManager(new LinearLayoutManager(ReportActivity.this));
                }catch (SQLException e)
                {
                    Toast.makeText(ReportActivity.this, "kosong", Toast.LENGTH_SHORT).show();
                    txtBerat.setText("-");
                }


            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (myToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                selectItemDrawer(menuItem);
                return true;
            }
        });
    }

    private void selectItemDrawer(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_bmi:
                Intent bmiClass = new Intent(this, MainActivity.class);
                bmiClass.setFlags(bmiClass.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(bmiClass);
                finish();
                break;
            case R.id.menu_workout:
                Intent workout_class = new Intent(this, WorkoutActivity.class);
                workout_class.setFlags(workout_class.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(workout_class);
                finish();
                break;
            case R.id.menu_report:
                Intent report_class = new Intent(this, ReportActivity.class);
                report_class.setFlags(report_class.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(report_class);
                break;
            case R.id.menu_grafik:
                Intent grafik_class = new Intent(this, GrafikActivity.class);
                grafik_class.setFlags(grafik_class.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(grafik_class);
                finish();
                break;
            case R.id.menu_quiz:
                Intent quiz_class = new Intent(this, QuizActivity.class);
                quiz_class.setFlags(quiz_class.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(quiz_class);
                finish();
                break;
            case R.id.menu_video:
                Intent video_class = new Intent(this, ArticleActivity.class);
                video_class.setFlags(video_class.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(video_class);
                finish();
                break;
            case R.id.menu_about:
                Intent about_class = new Intent(this, AboutActivity.class);
                about_class.setFlags(about_class.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(about_class);
                finish();
                break;
        }
        myDrawer.closeDrawers();
    }

    @Override
    public void onBackPressed() {
        Intent back_class = new Intent(this, MainActivity.class);
        startActivity(back_class);
        finish();
    }
}


