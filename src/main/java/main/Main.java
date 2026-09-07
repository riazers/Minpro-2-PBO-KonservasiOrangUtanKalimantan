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
            System.out.println("3. Update Status Tahapan Rehabilitasi (Update)");
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
                    updateStatus();
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
        String idCatatan = "OU-KAL-" + (daftarKonservasi.size() + 101);

        String nama = inputString("Nama Orangutan: ");
        int umur = inputInteger("Estimasi Umur (Tahun): ");
        
        System.out.println("Jenis Kelamin: 1. Jantan | 2. Betina");
        int jkPilihan = inputInteger("Pilih [1/2]: ");
        String jenisKelamin = (jkPilihan == 1) ? "Jantan" : "Betina";

        System.out.println("\nPilih Wilayah Konservasi di Kalimantan:");
        System.out.println("1. TN Tanjung Puting (Kalimantan Tengah)");
        System.out.println("2. TN Sebangau (Kalimantan Tengah)");
        System.out.println("3. TN Betung Kerihun (Kalimantan Barat)");
        System.out.println("4. TN Kutai (Kalimantan Timur)");
        int opsiLokasi = inputInteger("Pilih Wilayah [1-4]: ");

        LokasiHabitat lokasi;
        switch (opsiLokasi) {
            case 1:
                lokasi = new LokasiHabitat("LOC-01", "TN Tanjung Puting", "Kalimantan Tengah", "Taman Nasional");
                break;
            case 2:
                lokasi = new LokasiHabitat("LOC-02", "TN Sebangau", "Kalimantan Tengah", "Taman Nasional");
                break;
            case 3:
                lokasi = new LokasiHabitat("LOC-03", "TN Betung Kerihun", "Kalimantan Barat", "Taman Nasional");
                break;
            default:
                lokasi = new LokasiHabitat("LOC-04", "TN Kutai", "Kalimantan Timur", "Taman Nasional");
                break;
        }

        System.out.println("\nStatus Tahap Konservasi:");
        System.out.println("1. Karantina Medis");
        System.out.println("2. Sekolah Hutan (Forest School)");
        System.out.println("3. Pulau Pra-Rilis");
        System.out.println("4. Liar / Rilis Penuh");
        int opsiStatus = inputInteger("Pilih Status [1-4]: ");
        
        String status;
        if (opsiStatus == 1) status = "Karantina Medis";
        else if (opsiStatus == 2) status = "Sekolah Hutan";
        else if (opsiStatus == 3) status = "Pra-Rilis";
        else status = "Liar / Rilis";

        Orangutan orangutan = new Orangutan("ID-" + (System.currentTimeMillis() % 1000), nama, umur, jenisKelamin);
        CatatanRehabilitasi catatan = new CatatanRehabilitasi(idCatatan, orangutan, lokasi, status);

        daftarKonservasi.add(catatan);
        System.out.println("✓ Sukses: Data berhasil didaftarkan dengan Kode Registrasi: " + idCatatan);
    }

    // 2. READ (Menerapkan perulangan)
    private static void tampilkanData() {
        System.out.println("\n==========================================================================================================");
        System.out.printf("| %-11s | %-12s | %-6s | %-8s | %-20s | %-18s | %-15s |\n",
                "ID Catatan", "Nama", "Umur", "Gender", "Wilayah Habitat", "Provinsi", "Status");
        System.out.println("==========================================================================================================");

        if (daftarKonservasi.isEmpty()) {
            System.out.println("|                                      Belum ada data konservasi.                                        |");
        } else {
            for (CatatanRehabilitasi c : daftarKonservasi) {
                System.out.printf("| %-11s | %-12s | %-6s | %-8s | %-20s | %-18s | %-15s |\n",
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
    private static void updateStatus() {
        tampilkanData();
        if (daftarKonservasi.isEmpty()) return;

        String idCari = inputString("\nMasukkan ID Catatan yang ingin diubah statusnya: ");
        CatatanRehabilitasi target = cariDataById(idCari);

        if (target != null) {
            System.out.println("Orangutan: " + target.getOrangutan().getNama());
            System.out.println("Status saat ini: " + target.getStatusKesehatan());
            System.out.println("\nPilih Status Baru:");
            System.out.println("1. Karantina Medis");
            System.out.println("2. Sekolah Hutan");
            System.out.println("3. Pra-Rilis");
            System.out.println("4. Liar / Rilis Selesai");
            
            int opsi = inputInteger("Pilihan [1-4]: ");
            if (opsi == 1) target.setStatusKesehatan("Karantina Medis");
            else if (opsi == 2) target.setStatusKesehatan("Sekolah Hutan");
            else if (opsi == 3) target.setStatusKesehatan("Pra-Rilis");
            else if (opsi == 4) target.setStatusKesehatan("Liar / Rilis");
            else System.out.println("Opsi tidak valid.");

            System.out.println("✓ Status berhasil diperbarui!");
        } else {
            System.out.println("Data dengan ID " + idCari + " tidak ditemukan.");
        }
    }

    // 4. DELETE
    private static void hapusData() {
        tampilkanData();
        if (daftarKonservasi.isEmpty()) return;

        String idCari = inputString("\nMasukkan ID Catatan yang ingin dihapus: ");
        CatatanRehabilitasi target = cariDataById(idCari);

        if (target != null) {
            daftarKonservasi.remove(target);
            System.out.println("✓ Data catatan " + idCari + " berhasil dihapus dari sistem!");
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
        daftarKonservasi.add(new CatatanRehabilitasi("OU-KAL-101", o1, l1, "Sekolah Hutan"));
    }
}
