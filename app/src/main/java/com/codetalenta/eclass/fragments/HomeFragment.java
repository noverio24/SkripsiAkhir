package com.codetalenta.eclass.fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codetalenta.eclass.R;
import com.codetalenta.eclass.adapters.SubjectAdapter;
import com.codetalenta.eclass.models.SubjectModel;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private RecyclerView recycleSubject;
    public View view;
    private List<SubjectModel> subjectModels = new ArrayList<>();
    private SubjectAdapter subjectAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        recycleSubject = view.findViewById(R.id.recycleSubject);
        getData();
        return view;
    }

    private void getData() {
        subjectModels.add(new SubjectModel("https://cdn2.iconfinder.com/data/icons/whcompare-isometric-web-hosting-servers/50/database-512.png", "Database"));
        subjectModels.add(new SubjectModel("https://cdn2.iconfinder.com/data/icons/whcompare-isometric-web-hosting-servers/50/database-512.png", "Database"));
        subjectModels.add(new SubjectModel("https://cdn2.iconfinder.com/data/icons/whcompare-isometric-web-hosting-servers/50/database-512.png", "Database"));
        subjectModels.add(new SubjectModel("https://cdn2.iconfinder.com/data/icons/whcompare-isometric-web-hosting-servers/50/database-512.png", "Database"));
        subjectModels.add(new SubjectModel("https://cdn2.iconfinder.com/data/icons/whcompare-isometric-web-hosting-servers/50/database-512.png", "Database"));
        subjectModels.add(new SubjectModel("https://cdn2.iconfinder.com/data/icons/whcompare-isometric-web-hosting-servers/50/database-512.png", "Database"));
        subjectModels.add(new SubjectModel("https://cdn2.iconfinder.com/data/icons/whcompare-isometric-web-hosting-servers/50/database-512.png", "Database"));
        subjectModels.add(new SubjectModel("https://cdn2.iconfinder.com/data/icons/whcompare-isometric-web-hosting-servers/50/database-512.png", "Database"));
        subjectAdapter = new SubjectAdapter(getContext(), subjectModels);
        recycleSubject.setLayoutManager(new GridLayoutManager(getContext(), 4));
        recycleSubject.setAdapter(subjectAdapter);
    }
}