/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import model.CatatanRehabilitasi;
import model.LokasiHabitat;
import model.Orangutan;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author riaza
 */
public class Main {
    // Menerapkan ArrayList
    private static ArrayList<CatatanRehabilitasi> daftarKonservasi = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Counter untuk ID Catatan yang lebih mudah dibaca
    private static int counterCatatan = 1;

    public static void main(String[] args) {
        // Data Awal
        inisialisasiDataAwal();

        int pilihan = 0;

        // Menerapkan perulangan agar program tidak berhenti
        do {
            System.out.println("\n=======================================================");
            System.out.println("  SISTEM KONSERVASI & REHABILITASI ORANGUTAN KALIMANTAN ");
            System.out.println("=======================================================");
            System.out.println("1. Tambah Data Observasi / Rehabilitasi (Create)");
            System.out.println("2. Tampilkan Semua Data Orangutan (Read)");
            System.out.println("3. Update Data Observasi / Rehabilitasi (Update)");
            System.out.println("4. Hapus Data Catatan Konservasi (Delete)");
            System.out.println("5. Keluar Program");
            System.out.println("-------------------------------------------------------");

            // Nilai Tambah: Validasi Input
            pilihan = inputInteger("Pilih menu [1-5]: ");

            // Percabangan memilih menu
            switch (pilihan) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    tampilkanData();
                    break;
                case 3:
                    updateData();
                    break;
                case 4:
                    hapusData();
                    break;
                case 5:
                    System.out.println("\nProgram selesai. Salam Lestari Konservasi Orangutan!");
                    break;
                default:
                    System.out.println("[Peringatan] Pilihan tidak valid. Silakan pilih menu 1-5.");
            }
        } while (pilihan != 5);
    }

    // 1. CREATE
    private static void tambahData() {
        System.out.println("\n--- Registrasi Orangutan Baru ---");

        // Format ID baru: CR001, CR002, dst.
        String idCatatan = generateIdCatatan();

        String nama = inputString("Nama Orangutan: ");
        int umur = inputInteger("Estimasi Umur (Tahun): ");
        String jenisKelamin = pilihJenisKelamin();

        LokasiHabitat lokasi = pilihLokasi();
        String status = pilihStatus();

        Orangutan orangutan = new Orangutan(
                "ID-" + (System.currentTimeMillis() % 1000),
                nama,
                umur,
                jenisKelamin
        );

        CatatanRehabilitasi catatan = new CatatanRehabilitasi(idCatatan, orangutan, lokasi, status);
        daftarKonservasi.add(catatan);

        System.out.println("Sukses: Data berhasil didaftarkan dengan Kode Registrasi: " + idCatatan);
    }

    // Helper membuat ID Catatan yang lebih mudah diketik
    private static String generateIdCatatan() {
        return String.format("CR%03d", counterCatatan++);
    }

    // Helper pilih jenis kelamin
    private static String pilihJenisKelamin() {
        System.out.println("Jenis Kelamin: 1. Jantan | 2. Betina");
        int jkPilihan = inputInteger("Pilih [1/2]: ");
        return (jkPilihan == 1) ? "Jantan" : "Betina";
    }

    // Helper pilih lokasi habitat
    private static LokasiHabitat pilihLokasi() {
        System.out.println("\nPilih Wilayah Konservasi di Kalimantan:");
        System.out.println("1. TN Tanjung Puting (Kalimantan Tengah)");
        System.out.println("2. TN Sebangau (Kalimantan Tengah)");
        System.out.println("3. TN Betung Kerihun (Kalimantan Barat)");
        System.out.println("4. TN Kutai (Kalimantan Timur)");

        int opsiLokasi = inputInteger("Pilih Wilayah [1-4]: ");

        switch (opsiLokasi) {
            case 1:
                return new LokasiHabitat("LOC-01", "TN Tanjung Puting", "Kalimantan Tengah", "Taman Nasional");
            case 2:
                return new LokasiHabitat("LOC-02", "TN Sebangau", "Kalimantan Tengah", "Taman Nasional");
            case 3:
                return new LokasiHabitat("LOC-03", "TN Betung Kerihun", "Kalimantan Barat", "Taman Nasional");
            default:
                return new LokasiHabitat("LOC-04", "TN Kutai", "Kalimantan Timur", "Taman Nasional");
        }
    }

    // Helper pilih status rehabilitasi
    private static String pilihStatus() {
        System.out.println("\nStatus Tahap Konservasi:");
        System.out.println("1. Karantina Medis");
        System.out.println("2. Sekolah Hutan (Forest School)");
        System.out.println("3. Pulau Pra-Rilis");
        System.out.println("4. Liar / Rilis Penuh");

        int opsiStatus = inputInteger("Pilih Status [1-4]: ");

        switch (opsiStatus) {
            case 1:
                return "Karantina Medis";
            case 2:
                return "Sekolah Hutan";
            case 3:
                return "Pra-Rilis";
            default:
                return "Liar / Rilis";
        }
    }

    // 2. READ
    private static void tampilkanData() {
        System.out.println("\n==========================================================================================================");
        System.out.printf("| %-10s | %-12s | %-6s | %-8s | %-20s | %-18s | %-15s |\n",
                "ID Catatan", "Nama", "Umur", "Gender", "Wilayah Habitat", "Provinsi", "Status");
        System.out.println("==========================================================================================================");

        if (daftarKonservasi.isEmpty()) {
            System.out.println("|                                      Belum ada data konservasi.                                        |");
        } else {
            for (CatatanRehabilitasi c : daftarKonservasi) {
                System.out.printf("| %-10s | %-12s | %-6s | %-8s | %-20s | %-18s | %-15s |\n",
                        c.getIdCatatan(),
                        c.getOrangutan().getNama(),
                        c.getOrangutan().getUmurTahun() + " Thn",
                        c.getOrangutan().getJenisKelamin(),
                        c.getLokasi().getNamaWilayah(),
                        c.getLokasi().getProvinsi(),
                        c.getStatusKesehatan());
            }
        }

        System.out.println("==========================================================================================================");
    }

    // 3. UPDATE
    private static void updateData() {
        tampilkanData();
        if (daftarKonservasi.isEmpty()) return;

        String idCari = inputString("\nMasukkan ID Catatan yang ingin diubah: ");
        CatatanRehabilitasi target = cariDataById(idCari);

        if (target == null) {
            System.out.println("Data dengan ID " + idCari + " tidak ditemukan.");
            return;
        }

        int pilihan;

        do {
            System.out.println("\n--- Update Data: " + target.getIdCatatan() + " ---");
            System.out.println("1. Ubah ID Catatan");
            System.out.println("2. Ubah Nama Orangutan");
            System.out.println("3. Ubah Umur");
            System.out.println("4. Ubah Jenis Kelamin");
            System.out.println("5. Ubah ID Orangutan");
            System.out.println("6. Ganti Seluruh Data Orangutan");
            System.out.println("7. Ganti Lokasi Habitat dari Daftar");
            System.out.println("8. Ubah ID Lokasi");
            System.out.println("9. Ubah Nama Wilayah");
            System.out.println("10. Ubah Provinsi");
            System.out.println("11. Ubah Status Zona");
            System.out.println("12. Ubah Status Tahap Rehabilitasi");
            System.out.println("0. Selesai / Simpan");

            pilihan = inputInteger("Pilih menu update [0-12]: ");

            switch (pilihan) {
                case 1:
                    String idBaru = inputString("ID Catatan baru: ");
                    if (cariDataById(idBaru) != null && !idBaru.equalsIgnoreCase(target.getIdCatatan())) {
                        System.out.println("ID Catatan sudah digunakan. Gunakan ID lain.");
                    } else {
                        target.setIdCatatan(idBaru);
                        System.out.println("ID Catatan berhasil diubah.");
                    }
                    break;

                case 2:
                    target.getOrangutan().setNama(inputString("Nama baru: "));
                    System.out.println("Nama berhasil diubah.");
                    break;

                case 3:
                    target.getOrangutan().setUmurTahun(inputInteger("Umur baru (tahun): "));
                    System.out.println("Umur berhasil diubah.");
                    break;

                case 4:
                    target.getOrangutan().setJenisKelamin(pilihJenisKelamin());
                    System.out.println("Jenis kelamin berhasil diubah.");
                    break;

                case 5:
                    target.getOrangutan().setIdOrangutan(inputString("ID Orangutan baru: "));
                    System.out.println("ID Orangutan berhasil diubah.");
                    break;

                case 6:
                    System.out.println("Masukkan data Orangutan baru:");
                    String idOr = inputString("ID Orangutan: ");
                    String nama = inputString("Nama: ");
                    int umur = inputInteger("Umur (tahun): ");
                    String jk = pilihJenisKelamin();

                    target.setOrangutan(new Orangutan(idOr, nama, umur, jk));
                    System.out.println("Data Orangutan berhasil diganti.");
                    break;

                case 7:
                    target.setLokasi(pilihLokasi());
                    System.out.println("Lokasi habitat berhasil diganti.");
                    break;

                case 8:
                    target.getLokasi().setIdLokasi(inputString("ID Lokasi baru: "));
                    System.out.println("ID Lokasi berhasil diubah.");
                    break;

                case 9:
                    target.getLokasi().setNamaWilayah(inputString("Nama wilayah baru: "));
                    System.out.println("Nama wilayah berhasil diubah.");
                    break;

                case 10:
                    target.getLokasi().setProvinsi(inputString("Provinsi baru: "));
                    System.out.println("Provinsi berhasil diubah.");
                    break;

                case 11:
                    target.getLokasi().setStatusZona(inputString("Status zona baru: "));
                    System.out.println("Status zona berhasil diubah.");
                    break;

                case 12:
                    target.setStatusKesehatan(pilihStatus());
                    System.out.println("Status tahap rehabilitasi berhasil diubah.");
                    break;

                case 0:
                    System.out.println("Update selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }

    // 4. DELETE
    private static void hapusData() {
        tampilkanData();
        if (daftarKonservasi.isEmpty()) return;

        String idCari = inputString("\nMasukkan ID Catatan yang ingin dihapus: ");
        CatatanRehabilitasi target = cariDataById(idCari);

        if (target != null) {
            daftarKonservasi.remove(target);
            System.out.println("Data catatan " + idCari + " berhasil dihapus dari sistem!");
        } else {
            System.out.println("Data dengan ID " + idCari + " tidak ditemukan.");
        }
    }

    // Helper pencarian
    private static CatatanRehabilitasi cariDataById(String id) {
        for (CatatanRehabilitasi c : daftarKonservasi) {
            if (c.getIdCatatan().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }

    // Nilai Tambah: Validasi Integer
    private static int inputInteger(String pesan) {
        while (true) {
            System.out.print(pesan);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("[Error] Masukkan angka yang valid!");
            }
        }
    }

    // Nilai Tambah: Validasi String
    private static String inputString(String pesan) {
        while (true) {
            System.out.print(pesan);
            String val = scanner.nextLine().trim();
            if (!val.isEmpty()) {
                return val;
            }
            System.out.println("[Error] Teks tidak boleh kosong!");
        }
    }

    // Data Awal (Dummy)
    private static void inisialisasiDataAwal() {
        Orangutan o1 = new Orangutan("ID-001", "Boni", 5, "Jantan");
        LokasiHabitat l1 = new LokasiHabitat("LOC-01", "TN Tanjung Puting", "Kalimantan Tengah", "Taman Nasional");

        daftarKonservasi.add(new CatatanRehabilitasi("CR001", o1, l1, "Sekolah Hutan"));

        // ID berikutnya menjadi CR002
        counterCatatan = 2;
    }
}