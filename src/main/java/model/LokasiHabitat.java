/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author riaza
 */
public class LokasiHabitat {
    private String idLokasi;
    private String namaWilayah; // contoh: TN Tanjung Puting, TN Sebangau
    private String provinsi;    // Kalteng, Kalbar, Kaltim, dll.
    private String statusZona;  // Hutan Lindung, Suaka Margasatwa, Taman Nasional

    // Constructor
    public LokasiHabitat(String idLokasi, String namaWilayah, String provinsi, String statusZona) {
        this.idLokasi = idLokasi;
        this.namaWilayah = namaWilayah;
        this.provinsi = provinsi;
        this.statusZona = statusZona;
    }

    // Getter & Setter
    public String getIdLokasi() { return idLokasi; }
    public void setIdLokasi(String idLokasi) { this.idLokasi = idLokasi; }

    public String getNamaWilayah() { return namaWilayah; }
    public void setNamaWilayah(String namaWilayah) { this.namaWilayah = namaWilayah; }

    public String getProvinsi() { return provinsi; }
    public void setProvinsi(String provinsi) { this.provinsi = provinsi; }

    public String getStatusZona() { return statusZona; }
    public void setStatusZona(String statusZona) { this.statusZona = statusZona; }
}
