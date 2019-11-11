package org.d3ifcool.fitme;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.prolificinteractive.materialcalendarview.CalendarDay;

import org.d3ifcool.fitme.database.DbHelper;

import java.util.ArrayList;

public class MulaiExerciseActivity extends AppCompatActivity {
    public static final String EXTRA_INT_EXERCISE = "extra_INT";
    private DrawerLayout myDrawer;
    private ActionBarDrawerToggle myToggle;

    DbHelper dbHelper;

    ImageView img;
    TextView jdlGerakan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mulai_exercise);
        img = findViewById(R.id.imageView6);
        jdlGerakan = findViewById(R.id.textView9);

        dbHelper = new DbHelper(this);

        final int posExercise = getIntent().getIntExtra(EXTRA_INT_EXERCISE, 0);

        ArrayList<Integer> dataGambar = new ArrayList<>();
        dataGambar.add(R.drawable.ic_workout);
        dataGambar.add(R.drawable.ic_workout);
        dataGambar.add(R.drawable.ic_workout);

        if (posExercise == 0) {
            jdlGerakan.setText("Sit Up");
            img.setImageResource(dataGambar.get(0));
        } else if (posExercise == 1) {
            jdlGerakan.setText("Push Up");
            img.setImageResource(dataGambar.get(1));
        } else if (posExercise == 2) {
            jdlGerakan.setText("Bench Press");
            img.setImageResource(dataGambar.get(2));
        }
    }

    public void selesaiExercise(View view) {
        final int posExercise = getIntent().getIntExtra(EXTRA_INT_EXERCISE, 0);
        String judul = jdlGerakan.getText().toString();

        if (posExercise == 0) {
            Intent intent = new Intent(this, FinishActivity.class);
            intent.putExtra(FinishActivity.EXTRA_INT_FINISH, posExercise);
            intent.putExtra(FinishActivity.EXTRA_INT_GERAKAN, judul);
            startActivity(intent);
            finish();
        } else if (posExercise == 1) {
            Intent intent = new Intent(this, FinishActivity.class);
            intent.putExtra(FinishActivity.EXTRA_INT_FINISH, posExercise);
            intent.putExtra(FinishActivity.EXTRA_INT_GERAKAN, judul);
            startActivity(intent);
            finish();
        } else if (posExercise == 2) {
            Intent intent = new Intent(this, FinishActivity.class);
            intent.putExtra(FinishActivity.EXTRA_INT_FINISH, posExercise);
            intent.putExtra(FinishActivity.EXTRA_INT_GERAKAN, judul);
            startActivity(intent);
            finish();
        }
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
                startActivity(video_class);finish();
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
