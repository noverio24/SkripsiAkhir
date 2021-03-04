package com.codetalenta.eclass.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codetalenta.eclass.R;
import com.codetalenta.eclass.models.TaskModel;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyView> {
    private Context context;
    private List<TaskModel> data;

    public TaskAdapter(Context context, List<TaskModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public TaskAdapter.MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_task, parent, false);
        return new MyView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.MyView holder, int position) {
        holder.judulTugas.setText(data.get(position).getJudulTugas());
        holder.namaKelas.setText(data.get(position).getJudulTugas());
        holder.namaPengajar.setText(data.get(position).getNamaPengajar());
        holder.tanggal.setText(data.get(position).getTanggal());
        holder.jumlahHadir.setText(String.valueOf(data.get(position).getJumlahHadir()));
        holder.totalMahasiswa.setText(String.valueOf(data.get(position).getTotalMahasiswa()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyView extends RecyclerView.ViewHolder {
        TextView judulTugas, namaKelas, namaPengajar, tanggal, jumlahHadir, totalMahasiswa;
        public MyView(@NonNull View itemView) {
            super(itemView);
            judulTugas = itemView.findViewById(R.id.judulTugas);
            namaKelas = itemView.findViewById(R.id.namaKelas);
            namaPengajar = itemView.findViewById(R.id.namaPengajar);
            tanggal = itemView.findViewById(R.id.tanggal);
            jumlahHadir = itemView.findViewById(R.id.totalMhsMasuk);
            totalMahasiswa = itemView.findViewById(R.id.totalAllMhs);
        }
    }
}
