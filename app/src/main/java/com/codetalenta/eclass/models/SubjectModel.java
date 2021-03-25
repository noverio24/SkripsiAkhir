package com.codetalenta.eclass.models;

public class SubjectModel {
    String name,code , description , schedule, notedWeek,time, namaMatkul;
    int nilaiPresent,dosen_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getNotedWeek() {
        return notedWeek;
    }

    public void setNotedWeek(String notedWeek) {
        this.notedWeek = notedWeek;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public void setNamaMatkul(String namaMatkul) {
        this.namaMatkul = namaMatkul;
    }

    public int getNilaiPresent() {
        return nilaiPresent;
    }

    public void setNilaiPresent(int nilaiPresent) {
        this.nilaiPresent = nilaiPresent;
    }

    public int getDosen_id() {
        return dosen_id;
    }

    public void setDosen_id(int dosen_id) {
        this.dosen_id = dosen_id;
    }
}
