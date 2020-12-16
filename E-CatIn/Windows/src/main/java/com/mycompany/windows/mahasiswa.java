/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.windows;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Asus
 */
public class mahasiswa {
    private SimpleIntegerProperty nim;
    private SimpleStringProperty nama;
    private SimpleStringProperty kegiatan;
    private SimpleStringProperty jeniskegiatan;
    private SimpleIntegerProperty poin;

   
    public mahasiswa(){
        this.nim= null;
        this.nama = null;
        this.kegiatan = null;
        this.jeniskegiatan = null;
        this.poin = null;
    }
    
    public mahasiswa (int nim, String nama, String kegiatan, String jeniskegiatan, int poin){
        this.nim = new SimpleIntegerProperty(nim);
        this.nama = new SimpleStringProperty(nama);
        this.kegiatan = new SimpleStringProperty(kegiatan);
        this.jeniskegiatan = new SimpleStringProperty (jeniskegiatan);
        this.poin = new SimpleIntegerProperty(poin);
    }
    
    public mahasiswa(String nama, String kegiatan, String jeniskegiatan){
        this.nim = null;
        this.nama = null;
        this.kegiatan = null;
        this.jeniskegiatan = null;
        this.poin = null;
    }
    
    public int getNim(){
        return nim.get();
    }
    
    public String getNama(){
        return nama.get();
    }
    
    public String getKegiatan(){
        return kegiatan.get();
    }
    
    public String getJeniskegiatan(){
        return jeniskegiatan.get();
    }
    
    public int getPoin(){
        return poin.get();
    }
    
    public void setNim(SimpleIntegerProperty nim){
        this.nim=nim;
    }
    
    public void setNama(SimpleStringProperty nama){
        this.nama=nama;
    }
    public void setKegiatan(SimpleStringProperty kegiatan){
        this.kegiatan=kegiatan;
    }
     public void setJeniskegiatan(SimpleStringProperty jeniskegiatan){
         this.jeniskegiatan=jeniskegiatan;
     }
     public void setPoin(SimpleIntegerProperty poin){
         this.poin = poin;
     }
   
}
