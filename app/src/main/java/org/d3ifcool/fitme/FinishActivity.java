package org.d3ifcool.fitme;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.prolificinteractive.materialcalendarview.CalendarDay;

import org.d3ifcool.fitme.database.DbHelper;


public class FinishActivity extends AppCompatActivity {
    public static final String EXTRA_INT_FINISH = "extra_INT";
    public static final String EXTRA_INT_GERAKAN = "extra_NAME";
    int tgl;
    Button done;
    DbHelper dbHelper;
    TextView judulgerakan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        final int posFinish = getIntent().getIntExtra(EXTRA_INT_FINISH, 0);
        final String judul = getIntent().getStringExtra(EXTRA_INT_GERAKAN);

        judulgerakan = findViewById(R.id.textView11);
        done = findViewById(R.id.selesai);

        judulgerakan.setText(judul);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper = new DbHelper(getBaseContext());
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                try {
                    final CalendarDay cld = new CalendarDay();
                    tgl = cld.getDay();

                    String finishedGerakan = judul;
                    String sqlInsert = "insert into gerakanselesai(gerakan, tanggal) values ('"+finishedGerakan+"', "+tgl+");";
                    db.execSQL(sqlInsert);
                    Toast.makeText(FinishActivity.this, "Data berhasil tersimpan.", Toast.LENGTH_SHORT).show();
                }catch (SQLException e)
                {
                    Toast.makeText(FinishActivity.this, ""+e, Toast.LENGTH_LONG).show();
                }

                Intent intent = new Intent(FinishActivity.this,WorkoutActivity.class);
                startActivity(intent);
                finish();
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
