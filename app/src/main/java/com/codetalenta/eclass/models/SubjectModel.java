package com.codetalenta.eclass.models;

public class SubjectModel {
    private String iconMatkul, namaMatkul;

    public SubjectModel(String iconMatkul, String namaMatkul) {
        this.iconMatkul = iconMatkul;
        this.namaMatkul = namaMatkul;
    }

    public String getIconMatkul() {
        return iconMatkul;
    }

    public void setIconMatkul(String iconMatkul) {
        this.iconMatkul = iconMatkul;
    }

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public void setNamaMatkul(String namaMatkul) {
        this.namaMatkul = namaMatkul;
    }
}
