package com.bailram.restfullapi.model;

import javax.persistence.*;

@Entity
@Table(name = "mahasiswa")
public class Mahasiswa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NIM", length = 20)
    private int nim;
    @Column(name = "nama")
    private String nama;
    @Column(name = "jurusan")
    private String jurusan;
    @Column(name = "ipk")
    private float ipk;

    public Mahasiswa() {
    }

    public Mahasiswa(String nama, String jurusan, float ipk) {
        this.nama = nama;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }

    public Mahasiswa(int nim, String nama, String jurusan, float ipk) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }

    public int getNim() {
        return nim;
    }

    public void setNim(int nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public float getIpk() {
        return ipk;
    }

    public void setIpk(float ipk) {
        this.ipk = ipk;
    }
}
