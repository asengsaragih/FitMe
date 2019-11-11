package org.d3ifcool.fitme;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.prolificinteractive.materialcalendarview.CalendarDay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import org.d3ifcool.fitme.database.DbHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity{

    private DrawerLayout myDrawer;
    private ActionBarDrawerToggle myToggle;
    private EditText txtTinggi, txtBerat;
    private TextView txtHasil;
    private Button btnSave;
    private float tinggiValue, beratValue;
    protected Cursor cursor;
    DbHelper dbHelper;
    private String tglSkrg;

    boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTinggi = findViewById(R.id.txt_tinggi);
        txtBerat = findViewById(R.id.txt_berat);
        txtHasil = findViewById(R.id.txt_hasil);
        btnSave = findViewById(R.id.btn_save);
        dbHelper = new DbHelper(this);

        myDrawer = findViewById(R.id.mainDrawer);
        myToggle = new ActionBarDrawerToggle(this, myDrawer, R.string.open,  R.string.close);
        myDrawer.addDrawerListener(myToggle);
        myToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.nav_view_drawer_main);
        setupDrawerContent(navigationView);
    }

    public void kalkulatorBMI(View view){
//        SQLiteDatabase dbhit = dbHelper.getReadableDatabase();
        final Date currentDate = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-YYYY");
        tglSkrg = dateFormat.format(currentDate);

//        cursor = dbhit.rawQuery("SELECT * FROM beratbadan;", null);

        String strTinggi = txtTinggi.getText().toString();
        String strBerat = txtBerat.getText().toString();

        if (strTinggi != null && !"".equals(strTinggi) && strBerat != null && !"".equals(strBerat)){
            tinggiValue = Float.parseFloat(strTinggi) / 100;
            beratValue = Float.parseFloat(strBerat);

            float bmi = beratValue / (tinggiValue * tinggiValue);

            displayBMI(bmi);
        }
    }

    public void saveBMI(View view){
        SQLiteDatabase dbRead = dbHelper.getReadableDatabase();
        SQLiteDatabase dbInsert = dbHelper.getWritableDatabase();

        try {
            String sqlReadWeight = "SELECT tanggal FROM beratbadan WHERE tanggal='" + tglSkrg + "'";
            Cursor weightCursor = dbRead.rawQuery(sqlReadWeight, null);

            int intBerat = (int) beratValue;

            if (weightCursor.getCount() > 0){
                String sqlUpdate = "UPDATE beratbadan SET berat=" + intBerat + " WHERE tanggal='" + tglSkrg + "'";
                dbInsert.execSQL(sqlUpdate);
                Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, GrafikActivity.class);
                startActivity(intent);
            } else {
                try {
                    String sqlInsert = "insert into beratbadan(berat, tanggal) values("+intBerat+", '"+ tglSkrg +"');";
                    dbInsert.execSQL(sqlInsert);
                    Toast.makeText(this, "Data berhasil disimpan.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, GrafikActivity.class);
                    startActivity(intent);
                }catch (SQLException e)
                {
                    Toast.makeText(this, ""+e, Toast.LENGTH_LONG).show();
                    Log.e("Error insert berat : ", e.toString());
                }
            }
        } catch (Exception e) {
            Toast.makeText(this, "" + e, Toast.LENGTH_SHORT).show();
            Log.e("Error read berat : ", e.toString());
        }
        reset();
    }

    private void displayBMI(float bmi) {
        String bmiLabel="";

        if (bmi <= 18.5){
            bmiLabel = "KURUS";
        }else if (bmi >= 18.5 && bmi <= 24.9){
            bmiLabel = "IDEAL";
        }else if (bmi >= 24.9 && bmi <= 29.9){
            bmiLabel = "GEMUK";
        } else {
            bmiLabel = "OBESITAS";
        }

        txtHasil.setText(bmiLabel);
        txtHasil.setVisibility(View.VISIBLE);
        closeKeycoard();
        btnSave.setVisibility(View.VISIBLE);
    }

    public void reset(){
        txtTinggi.setText("");
        txtBerat.setText("");
    }

    public void closeKeycoard(){
        View view = this.getCurrentFocus();
        if (view != null){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
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
                finish();
                break;
        }
        myDrawer.closeDrawers();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}

