package com.tabian.saveanddisplaysql;

public class PeopleModel {
    private String nama, nohp;

    public PeopleModel(String nama, String nohp) {
        this.nama = nama;
        this.nohp = nohp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }
}
