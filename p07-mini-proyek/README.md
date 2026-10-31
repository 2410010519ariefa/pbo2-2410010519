# p07-mini-proyek: Katalog Buku Perpustakaan

Mini proyek Tugas 7 - Tabel, Menu, dan Mini Proyek
Mata kuliah Pemrograman Berbasis Objek 2 (TIF1508)

- Nama: Ariefa Salsabilla Azzahra
- NPM: 2410010519
- Kelas: 5B TI Reg Banjarmasin

Aplikasi desktop **KatalogBuku** untuk mengelola katalog buku perpustakaan. Data ditampilkan pada `JTable` dengan `AbstractTableModel`, ditambah, diubah, dan dihapus melalui `JDialog` modal, serta dapat dicari dan diurutkan. Tampilan memakai FlatLaf.

## Video demo

Tautan video demo (maksimal 3 menit):

https://drive.google.com/file/d/1E6CaOP10ugOl5YexApuJgYlcIWpEV6Uk/view?usp=sharing

## Struktur kelas

| Kelas | Jenis | Keterangan |
|---|---|---|
| `Status` | enum | Status buku: Tersedia atau Dipinjam. `toString()` dipakai sebagai teks di tabel dan combo box |
| `Buku` | record | Data satu buku: kode, judul, penulis, tahun, status |
| `BukuTableModel` | kelas model | Turunan `AbstractTableModel`, menyimpan `List<Buku>` dan memanggil `fireTable...` setelah data berubah |
| `DialogBuku` | JDialog Form (`.form`) | Dialog modal untuk tambah dan ubah buku, lengkap dengan validasi |
| `KatalogBuku` | JFrame Form (`.form`) | Jendela utama: tabel, tombol, kolom cari, menu, dan label status |

## Fitur

| No | Fitur | Penerapan |
|---|---|---|
| 1 | Tabel buku | Kolom Kode, Judul, Penulis, Tahun Terbit, dan Status memakai `BukuTableModel` |
| 2 | Data contoh | Enam buku ditampilkan saat aplikasi dibuka |
| 3 | Tambah dan ubah | Melalui `DialogBuku` (modal). Kode dan judul wajib diisi. Tahun berupa angka 1900 sampai tahun sekarang |
| 4 | Hapus | Dengan dialog konfirmasi. Nomor baris diubah dengan `convertRowIndexToModel` |
| 5 | Menu | Menu File dan Buku. Mnemonic Alt+F dan Alt+B. Accelerator Ctrl+N (Tambah), Ctrl+E (Ubah), Ctrl+D (Hapus) |
| 6 | Pencarian | Menyaring berdasarkan kode, judul, atau penulis (huruf besar dan kecil dianggap sama) |
| 7 | Status | Label menampilkan jumlah buku yang ditampilkan dan jumlah buku yang tersedia |
| 8 | Tampilan | JFrame Form dan JDialog Form dengan file `.form`, FlatLaf, tombol Ubah dan Hapus aktif hanya jika ada baris yang dipilih |
| 9 | Dokumentasi | README ini, berisi peta event dan tautan video demo |

## Peta event

### Jendela utama (`KatalogBuku`)

| Komponen | Event | Method | Isi |
|---|---|---|---|
| `tambahButton` | Action: actionPerformed | `tambahButtonActionPerformed` | Memanggil `tambah()` |
| `ubahButton` | Action: actionPerformed | `ubahButtonActionPerformed` | Memanggil `ubah()` |
| `hapusButton` | Action: actionPerformed | `hapusButtonActionPerformed` | Memanggil `hapus()` |
| `tambahItem` (Ctrl+N) | Action: actionPerformed | `tambahItemActionPerformed` | Memanggil `tambah()` |
| `ubahItem` (Ctrl+E) | Action: actionPerformed | `ubahItemActionPerformed` | Memanggil `ubah()` |
| `hapusItem` (Ctrl+D) | Action: actionPerformed | `hapusItemActionPerformed` | Memanggil `hapus()` |
| `keluarItem` | Action: actionPerformed | `keluarItemActionPerformed` | Menutup jendela dengan `dispose()` |
| `cariField` | Key: keyReleased | `cariFieldKeyReleased` | Memanggil `saring()` |
| `bukuTable` | Mouse: mouseClicked | `bukuTableMouseClicked` | Klik dua kali memanggil `ubah()` |
| `bukuTable` (pemilihan baris) | `ListSelectionListener` (dipasang di konstruktor karena tidak ada di menu Events) | `perbaruiTombol()` | Mengaktifkan atau menonaktifkan tombol dan item menu Ubah dan Hapus |

### Dialog (`DialogBuku`)

| Komponen | Event | Method | Isi |
|---|---|---|---|
| `batalButton` | Action: actionPerformed | `batalButtonActionPerformed` | Menutup dialog dengan `dispose()`, hasil tetap `null` |
| `simpanButton` | Action: actionPerformed | `simpanButtonActionPerformed` | Memanggil `simpan()` untuk validasi lalu menyimpan hasil |

### Alur data

1. Tombol atau menu memanggil `tambah()`, `ubah()`, atau `hapus()` pada `KatalogBuku`.
2. `tambah()` dan `ubah()` membuka `DialogBuku` melalui `tampilkan()`. Karena dialog modal, baris berikutnya menunggu sampai dialog ditutup.
3. Jika `tampilkan()` mengembalikan `Buku` (bukan `null`), data dimasukkan ke `BukuTableModel`, lalu model memanggil `fireTable...` sehingga tabel menggambar ulang.
4. `perbaruiStatus()` memperbarui label jumlah buku.

## Validasi pada dialog

| Isian | Aturan | Pesan |
|---|---|---|
| Kode | Wajib diisi | Kode wajib diisi |
| Judul | Wajib diisi | Judul wajib diisi |
| Tahun terbit | Angka 1900 sampai tahun sekarang | Tahun terbit berupa angka 1900 sampai tahun sekarang |
| Penulis | Boleh dikosongkan | - |

## Deklarasi penggunaan AI

- **Alat yang dipakai:** Claude (Anthropic).
- **Keperluan:**
  - Memandu langkah pengerjaan praktikum dan mini proyek di Apache NetBeans (langkah GUI Builder, pengaturan properti, event, dan Git).
  - Menyediakan contoh kode untuk kelas model, dialog, event handler, dan method bantu, yang kemudian saya ketik atau tempel, jalankan, dan uji sendiri di NetBeans.
  - Membantu menemukan penyebab error saat pengerjaan.
  - Membantu menyusun draf README dan skrip video demo.
