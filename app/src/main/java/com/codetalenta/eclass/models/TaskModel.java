package com.codetalenta.eclass.models;

public class TaskModel {
    private String judulTugas, namaKelas, namaPengajar, tanggal;
    private int jumlahHadir, totalMahasiswa, id;


    public TaskModel( int id, String judulTugas, String namaKelas, String namaPengajar, String tanggal, int jumlahHadir, int totalMahasiswa) {
        this.judulTugas = judulTugas;
        this.namaKelas = namaKelas;
        this.namaPengajar = namaPengajar;
        this.tanggal = tanggal;
        this.jumlahHadir = jumlahHadir;
        this.totalMahasiswa = totalMahasiswa;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudulTugas() {
        return judulTugas;
    }

    public void setJudulTugas(String judulTugas) {
        this.judulTugas = judulTugas;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public String getNamaPengajar() {
        return namaPengajar;
    }

    public void setNamaPengajar(String namaPengajar) {
        this.namaPengajar = namaPengajar;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getJumlahHadir() {
        return jumlahHadir;
    }

    public void setJumlahHadir(int jumlahHadir) {
        this.jumlahHadir = jumlahHadir;
    }

    public int getTotalMahasiswa() {
        return totalMahasiswa;
    }

    public void setTotalMahasiswa(int totalMahasiswa) {
        this.totalMahasiswa = totalMahasiswa;
    }
}
