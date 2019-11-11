package org.d3ifcool.fitme;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class CountdownActivity extends AppCompatActivity {
    public static final String EXTRA_INT_COUNTDOWN = "extra_INT";
    private DrawerLayout myDrawer;
    private ActionBarDrawerToggle myToggle;

    CountDownTimer timer;
    TextView waktu, getready;
    final long startTime = 6*1000;
    long interval = 1*1000;
    int gambar []={R.drawable.pushup};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);
        waktu = findViewById(R.id.waktu);
        getready = findViewById(R.id.textView8);

        final int posGerakan = getIntent().getIntExtra(EXTRA_INT_COUNTDOWN, 0);

        timer = new CountDownTimer(startTime, interval) {
            @Override
            public void onTick(long millisUntilFinished) {
                waktu.setText(""+millisUntilFinished/1000);
            }
            @Override
            public void onFinish() {
                getready.setVisibility(View.GONE);
                waktu.setText("Mulai!");
                if (posGerakan == 0) {
                    Intent intent = new Intent(CountdownActivity.this, MulaiExerciseActivity.class);
                    intent.putExtra(MulaiExerciseActivity.EXTRA_INT_EXERCISE, posGerakan);
                    startActivity(intent);
                    finish();
                } else if (posGerakan == 1) {
                    Intent intent = new Intent(CountdownActivity.this, MulaiExerciseActivity.class);
                    intent.putExtra(MulaiExerciseActivity.EXTRA_INT_EXERCISE, posGerakan);
                    startActivity(intent);
                    finish();
                } else if (posGerakan == 2) {
                    Intent intent = new Intent(CountdownActivity.this, MulaiExerciseActivity.class);
                    intent.putExtra(MulaiExerciseActivity.EXTRA_INT_EXERCISE, posGerakan);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
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

    @Override
    public void onBackPressed() {
        Intent back_class = new Intent(this, WorkoutActivity.class);
        startActivity(back_class);
        finish();
    }

}
