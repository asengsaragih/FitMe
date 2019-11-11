package org.d3ifcool.fitme.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.d3ifcool.fitme.R;
import org.d3ifcool.fitme.ReviewActivity;
import org.d3ifcool.fitme.model.DataListCustom;

import java.util.ArrayList;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolder> {
    Context context;
    ArrayList<DataListCustom> arrData;

    public AdapterList(Context context, ArrayList<DataListCustom> arrData) {
        this.context = context;
        this.arrData = arrData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView judul;
//        ImageView gambar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.txt_list);
//            gambar = itemView.findViewById(R.id.img_list);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.custom_list_recycler, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int posisi) {
        DataListCustom isi = arrData.get(posisi);

        viewHolder.judul.setText(isi.getJudul());
//        viewHolder.gambar.setImageResource(isi.getGambar());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (posisi == 0) {
                    Intent intent = new Intent(context, ReviewActivity.class);
                    intent.putExtra(ReviewActivity.EXTRA_INT_REVIEW, 0);
                    context.startActivity(intent);
                } else if (posisi == 1) {
                    Intent intent = new Intent(context, ReviewActivity.class);
                    intent.putExtra(ReviewActivity.EXTRA_INT_REVIEW, 1);
                    context.startActivity(intent);
                } else if (posisi == 2) {
                    Intent intent = new Intent(context, ReviewActivity.class);
                    intent.putExtra(ReviewActivity.EXTRA_INT_REVIEW, 2);
                    context.startActivity(intent);
                } else if (posisi == 3) {
                    Intent intent = new Intent(context, ReviewActivity.class);
                    intent.putExtra(ReviewActivity.EXTRA_INT_REVIEW, 3);
                    context.startActivity(intent);
                } else if (posisi == 4) {
                    Intent intent = new Intent(context, ReviewActivity.class);
                    intent.putExtra(ReviewActivity.EXTRA_INT_REVIEW, 4);
                    context.startActivity(intent);
                } else if (posisi == 5) {
                    Intent intent = new Intent(context, ReviewActivity.class);
                    intent.putExtra(ReviewActivity.EXTRA_INT_REVIEW, 5);
                    context.startActivity(intent);
                } else if (posisi == 6) {
                    Intent intent = new Intent(context, ReviewActivity.class);
                    intent.putExtra(ReviewActivity.EXTRA_INT_REVIEW, 6);
                    context.startActivity(intent);
                } else if (posisi == 7) {
                    Intent intent = new Intent(context, ReviewActivity.class);
                    intent.putExtra(ReviewActivity.EXTRA_INT_REVIEW, 7);
                    context.startActivity(intent);
                } else if (posisi == 8) {
                    Intent intent = new Intent(context, ReviewActivity.class);
                    intent.putExtra(ReviewActivity.EXTRA_INT_REVIEW, 8);
                    context.startActivity(intent);
                } else if (posisi == 9) {
                    Intent intent = new Intent(context, ReviewActivity.class);
                    intent.putExtra(ReviewActivity.EXTRA_INT_REVIEW, 9);
                    context.startActivity(intent);
                } else if (posisi == 10) {
                    Intent intent = new Intent(context, ReviewActivity.class);
                    intent.putExtra(ReviewActivity.EXTRA_INT_REVIEW, 2);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrData.size();
    }


}
