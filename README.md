# Minpro-2-PBO-KonservasiOrangutanKalimantan

    Dibuat oleh: Riaz Ramadhan Al Fattah
    NIM: 2509116106

<p align="left">
<img src="https://user-images.githubusercontent.com/74038190/212257468-1e9a91f1-b626-4baa-b15d-5c385dfa7ed2.gif" width="200">
</p>


## Daftar Isi
### - [Deskripsi Program](#deskripsi-program) 
### - [Penjelasan Alur Program](#penjelasan-alur-program)
### - [Struktur Package](#struktur-package-(MVC))

## Deskripsi Program
**Sistem Konservasi & Rehabilitasi Orangutan Kalimantan** adalah aplikasi berbasis **Java CLI** yang dikembangkan dari Mini Project 1. Program ini digunakan untuk mendata, memantau, dan mengelola tahapan rehabilitasi orangutan di berbagai Taman Nasional di Pulau Kalimantan. Program menerapkan **CRUD penuh** dengan pendekatan **Object-Oriented Programming (OOP)** serta **arsitektur MVC (Model–View–Controller)**.

Pada Mini Project 2 ini ditambahkan:
- **Inheritance**: `Orangutan` (superclass) dengan 2 subclass `OrangutanJantan` dan `OrangutanBetina`.
- **Polymorphism**: method `getJenisKelamin()`, `getKategori()`, dan `getInfoTambahan()` di-*override* oleh subclass, serta *casting* runtime (`instanceof`) pada saat update.
- **Struktur MVC**: pemisahan `model`, `view`, `controller`, `main`.
- **Dummy data awal**: 2 data orangutan langsung tampil saat fitur Read pertama kali dibuka.

## Penjelasan Alur Program
1. **Start** -> `Main` membuat `KonservasiView` dan `KonservasiController`. Controller otomatis mengisi **2 dummy data** ke ArrayList.
2. **Menu Utama (loop `do-while`)** → Menampilkan 5 pilihan. Program berhenti hanya jika user memilih **5. Keluar**.
3. **Create** -> User memasukkan nama, umur, jenis kelamin. Jika **Jantan**, diminta `cheek pads`; jika **Betina**, diminta `jumlah anak`. Objek dibuat sebagai `OrangutanJantan` / `OrangutanBetina` (polymorphic). Data disimpan dengan ID `C1`, `C2`, dst.
4. **Read** -> Menampilkan seluruh data dalam tabel (perulangan `for-each`). Kolom **Kategori**, **Gender**, dan **Info Tambahan** diambil dari method yang di-*override* (polymorphism).
5. **Update** -> User memilih ID, lalu masuk submenu update yang dapat mengubah:
   - Nama, Umur
   - Info khusus (Cheek Pads / Jumlah Anak) — menggunakan `instanceof` + casting
   - Lokasi, Status
6. **Delete** -> Menghapus data berdasarkan ID.
7. **Keluar** -> Program berhenti.

## 🏛️ Struktur Package (MVC)
