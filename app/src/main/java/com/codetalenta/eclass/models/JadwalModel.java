package com.codetalenta.eclass.models;

public class JadwalModel {

    private int id, totalMahasiswa, totalHadir;
    private String namaKelas, universitas, dosen;

    public JadwalModel(int id, int totalMahasiswa, int totalHadir, String namaKelas, String universitas, String dosen) {
        this.id = id;
        this.totalMahasiswa = totalMahasiswa;
        this.totalHadir = totalHadir;
        this.namaKelas = namaKelas;
        this.universitas = universitas;
        this.dosen = dosen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalMahasiswa() {
        return totalMahasiswa;
    }

    public void setTotalMahasiswa(int totalMahasiswa) {
        this.totalMahasiswa = totalMahasiswa;
    }

    public int getTotalHadir() {
        return totalHadir;
    }

    public void setTotalHadir(int totalHadir) {
        this.totalHadir = totalHadir;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public String getUniversitas() {
        return universitas;
    }

    public void setUniversitas(String universitas) {
        this.universitas = universitas;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }
}
