package com.codetalenta.eclass.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codetalenta.eclass.R;
import com.codetalenta.eclass.models.RaportModel;

import java.util.List;

public class RaportAdapter extends RecyclerView.Adapter<RaportAdapter.MyView> {
    private List<RaportModel> data;
    private Context context;

    public RaportAdapter(List<RaportModel> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public RaportAdapter.MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_report, parent, false);
        return new MyView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RaportAdapter.MyView holder, int position) {
        holder.namaKelas.setText(data.get(position).getNamaKelas());
        holder.namaPengajar.setText(data.get(position).getNamaPengajar());
        holder.status.setText("Status : "+data.get(position).getStatus());
        holder.nilai.setText("Total Nilai : "+data.get(position).getNilai());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyView extends RecyclerView.ViewHolder {
        TextView namaKelas, namaPengajar, nilai, status;
        public MyView(@NonNull View itemView) {
            super(itemView);
            namaKelas = itemView.findViewById(R.id.namaKelas);
            namaPengajar = itemView.findViewById(R.id.namaPengajar);
            nilai = itemView.findViewById(R.id.totalNilai);
            status = itemView.findViewById(R.id.status);
        }
    }
}
