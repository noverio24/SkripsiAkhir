package com.codetalenta.eclass.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codetalenta.eclass.R;
import com.codetalenta.eclass.models.SubjectModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.MyView> {
    private Context context;
    private List<SubjectModel> data;

    public SubjectAdapter(Context context, List<SubjectModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_subject, parent, false);
        return new MyView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        Picasso.get().load(data.get(position).getIconMatkul()).into(holder.iconMatkul);
        holder.namaMatkul.setText(data.get(position).getNamaMatkul());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyView extends RecyclerView.ViewHolder {
        public ImageView iconMatkul;
        public TextView namaMatkul;
        public MyView(@NonNull View itemView) {
            super(itemView);
            iconMatkul = itemView.findViewById(R.id.iconMatkul);
            namaMatkul = itemView.findViewById(R.id.namaMatkul);
        }
    }
}
