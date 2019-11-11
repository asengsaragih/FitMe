package org.d3ifcool.fitme;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import org.d3ifcool.fitme.database.DbHelper;
import org.d3ifcool.fitme.model.QuestionBank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    private DrawerLayout myDrawer;
    private ActionBarDrawerToggle myToggle;
    DbHelper helper;

    private QuestionBank mQuestionLibrary = new QuestionBank();
    private TextView mScoreView;   // Untuk menampilkan skor saat ini
    private TextView mQuestionView;  //menampilkan jawaban
    private Button mButtonChoice1; // jawaban 1
    private Button mButtonChoice2; // jawaban 2
    private Button mButtonChoice3; //jawaban 3
    private Button mButtonChoice4; //jawaban 4

    private String mAnswer;  // untuk cek jawaban benar atau tidaknya
    private int mRightAnswerCount = 0;  // current total score
    private int mQuizCount = 1; //
    static final  private int QUIZ_COUNT = 5;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String quizData[][] = {
            {"Masa remaja dimulai dari usia?", "10 Tahun", "15 Tahun", "17 Tahun", "13 Tahun"},
            {"Menu Pelengkap 4 sehat 5 sempurna?", "Susu", "Ikan", "Sayur", "Buah"},
            {"Menu yang mengandung karbohidrat, kecuali?", "Daging", "Kentang", "Singkong", "Gandum"},
            {"Vitamin A berfungsi untuk menjaga kesehatan?", "Mata", "Gigi", "Telinga", "Tulang"},
            {"Berikut 9ini penyakit infeksi menular seksual?", "HIV/AIDS", "Herpes", "Flu", "Syphilis"},
            {"Berikut 0ini penyakit infeksi menular seksual?", "HIV/AIDS", "Herpes", "Flu", "Syphilis"},
            {"Berikut -ini penyakit infeksi menular seksual?", "HIV/AIDS", "Herpes", "Flu", "Syphilis"},
            {"Berikut 8ini penyakit infeksi menular seksual?", "HIV/AIDS", "Herpes", "Flu", "Syphilis"},
            {"Berikut 7ini penyakit infeksi menular seksual?", "HIV/AIDS", "Herpes", "Flu", "Syphilis"},
            {"Berikut 7ini penyakit infeksi menular seksual?", "HIV/AIDS", "Herpes", "Flu", "Syphilis"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        helper = new DbHelper(QuizActivity.this);

        myDrawer = findViewById(R.id.quiz_drawer);
        myToggle = new ActionBarDrawerToggle(this, myDrawer, R.string.open,  R.string.close);
        myDrawer.addDrawerListener(myToggle);
        myToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.nv_quiz);
        setupDrawerContent(navigationView);

        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        mButtonChoice4 = (Button)findViewById(R.id.choice4);

        //create quizArray
        for (int i = 0; i < quizData.length ; i++) {
            ArrayList<String> tmpQuiz = new ArrayList<>();
            tmpQuiz.add(quizData[i][0]); //question
            tmpQuiz.add(quizData[i][1]); //right ans
            tmpQuiz.add(quizData[i][2]);
            tmpQuiz.add(quizData[i][3]);
            tmpQuiz.add(quizData[i][4]);

            quizArray.add(tmpQuiz);

        }
        showNextQuiz();
    }

    public void  showNextQuiz(){
        mScoreView.setText(mRightAnswerCount+"/5");

        Random random = new Random();
        int RandomQuiz = random.nextInt(5);

        ArrayList<String> quiz = quizArray.get(RandomQuiz);

        mQuestionView.setText(quiz.get(0));
        mAnswer = quiz.get(1);

        quiz.remove(0);
        Collections.shuffle(quiz);

        mButtonChoice1.setText(quiz.get(0));
        mButtonChoice2.setText(quiz.get(1));
        mButtonChoice3.setText(quiz.get(2));
        mButtonChoice4.setText(quiz.get(3));

        quizArray.remove(RandomQuiz);
    }

    public void onClick(View view) {
        //all logic for all answers buttons in one method
        Button answerbtn = (Button) findViewById(view.getId());
        String btnText = answerbtn.getText().toString();

        if (btnText.equals(mAnswer)){
            mRightAnswerCount++;
//            mScoreView.setText(mRightAnswerCount+"/"+quizData.length);
            Toast.makeText(QuizActivity.this, "Benar!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(QuizActivity.this, "Salah!", Toast.LENGTH_SHORT).show();

        }

        if (mQuizCount == QUIZ_COUNT){
            Intent bmiClass = new Intent(this, HighestScoreActivity.class);
            bmiClass.putExtra("score",mRightAnswerCount);
            startActivity(bmiClass);
            finish();
        }else{
            mQuizCount++;
            showNextQuiz();
        }
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
                finish();
                break;
            case R.id.menu_quiz:
                Intent quiz_class = new Intent(this, QuizActivity.class);
                quiz_class.setFlags(quiz_class.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(quiz_class);
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

