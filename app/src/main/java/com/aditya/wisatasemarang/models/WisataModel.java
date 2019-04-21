package com.aditya.wisatasemarang.models;

import com.google.gson.annotations.SerializedName;

public class WisataModel {
    @SerializedName("id")
    private  String id;

    @SerializedName("nama_pariwisata")
    private  String nama;

    @SerializedName("alamat_pariwisata")
    private  String alamat;

    @SerializedName("detail_pariwisata")
    private  String deskripsi;

    @SerializedName("gambar_pariwisata")
    private  String gambar;

    @SerializedName("maps")
    private  String maps;

    public WisataModel(String id, String nama, String alamat, String deskripsi, String gambar, String maps) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
        this.maps = maps;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getMaps() {
        return maps;
    }

    public void setMaps(String maps) {
        this.maps = maps;
    }
}
