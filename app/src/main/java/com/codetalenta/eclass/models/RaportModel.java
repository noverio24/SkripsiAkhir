package com.codetalenta.eclass.models;

public class RaportModel {
    private String namaKelas, namaPengajar, nilai, status;

    public RaportModel(String namaKelas, String namaPengajar, String nilai, String status) {
        this.namaKelas = namaKelas;
        this.namaPengajar = namaPengajar;
        this.nilai = nilai;
        this.status = status;
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

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
