package org.d3ifcool.fitme.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.d3ifcool.fitme.ArticleActivity;
import org.d3ifcool.fitme.DataArticle;
import org.d3ifcool.fitme.DetailArticleActivity;
import org.d3ifcool.fitme.R;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder>{

    private Context context;
    private ArrayList<DataArticle> modelDataArticle;

    public ArticleAdapter(Context context, ArrayList<DataArticle> modelDataArticle) {
        this.context = context;
        this.modelDataArticle = modelDataArticle;
    }

    @NonNull
    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemlist = LayoutInflater.from(context).inflate(R.layout.item_list_article,parent,false);
        return new ArticleAdapter.ViewHolder(itemlist);
    }

    @Override
    public int getItemCount() {
        return modelDataArticle.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView judulArticle, descArticle;
        ImageView gambar;
        View itemView;
        LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView=itemView;
            gambar = itemView.findViewById(R.id.image_article);
            judulArticle = itemView.findViewById(R.id.text_view_title);
            descArticle = itemView.findViewById(R.id.text_view_desc);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleAdapter.ViewHolder holder, final int position) {
        final DataArticle model = modelDataArticle.get(position);
        holder.judulArticle.setText(model.getJudulArticle());
        holder.descArticle.setText(model.getDeskripsi());
        holder.gambar.setImageResource(model.getGambar());
//        holder.bind(model, listener);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailArticleActivity.class);
                intent.putExtra("Article", model);
                context.startActivity(intent);
            }
        });
    }
}
