package org.d3ifcool.fitme;

import android.os.Parcel;
import android.os.Parcelable;

public class DataArticle implements Parcelable {
    private String judulArticle, Deskripsi;
    private int gambar;


    public DataArticle(int gambar, String judulArticle, String deskripsi) {
        this.gambar = gambar;
        this.judulArticle = judulArticle;
        this.Deskripsi = deskripsi;
    }

    protected DataArticle(Parcel in) {
        judulArticle = in.readString();
        Deskripsi = in.readString();
        gambar = in.readInt();
    }

    public static final Creator<DataArticle> CREATOR = new Creator<DataArticle>() {
        @Override
        public DataArticle createFromParcel(Parcel in) {
            return new DataArticle(in);
        }

        @Override
        public DataArticle[] newArray(int size) {
            return new DataArticle[size];
        }
    };

    public int getGambar() {
        return gambar;
    }

    public String getJudulArticle() {
        return judulArticle;
    }


    public String getDeskripsi() {
        return Deskripsi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(judulArticle);
        parcel.writeString(Deskripsi);
        parcel.writeInt(gambar);
    }
}
