package com.codetalenta.eclass.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codetalenta.eclass.R;
import com.codetalenta.eclass.models.JadwalModel;

import java.util.List;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.MyView> {
    private Context context;
    private List<JadwalModel> list;

    public JadwalAdapter(Context context, List<JadwalModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public JadwalAdapter.MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_jadwal, parent, false);
        return new MyView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalAdapter.MyView holder, int position) {
        holder.namaKelas.setText("Kelas : "+list.get(position).getNamaKelas());
        holder.namaDosen.setText("Dosen : "+list.get(position).getDosen());
        holder.namaUniversitas.setText("Universitas : "+list.get(position).getUniversitas());
        holder.totalAllMhs.setText(String.valueOf(list.get(position).getTotalMahasiswa()));
        holder.totalMhsMasuk.setText(String.valueOf(list.get(position).getTotalHadir()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyView extends RecyclerView.ViewHolder {
        TextView namaKelas,namaUniversitas, namaDosen, totalMhsMasuk, totalAllMhs;
        public MyView(@NonNull View itemView) {
            super(itemView);
            namaKelas = itemView.findViewById(R.id.namaKelas);
            namaUniversitas = itemView.findViewById(R.id.namaUniv);
            namaDosen = itemView.findViewById(R.id.namaDosen);
            totalMhsMasuk = itemView.findViewById(R.id.totalMhsMasuk);
            totalAllMhs =  itemView.findViewById(R.id.totalAllMhs);
        }
    }
}
