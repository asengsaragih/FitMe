package org.d3ifcool.fitme;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
//import com.github.mikephil.charting.formatter.IAxisValueFormatter;
//import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.navigation.NavigationView;

import org.d3ifcool.fitme.database.DbHelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;


import java.util.ArrayList;


public class GrafikActivity extends AppCompatActivity {
    public GrafikActivity() {

    }
    private DrawerLayout myDrawer;
    private ActionBarDrawerToggle myToggle;

    BarChart chart;
    TextView emptyView, emptyView2;
    ArrayList<BarEntry> barEntries;
    ArrayList<String> barLabels;
    BarDataSet barDataSet;
    BarData barData;

    DbHelper dbHelper;
    protected Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafik);

        chart = (BarChart) findViewById(R.id.bargraph);
        emptyView = findViewById(R.id.empty_view);
        emptyView2= findViewById(R.id.empty_view2);

        emptyView.setVisibility(View.GONE);
        emptyView2.setVisibility(View.GONE);
        barEntries = new ArrayList<BarEntry>();
        barLabels = new ArrayList<String>();

        dbHelper = new DbHelper(this);

        SQLiteDatabase dbhit = dbHelper.getReadableDatabase();
        cursor = dbhit.rawQuery("SELECT * FROM beratbadan;", null);
        cursor.moveToFirst();

        if (cursor.getCount() == 0) {
            emptyView.setVisibility(View.VISIBLE);
            emptyView2.setVisibility(View.VISIBLE);
            chart.setVisibility(View.GONE);
        } else {
//            chart.getAxisLeft().setTextColor(Color.WHITE);
            chart.getAxisRight().setTextColor(Color.WHITE);
            chart.getXAxis().setTextColor(Color.WHITE);
            chart.getLegend().setTextColor(Color.WHITE);

            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToPosition(i);
                barEntries.add(new BarEntry(cursor.getInt(0), cursor.getInt(1)));
                barLabels.add("Workout ke -" + cursor.getCount());

                Log.d("DATABASE", cursor.getCount() + " banyaknya");
            }
//
            barDataSet = new BarDataSet(barEntries, "Berat Badan");

//            barData = new BarData(barDataSet);
//            chart.getXAxis().setValueFormatter(
//                    new IndexAxisValueFormatter(barLabels));

            barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

            chart.setData(barData);

            chart.animateY(3000);
        }

        myDrawer = findViewById(R.id.grafik_drawer);
        myToggle = new ActionBarDrawerToggle(this, myDrawer, R.string.open, R.string.close);
        myDrawer.addDrawerListener(myToggle);
        myToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.nv_grafik);
        setupDrawerContent(navigationView);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (myToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                selectItemDrawer(menuItem);
                return true;
            }
        });
    }

    private void selectItemDrawer(MenuItem menuItem){
        switch (menuItem.getItemId()){
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
                finish();
                break;
            case R.id.menu_grafik:
                Intent grafik_class = new Intent(this, GrafikActivity.class);
                grafik_class.setFlags(grafik_class.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(grafik_class);
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

