# p07-tabel-dan-menu

Tugas 7 - Tabel, Menu, dan Mini Proyek
Mata kuliah Pemrograman Berbasis Objek 2 (TIF1508)

- Nama: Ariefa Salsabilla Azzahra
- NPM: 2410010519
- Kelas: 5B TI Reg Banjarmasin

Proyek ini berisi aplikasi **Daftar Kontak** (`AplikasiKontak`) yang menampilkan data kontak pada `JTable` dengan `AbstractTableModel`, menu dengan mnemonic dan accelerator, serta `JDialog` modal untuk menambah dan mengubah kontak.

## Jawaban Eksperimen Praktikum 5

### Eksperimen 1: baris `fireTableRowsInserted(baris, baris);` dijadikan komentar

**Hasil pengamatan:** Setelah baris tersebut dijadikan komentar dan kontak baru ditambahkan, tabel tidak langsung berubah. Tabel tetap menampilkan 5 baris, sedangkan label status di bagian bawah sudah menunjukkan "Menampilkan 6 dari 6 kontak".

**Penjelasan:** Data kontak baru sebenarnya sudah masuk ke dalam `List` pada model, tetapi `JTable` tidak menyimpan data sendiri. `JTable` baru menggambar ulang barisnya ketika model memberi tahu melalui method `fireTable...`. Tanpa pemberitahuan tersebut, tabel tidak mengetahui bahwa ada baris baru.

### Eksperimen 2: isi method `barisTerpilih` diganti menjadi `return kontakTable.getSelectedRow();`

**Hasil pengamatan:** Setelah kata "ah" dicari, tabel hanya menampilkan Siti Rahmah, Ahmad Fauzi, dan Nur Aisyah. Ketika Ahmad Fauzi dipilih lalu tombol Hapus diklik, dialog konfirmasi menampilkan nama **Budi Santoso**, bukan Ahmad Fauzi. Dialog kemudian ditutup dengan memilih No.

**Penjelasan:** Ahmad Fauzi berada pada baris tampilan nomor 1 setelah tabel disaring, sedangkan baris nomor 1 pada model adalah Budi Santoso. Tanpa `convertRowIndexToModel`, program memakai nomor baris tampilan sebagai nomor baris model sehingga kontak yang salah yang diambil. Jika dialog dijawab Yes, kontak yang terhapus adalah Budi Santoso.

### Eksperimen 3: `super(pemilik, judul, true)` diubah menjadi `false`

**Hasil pengamatan:** Ketika dialog terbuka, jendela utama tetap dapat diklik. Setelah data diisi dan tombol Simpan diklik, kontak baru tidak muncul di tabel dan label status tetap menunjukkan "Menampilkan 5 dari 5 kontak".

**Penjelasan:** Pada dialog yang tidak modal, `setVisible(true)` tidak menunggu dialog ditutup. Method `tampilkan()` langsung mengembalikan `hasil` yang masih `null`, sehingga method `tambah()` menganggap pengguna membatalkan dan tidak menambahkan kontak. Data yang diisi baru tersimpan ke `hasil` sesudah itu dan tidak dibaca oleh siapa pun.

### Eksperimen 4: menekan Ctrl+N, Ctrl+E, dan Ctrl+D

**Hasil pengamatan:** Ketika tidak ada baris yang dipilih, Ctrl+N bekerja dan membuka dialog Tambah Kontak, sedangkan Ctrl+E dan Ctrl+D tidak bekerja. Item Ubah dan Hapus pada menu Kontak berwarna abu-abu. Ketika sebuah baris dipilih, Ctrl+E dan Ctrl+D bekerja.

**Penjelasan:** Method `perbaruiTombol()` mengatur `ubahItem` dan `hapusItem` menjadi tidak aktif (`setEnabled(false)`) ketika tidak ada baris yang dipilih. Item menu yang tidak aktif tidak merespons pintasan keyboard-nya. Item `tambahItem` selalu aktif sehingga Ctrl+N selalu bekerja.

### Eksperimen 5: accelerator `hapusItem` diubah menjadi tombol Delete tanpa Ctrl

**Hasil pengamatan:** Pada method `initComponents()`, baris `hapusItem.setAccelerator(...)` berubah.

Sebelum:

```java
hapusItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
```

Sesudah:

```java
hapusItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
```

**Penjelasan:** Tombol `VK_D` berganti menjadi `VK_DELETE`, dan `InputEvent.CTRL_DOWN_MASK` berganti menjadi `0` karena tombol Ctrl tidak lagi diperlukan.

### Eksperimen 6: atribut `model` dideklarasikan tanpa nilai awal dan diisi setelah `initComponents()`

**Hasil pengamatan:** Aplikasi gagal tampil dan muncul pesan error berikut pada jendela Output:

```
Exception in thread "AWT-EventQueue-0" java.lang.IllegalArgumentException: Cannot set a null TableModel
	at java.desktop/javax.swing.JTable.setModel(JTable.java:3764)
	at id.ac.uniska.pbo2.p07.AplikasiKontak.initComponents(AplikasiKontak.java:109)
	at id.ac.uniska.pbo2.p07.AplikasiKontak.<init>(AplikasiKontak.java:27)
```

**Penjelasan:** `initComponents()` dipanggil di awal konstruktor dan menjalankan `kontakTable.setModel(model)`. Pada saat itu `model` masih bernilai `null` karena baris `model = new KontakTableModel();` baru dijalankan setelah `initComponents()` selesai. `JTable` tidak boleh menerima model `null` sehingga muncul `IllegalArgumentException`. Oleh karena itu, atribut `model` harus sudah dibuat pada saat dideklarasikan.

Catatan: pada percobaan pertama, atribut `model` masih memakai kata `final` sehingga terjadi error kompilasi `variable model might not have been initialized`. Setelah kata `final` dihapus, error di atas muncul saat program dijalankan.
