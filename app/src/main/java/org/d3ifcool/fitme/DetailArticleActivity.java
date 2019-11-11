package org.d3ifcool.fitme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailArticleActivity extends AppCompatActivity {

    TextView judulArticle, descArticle;
    ImageView gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_article);

        judulArticle = findViewById(R.id.text_view_title);
        descArticle = findViewById(R.id.text_view_isi);
        gambar = findViewById(R.id.image_article);

        DataArticle getData = getIntent().getParcelableExtra("Article");
        judulArticle.setText(getData.getJudulArticle());
        descArticle.setText(getData.getDeskripsi());
        gambar.setImageResource(getData.getGambar());

    }

    @Override
    public void onBackPressed() {
        Intent back_class = new Intent(this, ArticleActivity.class);
        startActivity(back_class);
        finish();
    }

}
