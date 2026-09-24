/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package model;

/**
 * Superclass Orangutan.
 * Menyimpan atribut umum yang dimiliki semua orangutan.
 * Menerapkan encapsulation (private + getter/setter).
 *
 * @author riaza
 */
public class Orangutan {
    // Encapsulation: atribut private
    private String idOrangutan;
    private String nama;
    private int umurTahun;

    // Constructor
    public Orangutan(String idOrangutan, String nama, int umurTahun) {
        this.idOrangutan = idOrangutan;
        this.nama = nama;
        this.umurTahun = umurTahun;
    }

    // Getter & Setter (Encapsulation)
    public String getIdOrangutan() { return idOrangutan; }
    public void setIdOrangutan(String idOrangutan) { this.idOrangutan = idOrangutan; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public int getUmurTahun() { return umurTahun; }
    public void setUmurTahun(int umurTahun) { this.umurTahun = umurTahun; }

    // Method yang akan di-OVERRIDE oleh subclass (Polymorphism) 
    public String getJenisKelamin() {
        return "Tidak Diketahui";
    }

    public String getKategori() {
        return "Orangutan";
    }

    /** Info tambahan spesifik tiap subclass */
    public String getInfoTambahan() {
        return "-";
    }
}