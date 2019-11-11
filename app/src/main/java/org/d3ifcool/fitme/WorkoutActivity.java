package org.d3ifcool.fitme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import org.d3ifcool.fitme.adapter.AdapterList;
import org.d3ifcool.fitme.model.DataListCustom;

import java.util.ArrayList;

public class WorkoutActivity extends AppCompatActivity {

    private DrawerLayout myDrawer;
    private ActionBarDrawerToggle myToggle;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<DataListCustom> array = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        array.clear();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        array.add(new DataListCustom(R.drawable.ic_calendar,"Sit Up" ));
        array.add(new DataListCustom(R.drawable.ic_calendar,"Push Up" ));
        array.add(new DataListCustom(R.drawable.ic_calendar,"Bench Press" ));
        array.add(new DataListCustom(R.drawable.ic_calendar,"Angled Leg Press" ));
        array.add(new DataListCustom(R.drawable.ic_calendar,"Chin Ups" ));
        array.add(new DataListCustom(R.drawable.ic_calendar,"Concentration Curls" ));
        array.add(new DataListCustom(R.drawable.ic_calendar,"Dumbbell Presses" ));
        array.add(new DataListCustom(R.drawable.ic_calendar,"Plank" ));
        array.add(new DataListCustom(R.drawable.ic_calendar,"Low Pulley Cable Crossover" ));
        AdapterList adapterList = new AdapterList(this, array);
        recyclerView.setAdapter(adapterList);

        myDrawer = findViewById(R.id.workout_drawer);
        myToggle = new ActionBarDrawerToggle(this, myDrawer, R.string.open,  R.string.close);
        myDrawer.addDrawerListener(myToggle);
        myToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.nv_workout);
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
