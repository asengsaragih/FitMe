package org.d3ifcool.fitme.model;

public class DataInfo {
    private String judulGerakan;
    private String isiInfo;
    private String isiManfaat;
    private int imageResId = -1;

    DataInfo(String judulGerakan, String isiInfo, String isiManfaat) {
        this.judulGerakan = judulGerakan;
        this.isiInfo = isiInfo;
        this.isiManfaat = isiManfaat;
    }

    public DataInfo(String judulGerakan, String isiInfo, String isiManfaat, int imageResId) {
        this.judulGerakan = judulGerakan;
        this.isiInfo = isiInfo;
        this.isiManfaat = isiManfaat;
        this.imageResId = imageResId;
    }

    public String getJudulGerakan() {
        return judulGerakan;
    }

    public String getIsiInfo() {
        return isiInfo;
    }

    public String getIsiManfaat() {return  isiManfaat;}

    boolean hasImage() {
        return imageResId != -1;
    }

    public int getImageResId() {
        return imageResId;
    }
}
