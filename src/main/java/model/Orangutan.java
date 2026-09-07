/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author riaza
 */
public class Orangutan {
    // Nilai Tambah: Access Modifier private & Encapsulation
    private String idOrangutan;
    private String nama;
    private int umurTahun;
    private String jenisKelamin; // Jantan / Betina

    // Constructor
    public Orangutan(String idOrangutan, String nama, int umurTahun, String jenisKelamin) {
        this.idOrangutan = idOrangutan;
        this.nama = nama;
        this.umurTahun = umurTahun;
        this.jenisKelamin = jenisKelamin;
    }

    // Getter & Setter (Encapsulation)
    public String getIdOrangutan() { return idOrangutan; }
    public void setIdOrangutan(String idOrangutan) { this.idOrangutan = idOrangutan; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public int getUmurTahun() { return umurTahun; }
    public void setUmurTahun(int umurTahun) { this.umurTahun = umurTahun; }

    public String getJenisKelamin() { return jenisKelamin; }
    public void setJenisKelamin(String jenisKelamin) { this.jenisKelamin = jenisKelamin; }
}
