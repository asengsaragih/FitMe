package org.d3ifcool.fitme.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "biodata_user";
    public static final int DB_VERSION = 1;

    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    String sqlIdentitas = "CREATE TABLE biodata(email text primary key, username text null, jeniskelamin text null," +
            " usia integer, berat integer, tinggi integer);";

    String sqlWorkout = "CREATE TABLE stepWorkout(jumlah integer primary key);";

//    String sqlBMI = "CREATE TABLE bmi(nomer integer primary key, bmi integer);";
    String sqlBMI = "CREATE TABLE beratbadan(nomerId integer primary key AUTOINCREMENT, berat integer, tanggal text);";

    String sqlSelesai = "CREATE TABLE gerakanselesai(nomerId integer primary key AUTOINCREMENT, gerakan string, tanggal integer);";

    String sqlKuis = "CREATE TABLE hasilKuis(nomerId integer primary key AUTOINCREMENT, hasilScore integer, tanggalMain string);";


//    String sqltype = "CREATE TABLE nomer(idNo integer primary key, nmr integer);";

    @Override
    public void onCreate(SQLiteDatabase db) {

//        Log.d("Data", "onCreate: "+sqlIdentitas);
        db.execSQL(sqlIdentitas);
//        Log.d("Data", "onCreate: "+sqlWorkout);
        db.execSQL(sqlWorkout);

        db.execSQL(sqlBMI);

        db.execSQL(sqlSelesai);

        db.execSQL(sqlKuis);

//        db.execSQL(sqltype);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + sqlIdentitas);
        db.execSQL("DROP TABLE IF EXISTS " + sqlWorkout);
        db.execSQL("DROP TABLE IF EXISTS " + sqlKuis);
    }

}
