package org.d3ifcool.fitme.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.d3ifcool.fitme.R;
import org.d3ifcool.fitme.model.DataListKuis;
import org.d3ifcool.fitme.model.DataListReport;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterListKuis extends RecyclerView.Adapter<AdapterListKuis.ViewHolder> {
    Context context;
    ArrayList<DataListKuis> arrData;

    public AdapterListKuis(Context context, ArrayList<DataListKuis> arrData) {
        this.context = context;
        this.arrData = arrData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView listSkor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            listSkor = itemView.findViewById(R.id.tvSkorKuis);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.custom_list_recycler2, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int posisi) {
        DataListKuis isi = arrData.get(posisi);

        viewHolder.listSkor.setText("Percobaan ke-" + (posisi + 1) + isi.getHasilKuis());
    }

    @Override
    public int getItemCount() {

        return arrData.size();
    }


}
