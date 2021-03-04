package com.codetalenta.eclass.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codetalenta.eclass.R;
import com.codetalenta.eclass.adapters.JadwalAdapter;
import com.codetalenta.eclass.models.JadwalModel;

import java.util.ArrayList;
import java.util.List;


public class KelasFragment extends Fragment {

    RecyclerView listJadwal;
    List<JadwalModel> jadwalModels = new ArrayList<>();
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_kelas, container, false);
        getData();
        return view;
    }

    private void getData() {
        listJadwal = view.findViewById(R.id.recyclerJadwal);
        jadwalModels.add(new JadwalModel(1, 8, 3, "Basis Data", "Universitas Oke Banget", "Nikky Rufiansya"));
        jadwalModels.add(new JadwalModel(1, 8, 3, "Basis Data", "Universitas Oke Banget", "Nikky Rufiansya"));
        jadwalModels.add(new JadwalModel(1, 8, 3, "Basis Data", "Universitas Oke Banget", "Nikky Rufiansya"));
        jadwalModels.add(new JadwalModel(1, 8, 3, "Basis Data", "Universitas Oke Banget", "Nikky Rufiansya"));
        jadwalModels.add(new JadwalModel(1, 8, 3, "Basis Data", "Universitas Oke Banget", "Nikky Rufiansya"));
        jadwalModels.add(new JadwalModel(1, 8, 3, "Basis Data", "Universitas Oke Banget", "Nikky Rufiansya"));
        jadwalModels.add(new JadwalModel(1, 8, 3, "Basis Data", "Universitas Oke Banget", "Nikky Rufiansya"));
        jadwalModels.add(new JadwalModel(1, 8, 3, "Basis Data", "Universitas Oke Banget", "Nikky Rufiansya"));
        JadwalAdapter jadwalAdapter = new JadwalAdapter(getContext(), jadwalModels);
        listJadwal.setLayoutManager(new LinearLayoutManager(getContext()));
        listJadwal.setAdapter(jadwalAdapter);
    }

}