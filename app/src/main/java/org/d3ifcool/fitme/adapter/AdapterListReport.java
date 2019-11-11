package org.d3ifcool.fitme.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.d3ifcool.fitme.R;
import org.d3ifcool.fitme.model.DataListReport;

public class AdapterListReport extends RecyclerView.Adapter<AdapterListReport.ViewHolder> {
    Context context;
    ArrayList<DataListReport> arrData;

    public AdapterListReport(Context context, ArrayList<DataListReport> arrData) {
        this.context = context;
        this.arrData = arrData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView listWorkout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            listWorkout = itemView.findViewById(R.id.txt_list2);
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
        DataListReport isi = arrData.get(posisi);

        viewHolder.listWorkout.setText(isi.getListWorkout());

    }

    @Override
    public int getItemCount() {

        return arrData.size();
    }


}
