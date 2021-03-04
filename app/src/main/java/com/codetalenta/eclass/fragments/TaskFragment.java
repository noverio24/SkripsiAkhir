package com.codetalenta.eclass.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import com.codetalenta.eclass.R;
import com.codetalenta.eclass.adapters.TaskAdapter;
import com.codetalenta.eclass.models.TaskModel;

import java.util.ArrayList;
import java.util.List;


public class TaskFragment extends Fragment {
    View view;
    List<TaskModel> taskModels = new ArrayList<>();
    RecyclerView recyclerView;
    CalendarView calendarView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_task, container, false);
        getData();
        calender();
        return view;
    }


    private void calender() {
        calendarView = view.findViewById(R.id.calenderView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String bulan = null;

                switch (month) {
                    case 0:
                        bulan = "Januari";
                        break;
                    case 1:
                        bulan = "febuari";
                        break;
                    case 2:
                        bulan = "maret";
                        break;
                    case 3:
                        bulan = "april";
                        break;
                    case 4:
                        bulan = "mei";
                        break;
                    case 5:
                        bulan = "juni";
                        break;
                    case 6:
                        bulan = "juli";
                        break;
                    case 7:
                        bulan = "agustus";
                        break;
                    case 8:
                        bulan = "september";
                        break;
                    case 9:
                        bulan = "oktober";
                        break;
                    case 10:
                        bulan = "november";
                        break;
                    case 11:
                        bulan = "desember";
                        break;
                }

                String tanggal =String.valueOf(dayOfMonth + "-" + bulan + "-" + year);
                Toast.makeText(getContext(), tanggal, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getData() {
        recyclerView = view.findViewById(R.id.recyclerTask);
        taskModels.add(new TaskModel(1, "Tugas Basis Data", "Basis Data", "Nikky", "22-febuari-2021", 10, 10));
        taskModels.add(new TaskModel(1, "Tugas Basis Data", "Basis Data", "Nikky", "23-febuari-2021", 10, 10));
        taskModels.add(new TaskModel(1, "Tugas Basis Data", "Basis Data", "Nikky", "23-febuari-2021", 10, 10));
        TaskAdapter taskAdapter = new TaskAdapter(getContext(), taskModels);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(taskAdapter);

    }
}