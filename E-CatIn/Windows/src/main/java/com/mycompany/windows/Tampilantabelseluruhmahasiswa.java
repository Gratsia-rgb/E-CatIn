/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.windows;

/**
 *
 * @author Don Harry
 */
public class Tampilantabelseluruhmahasiswa {
   private Integer ID_Mahasiswa,NIM;
   private String nama,password,poin,kegiatan,jeniskegiatan;

    public Tampilantabelseluruhmahasiswa(Integer ID_Mahasiswa, Integer NIM, String nama, String password, String poin, String kegiatan, String jeniskegiatan) {
        this.ID_Mahasiswa = ID_Mahasiswa;
        this.NIM = NIM;
        this.nama = nama;
        this.password = password;
        this.poin = poin;
        this.kegiatan = kegiatan;
        this.jeniskegiatan = jeniskegiatan;
    }

    public Integer getID_Mahasiswa() {
        return ID_Mahasiswa;
    }

    public void setID_Mahasiswa(Integer ID_Mahasiswa) {
        this.ID_Mahasiswa = ID_Mahasiswa;
    }

    public Integer getNIM() {
        return NIM;
    }

    public void setNIM(Integer NIM) {
        this.NIM = NIM;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPoin() {
        return poin;
    }

    public void setPoin(String poin) {
        this.poin = poin;
    }

    public String getKegiatan() {
        return kegiatan;
    }

    public void setKegiatan(String kegiatan) {
        this.kegiatan = kegiatan;
    }

    public String getJeniskegiatan() {
        return jeniskegiatan;
    }

    public void setJeniskegiatan(String jeniskegiatan) {
        this.jeniskegiatan = jeniskegiatan;
    }
   
}
