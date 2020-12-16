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


 String nim,nama,poin,kegiatan,jeniskegiatan;

    public Tampilantabelseluruhmahasiswa(String nim, String nama, String poin, String kegiatan, String jeniskegiatan) {
        this.nim = nim;
        this.nama = nama;
        this.poin = poin;
        this.kegiatan = kegiatan;
        this.jeniskegiatan = jeniskegiatan;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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
