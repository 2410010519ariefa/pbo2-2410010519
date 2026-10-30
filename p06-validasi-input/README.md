# Tugas 6 - Validasi Input dan Kegunaan

Mata kuliah: Pemrograman Berbasis Objek 2 (TIF1508), Pertemuan 6

Nama: Ariefa Salsabilla Azzahra
NPM: 2410010519
Kelas: 5B TI Reg Bjm

Proyek: `p06-validasi-input` (package `id.ac.uniska.pbo2.p06`)

File form yang dikumpulkan: `FormAnggota.java` dan `FormAnggota.form`. Nama form mengikuti Praktikum 3 di modul, yaitu `FormAnggota`.

File lain di proyek:
- `Validator.java`: aturan validasi NPM, nama, email, dan nomor HP.
- `UjiValidator.java`: pengujian aturan Validator tanpa GUI.
- `P06ValidasiInput.java`: kelas bawaan NetBeans saat proyek dibuat.

## 1. Lembar Peer Review

Teman peninjau: (diisi setelah peer review)

![Lembar peer review](screenshots/peer-review.jpg)

## 2. Temuan Teman, Perbaikan, dan Commit

| No | Temuan dari teman | Skor | Perbaikan yang saya lakukan | Commit |
|----|-------------------|------|-----------------------------|--------|
| 1  | (diisi setelah peer review) | | | |

## 3. Tangkapan Layar

Form dengan pesan kesalahan (garis merah, pesan di bawah isian, dan ringkasan jumlah kesalahan):

![Form dengan pesan kesalahan](screenshots/screenshot-form-error.png)

Jendela Navigator yang memperlihatkan label pesan (`npmPesanLabel`, `namaPesanLabel`, `prodiPesanLabel`, `emailPesanLabel`, `hpPesanLabel`):

![Jendela Navigator](screenshots/screenshot-navigator.png)

## 4. Jawaban Eksperimen Praktikum 4

1. Mengetik huruf pada isian NPM: huruf tidak masuk, dan angka berhenti di 10 digit. Penyebabnya baris `evt.consume()` di dalam `npmFieldKeyTyped`, yang berjalan kalau karakter bukan angka atau isian sudah 10 digit.
2. Email diisi `siti@` lalu Tab: pesan "Format email belum benar, contoh: nama@contoh.com" muncul saat fokus meninggalkan isian, lewat event `focusLost`.
3. Klik isian Nama tanpa mengetik lalu Tab: tidak ada pesan kesalahan. `namaFieldFocusLost` hanya memeriksa isian yang tidak kosong, jadi isian kosong baru diperiksa saat tombol Daftar diklik.
4. Centang persetujuan lalu klik Daftar dengan form kosong: fokus pindah ke NPM (kesalahan pertama). Muncul lima pesan "wajib diisi" dan ringkasan "5 isian perlu diperbaiki".
5. Alt + N: fokus pindah ke isian Nama lengkap. Yang mengaturnya properti `displayedMnemonic` (N) dan `labelFor` pada `namaLabel`.
6. Isi beberapa isian, klik Batal, lalu pilih No: data tetap ada, karena method `batal()` berhenti (`return`) kalau jawabannya bukan Yes.

## 5. Deklarasi Penggunaan AI

Saya memakai Claude untuk panduan langkah pengerjaan di NetBeans, penjelasan kode, dan pengecekan kode yang saya kirim. Kode akhir saya ketik dan uji sendiri.
