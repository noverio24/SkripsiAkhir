package com.codetalenta.eclass.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codetalenta.eclass.R;
import com.codetalenta.eclass.adapters.RaportAdapter;
import com.codetalenta.eclass.models.RaportModel;

import java.util.ArrayList;
import java.util.List;


public class RapotFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private List<RaportModel> raportModels = new ArrayList<>();
    private RaportAdapter raportAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_rapot, container, false);
        getRaport();
        return view;
    }

    private void getRaport() {
        recyclerView = view.findViewById(R.id.recyclerRaport);
        raportModels.add(new RaportModel("Basis Data", "Laila", "90", "Good"));
        raportModels.add(new RaportModel("Basis Data", "Laila", "90", "Good"));
        raportModels.add(new RaportModel("Basis Data", "Laila", "90", "Good"));
        raportModels.add(new RaportModel("Basis Data", "Laila", "90", "Good"));
        raportAdapter = new RaportAdapter(raportModels, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(raportAdapter);
    }
}