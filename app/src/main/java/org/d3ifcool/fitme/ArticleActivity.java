package org.d3ifcool.fitme;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import org.d3ifcool.fitme.R;
import org.d3ifcool.fitme.adapter.ArticleAdapter;

import java.util.ArrayList;

public class ArticleActivity extends AppCompatActivity {

    private RecyclerView rvArticle;
    private ArrayList<DataArticle> modelDataArticle;
    private DrawerLayout myDrawer;
    private ActionBarDrawerToggle myToggle;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        myDrawer = findViewById(R.id.artikel_drawer);
        myToggle = new ActionBarDrawerToggle(this, myDrawer, R.string.open,  R.string.close);
        myDrawer.addDrawerListener(myToggle);
        myToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.nv_artikel);
        setupDrawerContent(navigationView);

        rvArticle = findViewById(R.id.recylerViewArticle);
        modelDataArticle= new ArrayList<>();
        modelDataArticle.add(new DataArticle(R.drawable.tubuhgemuk, "Tubuh Yang Gemuk", "Bahaya kegemukan salah satunya adalah meningkatkan risiko terjadinya berbagai penyakit. " +
                "Memiliki lemak berlebih dalam tubuh, khususnya di daerah pinggang, akan menambah risiko gangguan kesehatan yang serius dan dikaitkan dengan risiko berkembangnya beberapa jenis penyakit " +
                "seperti kanker dan penyakit jantung. Banyak gangguan, baik secara fisik maupun psikis, yang dapat muncul sebagai akibat dari kegemukan, di antaranya: Penyakit Kronis, menyebabkan gangguan tidur, " +
                "menyebabkan gangguan pada lutut dan pinggang, meningkatkan resiko terkena kanker, serta diskriminasi dan tidak percaya diri."));
        modelDataArticle.add(new DataArticle(R.drawable.tubuhideal, "Tubuh Yang Ideal", "Berat badan ideal perlu tetap dijaga karena tiga alasan. Pertama, agar tidak menimbulkan berbagai " +
                "penyakit metabolik. Kedua, tidak mencetuskan kejadian penyakit yang sudah ada, dan ketiga, menghindari kematian prematur (premature death). Berat badan merupakan salah satu faktor risiko untuk sejumlah " +
                "penyakit metabolik, darah tinggi, kencing manis, kelebihan lemak darah. Namun, menjaga berat badan ideal tidak mudah. Pola makan dan gaya hidup sering memicu orang menjadi gemuk. Itu juga terjadi karena " +
                "sukar mengerem nafsu makan yang berlebihan serta pilihan menu yang tinggi kalori. Solusi terpenting agar mendapatkan berat badan yang ideal adalah menata menu dan menjaga asupan makanan harian. Orang sering " +
                "kali sangat membatasi porsi makanan utamanya, namun lupa kalau jajanan pun dapat memberikan kalori berlebihan. Menjaga berat badan agar tetap ideal juga bisa dilakukan dengan cara memperhitungkan jenis dan " +
                "jumlah asupan yang kita konsumsi. Kebanyakan orang lebih mengejar nikmatnya kelezatan di lidah. Kalau itu terus dituruti, maka yang memikul akibat buruknya kemudian tentu tubuh kita sendiri."));
        modelDataArticle.add(new DataArticle(R.drawable.tubuhkurus, "Tubuh Yang Kurus", "Memiliki badan kurus atau status gizi underweight tidak berarti sehat. Ada beberapa faktor penyebab badan kurus," +
                " di antaranya adalah faktor keturunan, kekurangan nutrisi, hingga kondisi medis tertentu yang harus Anda waspadai. Penting bagi Anda untuk mengetahui faktor penyebab badan kurus. Pasalnya, badan yang terlalu kurus " +
                "dapat merusak kesehatan Anda dan berpengaruh pada sistem kekebalan tubuh yang lemah, kelemahan tulang atau osteoporosis, anemia, kekurangan energi, hingga gangguan kesuburan. Ada beragam penyebab badan kurus, di antaranya: " +
                "Genetik atau keturunan, aktivitas fisik yang cenderung tinggi, kondisi media tertentu, obat-obatan tertentu, dan masalah psikologis."));
        ArticleAdapter articleAdapter = new ArticleAdapter(this, modelDataArticle);
        rvArticle.setAdapter(articleAdapter);
        rvArticle.setLayoutManager(new LinearLayoutManager(this));

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
