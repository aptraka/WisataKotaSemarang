package com.aditya.wisatasemarang.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WisataResponse {
    @SerializedName("data")
    ArrayList<WisataModel> data = new ArrayList<>();

    @SerializedName("sukses")
    String status;

    @SerializedName("pesan")
    String pesan;

    public WisataResponse(ArrayList<WisataModel> data, String status, String pesan) {
        this.data = data;
        this.status = status;
        this.pesan = pesan;
    }

    public ArrayList<WisataModel> getData() {
        return data;
    }

    public void setData(ArrayList<WisataModel> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }
}
